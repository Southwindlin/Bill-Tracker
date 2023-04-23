CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE bills (
                       id SERIAL PRIMARY KEY,
                       amount NUMERIC(10, 2) NOT NULL,
                       category VARCHAR(255) NOT NULL,
                       purpose VARCHAR(255) NOT NULL,
                       date DATE NOT NULL,
                       payer INTEGER REFERENCES users(id)
);
