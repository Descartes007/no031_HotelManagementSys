package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.RoomordersDAO;
import com.entity.Roomorders;
import com.service.RoomordersService;

@Service("roomordersService")
public class RoomordersServiceImpl implements RoomordersService {
	@Autowired
	private RoomordersDAO roomordersDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertRoomorders(Roomorders roomorders) {
		return this.roomordersDAO.insertRoomorders(roomorders);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateRoomorders(Roomorders roomorders) {
		return this.roomordersDAO.updateRoomorders(roomorders);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteRoomorders(String roomordersid) {
		return this.roomordersDAO.deleteRoomorders(roomordersid);
	}

	@Override // 继承接口的查询全部
	public List<Roomorders> getAllRoomorders() {
		return this.roomordersDAO.getAllRoomorders();
	}

	@Override // 继承接口的按条件精确查询
	public List<Roomorders> getRoomordersByCond(Roomorders roomorders) {
		return this.roomordersDAO.getRoomordersByCond(roomorders);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Roomorders> getRoomordersByLike(Roomorders roomorders) {
		return this.roomordersDAO.getRoomordersByLike(roomorders);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Roomorders getRoomordersById(String roomordersid) {
		return this.roomordersDAO.getRoomordersById(roomordersid);
	}

}

