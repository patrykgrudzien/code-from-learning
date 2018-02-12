CREATE TABLE users(
   username varchar(20) NOT NULL,
   password varchar(20) NOT NULL,
   enabled boolean NOT NULL DEFAULT FALSE,
   primary key(username)
);