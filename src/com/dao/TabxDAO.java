package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Tabx;

@Repository("tabxDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface TabxDAO {

	/**
	 * TabxDAO 接口 可以按名称直接调用tabx.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包tabx.xml里的insertTabx配置 返回值0(失败),1(成功)
	public int insertTabx(Tabx tabx);

	// 更新数据 调用entity包tabx.xml里的updateTabx配置 返回值0(失败),1(成功)
	public int updateTabx(Tabx tabx);

	// 删除数据 调用entity包tabx.xml里的deleteTabx配置 返回值0(失败),1(成功)
	public int deleteTabx(String tabxid);

	// 查询全部数据 调用entity包tabx.xml里的getAllTabx配置 返回List类型的数据
	public List<Tabx> getAllTabx();

	public List<Tabx> getFrontTabx();

	// 按照Tabx类里面的值精确查询 调用entity包tabx.xml里的getTabxByCond配置 返回List类型的数据
	public List<Tabx> getTabxByCond(Tabx tabx);

	// 按照Tabx类里面的值模糊查询 调用entity包tabx.xml里的getTabxByLike配置 返回List类型的数据
	public List<Tabx> getTabxByLike(Tabx tabx);

	// 按主键查询表返回单一的Tabx实例 调用entity包tabx.xml里的getTabxById配置
	public Tabx getTabxById(String tabxid);

}
