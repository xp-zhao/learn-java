DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `award_id` bigint NOT NULL COMMENT '秒杀奖品id',
  `user_id` bigint NOT NULL COMMENT '用户Id',
  `state` tinyint NOT NULL COMMENT '状态标示：-1指无效，0指成功，1指已付款',
  `money` bigint NOT NULL COMMENT '金额',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB COMMENT '支付信息表';


DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`  (
  `award_id` bigint NOT NULL AUTO_INCREMENT COMMENT '奖品id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `award_count` int NOT NULL COMMENT '奖品数量',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开启时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int NOT NULL COMMENT '版本号',
  PRIMARY KEY (`award_id`) USING BTREE,
  INDEX `idx_start_time`(`start_time`) USING BTREE,
  INDEX `idx_end_time`(`end_time`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB COMMENT '奖品表';

INSERT INTO `award` VALUES (1000, 'Iphone15', 1000, '2023-09-06 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', 0);
INSERT INTO `award` VALUES (1001, '华为mate60pro', 1000, '2023-09-06 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', 0);
INSERT INTO `award` VALUES (1002, '小米13', 1000, '2023-09-06 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', 0);
INSERT INTO `award` VALUES (1003, '红米note', 1000, '2023-09-06 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', '2023-09-08 16:30:00', 0);

DROP TABLE IF EXISTS `user_take_seckill`;
CREATE TABLE `user_take_seckill`  (
  `award_id` bigint NOT NULL COMMENT '秒杀奖品id',
  `user_id` bigint NOT NULL COMMENT '用户Id',
  `state` tinyint NOT NULL COMMENT '状态标示：-1指无效，0指成功，1指已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`award_id`, `user_id`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB COMMENT = '用户参与秒杀记录表';
