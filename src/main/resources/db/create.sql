SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS events (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 date VARCHAR,
 location VARCHAR,
 description VARCHAR
);


CREATE TABLE IF NOT EXISTS rec (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 date VARCHAR,
 location VARCHAR,
 description VARCHAR,
 alcohol BOOLEAN,
 active BOOLEAN,
 kidFriendly BOOLEAN
);

CREATE TABLE IF NOT EXISTS tech (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 date VARCHAR,
 location VARCHAR,
 description VARCHAR,
 level VARCHAR,
 language VARCHAR,
 framework VARCHAR,
 job VARCHAR
);

CREATE TABLE IF NOT EXISTS design (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 date VARCHAR,
 location VARCHAR,
 description VARCHAR,
 specialty VARCHAR
);

