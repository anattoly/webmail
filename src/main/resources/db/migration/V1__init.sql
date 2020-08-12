create table users(id bigint primary key auto_increment,
                   login varchar(100),
                   password varchar(50),
                   firstName varchar(50),
                   lastName varchar(50),
                   middleName varchar(50),
                   userRole varchar(250));

CREATE TABLE mails(id bigint primary key auto_increment,
                   authorId bigint,
                   recipientsId varchar(max),
                   subject varchar(250),
                   text varchar(1024),
                   dateMail timestamp,
                   replyMailId bigint);

ALTER TABLE mails ADD CONSTRAINT FKklnrv3weler2ftkweewlky958 foreign key (authorId) references users(id);