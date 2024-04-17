package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Hist;
@Service("histService")
public interface HistService {
	// 插入数据 调用histDAO里的insertHist配置
	public int insertHist(Hist hist);

	// 更新数据 调用histDAO里的updateHist配置
	public int updateHist(Hist hist);

	// 删除数据 调用histDAO里的deleteHist配置
	public int deleteHist(String histid);

	// 查询全部数据 调用histDAO里的getAllHist配置
	public List<Hist> getAllHist();

	// 按照Hist类里面的字段名称精确查询 调用histDAO里的getHistByCond配置
	public List<Hist> getHistByCond(Hist hist);

	// 按照Hist类里面的字段名称模糊查询 调用histDAO里的getHistByLike配置
	public List<Hist> getHistByLike(Hist hist);

	// 按主键查询表返回单一的Hist实例 调用histDAO里的getHistById配置
	public Hist getHistById(String histid);

}

