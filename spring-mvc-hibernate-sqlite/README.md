### Spring MVC Application with Hibernate 

#### How to run the application 


a)Copy the file bankdb.sqlite from ```/src/resources````` to your location 

* For Windows

Copy it to any location 

Example: 

Create a Folder Named BankingApp in D:\App .Make sure to create the folder App in D drive first .

Then copy the sqlite it to ```D:\App\BankingApp``` so that final structure looks like ```D:\App\BankingApp\bankdb.sqlite```



This is the path of the data base which is hard coded 
in ```getDataSource()``` method of ```com.nitendratech.bankingapp.config.ApplicationContextConfig``` class

* For Mac of Linux

I have copied it to ```/Users/nitendragautam/apps/bankdb.sqlite``` location and edited the 
```getDataSource()``` method of ```com.nitendratech.bankingapp.config.ApplicationContextConfig``` class

(
(c)Compile the War file and deplpy to Tomcat

Go to the project root location 

```
mvn clean install
```

(d) rename the war file to bankingapp.war from bankingapp-1.0.war  and deploy the command


(e) Deploy in Tomcat  using the User interface 



You should be able to access URL at

```http://127.0.0.1:8080/bankingapp/bankAccount/listBankAccount.html```


##### Note 

As Hibernate does not support SQLite directly , an dialect is used as in org.hibernate.dialect.SQLiteDialect class


This is referenced in ApplicationContextConfig class by method  getHibernateProperties().

To use any other data base like MySQL and SQL Server,define new hibernate properties for that database.


