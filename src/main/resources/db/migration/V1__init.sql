create table users(id bigint primary key auto_increment,
                   login varchar(100) not null ,
                   password varchar(50) not null ,
                   firstName varchar(50),
                   lastName varchar(50),
                   middleName varchar(50),
                   userRole varchar(250) not null);

CREATE TABLE mails(id bigint primary key auto_increment,
                   authorId bigint not null,
                   subject varchar(250),
                   text varchar(1024),
                   dateMail timestamp not null,
                   replyMailId bigint);

CREATE TABLE inbox(recipientId bigint,
                   mailId bigint,
                   isRead boolean,
                   isStared boolean,
                   isImportant boolean);

ALTER TABLE mails ADD CONSTRAINT FKklnrv3weler2ftkweewlky958 foreign key (authorId) references users(id);
ALTER TABLE inbox ADD CONSTRAINT FKtlhrmb8elerd5tkweewlky87b foreign key (recipientId) references users(id);
ALTER TABLE inbox ADD CONSTRAINT FKpln7vuwe2erbgtkweewlky6tn foreign key (mailId) references mails(id);