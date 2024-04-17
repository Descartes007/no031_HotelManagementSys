package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Buy;
@Service("buyService")
public interface BuyService {
	// 插入数据 调用buyDAO里的insertBuy配置
	public int insertBuy(Buy buy);

	// 更新数据 调用buyDAO里的updateBuy配置
	public int updateBuy(Buy buy);

	// 删除数据 调用buyDAO里的deleteBuy配置
	public int deleteBuy(String buyid);

	// 查询全部数据 调用buyDAO里的getAllBuy配置
	public List<Buy> getAllBuy();

	// 按照Buy类里面的字段名称精确查询 调用buyDAO里的getBuyByCond配置
	public List<Buy> getBuyByCond(Buy buy);

	// 按照Buy类里面的字段名称模糊查询 调用buyDAO里的getBuyByLike配置
	public List<Buy> getBuyByLike(Buy buy);

	// 按主键查询表返回单一的Buy实例 调用buyDAO里的getBuyById配置
	public Buy getBuyById(String buyid);

}

