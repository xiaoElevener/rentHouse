package com.xiao.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xiao.dao.HouseDao;
import com.xiao.entity.House;
import com.xiao.entity.HouseCond;
import com.xiao.entity.Page;
import com.xiao.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;

	@Override
	public Page<House> findHouseByCond(HouseCond houseCond, Integer pageNo,
			Integer pageSize) {

		Page<House> result = new Page<House>();
		result.setPageNo(pageNo);
		result.setPageSize(pageSize);

		DetachedCriteria resultCriteria = DetachedCriteria
				.forClass(House.class);
		if (houseCond.getId() != null && houseCond.getId().length() > 0) {
			resultCriteria.add(Restrictions.eq("id",
					Integer.parseInt(houseCond.getId())));
		}

		if (houseCond.getTitle() != null && houseCond.getTitle().length() > 0) {
			resultCriteria.add(Restrictions.like("title",
					"%" + houseCond.getTitle() + "%"));
		}

		if (houseCond.getPrice() != null && houseCond.getPrice().length() > 0) {
			String[] prices = houseCond.getPrice().split("-");
			Integer minPrice = Integer.parseInt(prices[0]);
			Integer maxPrice = Integer.parseInt(prices[1]);
			resultCriteria.add(Restrictions
					.between("price", minPrice, maxPrice));
		}

		if (houseCond.getStreet_id() != null
				&& houseCond.getStreet_id().length() > 0) {
			resultCriteria.createCriteria("street").add(
					Restrictions.eq("streetId",
							Integer.parseInt(houseCond.getStreet_id())));
		}

		if (houseCond.getType_id() != null
				&& houseCond.getType_id().length() > 0) {
			resultCriteria.createCriteria("type").add(
					Restrictions.eq("typeId",
							Integer.parseInt(houseCond.getType_id())));
		}

		if (houseCond.getFloorage() != null
				&& houseCond.getFloorage().length() > 0) {
			String[] areas = houseCond.getFloorage().split("-");
			Integer minArea = Integer.parseInt(areas[0]);
			Integer maxArea = Integer.parseInt(areas[1]);
			resultCriteria.add(Restrictions.between("floorage", minArea,
					maxArea));
		}

		result = houseDao.findHouse(resultCriteria, result);

		return result;
	}

	@Override
	public House findHouseDetail(Integer id) {
		House house = houseDao.findHouseById(id);
		return house;
	}

	@Override
	public Boolean createHouse(House house) throws Exception {
		Boolean isSuccess = houseDao.createHouse(house);
		return isSuccess;
	}

	@Override
	public JSONObject findJsonHouseByCond(HouseCond houseCond, Integer pageNo,
			Integer pageSize) {
		return findHouseByCond(houseCond, pageNo, pageSize).toJsonObject();
	}

}
