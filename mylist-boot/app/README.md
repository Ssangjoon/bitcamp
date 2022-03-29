# sql

```
create table ml_member(
  no int not null,
  name varchar(50) not null,
  email varchar(50) not null,
  password varchar(50) not null,
  regist_date datetime default now()
  );
  
  alter table ml_member 
  add constraint primary key (no)
  modify column no int not null auto_increment;
```

###2단계 회원 데이터를 다룰 DAO 인터페이스를 정의한다. 

  