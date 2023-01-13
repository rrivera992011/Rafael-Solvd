INSERT INTO category VALUES (1, 'Pizza');
INSERT INTO category VALUES (2, 'Antibiotic');
INSERT INTO customer(first_name, last_name, phone_number, age, address) VALUES ('Tom', 'Jackson', '6541231234', 21, 'Road'); 
INSERT INTO customer VALUES (2, 'Tom', 'Sawyer', '2342345675', 22, '12 easy street');
INSERT INTO employee_type VALUES (1, 'Pharmacist');
INSERT INTO appointment VALUES (1, '2023-1-13 13:00:00', 1, 1, 1);
INSERT INTO employee VALUES (1,'Antonio', 'Justin', '1234567', 1);
INSERT INTO appointment_type VALUES (1, 'Vaccine');
INSERT INTO appointment_type VALUES (2, 'Check-up');
INSERT INTO recipe VALUES (1, 'Amoxicillin');

UPDATE customer SET first_name = 'Mike' WHERE first_name = 'Tom';
UPDATE customer SET first_name = 'Sanders' WHERE last_name = 'Jackson';
UPDATE customer SET address = '152 Pain Avenue' WHERE address = '12 easy street';
UPDATE customer SET age = 17 WHERE age = 22;
UPDATE employee SET first_name = 'Andrew' WHERE first_name = 'Antonio';
UPDATE employee_type SET employee_type = 'Doctor' WHERE employee_type = 'Clerk';
UPDATE category SET category_name = 'Headache' WHERE category_name = 'Pizza';
UPDATE category SET category_name = 'Glucose' WHERE category_name = 'Antibiotic';
UPDATE appointment_type SET appointment_type = 'Refill' WHERE appointment_type = 'Vaccine';
UPDATE appointment_type SET appointment_type = 'Insurance' WHERE appointment_type = "Vaccine";

DELETE FROM category WHERE category_name = 'Pizza';
DELETE FROM category WHERE category_name = 'Antibiotic';
DELETE FROM customer WHERE age = 22;
DELETE FROM employee;
DELETE FROM employee_type;
DELETE FROM employee WHERE employee_id = 1;
DELETE FROM employee_type WHERE employee_type_id = 1;
DELETE FROM appointment_type;
DELETE FROM category;
DELETE FROM examination;

ALTER TABLE customer RENAME COLUMN age to how_old;
ALTER TABLE customer RENAME COLUMN how_old TO age;
ALTER TABLE recipe RENAME COLUMN size to size_in_milliliters;
ALTER TABLE prescription RENAME COLUMN rx_number to prescription_number;
ALTER TABLE category ADD location_in_store varchar(255);

SELECT * FROM customer
	LEFT JOIN appointment ON customer.customer_id = appointment.customer_id
    LEFT JOIN examination ON customer.customer_id = examination.customer_id
    LEFT JOIN customer_order ON customer.customer_id = customer_order.customer_id
    LEFT JOIN prescription ON customer.customer_id = prescription.customer_id
	LEFT JOIN appointment_type ON appointment.appointment_type_id = appointment_type.appointment_type_id
    LEFT JOIN employee ON appointment.employee_id = employee.employee_id
	LEFT JOIN examination_type ON examination.examination_type_id = examination_type.examination_type_id
    LEFT JOIN payment_type ON customer_order.payment_type_id = payment_type.payment_type_id
    LEFT JOIN inventory ON prescription.inventory_id = customer_order.product_id
	LEFT JOIN recipe ON prescription.recipe_id = recipe.recipe_id
    LEFT JOIN category ON inventory.category_id = category.category_id
    LEFT JOIN employee_type ON employee.employee_type_id = employee_type.employee_type_id;
	
SELECT * FROM customer LEFT JOIN appointment ON customer.customer_id = appointment.customer_id;
SELECT * FROM employee RIGHT JOIN employee_type ON employee.employee_type_id = employee_type.employee_type_id;
SELECT * FROM employee CROSS JOIN employee_type;
SELECT * FROM appointment CROSS JOIN appointment_type;
SELECT * FROM customer
LEFT JOIN appointment ON customer.customer_id = appointment.customer_id 
UNION
SELECT * FROM customer
RIGHT JOIN appointment ON customer.customer_id = appointment.customer_id;

SELECT COUNT(customer_id) from customer;
SELECT AVG(age) FROM customer;
SELECT SUM(age) FROM customer;
SELECT MAX(price) AS highest_price from inventory;
SELECT MIN(price) AS lowest_price from inventory;
SELECT MIN(age) AS youngest FROM customer;
SELECT MAX(age) AS oldest FROM customer;

SELECT COUNT(customer_id), age FROM customer GROUP BY age HAVING COUNT(customer_id) > 0;
SELECT COUNT(customer_id), phone_number FROM customer GROUP BY phone_number HAVING COUNT(customer_id) > 0;
SELECT COUNT(price), category_name FROM category GROUP BY category_name HAVING MIN(price) < 21;
SELECT COUNT(price), category_name FROM category GROUP BY category_name HAVING MIN(price) > 21;
SELECT COUNT(age), last_name FROM customer GROUP BY last_name HAVING MIN(age) < 17;
SELECT COUNT(age), last_name FROM customer GROUP BY last_name HAVING MIN(age) > 17;
SELECT COUNT(age), age FROM customer GROUP BY age HAVING MIN(age) > 17;