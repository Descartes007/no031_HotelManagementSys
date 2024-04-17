package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.NeedsDAO;
import com.entity.Needs;
import com.service.NeedsService;

@Service("needsService")
public class NeedsServiceImpl implements NeedsService {
	@Autowired
	private NeedsDAO needsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertNeeds(Needs needs) {
		return this.needsDAO.insertNeeds(needs);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateNeeds(Needs needs) {
		return this.needsDAO.updateNeeds(needs);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteNeeds(String needsid) {
		return this.needsDAO.deleteNeeds(needsid);
	}

	@Override // 继承接口的查询全部
	public List<Needs> getAllNeeds() {
		return this.needsDAO.getAllNeeds();
	}

	@Override // 继承接口的按条件精确查询
	public List<Needs> getNeedsByCond(Needs needs) {
		return this.needsDAO.getNeedsByCond(needs);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Needs> getNeedsByLike(Needs needs) {
		return this.needsDAO.getNeedsByLike(needs);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Needs getNeedsById(String needsid) {
		return this.needsDAO.getNeedsById(needsid);
	}

}

