DROP TABLE IF EXISTS userBalance;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS userDetail;
DROP TABLE IF EXISTS roles;




CREATE TABLE roles (
	role_id SERIAL PRIMARY KEY,
	role_name VARCHAR (50)
);

CREATE TABLE userDetail(
	user_name VARCHAR(50) PRIMARY KEY,
	user_str VARCHAR(30),
	user_city VARCHAR(30),
	user_region VARCHAR(30),
	user_zip VARCHAR(10),
	user_country VARCHAR(20)
);

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	user_name VARCHAR(50) REFERENCES userDetail(user_name),
	user_acc VARCHAR(150),
	user_email VARCHAR(150),
	user_password VARCHAR(50),
	role_id INT REFERENCES roles(role_id)
	
);

CREATE TABLE userBalance (
	balance_id SERIAL PRIMARY KEY,
	user_id INT REFERENCES users(user_id),
	user_balance DECIMAL DEFAULT 0
);


INSERT INTO roles(role_name) VALUES
('Admin'),
('Banker'),
('Customer');

INSERT INTO userdetail (
user_name,
user_str,
user_city,
user_region,
user_zip,
user_country
) VALUES
('Jaehyun Lewis', 'some street name', 'Tacoma', 'WA', '12345', 'USA'),
('john johns', 'some street name2', 'Los Angelos', 'CA', '12346', 'USA'),
('customer', 'some street name 3', 'Los Angelos', 'CA', '12347', 'USA');

INSERT INTO users(
user_name,
user_acc,
user_email,
user_password,
role_id
) VALUES
('Jaehyun Lewis', 'Admin', 'Admin@gmail.com', 'password', '1'),
('john johns', 'Banker', 'Banker@gmail.com', 'password1', '2'),
('customer', 'customer1', 'customer@gmail.com', 'password2', '3');

INSERT INTO userbalance (
user_id,
user_balance
) VALUES
(1, 2000),
(2, 0),
(3, 13);