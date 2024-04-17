package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Details;

@Repository("detailsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface DetailsDAO {

	/**
* DetailsDAO 接口 可以按名称直接调用details.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包details.xml里的insertDetails配置 返回值0(失败),1(成功)
	public int insertDetails(Details details);

	// 更新数据 调用entity包details.xml里的updateDetails配置 返回值0(失败),1(成功)
	public int updateDetails(Details details);

	// 删除数据 调用entity包details.xml里的deleteDetails配置 返回值0(失败),1(成功)
	public int deleteDetails(String detailsid);

	// 查询全部数据 调用entity包details.xml里的getAllDetails配置 返回List类型的数据
	public List<Details> getAllDetails();

	// 按照Details类里面的值精确查询 调用entity包details.xml里的getDetailsByCond配置 返回List类型的数据
	public List<Details> getDetailsByCond(Details details);

	// 按照Details类里面的值模糊查询 调用entity包details.xml里的getDetailsByLike配置 返回List类型的数据
	public List<Details> getDetailsByLike(Details details);

	// 按主键查询表返回单一的Details实例 调用entity包details.xml里的getDetailsById配置
	public Details getDetailsById(String detailsid);

}


