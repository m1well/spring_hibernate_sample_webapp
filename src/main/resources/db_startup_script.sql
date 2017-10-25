CREATE DATABASE IF NOT EXISTS sampledatabase CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE sampledatabase;

--
-- Table structure for table app_authorities
--

DROP TABLE IF EXISTS app_authorities;
CREATE TABLE app_authorities (
  uuid  INT(11) NOT NULL AUTO_INCREMENT,
  authority VARCHAR(100) NOT NULL,
  PRIMARY KEY (uuid)
) ENGINE=InnoDB AUTO_INCREMENT=2;

--
-- Dumping data for table app_authorities
--

LOCK TABLES app_authorities WRITE;
INSERT INTO app_authorities VALUES ('1','ROLE_USER');
UNLOCK TABLES;

--
-- Table structure for table app_users
--

DROP TABLE IF EXISTS app_users;
CREATE TABLE app_users (
   uuid INT(11) NOT NULL AUTO_INCREMENT,
   user_name VARCHAR(20) NOT NULL,
   password VARCHAR(30) NOT NULL,
   PRIMARY KEY (uuid)
) ENGINE=InnoDB AUTO_INCREMENT=4;

--
-- Table structure for table app_user_authorities
--

DROP TABLE IF EXISTS app_user_authorities;
CREATE TABLE app_user_authorities (
  app_user INT(11) NOT NULL,
  app_authority INT(11) NOT NULL,
  PRIMARY KEY (app_user, app_authority),
  CONSTRAINT fk_app_user_authorities_2_app_users FOREIGN KEY (app_user) REFERENCES app_users(uuid) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_app_user_authorities_2_app_authorities FOREIGN KEY (app_authority) REFERENCES app_authorities(uuid) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;