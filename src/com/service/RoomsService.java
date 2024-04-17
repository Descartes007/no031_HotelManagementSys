package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Rooms;

@Service("roomsService")
public interface RoomsService {
	// 插入数据 调用roomsDAO里的insertRooms配置
	public int insertRooms(Rooms rooms);

	// 更新数据 调用roomsDAO里的updateRooms配置
	public int updateRooms(Rooms rooms);

	// 删除数据 调用roomsDAO里的deleteRooms配置
	public int deleteRooms(String roomsid);

	// 查询全部数据 调用roomsDAO里的getAllRooms配置
	public List<Rooms> getAllRooms();

	public List<Rooms> getFrontRooms();

	// 按照Rooms类里面的字段名称精确查询 调用roomsDAO里的getRoomsByCond配置
	public List<Rooms> getRoomsByCond(Rooms rooms);

	// 按照Rooms类里面的字段名称模糊查询 调用roomsDAO里的getRoomsByLike配置
	public List<Rooms> getRoomsByLike(Rooms rooms);

	// 按主键查询表返回单一的Rooms实例 调用roomsDAO里的getRoomsById配置
	public Rooms getRoomsById(String roomsid);

}
