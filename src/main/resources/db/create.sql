SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS events (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 date VARCHAR,
 location VARCHAR,
 description VARCHAR

);

