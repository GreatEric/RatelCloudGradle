

create table sys_user(
id int primary key auto_increment,
uid varchar(255) unique not null comment '用户ID',
gender tinyint comment '性别:1->男;2->女',
first_name varchar(20) default '' comment '真实名',
last_name varchar(20) default '' comment '真实姓',
avatar varchar(255) default '' comment '头像',
email varchar(50) unique comment '用户邮箱',
mobile varchar(20) unique comment '用户手机号',
crown_code varchar(5) comment '国际冠码',
status tinyint comment '状态: 0->禁用;1->正常',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);


create table sys_perms(
id int primary key auto_increment,
pid int not null comment '父ID',
pname varchar(50) not null comment '权限名称',
ptype tinyint not null comment '权限类型: 1->菜单;2->api',
proute_path varchar(255) comment '路由地址',
proute_path_params varchar(255) comment '路由参数',
picon varchar(50) comment '权限显示图标',
pmethod varchar(10) comment '请求方式',
paccess_point varchar(255) comment 'api接口地址',
permid varchar(255) comment '权限标识',
porder int comment '排序',
status tinyint comment '状态: 0->禁用;1->正常',
visibility tinyint comment '状态: 0->隐藏;1->显示',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);

create table sys_role(
id int primary key auto_increment,
rname varchar(50) not null default '' comment '角色名称',
remark varchar(255) comment '角色备注',
status tinyint comment '状态: 0->禁用;1->正常',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);

create table sys_admin(
id int primary key auto_increment,
uid varchar(255) unique not null comment 'admin用户ID',
account varchar(100) not null comment '账户名称',
realname varchar(50) comment '真实姓名',
pwd varchar(255) comment '密码',
salt varchar(255) comment '盐值',
status tinyint comment '状态: 0->禁用;1->正常',
type tinyint comment '管路员类型: 0->超级管理员; 1->系统管理员; 2->普通管理员',
last_login_time timestamp comment '最近登录时间',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);


create table customer_admin(
id int primary key auto_increment,
uid varchar(255) unique not null comment 'admin用户ID',
account varchar(100) not null comment '账户名称',
realname varchar(50) comment '真实姓名',
pwd varchar(255) comment '密码',
salt varchar(255) comment '盐值',
status tinyint comment '状态: 0->禁用;1->正常',
type tinyint comment '管路员类型: 0->超级管理员; 1->系统管理员; 2->普通管理员',
last_login_time timestamp comment '最近登录时间',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);

create table sys_admin_role(
id int primary key auto_increment,
uid varchar(100) not null comment '账户id',
rid int comment '角色id',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);

create table sys_role_perm(
id int primary key auto_increment,
rid int comment '角色id',
pid int comment '权限id',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);


create table sys_services(
id int primary key auto_increment,
sname varchar(255) comment '服务名称',
sdes text comment '服务描述',
sprice_monthly decimal(5,2) comment '服务包月价格',
sprice_annually decimal(5,2) comment '服务包月价格',
smarketing_meth_id int comment '营销手段id',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);

create table mail_retrieve(
id int primary key auto_increment,
account varchar(100) not null comment '账户邮箱',
sid varchar(255) comment '验证token',
out_time varchar(255) comment '失效时间',
create_time timestamp comment '创建时间'
);

create table user_center_task_setting(
id int primary key auto_increment,
ttype varchar(50) not null comment '任务类型名称',
ticon_img varchar(255) not null comment '类型Icon图片',
tlink varchar(255) not null comment '任务跳转链接',
tdesc text not null comment '任务描述',
treward_type tinyint comment '任务奖励类型: 1->积分;2->优惠券',
treward_cotent varchar(255) comment '任务奖励内容: json格式',
tstartup_time timestamp comment '任务开始时间',
tendup_time timestamp comment '结束开始时间',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
creator_id long comment '创建者ID'
);