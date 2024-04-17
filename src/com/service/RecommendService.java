package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Foods;

@Service("recommendService")
public interface RecommendService {
	public List<Foods> getRecommend(String userid);
}
