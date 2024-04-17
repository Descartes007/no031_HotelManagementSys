package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Roomorders;
@Service("roomordersService")
public interface RoomordersService {
	// 插入数据 调用roomordersDAO里的insertRoomorders配置
	public int insertRoomorders(Roomorders roomorders);

	// 更新数据 调用roomordersDAO里的updateRoomorders配置
	public int updateRoomorders(Roomorders roomorders);

	// 删除数据 调用roomordersDAO里的deleteRoomorders配置
	public int deleteRoomorders(String roomordersid);

	// 查询全部数据 调用roomordersDAO里的getAllRoomorders配置
	public List<Roomorders> getAllRoomorders();

	// 按照Roomorders类里面的字段名称精确查询 调用roomordersDAO里的getRoomordersByCond配置
	public List<Roomorders> getRoomordersByCond(Roomorders roomorders);

	// 按照Roomorders类里面的字段名称模糊查询 调用roomordersDAO里的getRoomordersByLike配置
	public List<Roomorders> getRoomordersByLike(Roomorders roomorders);

	// 按主键查询表返回单一的Roomorders实例 调用roomordersDAO里的getRoomordersById配置
	public Roomorders getRoomordersById(String roomordersid);

}

