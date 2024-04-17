package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Employ;
@Service("employService")
public interface EmployService {
	// 插入数据 调用employDAO里的insertEmploy配置
	public int insertEmploy(Employ employ);

	// 更新数据 调用employDAO里的updateEmploy配置
	public int updateEmploy(Employ employ);

	// 删除数据 调用employDAO里的deleteEmploy配置
	public int deleteEmploy(String employid);

	// 查询全部数据 调用employDAO里的getAllEmploy配置
	public List<Employ> getAllEmploy();

	// 按照Employ类里面的字段名称精确查询 调用employDAO里的getEmployByCond配置
	public List<Employ> getEmployByCond(Employ employ);

	// 按照Employ类里面的字段名称模糊查询 调用employDAO里的getEmployByLike配置
	public List<Employ> getEmployByLike(Employ employ);

	// 按主键查询表返回单一的Employ实例 调用employDAO里的getEmployById配置
	public Employ getEmployById(String employid);

}

