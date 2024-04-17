package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UsersDAO;
import com.entity.Users;
import com.util.VeDate;

public class UsersTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		UsersDAO usersDAO = (UsersDAO) resource.getBean(UsersDAO.class);
		for (int i = 10; i < 25; i++) {
			Users users = new Users();
			users.setBirthday(VeDate.getStringDateShort());
			users.setContact("" + i);
			users.setPassword("" + i);
			users.setRealname("" + i);
			users.setRegdate(VeDate.getStringDateShort());
			if (i % 2 == 0) {
				users.setSex("男");
			} else {
				users.setSex("女");
			}
			users.setUsername("" + i);
			users.setUsersid("" + i);
			usersDAO.insertUsers(users);
		}
	}

}
