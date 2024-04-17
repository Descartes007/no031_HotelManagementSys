package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BuyDAO;
import com.entity.Buy;
import com.service.BuyService;

@Service("buyService")
public class BuyServiceImpl implements BuyService {
	@Autowired
	private BuyDAO buyDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBuy(Buy buy) {
		return this.buyDAO.insertBuy(buy);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBuy(Buy buy) {
		return this.buyDAO.updateBuy(buy);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBuy(String buyid) {
		return this.buyDAO.deleteBuy(buyid);
	}

	@Override // 继承接口的查询全部
	public List<Buy> getAllBuy() {
		return this.buyDAO.getAllBuy();
	}

	@Override // 继承接口的按条件精确查询
	public List<Buy> getBuyByCond(Buy buy) {
		return this.buyDAO.getBuyByCond(buy);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Buy> getBuyByLike(Buy buy) {
		return this.buyDAO.getBuyByLike(buy);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Buy getBuyById(String buyid) {
		return this.buyDAO.getBuyById(buyid);
	}

}

