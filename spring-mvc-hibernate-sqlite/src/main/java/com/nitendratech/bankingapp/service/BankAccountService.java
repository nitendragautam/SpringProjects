package com.nitendratech.bankingapp.service;

import java.util.List;

import com.nitendratech.bankingapp.model.BankAccount;

public interface BankAccountService {

	public void addBankAccountData(BankAccount p);
	public void updateBankAccountData(BankAccount p);
	public List<BankAccount> listBankAccountData();
	public BankAccount getBankAccountDataById(int id);
    public void deleteBankAccountData(BankAccount p);
    
  //Search the Table according to Given Name
    public List<BankAccount> searchBankAccountByName(String searchString);
   
    
}
