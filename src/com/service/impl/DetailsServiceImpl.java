package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.DetailsDAO;
import com.entity.Details;
import com.service.DetailsService;

@Service("detailsService")
public class DetailsServiceImpl implements DetailsService {
	@Autowired
	private DetailsDAO detailsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertDetails(Details details) {
		return this.detailsDAO.insertDetails(details);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateDetails(Details details) {
		return this.detailsDAO.updateDetails(details);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteDetails(String detailsid) {
		return this.detailsDAO.deleteDetails(detailsid);
	}

	@Override // 继承接口的查询全部
	public List<Details> getAllDetails() {
		return this.detailsDAO.getAllDetails();
	}

	@Override // 继承接口的按条件精确查询
	public List<Details> getDetailsByCond(Details details) {
		return this.detailsDAO.getDetailsByCond(details);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Details> getDetailsByLike(Details details) {
		return this.detailsDAO.getDetailsByLike(details);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Details getDetailsById(String detailsid) {
		return this.detailsDAO.getDetailsById(detailsid);
	}

}

