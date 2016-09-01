DROP DATABASE IF EXISTS pricelist;
CREATE DATABASE pricelist ENCODING = 'UTF8';
DROP USER IF EXISTS anykey;
CREATE USER anykey WITH password 'anykey';
GRANT ALL privileges ON DATABASE pricelist TO anykey;