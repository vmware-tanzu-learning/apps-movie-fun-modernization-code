CREATE TABLE album
(
  id     BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  artist VARCHAR(255),
  rating INT(11)                NOT NULL,
  title  VARCHAR(255),
  year   INT(11)                NOT NULL
);
