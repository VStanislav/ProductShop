
CREATE TABLE users (id bigserial, user_name VARCHAR(255), password VARCHAR(255), email VARCHAR(255),PRIMARY KEY (id),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO users (user_name,password,email) VALUES ('Jon','$2y$10$bKESjQ2JjLAGuinwe3nsCeGJS8q7n4/ZnEMQEHRXkTkQIDN9joPK.','jon@gmail.com'),('Billy','$2y$10$x1tkHIqBTsJsvHcGilhR.OrjGMfDShbGCDMuqn0L8CUr8tCP2eqNK','billy@gmail.com'),('Kody','$2y$10$gqCtfLtnt8biDXCYoZOpvOrElk..Yl0JjmOWg3B.uwotPJJ5yh2eu','kody@gmail.com');

CREATE TABLE roles (id bigserial, name VARCHAR(255),PRIMARY KEY (id),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO roles (name) VALUES ('GUEST'),('ROLE_USER'),('ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS users_role (user_id bigint,authority_id int,primary key (user_id,authority_id),foreign key (authority_id) references roles (id),foreign key (user_id) references users (id),created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
INSERT INTO users_role (user_id,authority_id) VALUES (1,1),(2,2),(3,3);