package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Foods;

@Repository("foodsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface FoodsDAO {

	/**
	 * FoodsDAO 接口 可以按名称直接调用foods.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包foods.xml里的insertFoods配置 返回值0(失败),1(成功)
	public int insertFoods(Foods foods);

	// 更新数据 调用entity包foods.xml里的updateFoods配置 返回值0(失败),1(成功)
	public int updateFoods(Foods foods);

	// 删除数据 调用entity包foods.xml里的deleteFoods配置 返回值0(失败),1(成功)
	public int deleteFoods(String foodsid);

	// 查询全部数据 调用entity包foods.xml里的getAllFoods配置 返回List类型的数据
	public List<Foods> getAllFoods();

	public List<Foods> getFoodsByNews();

	public List<Foods> getFoodsByHot();

	public List<Foods> getFoodsByCate(String cateid);

	// 按照Foods类里面的值精确查询 调用entity包foods.xml里的getFoodsByCond配置 返回List类型的数据
	public List<Foods> getFoodsByCond(Foods foods);

	// 按照Foods类里面的值模糊查询 调用entity包foods.xml里的getFoodsByLike配置 返回List类型的数据
	public List<Foods> getFoodsByLike(Foods foods);

	// 按主键查询表返回单一的Foods实例 调用entity包foods.xml里的getFoodsById配置
	public Foods getFoodsById(String foodsid);

}
