CREATE TABLE products (id bigserial, title VARCHAR(255), category_id bigint references categories(id),price integer , PRIMARY KEY (id),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO products (title,price) VALUES ('Apple',99),('Sony',100),('Sony',30),('Pony',40);

CREATE TABLE orders (id bigserial, username VARCHAR(255), total_price int,address VARCHAR(255), phone VARCHAR(255), PRIMARY KEY (id),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);


CREATE TABLE order_items (id bigserial, product_id bigint references products(id), order_id bigint references orders(id),quantity int, price_per_product int,price int, PRIMARY KEY (id),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
