CREATE TABLE cat (ID SERIAL PRIMARY KEY ,NAME  VARCHAR(255) NOT NULL);
CREATE TABLE prod (
  ID       SERIAL PRIMARY KEY,
  CAT_ID   int NOT NULL REFERENCES cat(id),
  NAME     VARCHAR(255) NOT NULL,
  PRICE    NUMERIC(16,2) NOT NULL
);
INSERT INTO cat (name) VALUES
    ('принтер'),
    ('Принтер'),
    ('Монитор'),
    ('Монитор'),
    ('Телевизор');

INSERT INTO prod (cat_id, name, price) VALUES
    (1,'Hp 1018',4200),
    (3,'Samsung 4500',9800.45),
    (5,'Самсунг ТВ 5000', 43286.76),
    (2,'Epson 7200 ',12300),
    (4,'Samsung 8734',6546);



