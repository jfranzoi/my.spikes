DROP TABLE IF EXISTS items;
CREATE TABLE items (
  id int(11) NOT NULL AUTO_INCREMENT,
  description tinytext NOT NULL,
  price int(11) NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB;