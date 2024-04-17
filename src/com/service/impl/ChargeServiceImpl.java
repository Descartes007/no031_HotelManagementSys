package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ChargeDAO;
import com.entity.Charge;
import com.service.ChargeService;

@Service("chargeService")
public class ChargeServiceImpl implements ChargeService {
	@Autowired
	private ChargeDAO chargeDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCharge(Charge charge) {
		return this.chargeDAO.insertCharge(charge);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCharge(Charge charge) {
		return this.chargeDAO.updateCharge(charge);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCharge(String chargeid) {
		return this.chargeDAO.deleteCharge(chargeid);
	}

	@Override // 继承接口的查询全部
	public List<Charge> getAllCharge() {
		return this.chargeDAO.getAllCharge();
	}

	@Override // 继承接口的按条件精确查询
	public List<Charge> getChargeByCond(Charge charge) {
		return this.chargeDAO.getChargeByCond(charge);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Charge> getChargeByLike(Charge charge) {
		return this.chargeDAO.getChargeByLike(charge);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Charge getChargeById(String chargeid) {
		return this.chargeDAO.getChargeById(chargeid);
	}

}

