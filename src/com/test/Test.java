package com.test;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.AdminDAO;
import com.entity.Admin;
import com.util.VeDate;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		AdminDAO adminDAO = (AdminDAO) resource.getBean(AdminDAO.class);
		for (int i = 0; i < 45; i++) {
			Admin admin = new Admin();
			admin.setAdminid(UUID.randomUUID().toString());
			admin.setUsername("admin" + i);
			admin.setPassword("admin" + i);
			admin.setRealname("admin" + i);
			admin.setContact("-" + i + i * i);
			admin.setAddtime(VeDate.getStringDateShort());
			adminDAO.insertAdmin(admin);
		}
	}
}






































