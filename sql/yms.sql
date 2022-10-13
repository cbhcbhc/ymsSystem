CREATE TABLE `cart` (
                        `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
                        `uid` bigint(11) DEFAULT NULL COMMENT '关联用户id',
                        `pid` bigint(11) DEFAULT NULL COMMENT '关联产品id',
                        `number` int(11) DEFAULT NULL COMMENT '产品数量',
                        `tprice` double(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

CREATE TABLE `image` (
                         `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
                         `ititle` varchar(50) DEFAULT NULL COMMENT '图片标题',
                         `iurl` varchar(100) DEFAULT NULL COMMENT '图片路径',
                         `itype` varchar(10) DEFAULT NULL COMMENT '图片类型 0：注册页面轮播图  1：产品轮播图图片等等 ',
                         `imsg` varchar(100) DEFAULT NULL COMMENT '描述  如：注册页面轮播图',
                         `istate` int(2) DEFAULT NULL COMMENT '1:可用    0：禁用',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

INSERT INTO `image` VALUES (1, '欢迎界面轮播图', 'w1.png', '1', '欢迎界面轮播图', 1);
INSERT INTO `image` VALUES (2, '欢迎界面轮播图', 'w2.png', '1', '欢迎界面轮播图', 1);
INSERT INTO `image` VALUES (3, '欢迎界面轮播图', 'w3.png', '1', '欢迎界面轮播图', 1);
INSERT INTO `image` VALUES (4, '欢迎界面轮播图', 'w4.png', '1', '欢迎界面轮播图', 1);
INSERT INTO `image` VALUES (5, '欢迎界面轮播图', 'w5.png', '1', '欢迎界面轮播图', 1);
INSERT INTO `image` VALUES (6, '首页轮播图1', 'i1.png', '2', '首页轮播图', 1);
INSERT INTO `image` VALUES (7, '首页轮播图', 'i2.png', '2', '首页轮播图', 1);
INSERT INTO `image` VALUES (8, '首页轮播图', 'i3.png', '2', '首页轮播图', 1);
INSERT INTO `image` VALUES (9, '首页轮播图', 'i4.png', '2', '首页轮播图', 1);
INSERT INTO `image` VALUES (10, '产品界面轮播图', 'pb1.png', '3', '产品界面轮播图', 1);
INSERT INTO `image` VALUES (11, '产品界面轮播图', 'pb2.png', '3', '产品界面轮播图', 1);
INSERT INTO `image` VALUES (12, '产品界面轮播图', 'pb3.png', '3', '产品界面轮播图', 1);

CREATE TABLE `order` (
                         `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
                         `otype` int(2) DEFAULT NULL COMMENT '1：外卖    0：自取',
                         `onumber` varchar(100) DEFAULT NULL COMMENT '订单流水号',
                         `uid` bigint(11) DEFAULT NULL COMMENT '关联用户表id',
                         `oprice` double(8,2) DEFAULT NULL COMMENT '订单价格',
  `paystate` int(2) DEFAULT NULL COMMENT '支付状态 0:未支付   1：已经支付',
  `otime` varchar(50) DEFAULT NULL COMMENT '支付时间',
  `ostate` int(2) DEFAULT NULL COMMENT '订单状态：0：预定中（未收获） 1：已收货 2：退订 3：禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
                           `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
                           `pname` varchar(20) DEFAULT NULL COMMENT '产品名称',
                           `typeid` bigint(20) DEFAULT NULL COMMENT '关联类型表id',
                           `tprice` double(4,2) DEFAULT NULL COMMENT '产品原价',
  `tintroduce` varchar(200) DEFAULT NULL COMMENT '产品介绍',
  `pimageurl` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `photstate` int(2) DEFAULT NULL COMMENT '1:可做热饮    0：不可做热饮',
  `pdiscount` double(2,2) DEFAULT NULL COMMENT '折扣：0-1之间的小数',
  `pstate` int(2) DEFAULT NULL COMMENT '1:可用    0：禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
INSERT INTO `product` VALUES (1, '金桔柠檬1杯', 1, 8.80, '金桔配柠檬，清香与清新的碰撞，经典CP，酸甜清爽。\r\n· ⚠非外卖平台，门店不配送，购买后请到店使用', 'p1.png', 0, 0.90, 1);
INSERT INTO `product` VALUES (2, '红豆麻薯双拼', 1, 16.00, '红豆麻薯双拼（大杯）1份，包间免费', 'p2.png', 1, 0.98, 1);
INSERT INTO `product` VALUES (3, '招牌芋圆奶茶1份', 1, 20.00, '招牌芋圆奶茶', 'p3.png', 1, 0.90, 1);
INSERT INTO `product` VALUES (4, '黄金珍珠奶茶1杯', 1, 10.00, '黄金珍珠奶茶1杯', 'p4.png', 1, 0.88, 1);
INSERT INTO `product` VALUES (5, '【小春哥同款】书亦烧仙草(大杯)1杯', 1, 14.00, '【小春哥同款】书亦烧仙草(大杯)1杯', 'p5.png', 1, 0.80, 1);
INSERT INTO `product` VALUES (6, '葡萄芋圆冻冻1杯', 6, 14.00, '葡萄芋圆冻冻1杯', 'p6.png', 0, 0.98, 0);
INSERT INTO `product` VALUES (7, '鸭屎香大橘茶（大杯）1杯', 3, 16.00, '鸭屎香大橘茶（大杯）1杯', 'p7.png', 0, 0.90, 0);
INSERT INTO `product` VALUES (8, '黑糖小芋圆奶茶1杯', 1, 17.00, '黑糖小芋圆奶茶1杯', 'p8.png', 1, 0.80, 1);
INSERT INTO `product` VALUES (9, '牛魔王黑砖奶茶1杯', 1, 15.00, '牛魔王黑砖奶茶1杯', 'p9.png', 1, 0.90, 1);
INSERT INTO `product` VALUES (10, '多肉西瓜冰茶（大杯）1份', 3, 14.00, '多肉西瓜冰茶（大杯）1份', 'p10.png', 0, 0.90, 1);
INSERT INTO `product` VALUES (11, '芝士多肉葡萄（大杯）1杯', 3, 19.00, '芝士多肉葡萄（大杯）1杯', 'p11.png', 0, 0.90, 1);
INSERT INTO `product` VALUES (12, '草莓摇摇奶昔1杯', 4, 8.00, '草莓摇摇奶昔1杯', 'p12.png', 0, 0.80, 1);
INSERT INTO `product` VALUES (13, '黑糖珍珠大圣代1杯', 4, 12.00, '黑糖珍珠大圣代1杯', 'p13.png', 0, 0.90, 1);
INSERT INTO `product` VALUES (14, '芝士奶盖绿茶1杯', 2, 22.00, '芝士奶盖绿茶1杯', 'p14.png', 0, 0.90, 1);
INSERT INTO `product` VALUES (19, '测试数据', 3, 22.00, '测试苏剧', 'dc13308a0630490fa2ff9fbcf6548ead.png', NULL, 0.20, 1);
INSERT INTO `product` VALUES (20, NULL, NULL, NULL, NULL, 'cae0e0023de64d00a5735de172940897.png', NULL, NULL, 1);
INSERT INTO `product` VALUES (21, NULL, NULL, NULL, NULL, 'd6c95d23782e4032a045a79c7c425860.png', NULL, NULL, 1);
INSERT INTO `product` VALUES (22, NULL, NULL, NULL, NULL, '040f1ea0ef5744d498702c2df49fbaa8.png', NULL, NULL, 1);

CREATE TABLE `productorder` (
                                `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '产品、订单中间表',
                                `oid` varchar(100) DEFAULT NULL COMMENT '关联订单流水号',
                                `pid` bigint(11) DEFAULT NULL COMMENT '关联产品id',
                                `number` int(11) DEFAULT NULL COMMENT '购买产品数量',
                                `price` double(8,2) DEFAULT NULL COMMENT '产品单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

CREATE TABLE `type` (
                        `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
                        `typename` varchar(20) DEFAULT NULL COMMENT '类型名称',
                        `timageurl` varchar(100) DEFAULT NULL COMMENT '类型图片路径',
                        `tstate` int(2) DEFAULT NULL COMMENT '1:可用    0：禁用',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
INSERT INTO `type` VALUES (1, '醇香奶茶', 't1.png', 1);
INSERT INTO `type` VALUES (2, '鲜牛乳', 't2.png', 1);
INSERT INTO `type` VALUES (3, '四级鲜果茶', 't3.png', 1);
INSERT INTO `type` VALUES (4, '乳酸菌', 't4.png', 1);
INSERT INTO `type` VALUES (5, '加料2', 't5.png', 0);
INSERT INTO `type` VALUES (6, '花香轻乳茶', 't6.png', 1);

CREATE TABLE `user` (
                        `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
                        `uname` varchar(20) DEFAULT NULL COMMENT '用户名',
                        `upwd` varchar(100) DEFAULT NULL COMMENT '加密之后的密码',
                        `utell` varchar(11) NOT NULL COMMENT '手机号',
                        `ustate` int(1) DEFAULT NULL COMMENT '1:可用    0：禁用',
                        `uintegral` double(8,2) DEFAULT '0.00' COMMENT '会员积分',
  `urole` varchar(20) DEFAULT NULL COMMENT '用户角色：普通会员、黄金会员、铂金会员等',
  `token` varchar(100) DEFAULT NULL COMMENT 'token令牌',
  `jurisdiction` varchar(50) DEFAULT NULL COMMENT '用户权限  用户、管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;