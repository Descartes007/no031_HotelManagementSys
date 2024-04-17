package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.TabxDAO;
import com.entity.Tabx;
import com.service.TabxService;

@Service("tabxService")
public class TabxServiceImpl implements TabxService {
	@Autowired
	private TabxDAO tabxDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertTabx(Tabx tabx) {
		return this.tabxDAO.insertTabx(tabx);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateTabx(Tabx tabx) {
		return this.tabxDAO.updateTabx(tabx);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteTabx(String tabxid) {
		return this.tabxDAO.deleteTabx(tabxid);
	}

	@Override // 继承接口的查询全部
	public List<Tabx> getAllTabx() {
		return this.tabxDAO.getAllTabx();
	}

	@Override // 继承接口的查询全部
	public List<Tabx> getFrontTabx() {
		return this.tabxDAO.getFrontTabx();
	}

	@Override // 继承接口的按条件精确查询
	public List<Tabx> getTabxByCond(Tabx tabx) {
		return this.tabxDAO.getTabxByCond(tabx);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Tabx> getTabxByLike(Tabx tabx) {
		return this.tabxDAO.getTabxByLike(tabx);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Tabx getTabxById(String tabxid) {
		return this.tabxDAO.getTabxById(tabxid);
	}

}
