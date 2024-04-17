package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FoodsDAO;
import com.dao.HistDAO;
import com.dao.UsersDAO;
import com.entity.Foods;
import com.entity.Hist;
import com.entity.Users;
import com.service.RecommendService;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
	/**
	 * 计算用户浏览食品的相似度 返回食品的推荐集合 使用欧式向量集合进行计算
	 */
	@Autowired
	private HistDAO histDAO;
	@Autowired
	private FoodsDAO foodsDAO;
	@Autowired
	private UsersDAO usersDAO;
	private String userid = "";
	// 相似用户集合
	private List<List<Object>> similarityUsers = null;
	// 推荐所有食品集合
	private List<String> targetrecommendFoods = null;
	// 浏览过食品集合
	private List<String> commentedFoods = null;
	// 用户在食品浏览集合中的位置
	private int targetUserIndex = 0;
	// 目标用户浏览过的食品
	private List<String> targetUserCommentedFoods = null;

	private String[] foods = null;

	@Override
	public List<Foods> getRecommend(String userid) {
		this.userid = userid;
		// 建立用户数组 除了当前用户外 随机抽取9个用户
		String[] users = new String[10];
		users[0] = this.userid;
		List<Users> usersList = this.usersDAO.getUsers(this.userid);
		System.out.println("users == > " + usersList.size());
		for (int i = 0; i < 9; i++) {
			int j = i + 1;
			int tbNum = usersList.size();
			if (i < tbNum) {
				users[j] = usersList.get(i).getUsersid();
			} else {
				users[j] = "0";
			}
		}
		List<Foods> foodsList = this.foodsDAO.getAllFoods();
		this.foods = new String[foodsList.size()];
		for (int j = 0; j < foodsList.size(); j++) {
			this.foods[j] = foodsList.get(j).getFoodsid();
		}
		// 建立浏览二维数组 用户浏览了食品 1 未浏览 0 之后计算用户的相似度
		int[][] allUserFoodshist = new int[10][foodsList.size()];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < foodsList.size(); j++) {
				String foodsid = this.foods[j];
				Hist hist = new Hist();
				hist.setUsersid(users[i]);
				hist.setFoodsid(foodsid);
				List<Hist> histList = this.histDAO.getHistByCond(hist);
				if (histList.size() == 0) {
					allUserFoodshist[i][j] = 0;
				} else {
					Hist h = histList.get(0);
					allUserFoodshist[i][j] = Integer.parseInt(h.getNum());
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < foodsList.size(); j++) {
				if (j == foodsList.size() - 1) {
					System.out.print(allUserFoodshist[i][j]);
				} else {
					System.out.print(allUserFoodshist[i][j] + " ,");
				}
			}
			System.out.println("");
		}
		this.targetUserCommentedFoods = new ArrayList<String>();
		Hist hist = new Hist();
		hist.setUsersid(this.userid);
		List<Hist> histList = this.histDAO.getHistByCond(hist);
		for (int i = 0; i < histList.size(); i++) {
			// 转换目标用户食品浏览列表
			this.targetUserCommentedFoods.add(histList.get(i).getHistid());
		}

		// 计算用户相似度，排序
		this.calcUserSimilarity(allUserFoodshist, foodsList.size());
		// 计算食品推荐度，排序
		this.calcrecommendFoods(allUserFoodshist, foodsList.size());
		// 处理推荐食品列表
		this.handlerecommendFoods(allUserFoodshist, foodsList.size());
		String rommendId = "";
		for (int i = 0; i < this.targetrecommendFoods.size(); i++) {
			String item = this.targetrecommendFoods.get(i);
			if (!commentedFoods.contains(item)) {
				if (i == this.targetrecommendFoods.size() - 1) {
					rommendId += item;
				} else {
					rommendId += item + ",";
				}
			}
		}
		String[] str = rommendId.split(",");
		List<Foods> hotList = new ArrayList<Foods>();
		List<Foods> foodList = new ArrayList<Foods>();
		if (!"".equals(rommendId)) {
			for (String x : str) {
				Foods g = this.foodsDAO.getFoodsById(x);
				foodList.add(g);
				hotList.add(g);
			}
		} else {
			hotList = this.foodsDAO.getFoodsByHot();
		}
		return hotList;
	}

	private void calcrecommendFoods(int[][] allUserFoodshist, int foodsNum) {
		this.targetrecommendFoods = new ArrayList<String>();
		List<List<Object>> recommendFoods = new ArrayList<List<Object>>();
		List<Object> recommendFood = null;
		double recommdRate = 0, sumRate = 0;
		for (int i = 0; i < foodsNum; i++) {
			recommendFood = new ArrayList<Object>();
			recommendFood.add(i);
			recommdRate = allUserFoodshist[Integer.parseInt(similarityUsers.get(0).get(0).toString())][i]
					* Double.parseDouble(similarityUsers.get(0).get(1).toString())
					+ allUserFoodshist[Integer.parseInt(similarityUsers.get(1).get(0).toString())][i]
							* Double.parseDouble(similarityUsers.get(1).get(1).toString());
			recommendFood.add(recommdRate);
			recommendFoods.add(recommendFood);
			sumRate += recommdRate;
		}
		System.out.println("sumRate  == > " + sumRate / foodsNum);
		recommendFoods = compare(recommendFoods);
		for (List<Object> tList : recommendFoods) {
			System.out.println(tList.get(1));
		}
		// 大于平均推荐度的食品才有可能被推荐
		for (int i = 0; i < recommendFoods.size(); i++) {
			List<Object> item = recommendFoods.get(i);
			if (Double.parseDouble(item.get(1).toString()) > sumRate / foodsNum) { // 大于平均推荐度的食品才有可能被推荐
				System.out.println("foods= = >" + foods[Integer.parseInt(item.get(0).toString())]);
				this.targetrecommendFoods.add(foods[Integer.parseInt(item.get(0).toString())]);
			}
			if (i > 9) {
				break;
			}
		}
	}

	/**
	 * 把推荐列表中用户已经浏览过的食品剔除
	 */
	private void handlerecommendFoods(int[][] allUserFoodshist, int foodsNum) {
		int[] user2hist = new int[foodsNum];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < foodsNum; j++) {
				user2hist[j] = allUserFoodshist[i][j];
			}
		}
		commentedFoods = new ArrayList<String>();
		for (int i = 0; i < user2hist.length; i++) {
			if (allUserFoodshist[0][i] != 0) {
				commentedFoods.add(foods[i]);
			}
		}
	}

	/**
	 * 获取两个最相似的用户
	 */
	private void calcUserSimilarity(int[][] allUserFoodshist, int foodsNum) {
		int[] user2hist = new int[foodsNum];
		List<List<Object>> tmpList = new ArrayList<List<Object>>();

		for (int i = 0; i < 10; i++) {
			if (i == targetUserIndex) {
				for (int j = 0; j < foodsNum; j++) {
					user2hist[j] = allUserFoodshist[i][j];
				}
				continue;
			}
			List<Object> userSimilarity = new ArrayList<Object>();
			int[] user1hist = new int[foodsNum];
			for (int j = 0; j < foodsNum; j++) {
				user1hist[j] = allUserFoodshist[i][j];

			}
			userSimilarity.add(i);
			userSimilarity.add(calcTwoUserSimilarity(user1hist, user2hist, foodsNum));
			tmpList.add(userSimilarity);
		}
		this.similarityUsers = compare(tmpList);
	}

	/**
	 * 根据用户数据，计算用户相似度
	 * 
	 * @param user1hist
	 * @param user2hist
	 * @return
	 */
	private static double calcTwoUserSimilarity(int[] user1hist, int[] user2hist, int foodsNum) {
		double sum = 0;
		for (int i = 0; i < foodsNum; i++) {
			sum += Math.pow(user1hist[i] - user2hist[i], 2);
		}
		return Math.sqrt(sum);
	}

	/**
	 * 集合排序
	 */
	private static List<List<Object>> compare(List<List<Object>> tmpList) {
		for (int i = 0; i < tmpList.size(); i++) {
			for (int j = 0; j < tmpList.size() - i; j++) {
				List<Object> t1 = tmpList.get(i);
				List<Object> t2 = tmpList.get(j);
				if (Double.parseDouble("" + t1.get(1)) > Double.parseDouble("" + t2.get(1))) {
					List<Object> tmp = new ArrayList<Object>();
					tmp = t1;
					tmpList.set(i, t2);
					tmpList.set(j, tmp);
				}
			}
		}
		return tmpList;
	}

}
