create table users
(
  id       serial not null
    constraint users_pk
      primary key,
  name     varchar(50),
  surname  varchar(50),
  username varchar(50),
  age      integer,
  email    varchar(50),
  password varchar(50)
);

create table tasks
(
  title       varchar(128),
  description varchar(256),
  date        timestamp,
  id          serial not null
    constraint task_pk
      primary key,
  user_id     integer
    constraint task_users_id_fk
      references users
);

