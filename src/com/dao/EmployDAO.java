package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Employ;

@Repository("employDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface EmployDAO {

	/**
* EmployDAO 接口 可以按名称直接调用employ.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包employ.xml里的insertEmploy配置 返回值0(失败),1(成功)
	public int insertEmploy(Employ employ);

	// 更新数据 调用entity包employ.xml里的updateEmploy配置 返回值0(失败),1(成功)
	public int updateEmploy(Employ employ);

	// 删除数据 调用entity包employ.xml里的deleteEmploy配置 返回值0(失败),1(成功)
	public int deleteEmploy(String employid);

	// 查询全部数据 调用entity包employ.xml里的getAllEmploy配置 返回List类型的数据
	public List<Employ> getAllEmploy();

	// 按照Employ类里面的值精确查询 调用entity包employ.xml里的getEmployByCond配置 返回List类型的数据
	public List<Employ> getEmployByCond(Employ employ);

	// 按照Employ类里面的值模糊查询 调用entity包employ.xml里的getEmployByLike配置 返回List类型的数据
	public List<Employ> getEmployByLike(Employ employ);

	// 按主键查询表返回单一的Employ实例 调用entity包employ.xml里的getEmployById配置
	public Employ getEmployById(String employid);

}


