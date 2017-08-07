package com.xiao.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.xiao.entity.House;
import com.xiao.entity.Page;

public interface HouseDao {
	Integer findHouseCount(DetachedCriteria countCriteria);

	Page<House> findHouse(DetachedCriteria criteria, Page<House> page);
	
	House findHouseById(Integer id);

	Boolean createHouse(House house) throws Exception;
}
