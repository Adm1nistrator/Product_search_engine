# Прайс-лист

Приложение позволяет искать товары в прайс-листе по одному или нескольким критериям. 
Критерии поиска товара:
<li> Категория
<li> Наименование
<li> Цена от 
<li> Цена до 

## Создание БД, пользовател и таблиц

Для создания БД, пользователя, таблиц  необходимо запустить sql\exec.cmd который выполнить PSQL скрипт.
При выполнеии скрипат потребуется указать пароль "anykey" от учетнйо записи "anykey"
 ```html
 PSQL -U postgres -f create_db_and_user.sql
 PSQL -U anykey -d pricelist -f create_tables.sql
 ```

От учётной записи postgres выполнится запрос из файла create_db_and_user.sql на создание БД с именем "pricelist" и пользователем "anykey" с паролем "anykey" create_db_and_user.sql:

 ```html
 DROP DATABASE IF EXISTS pricelist;
 CREATE DATABASE pricelist ENCODING = 'UTF8';
 DROP USER IF EXISTS anykey;
 CREATE USER anykey WITH password 'anykey'; 
 GRANT ALL privileges ON DATABASE pricelist TO anykey;
 ```

Вторая сточка sql\exec.cmd выполнит запрос из файлик create_tables.sql для создания таблиц в БД "pricelist" с тестовым наполнением
***Файл create_tables.sql должен быть в кодировке windows-1251***

 ```html
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
 ```

В результиате получится страктура в БД:

![Структура БД "pricelist"](https://github.com/Adm1nistrator/Product_search_engine/blob/master/diagram.PNG)


##Параметры подключения к БД

В файле servlet-context.xml  \src\main\webapp\WEB-INF\spring\appServlet необходимо задать параметры для подключения к БД
 ```html
      <beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
                  destroy-method="close">
          <!-- настройки для подключения к базе данных -->
          <beans:property name="driverClassName" value="org.postgresql.Driver"/>  //драйвер для подключения к БД
          <beans:property name="url" value="jdbc:postgresql://localhost:5432/pricelist"/>   //Адрес сервера БД
          <beans:property name="username" value="anykey"/>    //Имя пользователя
          <beans:property name="password" value="anykey"/>    //Пароль
      </beans:bean>
 ```
##Адрес пользовательского интерфейса

По адресу {имя_сервера:порт}/price находится интерфейс для поиска товаров в прайс-листе

http://localhost:8080/price



