CREATE TABLE categories(
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(255)
);

INSERT INTO categories(category_name)
VALUES ('Technology'),
       ('Science'),
       ('Health');