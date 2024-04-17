package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.FoodsDAO;
import com.entity.Foods;
import com.service.FoodsService;

@Service("foodsService")
public class FoodsServiceImpl implements FoodsService {
	@Autowired
	private FoodsDAO foodsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertFoods(Foods foods) {
		return this.foodsDAO.insertFoods(foods);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateFoods(Foods foods) {
		return this.foodsDAO.updateFoods(foods);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteFoods(String foodsid) {
		return this.foodsDAO.deleteFoods(foodsid);
	}

	@Override // 继承接口的查询全部
	public List<Foods> getAllFoods() {
		return this.foodsDAO.getAllFoods();
	}

	@Override // 继承接口的查询全部
	public List<Foods> getFoodsByNews() {
		return this.foodsDAO.getFoodsByNews();
	}

	@Override // 继承接口的查询全部
	public List<Foods> getFoodsByHot() {
		return this.foodsDAO.getFoodsByHot();
	}

	@Override // 继承接口的查询全部
	public List<Foods> getFoodsByCate(String cateid) {
		return this.foodsDAO.getFoodsByCate(cateid);
	}

	@Override // 继承接口的按条件精确查询
	public List<Foods> getFoodsByCond(Foods foods) {
		return this.foodsDAO.getFoodsByCond(foods);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Foods> getFoodsByLike(Foods foods) {
		return this.foodsDAO.getFoodsByLike(foods);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Foods getFoodsById(String foodsid) {
		return this.foodsDAO.getFoodsById(foodsid);
	}

}
