package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.EmployDAO;
import com.entity.Employ;
import com.service.EmployService;

@Service("employService")
public class EmployServiceImpl implements EmployService {
	@Autowired
	private EmployDAO employDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertEmploy(Employ employ) {
		return this.employDAO.insertEmploy(employ);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateEmploy(Employ employ) {
		return this.employDAO.updateEmploy(employ);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteEmploy(String employid) {
		return this.employDAO.deleteEmploy(employid);
	}

	@Override // 继承接口的查询全部
	public List<Employ> getAllEmploy() {
		return this.employDAO.getAllEmploy();
	}

	@Override // 继承接口的按条件精确查询
	public List<Employ> getEmployByCond(Employ employ) {
		return this.employDAO.getEmployByCond(employ);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Employ> getEmployByLike(Employ employ) {
		return this.employDAO.getEmployByLike(employ);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Employ getEmployById(String employid) {
		return this.employDAO.getEmployById(employid);
	}

}

