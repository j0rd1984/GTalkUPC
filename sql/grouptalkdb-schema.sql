drop database if exists grouptalkdb;
create database grouptalkdb;

use grouptalkdb;

CREATE TABLE users (
    id BINARY(16) NOT NULL,
    loginid VARCHAR(15) NOT NULL UNIQUE,
    password BINARY(16) NOT NULL,
    email VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles (
    userid BINARY(16) NOT NULL,
    role ENUM ('registered','admin'),
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
    PRIMARY KEY (userid, role)
);

CREATE TABLE auth_tokens (
    userid BINARY(16) NOT NULL,
    token BINARY(16) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
    PRIMARY KEY (token)
);

CREATE TABLE interestgroups (
    id BINARY(16) NOT NULL,
    userid BINARY(16) NOT NULL,
    content VARCHAR(500) NOT NULL,
	last_modified TIMESTAMP NOT NULL,
    creation_timestamp DATETIME not null default current_timestamp,
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
    PRIMARY KEY (id)
);
CREATE TABLE themes (
    id BINARY(16) NOT NULL,
    userid BINARY(16) NOT NULL,
    subject VARCHAR(100) NOT NULL,
    content VARCHAR(500) NOT NULL,
	last_modified TIMESTAMP NOT NULL,
    creation_timestamp DATETIME not null default current_timestamp,
	interestgroupid BINARY(16) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
	FOREIGN KEY (interestgroupid) REFERENCES interestgroups(id) on delete cascade,
    PRIMARY KEY (id)
);
CREATE TABLE comments (
    id BINARY(16) NOT NULL,
    userid BINARY(16) NOT NULL,
    content VARCHAR(500) NOT NULL,
	last_modified TIMESTAMP NOT NULL,
    creation_timestamp DATETIME not null default current_timestamp,
	themeid BINARY(16) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
	FOREIGN KEY (themeid) REFERENCES themes(id) on delete cascade,
    PRIMARY KEY (id)
);
CREATE TABLE user_group (
    userid BINARY(16) NOT NULL,
    interestgroup BINARY(16) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
	FOREIGN KEY (interestgroup) REFERENCES interestgroups(id) on delete cascade,
    PRIMARY KEY (userid, interestgroup)
);