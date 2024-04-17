package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Needs;

@Repository("needsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface NeedsDAO {

	/**
* NeedsDAO 接口 可以按名称直接调用needs.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包needs.xml里的insertNeeds配置 返回值0(失败),1(成功)
	public int insertNeeds(Needs needs);

	// 更新数据 调用entity包needs.xml里的updateNeeds配置 返回值0(失败),1(成功)
	public int updateNeeds(Needs needs);

	// 删除数据 调用entity包needs.xml里的deleteNeeds配置 返回值0(失败),1(成功)
	public int deleteNeeds(String needsid);

	// 查询全部数据 调用entity包needs.xml里的getAllNeeds配置 返回List类型的数据
	public List<Needs> getAllNeeds();

	// 按照Needs类里面的值精确查询 调用entity包needs.xml里的getNeedsByCond配置 返回List类型的数据
	public List<Needs> getNeedsByCond(Needs needs);

	// 按照Needs类里面的值模糊查询 调用entity包needs.xml里的getNeedsByLike配置 返回List类型的数据
	public List<Needs> getNeedsByLike(Needs needs);

	// 按主键查询表返回单一的Needs实例 调用entity包needs.xml里的getNeedsById配置
	public Needs getNeedsById(String needsid);

}


