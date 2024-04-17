package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Booking;
@Service("bookingService")
public interface BookingService {
	// 插入数据 调用bookingDAO里的insertBooking配置
	public int insertBooking(Booking booking);

	// 更新数据 调用bookingDAO里的updateBooking配置
	public int updateBooking(Booking booking);

	// 删除数据 调用bookingDAO里的deleteBooking配置
	public int deleteBooking(String bookingid);

	// 查询全部数据 调用bookingDAO里的getAllBooking配置
	public List<Booking> getAllBooking();

	// 按照Booking类里面的字段名称精确查询 调用bookingDAO里的getBookingByCond配置
	public List<Booking> getBookingByCond(Booking booking);

	// 按照Booking类里面的字段名称模糊查询 调用bookingDAO里的getBookingByLike配置
	public List<Booking> getBookingByLike(Booking booking);

	// 按主键查询表返回单一的Booking实例 调用bookingDAO里的getBookingById配置
	public Booking getBookingById(String bookingid);

}

