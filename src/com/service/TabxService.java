package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Tabx;

@Service("tabxService")
public interface TabxService {
	// 插入数据 调用tabxDAO里的insertTabx配置
	public int insertTabx(Tabx tabx);

	// 更新数据 调用tabxDAO里的updateTabx配置
	public int updateTabx(Tabx tabx);

	// 删除数据 调用tabxDAO里的deleteTabx配置
	public int deleteTabx(String tabxid);

	// 查询全部数据 调用tabxDAO里的getAllTabx配置
	public List<Tabx> getAllTabx();

	public List<Tabx> getFrontTabx();

	// 按照Tabx类里面的字段名称精确查询 调用tabxDAO里的getTabxByCond配置
	public List<Tabx> getTabxByCond(Tabx tabx);

	// 按照Tabx类里面的字段名称模糊查询 调用tabxDAO里的getTabxByLike配置
	public List<Tabx> getTabxByLike(Tabx tabx);

	// 按主键查询表返回单一的Tabx实例 调用tabxDAO里的getTabxById配置
	public Tabx getTabxById(String tabxid);

}
