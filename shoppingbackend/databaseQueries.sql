create table category(

id IDENTITY,
name varchar(50),
description varchar(225),
image_url varchar(50),
is_active boolean,
constraint pk_category_id primary key(id)
);
INSERT INTO category(name,description,image_url,is_active) VALUES('Mobile','this   ss about mobile','cat_1.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('Television','this is about television','cat_2.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('LAPTOP','this is about laptop','cat_3.png','true');

CREATE TABLE user_detail(
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
email VARCHAR(50),
contact_number VARCHAR(50),
CONSTRAINT pk_user_id PRIMARY KEY(id),

);

INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('chacha','chaudhary','ADMIN','true','admin','chacha@chutya.com','9999999999');

INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('siddhant','chauhan','SUPPLIER','true','12345','sid@1209.com','8888888888');

INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
VALUES('anmol','chaudhary','SUPPLIER','true','12345','anmolchaudhary72@gmail.com','7777777777');

CREATE TABLE product(
 id IDENTITY,
 code VARCHAR(20),
 name VARCHAR(50),
 brand VARCHAR(50),
 description VARCHAR(50),
 unit_price DECIMAL(10,2),
 quantity INT,
 is_active BOOLEAN,
 category_id INT,
 supplier_id INT,
 purchases INT DEFAULT 0,
 views INT DEFAULT 0,
 CONSTRAINT pk_product_id PRIMARY KEY(id),
 CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
 CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);

