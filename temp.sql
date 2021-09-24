show databases;
create database bank;
use bank;
create table signup(Fname varchar(20),email varchar(50),username varchar(20) primary key,ph_number numeric(10),Acc_number numeric(10),gender varchar(20),Account_Type varchar(20),password varchar(15),r_password varchar(15), balance int default 5000);
show tables;
describe signup;

insert into signup values("Bhupati","Krishna","Gudla","xyz@gmail.com","bgudla000",9870207601,"bbgudla000","bbgudla000",1000);
insert into signup values("Harish","ram","tumma","htumma@gmail.com","htumma000",9870207601,"hhtumma000","hhtumma000","5000");

drop table bhu;

select * from signup;
select * from signup where username ="bgudla000" and password ="bbgudla000"; 
delete from signup;
alter table signup add primary key (username);
alter table signup add primary key (email);
UPDATE signup SET Acc_number= 66666 where username = "bkg";
SET SQL_SAFE_UPDATES = 0;                       -- removes the safe mode                

alter table signup add balance numeric(9);
alter table signup;
insert into signup (balance) values (5000);

ALTER TABLE signup
MODIFY COLUMN Fname varchar(50);

ALTER TABLE signup
MODIFY COLUMN password varchar(100);


alter table signup
drop column balance;


select balance from signup where username='bhupati';


update signup set balance = '10000'  where username = 'bhu';


create table transaction(username varchar(20),Acc_number numeric(10),Date_time varchar(100), Activity varchar(10) , Amount int);
desc transaction;
select * from bgudla00;
select * from ram00;
select * from tpraful00;
delete from bhu;

insert into bhu value(current_timestamp(),'Deposit',5000);


select * from radha;
select * from signup where username = 'admin111' and  Acc_number = 9630258 and password ='asdfasdfasdf';

select * from transaction;


select Date_time,Activity,Amount from transaction where username = 'radha' and Acc_number = 7410258;

select * from signup where username = 'radha' and Acc_number = 7410258 and password = 'radha12345';

select Fname,email,ph_number,gender,Account_Type from signup where username = 'srdKBtaBtn' and Acc_number = 868686;