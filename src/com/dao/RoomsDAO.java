package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Rooms;

@Repository("roomsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface RoomsDAO {

	/**
	 * RoomsDAO 接口 可以按名称直接调用rooms.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包rooms.xml里的insertRooms配置 返回值0(失败),1(成功)
	public int insertRooms(Rooms rooms);

	// 更新数据 调用entity包rooms.xml里的updateRooms配置 返回值0(失败),1(成功)
	public int updateRooms(Rooms rooms);

	// 删除数据 调用entity包rooms.xml里的deleteRooms配置 返回值0(失败),1(成功)
	public int deleteRooms(String roomsid);

	// 查询全部数据 调用entity包rooms.xml里的getAllRooms配置 返回List类型的数据
	public List<Rooms> getAllRooms();
	
	public List<Rooms> getFrontRooms();

	// 按照Rooms类里面的值精确查询 调用entity包rooms.xml里的getRoomsByCond配置 返回List类型的数据
	public List<Rooms> getRoomsByCond(Rooms rooms);

	// 按照Rooms类里面的值模糊查询 调用entity包rooms.xml里的getRoomsByLike配置 返回List类型的数据
	public List<Rooms> getRoomsByLike(Rooms rooms);

	// 按主键查询表返回单一的Rooms实例 调用entity包rooms.xml里的getRoomsById配置
	public Rooms getRoomsById(String roomsid);

}
