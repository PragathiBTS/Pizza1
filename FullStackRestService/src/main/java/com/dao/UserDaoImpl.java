package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public User createUser(User user) {
		System.out.println("inside create");
		Session session = this.sessionFactory.openSession();
		session.save(user);
		return user;
	}

	@Override
	public List<User> readUser() {
		Session session = this.sessionFactory.openSession();
	//HQL
		String readUser="from User";
		List<User> users= session.createQuery(readUser).list();
		return users;
	}

	@Override
	public User readUserById(int userId) {
		Session session = this.sessionFactory.openSession();
		/*String hqlRead="FROM User U WHERE U.userId = 1";
		List<User> users = session.createQuery(hqlRead).list();*/
		
		String hqlRead = "from User U WHERE U.userId = :userId";
		List<User> users = session.createQuery(hqlRead)
		.setParameter("userId", userId)
		.list();
		
		return users.get(0);
	}

	@Override
	public User getUserByName(String userName) {
		
		return null;
	}

	@Override
	public User updateUser(User user) {
		Session session = this.sessionFactory.openSession();
		session.saveOrUpdate(user);
		return user;
	}

	@Override
	public User deleteUserById(int userId) {
		Session session = this.sessionFactory.openSession();
		//session.load(User.class, new Integer(userId));
		//auto boxing
		User obj=session.load(User.class,userId);
		if(obj!=null)
		{
			//org.hib
			session.delete(obj);
			//session.flush();
		}
		
		
		/*Query query = session.createQuery("delete from User U WHERE U.userId = :userId");
		query.setParameter("userId", userId);
		int result = query.executeUpdate();*/
		return obj;
	}

}
