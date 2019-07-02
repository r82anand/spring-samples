drop table TOPIC;
drop table CHAPTER;
drop table CONTENTS;

CREATE TABLE TOPIC (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    created_date DATETIME,
    created_user INT
);

CREATE TABLE CHAPTER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    topic_id INT,
    title VARCHAR(50),
    created_date DATETIME,
    created_user INT,
    content_id INT
);

CREATE TABLE CONTENTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text LONGTEXT,
    created_date DATETIME,
    created_user INT
);

insert into TOPIC (title, created_date, created_user) values ('General Information', sysdate(), 100);
insert into TOPIC (title, created_date, created_user) values ('Architecture', sysdate(), 100);
insert into TOPIC (title, created_date, created_user) values ('Recent Events', sysdate(), 100);
insert into TOPIC (title, created_date, created_user) values ('FAQ', sysdate(), 100);

insert into CHAPTER (topic_id, title, created_date, created_user, content_id) values (1, 'GI - Chapter 1', sysdate(), 100, 5);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id) values (1, 'GI - Chapter 2', sysdate(), 100, 6);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id) values (2, 'Arch - Chapter 1', sysdate(), 100, 7);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id) values (2, 'Arch - Chapter 2', sysdate(), 100, 8);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id) values (2, 'Arch - Chapter 3', sysdate(), 100, 9);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id) values (3, 'Events - Chapter 1', sysdate(), 100, 10);

insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 1 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 3 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 4 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 1 and Chapter 1 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 1 and Chapter 2 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 1 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 2 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 3 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 3 and Chapter 1 - text', sysdate(), 100);

