package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.BookingDAO;
import com.entity.Booking;
import com.service.BookingService;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDAO bookingDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertBooking(Booking booking) {
		return this.bookingDAO.insertBooking(booking);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateBooking(Booking booking) {
		return this.bookingDAO.updateBooking(booking);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteBooking(String bookingid) {
		return this.bookingDAO.deleteBooking(bookingid);
	}

	@Override // 继承接口的查询全部
	public List<Booking> getAllBooking() {
		return this.bookingDAO.getAllBooking();
	}

	@Override // 继承接口的按条件精确查询
	public List<Booking> getBookingByCond(Booking booking) {
		return this.bookingDAO.getBookingByCond(booking);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Booking> getBookingByLike(Booking booking) {
		return this.bookingDAO.getBookingByLike(booking);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Booking getBookingById(String bookingid) {
		return this.bookingDAO.getBookingById(bookingid);
	}

}

