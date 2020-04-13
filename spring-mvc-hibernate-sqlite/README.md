### Spring MVC Application with Hibernate 

#### How to run the application 
(a)Create a Folder Named BankingApp in D:\App .Make sure to creae the folder App in D drive first 


(b)Copy the file bankdb.sqlite from /src/resources to D:\App\BankingApp so that final structurue looks like D:\App\BankingApp\bankdb.sqlite


This is the path of the data base which is hard coded in ApplicationContextConfig class


(c)Compile the War file and deploy in Tomcat 


You should be able to access URL at http://localhost:8080/bankingapp/bankAccount/listBankAccount.html



##### Note 

As Hibernate does not support SQLite directly , an dialect is used as in org.hibernate.dialect.SQLiteDialect class


This is referenced in ApplicationContextConfig class by method  getHibernateProperties().

To use any other data base like MySQL and SQL Server,define new hibernate properties for that database.


