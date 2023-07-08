package com.sunil.springBoot.SpringBootRestApi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunil.springBoot.SpringBootRestApi.entity.Customer;

import jakarta.persistence.EntityManager;



@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Customer> getAll() {
		//get current hibernate session
		Session hibernateSession = entityManager.unwrap(Session.class);
		//create a query
		Query<Customer> theQuery = hibernateSession.createQuery("from Customer", Customer.class);
		//execute
		List<Customer> customer = theQuery.getResultList();
		//return result
		return customer;
	}




	@Override
	public Customer getById(int id) {
		Session hibernateSession = entityManager.unwrap(Session.class);
		Customer c = hibernateSession.get(Customer.class, id);
		return c;
	}



	@Override
	public Object insert(Customer customer) {
		Session hibernateSession = entityManager.unwrap(Session.class);
		Object obj=hibernateSession.merge(customer);
		return obj;
	}

	@Override
	public int delete(int id) {
		Session hibernateSession = entityManager.unwrap(Session.class);
		
//	  	Query theQuery =hibernateSession.createQuery("delete from Customer where id:=cid");
//			theQuery.setParameter("cid", id);
//					int id1 = theQuery.executeUpdate();

			//or .........
			Customer c = hibernateSession.get(Customer.class, id);
			 hibernateSession.remove(c);
			
			
		return id;
	}

}
