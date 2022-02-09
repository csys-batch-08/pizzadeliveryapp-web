--users table
create table users
(user_id int GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
    user_name varchar(32) not null,
    phonenumber int not null,
    email varchar2(40) UNIQUE,
    address varchar2(100) not null,
    type varchar2(32) default 'user',
    wallet int default 5000,
    password varchar2(32) not null); 

select user_id from users where email='vicky@gmail.com';

select * from users;

select *  from users;

select user_id,user_name,phonenumber,email,address,wallet,password,role from users where email='vicky@gmail.com' and password='Hari@123';

drop table products CASCADE CONSTRAINTS;

--products table
create table products
(product_id int GENERATED ALWAYS AS IDENTITY START WITH 501 primary key,
product_name varchar2(32) not null,
product_size varchar2(32) not null,
price int not null,
status varchar2(32) default 'Available');  


insert into products(product_name,product_size,price)values('corn','large',60);

select * from products;

--order table 
create table orders(order_id int GENERATED ALWAYS AS IDENTITY START WITH 1001 primary key,
user_id int,
product_id int,
quantity int not null,
total_prize int not null,
order_date date not null,
status varchar2(32) default 'pending',
FOREIGN key(user_id) REFERENCES users(user_id),
foreign key(product_id) references products(product_id));


select * from orders;

--cart
create table cart(cart_id int GENERATED ALWAYS AS IDENTITY START WITH 7001 primary key,
user_id int,
product_id int,
quantity int not null,
total_prize int not null,
FOREIGN key (product_id) REFERENCES products(product_id),
FOREIGN key(user_id) REFERENCES users(user_id)); 

select product_id,product_name,product_size,price from products where product_name like 'fatboy%' where status='unAvailable';

select * from cart;

drop table orders CASCADE CONSTRAINTS;

--invoice bill
create table bills(bill_id int GENERATED ALWAYS AS IDENTITY START WITH 5001 primary key,
order_id int,
user_id int,
product_id int,
purchase_date date not null,
status varchar2(32) default 'delivered',
FOREIGN key (user_id) REFERENCES users(user_id),
FOREIGN key (product_id) REFERENCES products(product_id),
FOREIGN key(order_id) REFERENCES orders(order_id)); 

commit;

select * from users;
select * from products;
select * from orders;
select * from cart;
select * from bills;

select user_id,user_name,phonenumber,email,address,wallet,password,role from users;

select u.user_name,u.phonenumber,u.email,u.address,o.product_id,o.quantity,o.total_prize,o.order_date from users u join orders o on u.user_id=o.user_id;

select users.user_name,users.phonenumber,users.email,orders.product_id,orders.quantity,orders.total_prize,orders.order_date from users join orders on users.user_id = orders.user_id;

select product_id,product_name,product_size,price from products where status='Avilable' and product_name like 'f%' ;

select * from users where email='vicky@gmail.com' and password='Hari@123';

drop table products CASCADE CONSTRAINTS;

update users set wallet=wallet+90 where email='vicky@gmail.com';

commit;

select sum(total_prize) from  orders where status='pending' and order_date between '05-01-22' and  '17-01-22';

select * from users; 

select * from orders where user_id=22;

select * from products where product_name like 'c%';

update users set wallet=wallet-12100 where user_id=2;
select * from orders  where user_id=3;


select * from products where product_name like 'c%' ;

select product_id,product_name,product_size,price,status from products where status='Avilable' order by product_name;

select product_name,products.product_size from products join orders on  products.product_id=;

Select DISTINCT products.product_name, products.product_size,sum(orders.total_prize) total_price from orders join products on products.product_id=orders.product_id where orders.order_date between '05-01-22' and '13-01-22' group by products.product_name ,products.product_size order by total_price asc;

Select  products.product_name, products.product_size,orders.total_prize from orders join products on products.product_id=orders.product_id where orders.order_date between '05-01-22' and '13-01-22';

Select  products.product_name, products.product_size,orders.total_prize from orders join products on products.product_id=orders.product_id where orders.order_date between ? and ? order by orders.total_prize desc;

select users.user_name ,sum(orders.total_prize) total_prize from orders join users on users.user_id=orders.user_id where orders.order_date between '05-01-22' and '27-01-22' group by users.user_name  order by total_prize desc;