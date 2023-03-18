CREATE TABLE categories(
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(255)
);

INSERT INTO categories(category_name)
VALUES ('Technology'),
       ('Science'),
       ('Health');

CREATE TABLE authors(
    author_id SERIAL PRIMARY KEY ,
    author_name VARCHAR(50),
    gender VARCHAR(50)
);

INSERT INTO authors(author_name, gender)
VALUES ('Heng Sok', 'Male'),
       ('Fallen Love', 'Female'),
       ('Friend', 'Male');