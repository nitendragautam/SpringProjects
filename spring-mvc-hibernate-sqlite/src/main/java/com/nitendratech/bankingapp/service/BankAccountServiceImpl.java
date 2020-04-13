package com.nitendratech.bankingapp.service;

import java.util.List;


import com.nitendratech.bankingapp.dao.BankAccountDAO;
import com.nitendratech.bankingapp.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Implementation of Bank Service Class
 * Contains Business Logic
 * Defines the transactional Manager 
 */

@Service("bankAccountService")
public class BankAccountServiceImpl implements BankAccountService {

	private BankAccountDAO bankAccountDAO;

	public BankAccountServiceImpl(BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO=bankAccountDAO;
	}

	@Autowired
	@Qualifier("bankAccountDAO")
	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO = bankAccountDAO;
	}

	@Override
	@Transactional("bankAccountTransactionManager")
	public void addBankAccountData(BankAccount p) {
		bankAccountDAO.addBankAccountData(p);
	}

	@Override
	@Transactional("bankAccountTransactionManager")
	public void updateBankAccountData(BankAccount p) {
		
		if (p.getId() > 0) {
			bankAccountDAO.updateBankAccountData(p);
		}

	}

	@Override
	@Transactional("bankAccountTransactionManager")
	public List<BankAccount> listBankAccountData() {

		return bankAccountDAO.listBankAccountData();

	}

	@Override
	@Transactional("bankAccountTransactionManager")
	public BankAccount getBankAccountDataById(int id) {
		return bankAccountDAO.getBankAccountDataById(id);

	}

	
	@Override
	@Transactional("bankAccountTransactionManager")
	public void deleteBankAccountData(BankAccount p) {
		this.bankAccountDAO.deleteBankAccountData(p);

	}
	
	
	@Override
	@Transactional("bankAccountTransactionManager")
	public List<BankAccount> searchBankAccountByName(String searchString){
		return bankAccountDAO.searchBankAccountsByName(searchString);
	}

	
	
	
	
	
}
