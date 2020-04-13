CREATE DATABASE bankdb;

CREATE TABLE BankAccount(
id INTEGER NOT NULL PRIMARY KEY  AUTOINCREMENT,
first_name TEXT,
last_name TEXT,
phone_number INT,
email_address TEXT,
residental_address TEXT,
account_balance TEXT,
opening_date TEXT,
modified_date TEXT
);