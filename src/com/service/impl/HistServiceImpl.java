package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.HistDAO;
import com.entity.Hist;
import com.service.HistService;

@Service("histService")
public class HistServiceImpl implements HistService {
	@Autowired
	private HistDAO histDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertHist(Hist hist) {
		return this.histDAO.insertHist(hist);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateHist(Hist hist) {
		return this.histDAO.updateHist(hist);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteHist(String histid) {
		return this.histDAO.deleteHist(histid);
	}

	@Override // 继承接口的查询全部
	public List<Hist> getAllHist() {
		return this.histDAO.getAllHist();
	}

	@Override // 继承接口的按条件精确查询
	public List<Hist> getHistByCond(Hist hist) {
		return this.histDAO.getHistByCond(hist);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Hist> getHistByLike(Hist hist) {
		return this.histDAO.getHistByLike(hist);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Hist getHistById(String histid) {
		return this.histDAO.getHistById(histid);
	}

}

