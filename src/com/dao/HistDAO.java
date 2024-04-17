package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Hist;

@Repository("histDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface HistDAO {

	/**
* HistDAO 接口 可以按名称直接调用hist.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包hist.xml里的insertHist配置 返回值0(失败),1(成功)
	public int insertHist(Hist hist);

	// 更新数据 调用entity包hist.xml里的updateHist配置 返回值0(失败),1(成功)
	public int updateHist(Hist hist);

	// 删除数据 调用entity包hist.xml里的deleteHist配置 返回值0(失败),1(成功)
	public int deleteHist(String histid);

	// 查询全部数据 调用entity包hist.xml里的getAllHist配置 返回List类型的数据
	public List<Hist> getAllHist();

	// 按照Hist类里面的值精确查询 调用entity包hist.xml里的getHistByCond配置 返回List类型的数据
	public List<Hist> getHistByCond(Hist hist);

	// 按照Hist类里面的值模糊查询 调用entity包hist.xml里的getHistByLike配置 返回List类型的数据
	public List<Hist> getHistByLike(Hist hist);

	// 按主键查询表返回单一的Hist实例 调用entity包hist.xml里的getHistById配置
	public Hist getHistById(String histid);

}


