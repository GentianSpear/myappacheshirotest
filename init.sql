---权限表---
create table permission(
  pid int(11) not null AUTO_INCREMENT,
  name VARCHAR (255) not null DEFAULT '',
  url VARCHAR (255) DEFAULT '',
  primary key (pid)
)ENGINE =InnoDB DEFAULT CHARSET = utf-8;

insert into permission VALUES ('1','add','');
insert into permission VALUES ('2','delete','');
insert into permission VALUES ('3','edit','');
insert into permission VALUES ('4','query','');

---用户表---
create table user(
  uid int(11) not null AUTO_INCREMENT,
  username VARCHAR (255) not null DEFAULT '',
  password VARCHAR (255) not null DEFAULT '',
  primary key (uid)
)ENGINE =InnoDB DEFAULT CHARSET = utf-8;

insert into user VALUES ('1','admin','123');
insert into user VALUES ('2','demo','123');

---角色表---
create table role(
  rid int(11) not null AUTO_INCREMENT,
  rname VARCHAR (255) not null DEFAULT '',
  primary key (rid)
)ENGINE =InnoDB DEFAULT CHARSET = utf-8;

insert into role VALUES ('1','admin');
insert into role VALUES ('2','customer');

---权限角色关系表---
create table permission_role(
  rid int(11) not null,
  pid int(11) not null,
  key idx_rid (rid),
  key idx_pid (pid)
)ENGINE =InnoDB DEFAULT CHARSET = utf-8;

insert into permission_role VALUES ('1','1') ;
insert into permission_role VALUES ('1','2') ;
insert into permission_role VALUES ('1','3') ;
insert into permission_role VALUES ('1','4') ;
insert into permission_role VALUES ('2','1') ;
insert into permission_role VALUES ('2','4') ;

---用户角色关系表---
create table user_role(
  uid int(11) not null,
  rid int(11) not null,
  key idx_rid (rid),
  key idx_uid (uid)
)ENGINE =InnoDB DEFAULT CHARSET = utf-8;

insert into user_role VALUES (1,2);
insert into user_role VALUES (2,2);

