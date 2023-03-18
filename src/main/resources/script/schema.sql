CREATE TABLE authors(
    author_id SERIAL PRIMARY KEY ,
    author_name VARCHAR(50) NOT NULL,
    gender VARCHAR(50) NOT NULL
);

INSERT INTO authors(author_name, gender)
VALUES ('Heng Sok', 'Male'),
       ('Fallen Love', 'Female'),
       ('Friend', 'Male');


CREATE TABLE categories(
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

INSERT INTO categories(category_name)
VALUES ('Technology'),
       ('Science'),
       ('Health'),
       ('Fiction');

CREATE TABLE books(
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    published_date DATE,
    author_id INT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);

CREATE TABLE book_detail(
    id SERIAL PRIMARY KEY,
    book_id INT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

INSERT INTO books(title, published_date, author_id)
VALUES ('The Great Gatsby', '2001-04-10', 1),
       ('To Catch a Mockingbird', '1960-07-11', 2),
       ('Doctor Strange', '2015-06-08', 3);

INSERT INTO book_detail (book_id, category_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 4);