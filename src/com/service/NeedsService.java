package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Needs;
@Service("needsService")
public interface NeedsService {
	// 插入数据 调用needsDAO里的insertNeeds配置
	public int insertNeeds(Needs needs);

	// 更新数据 调用needsDAO里的updateNeeds配置
	public int updateNeeds(Needs needs);

	// 删除数据 调用needsDAO里的deleteNeeds配置
	public int deleteNeeds(String needsid);

	// 查询全部数据 调用needsDAO里的getAllNeeds配置
	public List<Needs> getAllNeeds();

	// 按照Needs类里面的字段名称精确查询 调用needsDAO里的getNeedsByCond配置
	public List<Needs> getNeedsByCond(Needs needs);

	// 按照Needs类里面的字段名称模糊查询 调用needsDAO里的getNeedsByLike配置
	public List<Needs> getNeedsByLike(Needs needs);

	// 按主键查询表返回单一的Needs实例 调用needsDAO里的getNeedsById配置
	public Needs getNeedsById(String needsid);

}

