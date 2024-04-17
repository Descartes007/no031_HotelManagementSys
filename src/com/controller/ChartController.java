package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Booking;
import com.entity.Topic;
import com.service.BookingService;
import com.service.TopicService;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chart", produces = "text/plain;charset=utf-8")
public class ChartController extends BaseController {
	@Autowired
	private TopicService topicService;
	@Autowired
	private BookingService bookingService;

	@RequestMapping("getCate.action")
	@ResponseBody
	public String getCate() {
		String start = VeDate.getStringDateShort();
		String end = VeDate.getNextDay(start, "-7");
		long days = VeDate.getDays(start, end) + 1;
		JSONArray total = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(end, "" + i);
			System.out.println(nxtDay);
			Booking booking = new Booking();
			booking.setAddtime(nxtDay);
			List<Booking> list = this.bookingService.getBookingByCond(booking);
			double sellTotal = 0;
			double sellCount = 0;
			for (Booking x : list) {
				if ("收入".equals(x.getCate())) {
					sellTotal += Double.parseDouble(x.getTotal());
				} else {
					sellCount = Double.parseDouble(x.getTotal());
				}
			}
			total.add(VeDate.getDouble(sellTotal));
			count.add(sellCount);
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("sellTotal", total.toString());
		json.put("sellCount", count.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("getReason.action")
	@ResponseBody
	public String getReason() {
		String start = VeDate.getStringDateShort();
		String end = VeDate.getNextDay(start, "-7");
		long days = VeDate.getDays(start, end) + 1;
		JSONArray total = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		JSONArray day = new JSONArray(); // 存放名称
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(end, "" + i);
			System.out.println(nxtDay);
			Booking booking = new Booking();
			booking.setAddtime(nxtDay);
			List<Booking> list = this.bookingService.getBookingByCond(booking);
			double sellTotal = 0;
			double sellCount = 0;
			for (Booking x : list) {
				if ("餐饮收入".equals(x.getReason())) {
					sellTotal += Double.parseDouble(x.getTotal());
				}
				if ("客房收入".equals(x.getReason())) {
					sellCount = Double.parseDouble(x.getTotal());
				}
			}
			total.add(VeDate.getDouble(sellTotal));
			count.add(sellCount);
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("sellTotal", total.toString());
		json.put("sellCount", count.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("chartPie.action")
	@ResponseBody
	public String chartPie() {
		JSONArray names = new JSONArray();
		JSONArray count = new JSONArray();// 定义count存放数值
		int stars1 = 0;
		int stars2 = 0;
		int stars3 = 0;
		int stars4 = 0;
		int stars5 = 0;
		names.add("非常满意");
		names.add("满意");
		names.add("一般");
		names.add("不满意");
		names.add("非常不满意");
		List<Topic> topicList = this.topicService.getAllTopic();
		for (Topic topic : topicList) {
			if ("1".equals(topic.getNum())) {
				stars1++;
			}
			if ("2".equals(topic.getNum())) {
				stars2++;
			}
			if ("3".equals(topic.getNum())) {
				stars3++;
			}
			if ("4".equals(topic.getNum())) {
				stars4++;
			}
			if ("5".equals(topic.getNum())) {
				stars5++;
			}

		}
		count.add(stars5);
		count.add(stars4);
		count.add(stars3);
		count.add(stars2);
		count.add(stars1);
		JSONObject json = new JSONObject();
		json.put("count", count.toString());
		json.put("names", names.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

}
