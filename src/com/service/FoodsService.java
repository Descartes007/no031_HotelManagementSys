package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Foods;

@Service("foodsService")
public interface FoodsService {
	// 插入数据 调用foodsDAO里的insertFoods配置
	public int insertFoods(Foods foods);

	// 更新数据 调用foodsDAO里的updateFoods配置
	public int updateFoods(Foods foods);

	// 删除数据 调用foodsDAO里的deleteFoods配置
	public int deleteFoods(String foodsid);

	// 查询全部数据 调用foodsDAO里的getAllFoods配置
	public List<Foods> getAllFoods();

	public List<Foods> getFoodsByNews();

	public List<Foods> getFoodsByHot();

	public List<Foods> getFoodsByCate(String cateid);

	// 按照Foods类里面的字段名称精确查询 调用foodsDAO里的getFoodsByCond配置
	public List<Foods> getFoodsByCond(Foods foods);

	// 按照Foods类里面的字段名称模糊查询 调用foodsDAO里的getFoodsByLike配置
	public List<Foods> getFoodsByLike(Foods foods);

	// 按主键查询表返回单一的Foods实例 调用foodsDAO里的getFoodsById配置
	public Foods getFoodsById(String foodsid);

}
