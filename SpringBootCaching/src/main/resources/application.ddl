drop table TOPIC;
drop table CHAPTER;
drop table CONTENTS;

CREATE TABLE TOPIC (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    description VARCHAR(500),
    created_date DATETIME,
    created_user INT
);

CREATE TABLE CHAPTER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    topic_id INT,
    title VARCHAR(50),
    created_date DATETIME,
    created_user INT,
    content_id INT,
    section_id INT,
    CONSTRAINT `FK_MANAGER` FOREIGN KEY (`section_id`) REFERENCES `CHAPTER` (`id`)
);

CREATE TABLE CONTENTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text LONGTEXT,
    created_date DATETIME,
    created_user INT
);

insert into TOPIC (title, description, created_date, created_user) values ('General Information', 'General Information Desc', sysdate(), 100);
insert into TOPIC (title, description, created_date, created_user) values ('Architecture', 'Architecture Desc', sysdate(), 100);
insert into TOPIC (title, description, created_date, created_user) values ('Recent Events', 'Recent Events Desc', sysdate(), 100);
insert into TOPIC (title, description, created_date, created_user) values ('FAQ', 'FAQ Desc', sysdate(), 100);

insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (1, 'GI - Chapter 1', sysdate(), 100, 1, null);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (1, 'GI - Chapter 2', sysdate(), 100, 2, null);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (2, 'Arch - Chapter 1', sysdate(), 100, 3, null);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (2, 'Arch - Chapter 2', sysdate(), 100, 4, null);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (2, 'Arch - Chapter 3, Section 1', sysdate(), 100, 5, 3);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (2, 'Arch - Chapter 3, Section 1.1', sysdate(), 100, 6, 5);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (2, 'Arch - Chapter 3, Section 1.2', sysdate(), 100, 7, 5);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (2, 'Arch - Chapter 3, Section 1.3', sysdate(), 100, 8, 5);
insert into CHAPTER (topic_id, title, created_date, created_user, content_id, section_id) values (3, 'Events - Chapter 1', sysdate(), 100, 9, null);

insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 1 and Chapter 1 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 1 and Chapter 2 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 1 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 2 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 3 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 4 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 5 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 2 and Chapter 6 - text', sysdate(), 100);
insert into CONTENTS (TEXT, created_date, created_user) values ('Topic 3 and Chapter 1 - text', sysdate(), 100);

