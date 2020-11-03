create database ordercenter;

CREATE TABLE `tb_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '用户id',
  `member_id` bigint NOT NULL COMMENT 'member id',
  `order_serial` varchar(50) NOT NULL COMMENT '订单编号',
  `order_status` tinyint DEFAULT NULL COMMENT '订单状态: 0->新订单;1->未支付;2->已支付;3->已发货;4->已完成;5->已取消;6->申请退款',
  `order_amt` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `discounted_amt` decimal(10,2) DEFAULT NULL COMMENT '优惠金额',
  `paid_amt` decimal(10,2) DEFAULT NULL COMMENT '实际支付金额',
  `using_coupon` tinyint DEFAULT NULL COMMENT '是否使用优惠券',
  `coupon_id` bigint DEFAULT NULL COMMENT '优惠券Id',
  `using_integral` tinyint DEFAULT NULL COMMENT '是否使用积分',
  `integral_using_amt` int DEFAULT NULL COMMENT '积分使数量',
  `isdel_by_member` tinyint DEFAULT NULL COMMENT '前端是否删除(顾客删除了，但是用户没有删除)',
  `isdel_by_customer` tinyint DEFAULT NULL COMMENT '用户删除了，但是顾客没有删除',
  `order_time` timestamp NULL DEFAULT NULL COMMENT '下单时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `tb_order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `product_id` bigint DEFAULT NULL COMMENT '产品id',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `product_img` varchar(255) DEFAULT NULL COMMENT '产品图片',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
  `product_qty` int DEFAULT NULL COMMENT '产品数量',
  `sku_id` int DEFAULT NULL COMMENT '产品sku id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `tb_order_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `history_id` bigint DEFAULT NULL COMMENT '删除前id',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `member_id` bigint DEFAULT NULL COMMENT 'member_id',
  `order_serial` varchar(50) NOT NULL COMMENT '订单编号',
  `order_status` tinyint DEFAULT NULL COMMENT '订单状态: 0->新订单;1->未支付;2->已支付;3->已发货;4->已完成;5->已取消;6->申请退款',
  `order_amt` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `discounted_amt` decimal(10,2) DEFAULT NULL COMMENT '优惠金额',
  `paid_amt` decimal(10,2) DEFAULT NULL COMMENT '实际支付金额',
  `using_coupon` tinyint DEFAULT NULL COMMENT '是否使用优惠券',
  `coupon_id` bigint DEFAULT NULL COMMENT '优惠券Id',
  `using_integral` tinyint DEFAULT NULL COMMENT '是否使用积分',
  `integral_using_amt` int DEFAULT NULL COMMENT '积分使数量',
  `order_time` timestamp NULL DEFAULT NULL COMMENT '下单时间',
  `del_time` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `del_by` bigint DEFAULT NULL COMMENT '删除操作所属账号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `tb_order_history_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `history_id` bigint DEFAULT NULL COMMENT '删除前id',
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `product_id` bigint DEFAULT NULL COMMENT '产品id',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `product_img` varchar(255) DEFAULT NULL COMMENT '产品图片',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
  `product_qty` int DEFAULT NULL COMMENT '产品数量',
  `sku_id` int DEFAULT NULL COMMENT '产品sku id',
  `del_time` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `del_by` bigint DEFAULT NULL COMMENT '删除操作所属账号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tb_order_refund` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `member_id` bigint DEFAULT NULL COMMENT 'member_id',
  `reason` text COMMENT '退款原因',
  `refund_amt` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  `refund_voucher` varchar(255) DEFAULT NULL COMMENT '退款凭证',
  `refund_status` tinyint DEFAULT NULL COMMENT '退款状态: 0->未审批;i->审批通过;2->驳回;3->已退款',
  `application_time` timestamp NULL DEFAULT NULL COMMENT '申请时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tb_order_refund_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `history_id` bigint DEFAULT NULL COMMENT '删除前id',
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `member_id` bigint DEFAULT NULL COMMENT 'member_id',
  `reason` text COMMENT '退款原因',
  `refund_amt` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  `refund_voucher` varchar(255) DEFAULT NULL COMMENT '退款凭证',
  `refund_status` tinyint DEFAULT NULL COMMENT '退款状态: 0->未审批;i->审批通过;2->驳回;3->已退款',
  `application_time` timestamp NULL DEFAULT NULL COMMENT '申请时间',
  `del_time` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  `del_by` bigint DEFAULT NULL COMMENT '删除操作所属账号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;