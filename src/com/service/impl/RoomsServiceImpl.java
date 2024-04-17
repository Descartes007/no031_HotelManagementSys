package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RoomsDAO;
import com.entity.Rooms;
import com.service.RoomsService;

@Service("roomsService")
public class RoomsServiceImpl implements RoomsService {
	@Autowired
	private RoomsDAO roomsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertRooms(Rooms rooms) {
		return this.roomsDAO.insertRooms(rooms);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateRooms(Rooms rooms) {
		return this.roomsDAO.updateRooms(rooms);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteRooms(String roomsid) {
		return this.roomsDAO.deleteRooms(roomsid);
	}

	@Override // 继承接口的查询全部
	public List<Rooms> getAllRooms() {
		return this.roomsDAO.getAllRooms();
	}

	@Override // 继承接口的查询全部
	public List<Rooms> getFrontRooms() {
		return this.roomsDAO.getFrontRooms();
	}

	@Override // 继承接口的按条件精确查询
	public List<Rooms> getRoomsByCond(Rooms rooms) {
		return this.roomsDAO.getRoomsByCond(rooms);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Rooms> getRoomsByLike(Rooms rooms) {
		return this.roomsDAO.getRoomsByLike(rooms);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Rooms getRoomsById(String roomsid) {
		return this.roomsDAO.getRoomsById(roomsid);
	}

}
