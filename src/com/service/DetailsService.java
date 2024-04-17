package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Details;
@Service("detailsService")
public interface DetailsService {
	// 插入数据 调用detailsDAO里的insertDetails配置
	public int insertDetails(Details details);

	// 更新数据 调用detailsDAO里的updateDetails配置
	public int updateDetails(Details details);

	// 删除数据 调用detailsDAO里的deleteDetails配置
	public int deleteDetails(String detailsid);

	// 查询全部数据 调用detailsDAO里的getAllDetails配置
	public List<Details> getAllDetails();

	// 按照Details类里面的字段名称精确查询 调用detailsDAO里的getDetailsByCond配置
	public List<Details> getDetailsByCond(Details details);

	// 按照Details类里面的字段名称模糊查询 调用detailsDAO里的getDetailsByLike配置
	public List<Details> getDetailsByLike(Details details);

	// 按主键查询表返回单一的Details实例 调用detailsDAO里的getDetailsById配置
	public Details getDetailsById(String detailsid);

}

