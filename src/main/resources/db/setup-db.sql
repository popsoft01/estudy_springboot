create  database estudy if not exists estudy;

create user if not exists 'estudy'@'localhost'identified by 'dollar';
grant all privileges on study.* to 'estudy'@'localhost';
flush privileges ;