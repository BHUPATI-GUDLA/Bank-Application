
# Bank Application 🏦 
In this bank application I was created few bank application and ATM features as follow,

## Features of application 

| Features        | Description                                                          |
| ----------------- | ------------------------------------------------------------------ |
|Show user balance   | In this bank user can see his available balance in account. |
| Deposit  | In this user can deposit money into his account.  |
| Withdrawa | In this user can withdraw some money from his account |
| Transfer money | In this user can transfer money to exiting user of bank |
| Mini Statement | In this user can see his past transaction history |
| User Profile | In this user can see is detials which is available in bank |


## Tech Stack

*Client:* HTML, CSS, JavaScript 

*Server-side:* MySQL, Java, Servlet, JSP

*Server used for Demo:* Tomcat V9.0 server

## Steps To Deployment

1) Download Eclips IDE.
2) Download any Tomcat server.
3) Download MySql and create database bank (*case sensitive*)
4) After creating bank database you need to create two tables 

- First Table sql query is
```bash
  create table signup(Fname varchar(20),email varchar(50),username varchar(20) primary key,ph_number numeric(10),Acc_number numeric(10),gender varchar(20),Account_Type varchar(20),password varchar(15),r_password varchar(15), balance int default 5000);
```
- Second Table sql query is
```bash
  create table transaction(username varchar(20),Acc_number numeric(10),Date_time varchar(100), Activity varchar(10) , Amount int);
```

6) connect Tomcat server and Eclips IDE.
7) Create Dynamic Project in Eclips.
8) Replace you src file with this repository src file.
9) Also replace yor WebConten File with this repository WebConten File.
10) Now in eclips right click on project, go to Run As and Run on Server.

Note: change browser settings in eclips if you want. If you not change browser settings then the project will run in eclips inbuilt browser.

  
  
  
  
## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)



## Author

Instagram - [bhupati_gudla](https://www.instagram.com/bhupati_gudla/)

## Note
- Guys if you have any issues regarding setup this project or any queries related to this project then message me on my Instagram ID 👆

  
