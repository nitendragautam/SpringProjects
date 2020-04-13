package com.nitendratech.bankingapp.dao;

import java.util.List;

import com.nitendratech.bankingapp.model.BankAccount;

/**
 * Interface for Bank Account DAO
 * @author nitendra
 *
 */
public interface BankAccountDAO {
	public void addBankAccountData(BankAccount p);
	public void updateBankAccountData(BankAccount p);
	public List<BankAccount> listBankAccountData();
	public BankAccount getBankAccountDataById(int id);
	public void deleteBankAccountData(BankAccount p);
	
	/**
	 * Search the BankAccount table with name as supplied criteria
	 */
	public List<BankAccount> searchBankAccountsByName(String searchString);
	
	
	
}

