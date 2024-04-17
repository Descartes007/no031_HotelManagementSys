package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Foods;
import com.service.FoodsService;
import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/foods" , produces = "text/plain;charset=utf-8")
public class FoodsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private FoodsService foodsService;
	@Autowired
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createFoods.action")
	public String createFoods() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/addfoods";
	}
	// 添加数据
	@RequestMapping("addFoods.action")
	public String addFoods(Foods foods) {
		foods.setAddtime(VeDate.getStringDateShort());
		foods.setHits("0");
		foods.setSellnum("0");
		this.foodsService.insertFoods(foods);
		return "redirect:/foods/createFoods.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteFoods.action")
	public String deleteFoods(String id) {
		this.foodsService.deleteFoods(id);
		return "redirect:/foods/getAllFoods.action";
	}

	// 批量删除数据
	@RequestMapping("deleteFoodsByIds.action")
	public String deleteFoodsByIds() {
		String[] ids = this.getRequest().getParameterValues("foodsid");
		if (ids != null) {
			for (String foodsid : ids) {
				this.foodsService.deleteFoods(foodsid);
			}
		}
		return "redirect:/foods/getAllFoods.action";
	}

	// 更新数据
	@RequestMapping("updateFoods.action")
	public String updateFoods(Foods foods) {
		this.foodsService.updateFoods(foods);
		return "redirect:/foods/getAllFoods.action";
	}

	// 显示全部数据
	@RequestMapping("getAllFoods.action")
	public String getAllFoods(String number) {
		List<Foods> foodsList = this.foodsService.getAllFoods();
		PageHelper.getPage(foodsList, "foods", null, null, 10, number, this.getRequest(), null);
		return "admin/listfoods";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryFoodsByCond.action")
	public String queryFoodsByCond(String cond, String name, String number) {
		Foods foods = new Foods();
		if(cond != null){
			if ("foodsname".equals(cond)) {
				foods.setFoodsname(name);
			}
			if ("image".equals(cond)) {
				foods.setImage(name);
			}
			if ("cateid".equals(cond)) {
				foods.setCateid(name);
			}
			if ("price".equals(cond)) {
				foods.setPrice(name);
			}
			if ("recommend".equals(cond)) {
				foods.setRecommend(name);
			}
			if ("addtime".equals(cond)) {
				foods.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				foods.setHits(name);
			}
			if ("sellnum".equals(cond)) {
				foods.setSellnum(name);
			}
			if ("contents".equals(cond)) {
				foods.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.foodsService.getFoodsByLike(foods), "foods", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryfoods";
	}

	// 按主键查询数据
	@RequestMapping("getFoodsById.action")
	public String getFoodsById(String id) {
		Foods foods = this.foodsService.getFoodsById(id);
		this.getRequest().setAttribute("foods", foods);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editfoods";
	}


}
