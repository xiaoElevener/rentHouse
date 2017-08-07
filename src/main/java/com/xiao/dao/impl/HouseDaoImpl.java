package com.xiao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiao.dao.HouseDao;
import com.xiao.entity.District;
import com.xiao.entity.House;
import com.xiao.entity.Page;
import com.xiao.entity.Street;
import com.xiao.entity.Type;
import com.xiao.entity.Users;

@Repository
public class HouseDaoImpl implements HouseDao {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 查询房屋数量
	 */
	public Integer findHouseCount(DetachedCriteria countCriteria) {
		Session session = sessionFactory.getCurrentSession();
		Long count = (Long) countCriteria.setProjection(Projections.rowCount()).getExecutableCriteria(session)
				.uniqueResult();
		return count.intValue();
	}

	public Page<House> findHouse(DetachedCriteria criteria, Page<House> page) {
		Session session = sessionFactory.getCurrentSession();
		int count = findHouseCount(criteria);
		/**
		 * 复原criteria
		 */
		criteria.setProjection(null);
		criteria.setResultTransformer(Criteria.ROOT_ENTITY);

		page.setTotalRecords(count);
		System.out.println("-------------查询page前----------");
		@SuppressWarnings("unchecked")
		List<House> list = criteria.getExecutableCriteria(session)
				.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize()).list();
		System.out.println("-------------查询page后----------");
		page.setTotalRecords(count);
		page.setList(list);
		return page;
	}

	public House findHouseById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		House house = (House) session.createCriteria(House.class).add(Restrictions.eq("id", id)).uniqueResult();
		return house;
	}

	public Boolean createHouse(House house) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			int house_id = (Integer) session.createQuery("select max(c.id) from House c").uniqueResult();
			house.setId(house_id + 1);
			Users users = (Users) session.get(Users.class, house.getUsers().getUserId());
			Type type = (Type) session.get(Type.class, house.getType().getTypeId());
			District district = (District) session.get(District.class, house.getStreet().getDistrict().getDistrictId());
			Street street = (Street) session.get(Street.class, house.getStreet().getStreetId());
			street.setDistrict(district);

			house.setUsers(users);
			house.setType(type);
			house.setStreet(street);
			session.save(house);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
