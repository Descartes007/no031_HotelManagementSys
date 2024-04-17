package com.test;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.OrdersDAO;
import com.dao.UsersDAO;
import com.entity.Orders;
import com.entity.Users;
import com.util.VeDate;

public class OrdersTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		UsersDAO usersDAO = (UsersDAO) resource.getBean(UsersDAO.class);
		OrdersDAO ordersDAO = (OrdersDAO) resource.getBean(OrdersDAO.class);
		List<Users> usersList = usersDAO.getAllUsers();
		for (Users users : usersList) {
			String userid = users.getUsersid();
			Random rand = new Random();
			int x = rand.nextInt(5) + 1;
			for (int i = 0; i < x; i++) {
				String ordercode = "PD" + VeDate.getStringDatex();
				Orders orders = new Orders();
				orders.setOrdersid(UUID.randomUUID().toString().replace("-", ""));
				orders.setAddtime(VeDate.getNextDay(VeDate.getStringDateShort(), "-" + i));
				orders.setOrdercode(ordercode);
				orders.setStatus("已评价");
				orders.setTotal(VeDate.getRandomDouble());
				orders.setUsersid(userid);
				ordersDAO.insertOrders(orders);
			}
		}

	}

}
