CREATE TABLE IF NOT EXISTS categories (
    id bigserial PRIMARY KEY,
    title VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO categories (title) VALUES ('USA'),('JPN');

CREATE TABLE IF NOT EXISTS products (id bigserial,
    title VARCHAR(255),
    category_id bigint references categories(id),
    price integer ,
    PRIMARY KEY (id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO products (title,price,category_id) VALUES ('Apple',99,1),('Sony',100,2),('Sony',30,2),('Pony',40,1);

CREATE TABLE IF NOT EXISTS orders (id bigserial,
    username VARCHAR(255),
    total_price int,
    address VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

CREATE TABLE IF NOT EXISTS order_items (
    id bigserial,
    product_id bigint references products(id),
    order_id bigint references orders(id),
    quantity int,
    price_per_product int,
    total_price int, PRIMARY KEY (id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
