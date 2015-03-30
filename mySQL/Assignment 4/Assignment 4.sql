USE prints;
CREATE VIEW Under_100 AS
SELECT items.item_id, title, artist, unit_price, order_qty AND unit_price < 100
FROM items, orderline
WHERE items.item_id = orderline.item_id AND unit_price < 100;
CREATE VIEW Allen AS
SELECT customers.customer_id, customer_name, customer_phone, title, artist
FROM customers, items, orderline, orders
WHERE customers.customer_id = orders.customer_id AND orders.order_id = orderline.order_id 
AND orderline.item_id = items.item_id AND order_qty >= 1;
CREATE VIEW orders_view AS 
SELECT items.item_id, title, artist, unit_price, order_qty
FROM items, orderline, orders
WHERE items.item_id = orderline.item_id AND orderline.order_id = orders.order_id 
AND order_date BETWEEN CAST('2014-01-01' AS DATE) AND CAST('2014-02-28' AS DATE);
CREATE VIEW zip_27 AS
SELECT customer_name, customer_phone, title, artist, ship_date
FROM customers, items, orders, orderline
WHERE customers.customer_id = orders.customer_id AND orders.order_id = orderline.order_id
AND orderline.item_id = items.item_id AND customer_zip LIKE "27%";
CREATE INDEX customer_id ON customers(customer_id);
CREATE INDEX name ON customers(customer_name);
CREATE INDEX shipped ON orders(customer_id, ship_date);
DROP INDEX name ON customers;
/*ALTER TABLE items ADD CHECK(unit_pirce > 35.00);*/
ALTER TABLE orders ADD FOREIGN KEY (customer_id) REFERENCES customers;
ALTER TABLE orderline ADD FOREIGN KEY (item_id) REFERENCES items;
ALTER TABLE items ADD COLUMN type CHAR(1);
UPDATE items 
SET type = 'M'
WHERE title = 'Skies Above';
ALTER TABLE items CHANGE artist artist CHAR(30);
/* DROP TABLE orders; */