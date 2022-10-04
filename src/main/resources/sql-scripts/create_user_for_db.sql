-- drop user andreip@localhost;

flush privileges;

CREATE USER 'andreip'@'localhost' IDENTIFIED BY 'andreip';

GRANT ALL PRIVILEGES ON * . * TO 'andreip'@'localhost';

ALTER USER 'andreip'@'localhost' IDENTIFIED BY 'andreip';