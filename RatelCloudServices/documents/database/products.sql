CREATE TABLE `tb_brand` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(100) NOT NULL COMMENT '品牌名称',
  `image` varchar(1000) DEFAULT '' COMMENT '品牌图片地址',
  `letter` char(1) DEFAULT '' COMMENT '品牌的首字母',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp comment '创建时间',
  `update_time` timestamp comment '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=325414 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='品牌表';