顾客信息表
create table member(
id bigint primary key auto_increment,
vendor_code varchar(50) unique not null comment '商城标识码',
name varchar(50) comment 'member姓名',
avatar varchar(255) comment 'member头像',
email varchar(50) unique not null comment 'member账号',
pwd varchar(255) not null comment 'member密码',
salt varchar(255) not null comment 'member密码盐值',
phone_binding tinyint comment '是否绑定手机',
bound_phone varchar(20) comment '绑定手机',
crown_code varchar(5) comment '国际冠码',
invitation_code varchar(15) comment 'member邀请码',
integral int comment 'member积分',
blacklisted tinyint comment '是否被拉入黑名单: 0->否;1->是',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间',
last_login_time timestamp comment '最近登录时间'
);


ALTER TABLE member ADD avatar varchar(255) after account;
ALTER TABLE member ADD mobile varchar(20) after account;
ALTER TABLE member ADD unique(`username`);
ALTER TABLE member DROP account;

积分变更记录表
create table integral_change_records(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
member_id long not null comment 'member id',
ctype tinyint not null comment '变更类型: 0->增加;1->减少',
camount int not null comment '变更数量',
creason varchar(255) not null comment '变更原因',
creason_category tinyint not null comment '变更原因类目',
create_time timestamp comment '变更时间'
);

积分使用和获取规则设置表
create table integral_settings(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
min_use_amount int comment '最低使用金额:单笔订单可用积分的最低金额，可设置为0，默认0',
max_use_amount int comment '最高使用金额',
max_use_ratio decimal comment '最高使用比例:单笔订单利用积分抵消的金额最大占比',
use_category tinyint comment '积分使用类别:0->没有最高使用积分;1->最高使用积分;2->最高使用比例',
used_with_coupons tinyint comment '可否与优惠券同时使用:0->不可以;1->可以',
used_coupons_category tinyint comment '可同时使用的优惠券类别: 1->全部类别;2->其中一种;3->多种优惠券',
exchange_unit int comment '积分-现金兑换单位',
min_use_unit int comment '积分使用最小单位（比如说只能整百的使用，剩余小于100则不能使用）',
min_earned_value int comment '单笔订单获取积分的最小金额（默认0）',
earned_value_ratio decimal comment '订单获取积分比例（例如0.1就是100块的订单给10积分）',
highest_earned_flag tinyint comment '是否有最高获取积分: 0->没有;1->有',
highest_earned_amount int comment '订单最高获取积分',
usable tinyint comment '是否可用:0->不可用;1->可用',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

签到设置表
create table attendance_settings(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
max_checkin_days int comment '最大连续签到天数',
reward_type tinyint comment '获取奖励类别: 0->积分;1->优惠券',
reward_content text comment '奖励内容:连续签到天数对应获得的奖励,用逗号分隔,积分就是数字,优惠券则是对应的优惠券id',
usable tinyint comment '是否可用:0->不可用;1->可用',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

签到记录表
create table attendance_records(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
member_id bigint not null comment 'member id',
checkin_time timestamp comment '签入时间',
consecutive_checkin_days int comment '当前连续签到天数'
);

会员任务表
create table member_tasks(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
tid bigint comment '任务id:对应的管理员设置的任务id',
ttitle varchar(255) comment '任务标题',
tdesc text comment '任务描述',
reward_type tinyint comment '奖励类别: 0->积分;1->优惠券',
reward_content text comment '奖励内容:积分或者优惠券id',
usable tinyint comment '是否可用:0->不可用;1->可用',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

任务记录表
create table member_task_progress(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
member_id bigint not null comment 'member id',
tid long comment '任务id:对应的管理员设置的任务id',
progress decimal comment '任务完成进度（比如说购买5笔订单，已下4笔就存4）',
iscomplete tinyint comment '是否完成: 0->未完成;1->已完成',
task_receiving_time timestamp comment '领取任务时间',
isexpired tinyint comment '是否超时'
);

会员地址表
create table member_address_settings(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
member_id bigint not null comment 'member id',
street varchar(255) comment '街道地址',
state varchar(50) comment '州',
prov varchar(50) comment '省',
country varchar(50) comment '国家',
postcode varchar(20) comment '邮编',
isdefault tinyint comment '是否默认: 0->否;1->是',
usable tinyint comment '是否可用:0->不可用;1->可用',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

店长推荐表
create table recommended_products(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
product_id bigint not null comment '产品id',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

账号安全表
create table account_security_settings(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
member_id bigint not null comment 'member id',
phone_binding tinyint comment '是否绑定手机:0->否;1->是',
email_binding tinyint comment '是否绑定邮箱:0->否;1->是',
bound_phone varchar(20) comment '已绑定手机',
bound_email varchar(50) comment '已绑定邮箱',
usable tinyint comment '是否可用:0->不可用;1->可用',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

member收藏表
create table member_favorites(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
member_id bigint not null comment 'member id',
content_type tinyint comment '收藏内容类型: 1->产品;2->文章',
content_id long comment '收藏内容: 收藏内容id',
create_time timestamp comment '创建时间'
);

优惠券设置表
create table coupon_settings{
id long primary key auto_increment,
vendor_code varchar(50) comment '商城标识码',
ctype tinyint not null comment '优惠券类别',
using_rules text comment '使用规则: json格式',
discounted_value decimal comment '优惠金额',
istime_limited tinyint comment '是否有时效限制:0=>无;1=>有',
startup_time timestamp comment '开始时间',
endup_time timestamp comment '结束时间',
usable tinyint comment '是否可用:0->不可用;1->可用',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
}

用户优惠券表
create table member_coupon(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
ctype tinyint not null comment '优惠券类别',
using_rules text comment '使用规则: json格式',
discounted_value decimal comment '优惠金额',
istime_limited tinyint comment '是否有时效限制:0=>无;1=>有',
startup_time timestamp comment '开始时间',
endup_time timestamp comment '结束时间',
coupon_status tinyint comment '优惠券状态:0->未使用;1->已使用;2->过期'
);

功能模块开关表
create table module_function_control(
id bigint primary key auto_increment,
vendor_code varchar(50) not null comment '商城标识码',
module_id int not null comment '模块id',
module_name varchar(50) not null comment '模块名称',
module_desc varchar(255) not null comment '模块描述',
isauthorized tinyint comment '用户是否有权限',
usable tinyint comment '是否可用:0->不可用;1->可用',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

字典数据表
create table sys_dict_data(
dict_code bigint primary key auto_increment comment '字典编码',
dict_sort int default '0' comment '字典排序',
dict_label varchar(100) comment '字典标签',
dict_value varchar(100) comment '字典键值',
status tinyint comment '状态:0->正常;1->停用',
remark varchar(500) comment '备注',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);

字典类型表
create table sys_dict_type (
dict_id bigint primary key auto_increment comment '字典主键',
dict_name varchar(100) comment '字典名称',
dict_type varchar(100) unique not null comment '字典类型',
status tinyint comment '状态:0->正常;1->停用',
remark varchar(500) comment '备注',
create_time timestamp comment '创建时间',
update_time timestamp comment '更新时间'
);
