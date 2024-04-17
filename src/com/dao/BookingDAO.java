package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Booking;

@Repository("bookingDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface BookingDAO {

	/**
* BookingDAO 接口 可以按名称直接调用booking.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包booking.xml里的insertBooking配置 返回值0(失败),1(成功)
	public int insertBooking(Booking booking);

	// 更新数据 调用entity包booking.xml里的updateBooking配置 返回值0(失败),1(成功)
	public int updateBooking(Booking booking);

	// 删除数据 调用entity包booking.xml里的deleteBooking配置 返回值0(失败),1(成功)
	public int deleteBooking(String bookingid);

	// 查询全部数据 调用entity包booking.xml里的getAllBooking配置 返回List类型的数据
	public List<Booking> getAllBooking();

	// 按照Booking类里面的值精确查询 调用entity包booking.xml里的getBookingByCond配置 返回List类型的数据
	public List<Booking> getBookingByCond(Booking booking);

	// 按照Booking类里面的值模糊查询 调用entity包booking.xml里的getBookingByLike配置 返回List类型的数据
	public List<Booking> getBookingByLike(Booking booking);

	// 按主键查询表返回单一的Booking实例 调用entity包booking.xml里的getBookingById配置
	public Booking getBookingById(String bookingid);

}


