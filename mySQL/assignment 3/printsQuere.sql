USE prints;
SELECT customer_name, customer_add, customer_city, customer_state, customer_zip
FROM customers;
SELECT customer_name, customer_phone
FROM customers
WHERE customer_state = 'GA';
SELECT customer_name, customer_zip
FROM customers
WHERE customer_state = 'NC' OR customer_state = 'SC';
SELECT title, artist, order_date, ship_date
FROM items, orders, orderline
WHERE items.item_id = orderline.item_id AND orderline.order_id = orders.order_id AND orderline.order_qty > 0;
SELECT item_id, title, artist, unit_price, on_hand
FROM items
ORDER BY unit_price;
SELECT item_id, title, artist, unit_price, on_hand
FROM items
WHERE unit_price > 100.00;
SELECT item_id, title, artist, unit_price, on_hand
FROM items
WHERE on_hand > 300;
SELECT title, unit_price, 2 * unit_price AS retail_price
FROM items;
SELECT customer_name, customer_phone
FROM customers, orders
WHERE customers.customer_id = orders.customer_id AND order_date like '2014%';
SELECT artist, SUM(order_qty) AS prints_sold
FROM items, orderline
WHERE items.item_id = orderline.item_id
GROUP BY artist;
SELECT title
FROM items
WHERE unit_price BETWEEN 40.00 AND 100.00;
SELECT customer_name, title, artist, order_qty
FROM items, customers, orderline, orders
WHERE customers.customer_id = orders.customer_id AND orders.order_id = orderline.order_id AND orderline.item_id = items.item_id;
SELECT customer_name, SUM(unit_price * order_qty) AS total_revenue
FROM customers, orderline, orders, items
WHERE customers.customer_id = orders.customer_id AND orders.order_id = orderline.order_id AND orderline.item_id = items.item_id
GROUP BY customers.customer_id;
SELECT customer_state, COUNT(customer_id)
FROM customers
GROUP BY customer_state;