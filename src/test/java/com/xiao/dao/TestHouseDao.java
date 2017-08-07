package com.xiao.dao;

import java.text.Normalizer.Form;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xiao.entity.House;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@Transactional
public class TestHouseDao {

	@Resource
	SessionFactory sessionFactory;

	@Resource
	private HouseDao houseDao;

	@Test
	public void testFindHouseCount() {
		int n = houseDao.findHouseCount(DetachedCriteria.forClass(House.class));
		System.out.println(n);
	}

	@Test
	public void testFindHouseById() {
		Assert.assertNotNull(houseDao.findHouseById(20));
	}

	@Test
	public void testCreateHouse() throws Exception {
		House house = new House();
		house.setId(1100);
		house.setFloorage(2000);
		houseDao.createHouse(house);
	}

	@Test
	public void testSessionFactory() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from House");
		List<House> list = query.list();
		Assert.assertNotNull(list);

	}
}
