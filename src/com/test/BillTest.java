package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BookingDAO;
import com.entity.Booking;
import com.util.VeDate;

public class BillTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		BookingDAO bookingDAO = (BookingDAO) resource.getBean(BookingDAO.class);
		String start = VeDate.getStringDateShort();
		String end = VeDate.getNextDay(start, "-7");
		long days = VeDate.getDays(start, end) + 1;
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(end, "" + i);
			if (1 == 1) {
				Booking booking = new Booking();
				booking.setAddtime(nxtDay);
				booking.setBno("B" + VeDate.getStringDatex() + i);
				booking.setCate("支出");
				booking.setReason("采购支出");
				booking.setTotal("" + VeDate.getRandomDouble());
				booking.setBookingid("B" + VeDate.getStringDatex() + i);
				bookingDAO.insertBooking(booking);
			}

			if (2 == 2) {
				Booking booking = new Booking();
				booking.setAddtime(nxtDay);
				booking.setBno("RD" + VeDate.getStringDatex() + i + 20);
				booking.setCate("收入");
				booking.setReason("客房收入");
				booking.setTotal("" + VeDate.getRandomDouble());
				booking.setBookingid("B" + VeDate.getStringDatex() + i + 20);
				bookingDAO.insertBooking(booking);
			}

			if (3 == 3) {
				Booking booking = new Booking();
				booking.setAddtime(nxtDay);
				booking.setBno("FD" + VeDate.getStringDatex() + i + 30);
				booking.setCate("收入");
				booking.setReason("餐饮收入");
				booking.setTotal("" + VeDate.getRandomDouble());
				booking.setBookingid("B" + VeDate.getStringDatex() + i + 30);
				bookingDAO.insertBooking(booking);
			}

		}
	}

}
