
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
    created_user INT
);

CREATE TABLE CONTENTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    article_type VARCHAR(50),
    article_id INT,
    text LONGTEXT,
    created_date DATETIME,
    created_user INT
);

insert into TOPIC (title, created_date, created_user) values ('General Information', sysdate(), 100);
insert into TOPIC (title, created_date, created_user) values ('Architecture', sysdate(), 100);
insert into TOPIC (title, created_date, created_user) values ('Recent Events', sysdate(), 100);
insert into TOPIC (title, created_date, created_user) values ('FAQ', sysdate(), 100);

insert into CHAPTER (topic_id, title, created_date, created_user) values (1, 'GI - Chapter 1', sysdate(), 100);
insert into CHAPTER (topic_id, title, created_date, created_user) values (1, 'GI - Chapter 2', sysdate(), 100);
insert into CHAPTER (topic_id, title, created_date, created_user) values (2, 'Arch - Chapter 1', sysdate(), 100);
insert into CHAPTER (topic_id, title, created_date, created_user) values (2, 'Arch - Chapter 2', sysdate(), 100);
insert into CHAPTER (topic_id, title, created_date, created_user) values (2, 'Arch - Chapter 3', sysdate(), 100);
insert into CHAPTER (topic_id, title, created_date, created_user) values (3, 'Events - Chapter 1', sysdate(), 100);

insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('topic', 1, 'Topic 1 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('topic', 2, 'Topic 2 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('topic', 3, 'Topic 3 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('topic', 4, 'Topic 4 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('chapter', 1, 'Topic 1 and Chapter 1 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('chapter', 2, 'Topic 1 and Chapter 2 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('chapter', 3, 'Topic 2 and Chapter 1 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('chapter', 4, 'Topic 2 and Chapter 2 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('chapter', 5, 'Topic 2 and Chapter 3 - text', sysdate(), 100);
insert into CONTENTS (article_type, article_id, TEXT, created_date, created_user) values ('chapter', 6, 'Topic 3 and Chapter 1 - text', sysdate(), 100);

