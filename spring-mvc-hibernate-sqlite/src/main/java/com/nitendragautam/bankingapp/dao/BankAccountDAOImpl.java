package com.nitendragautam.bankingapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nitendragautam.bankingapp.model.BankAccount;

/*
 * Implementation of the BankAccountDAO class
 */
@Repository
public class BankAccountDAOImpl implements BankAccountDAO {

	private SessionFactory sessionFactory;

	public BankAccountDAOImpl() {

	}

	public BankAccountDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Transaction tx = null;

	private static final Logger logger = LoggerFactory.getLogger(BankAccountDAOImpl.class);

	@Autowired
	@Qualifier("bankAccountSessionFactory")
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addBankAccountData(BankAccount p) {

		Session session = this.sessionFactory.openSession();

		try {
			tx = session.beginTransaction();
			session.save(p);
			logger.info("Bank Account saved successfully, BankAccount Details=" + p);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			
				session.close();
			

		}

	}

	@Override
	public void updateBankAccountData(BankAccount p) {
		Session session = this.sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.update(p);
			logger.info("Bank Account updated successfully, BankAccountDetails=" + p);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			
				session.close();
			
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankAccount> listBankAccountData() {
		List<BankAccount> listAllBankAccountData = new ArrayList<BankAccount>();
		Session session = this.sessionFactory.getCurrentSession();
		listAllBankAccountData = session.createQuery("From BankAccount").list();

		return listAllBankAccountData;

	}

	@Override
	public BankAccount getBankAccountDataById(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		BankAccount p = (BankAccount) session.load(BankAccount.class, new Integer(id));
		logger.info("Bank Account loaded successfully, Bank Account details=" + p);
		return p;

	}

	@Override
	public void deleteBankAccountData(BankAccount p) {

		Session session = this.sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.delete(p);

			tx.commit();
			logger.info("Bank Account Deleted successfully, BankAccount details=" + p);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			
				session.close();
			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankAccount> searchBankAccountsByName(String searchString) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BankAccount.class);
		criteria.add(Restrictions.ilike("lastName", searchString + "%"));
		return criteria.list();
	}

}
