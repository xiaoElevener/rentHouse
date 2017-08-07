package com.xiao.service;

import com.alibaba.fastjson.JSONObject;
import com.xiao.entity.House;
import com.xiao.entity.HouseCond;
import com.xiao.entity.Page;

public interface HouseService {
	Page<House> findHouseByCond(HouseCond houseCond, Integer pageNo,
			Integer pageSize);

	JSONObject findJsonHouseByCond(HouseCond houseCond, Integer pageNo,
			Integer pageSize);

	House findHouseDetail(Integer id);

	Boolean createHouse(House house) throws Exception;
}
