package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Buy;

@Repository("buyDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface BuyDAO {

	/**
* BuyDAO 接口 可以按名称直接调用buy.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包buy.xml里的insertBuy配置 返回值0(失败),1(成功)
	public int insertBuy(Buy buy);

	// 更新数据 调用entity包buy.xml里的updateBuy配置 返回值0(失败),1(成功)
	public int updateBuy(Buy buy);

	// 删除数据 调用entity包buy.xml里的deleteBuy配置 返回值0(失败),1(成功)
	public int deleteBuy(String buyid);

	// 查询全部数据 调用entity包buy.xml里的getAllBuy配置 返回List类型的数据
	public List<Buy> getAllBuy();

	// 按照Buy类里面的值精确查询 调用entity包buy.xml里的getBuyByCond配置 返回List类型的数据
	public List<Buy> getBuyByCond(Buy buy);

	// 按照Buy类里面的值模糊查询 调用entity包buy.xml里的getBuyByLike配置 返回List类型的数据
	public List<Buy> getBuyByLike(Buy buy);

	// 按主键查询表返回单一的Buy实例 调用entity包buy.xml里的getBuyById配置
	public Buy getBuyById(String buyid);

}


