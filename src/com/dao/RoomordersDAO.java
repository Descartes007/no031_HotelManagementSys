package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Roomorders;

@Repository("roomordersDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface RoomordersDAO {

	/**
* RoomordersDAO 接口 可以按名称直接调用roomorders.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包roomorders.xml里的insertRoomorders配置 返回值0(失败),1(成功)
	public int insertRoomorders(Roomorders roomorders);

	// 更新数据 调用entity包roomorders.xml里的updateRoomorders配置 返回值0(失败),1(成功)
	public int updateRoomorders(Roomorders roomorders);

	// 删除数据 调用entity包roomorders.xml里的deleteRoomorders配置 返回值0(失败),1(成功)
	public int deleteRoomorders(String roomordersid);

	// 查询全部数据 调用entity包roomorders.xml里的getAllRoomorders配置 返回List类型的数据
	public List<Roomorders> getAllRoomorders();

	// 按照Roomorders类里面的值精确查询 调用entity包roomorders.xml里的getRoomordersByCond配置 返回List类型的数据
	public List<Roomorders> getRoomordersByCond(Roomorders roomorders);

	// 按照Roomorders类里面的值模糊查询 调用entity包roomorders.xml里的getRoomordersByLike配置 返回List类型的数据
	public List<Roomorders> getRoomordersByLike(Roomorders roomorders);

	// 按主键查询表返回单一的Roomorders实例 调用entity包roomorders.xml里的getRoomordersById配置
	public Roomorders getRoomordersById(String roomordersid);

}


