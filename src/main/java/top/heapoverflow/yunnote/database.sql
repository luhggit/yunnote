create table calendar
(
  id               int auto_increment
  comment '主键'
    primary key,
  month            int                                not null
  comment '月份',
  year             int                                not null
  comment '年份',
  content          text                               not null
  comment '日历内容，json字符串',
  create_time      datetime default CURRENT_TIMESTAMP null,
  last_update_time datetime default CURRENT_TIMESTAMP null
  on update CURRENT_TIMESTAMP
);


create table markdown
(
  id               int auto_increment
    primary key,
  create_time      timestamp default CURRENT_TIMESTAMP not null,
  html_content     text                                null,
  last_update_time timestamp default CURRENT_TIMESTAMP not null,
  md_content       text                                null,
  status           varchar(255)                        null,
  first_class      varchar(255)                        null,
  second_class     varchar(255)                        null,
  title            varchar(255)                        null,
  index_id         int                                 not null
  comment '对应的markdown_index的id'
);

create table markdown_index
(
  id               int auto_increment
  comment '主键'
    primary key,
  pid              int default '0'                     not null
  comment '父级id',
  title            varchar(200)                        not null
  comment '目录的名字',
  detno            int default '0'                     null
  comment '序号',
  create_time      timestamp default CURRENT_TIMESTAMP null
  comment '创建时间',
  last_update_time timestamp default CURRENT_TIMESTAMP not null
  comment '更新时间'
)
  comment 'markdown目录';


create table mindmap
(
  id               int auto_increment
  comment '主键'
    primary key,
  index_id         int                                not null
  comment '目录id',
  title            varchar(200)                       null
  comment '标题',
  content          text                               null
  comment '内容',
  create_time      datetime default CURRENT_TIMESTAMP null,
  last_update_time datetime default CURRENT_TIMESTAMP null
  on update CURRENT_TIMESTAMP
);


create table mindmap_index
(
  id               int auto_increment
  comment '主键'
    primary key,
  pid              int default '0'                     not null
  comment '父级id',
  title            varchar(200)                        not null
  comment '目录的名字',
  detno            int default '0'                     null
  comment '序号',
  create_time      timestamp default CURRENT_TIMESTAMP null
  comment '创建时间',
  last_update_time timestamp default CURRENT_TIMESTAMP not null
  comment '更新时间'
)
  comment 'mindmap目录';

create table user
(
  id               int auto_increment
  comment '主键'
    primary key,
  username         varchar(50)                        not null
  comment '用户名',
  password         varchar(100)                       not null
  comment '密码',
  create_time      datetime default CURRENT_TIMESTAMP not null,
  last_update_time datetime default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  constraint user_username_uindex
  unique (username)
)
  comment '用户表';

