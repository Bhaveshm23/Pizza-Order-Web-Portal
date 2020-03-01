DROP DATABASE IF EXISTS pizzaProject;
CREATE DATABASE pizzaProject; 
USE pizzaProject;

DROP TABLE IF EXISTS Pizza;


CREATE TABLE IF NOT EXISTS Pizza (

  pizzaId integer primary key,
  pizzaName varchar(20),
  price double
);

DROP TABLE IF EXISTS Pizza_Order;

CREATE TABLE IF NOT EXISTS Pizza_Order(
	
	orderId integer primary key auto_increment,
	customerName varchar(30),
	contactNumber varchar(10),
	pizzaId integer,
	numberOfPiecesOrdered integer,
	bill double,
	foreign key(pizzaId) references Pizza(pizzaId)
	
);
INSERT INTO Pizza VALUES
	(1001, 'XYZVegS', 200),
	(1002, 'XYZVegM', 400),
	(1003, 'XYZVegL', 600),
	(1004, 'XYZNonVegS', 400);

INSERT INTO Pizza_Order VALUES
	(5001, 'Peter','1234567890',1001,1,200),
	(5002, 'Thomas','4567891230',1001,2,400),
	(5003, 'Decken','7890123456',1003,1,600),
	(5004, 'Jenifer','0123456789',1004,2,800);

	
	
commit;