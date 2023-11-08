create database if not exists hpBlog default charset utf8mb4 collate utf8mb4_general_ci;
use hpBlog;

# 用户表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `deleteStatus` int                                                          DEFAULT NULL COMMENT '删除状态：0、已删除 1、未删除',
    `createTime`   datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updateTime`   datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `username`     varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
    `nickname`     varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户昵称',
    `password`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
    `enabled`      bit(1)                                                       DEFAULT NULL COMMENT '开启或关闭',
    `sex`          int                                                          DEFAULT NULL COMMENT '性别：0、女 1、男',
    `mobile`       varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号',
    `email`        varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
    `dept_id`      bigint                                                       DEFAULT NULL COMMENT '部门ID',
    `create_by`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
    `update_by`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 272
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户';


INSERT INTO `sys_user`
VALUES ('1', '1', '2023-06-29 14:01:44', '2023-08-11 05:52:38', 'admin123', 'admin123',
        '{bcrypt}$2a$10$zpJ/X5qNYcM9/wbmf2nA4uDRecORWSsYiqHpn0VjxJ8bYCULAQMvC', '', '1', '17368578888',
        '4407509@qq.com', '1', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('2', '0', '2023-06-29 14:01:44', '2023-08-11 05:47:58', 'partner123', 'partner123',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('199', '0', '2023-06-29 14:01:44', '2023-08-11 05:47:58', '张三23', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('200', '0', '2023-06-29 14:01:44', '2023-08-11 05:47:58', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('201', '0', '2023-06-29 14:01:44', '2023-08-11 05:47:58', '111111', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('202', '0', '2023-06-29 14:01:44', '2023-08-11 05:47:58', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('203', '0', '2023-06-29 14:01:44', '2023-08-11 05:47:58', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('204', '0', '2023-06-29 14:01:44', '2023-08-11 05:47:58', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('205', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('206', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('207', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('208', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('209', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '测试', '123456',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '0', '17368578888',
        '4407509@qq.com', '3', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('210', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('211', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('212', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('213', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:03', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('214', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('215', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('216', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('217', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('218', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('219', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('220', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('221', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('222', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:07', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('223', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('224', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('225', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('226', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('227', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('228', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('229', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('230', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('231', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:11', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('232', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('233', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('234', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('235', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('236', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('237', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('238', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('239', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('240', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:16', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('241', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('242', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('243', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('244', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('245', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('246', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('247', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('248', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('249', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:19', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('250', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('251', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('252', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('253', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('254', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('255', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('256', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('257', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('258', '0', '2023-06-29 14:01:44', '2023-08-11 05:48:25', '432423', '432432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578888',
        '4407509@qq.com', '2', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('260', '0', '2023-07-12 22:40:45', '2023-08-11 05:47:58', '432432432', '432',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578465', '432@qq.com',
        '1', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('261', '0', '2023-07-12 22:41:57', '2023-08-11 05:47:58', '3333', '333333333',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578459', '3432@qq.com',
        '1', null, 'admin123');
INSERT INTO `sys_user`
VALUES ('262', '0', '2023-07-12 22:53:08', '2023-08-11 05:47:41', '4324', '432423',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17895968574', '3232@qq.com',
        '1', 'admin123', 'admin123');
INSERT INTO `sys_user`
VALUES ('263', '0', '2023-07-19 10:39:19', '2023-08-11 05:47:41', 'CTO', 'CTO',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '0', '17368578463',
        '4407509@qq.com', '1', 'admin123', 'admin123');
INSERT INTO `sys_user`
VALUES ('264', '0', '2023-07-19 10:49:31', '2023-08-11 05:47:41', 'manager', 'manager',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17368578463',
        '4407509@qq.com', '1', 'admin123', 'admin123');
INSERT INTO `sys_user`
VALUES ('265', '0', '2023-07-21 15:26:38', '2023-08-11 05:47:41', 'admin123456', null,
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '0', null, null, null, null,
        'admin123');
INSERT INTO `sys_user`
VALUES ('266', '0', '2023-07-24 10:42:22', '2023-08-11 05:47:41', 'test123456', 'test123456',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '0', null, null, null, null,
        'admin123');
INSERT INTO `sys_user`
VALUES ('267', '0', '2023-07-24 10:58:57', '2023-08-11 05:47:41', 'admin888', 'admin888',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '0', null, null, null, null,
        'admin123');
INSERT INTO `sys_user`
VALUES ('268', '0', '2023-07-31 22:01:12', '2023-08-11 05:47:41', 'xiaowang', '小王同学',
        '{bcrypt}$2a$10$0Ae0M/JMjsko./7YR.DHxO6oDVrd7XvElGh9CtriL4plvyd18iYA6', '', '1', '17322221111',
        '4407509@qq.com', '4', 'admin123', 'admin123');
INSERT INTO `sys_user`
VALUES ('269', '0', '2023-08-10 04:44:46', '2023-08-11 05:47:41', 'test0001', '测试账号',
        '{bcrypt}$2a$10$qfWwC8x5yP2C2ZgiOShSgualxuaR8camuQxhwsOa.wep2uSk3ZAMq', '', '0', '17368578463',
        '4407509@qq.com', '1', 'admin123', 'admin123');
INSERT INTO `sys_user`
VALUES ('270', '0', '2023-08-10 20:38:38', '2023-08-11 05:47:41', 'test0002', '测试2号',
        '{bcrypt}$2a$10$O5vULYpOH4JWemr.XeeF9u5boDxp1U0e7KT.g3W2l1AEVvffHlPDi', '', '1', '17368959681',
        '4407509@qq.com', '4', 'admin123', 'admin123');
INSERT INTO `sys_user`
VALUES ('271', '0', '2023-08-10 21:03:50', '2023-08-11 05:47:41', 'test0003', 'test0003',
        '{bcrypt}$2a$10$IScBVOOkBqclzRKoKwIQ5uZbRkGliqNFTpxZPV7x7dJJwARTnrse.', '', '1', '17698587456',
        '4407509@qq.com', '5', 'admin123', 'admin123');



# 角色表
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `deleteStatus` int                                                           DEFAULT NULL COMMENT '删除状态：0、已删除 1、未删除',
    `createTime`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `updateTime`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `name`         varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '角色名称',
    `tag`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色标签',
    `create_by`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '创建者',
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
    `remark`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 116
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色';

INSERT INTO `sys_role`
VALUES ('1', '1', '2023-06-29 14:49:49', '2023-07-03 13:40:33', '管理员', 'admin', '张三', '张三', '张三');
INSERT INTO `sys_role`
VALUES ('2', '0', '2023-06-29 14:49:49', '2023-08-11 05:47:28', '合作商', 'partner', '张三', 'admin123', '张三');
INSERT INTO `sys_role`
VALUES ('113', '0', '2023-07-24 10:33:16', '2023-08-11 05:47:28', '游客角色', 'guest', 'admin123', 'admin123',
        '游客角色');
INSERT INTO `sys_role`
VALUES ('114', '0', '2023-08-10 15:25:18', '2023-08-11 05:47:28', '测试角色', 'TestRole', 'admin123', 'admin123',
        '测试角色：只提供文章管理、图标管理、日志管理');
INSERT INTO `sys_role`
VALUES ('115', '0', '2023-08-10 21:03:02', '2023-08-11 01:42:54', '系统权限-系统工具-工作流管理', 'system-activiti',
        'admin123', 'admin123', '角色具有的菜单：系统权限-系统工具-工作流管理');


# 用户角色表
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    userId bigint(20) default null comment '用户id',
    roleId bigint(20) default null comment '角色id'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户-角色';

INSERT INTO `sys_user_role`
VALUES ('200', '1');
INSERT INTO `sys_user_role`
VALUES ('200', '2');
INSERT INTO `sys_user_role`
VALUES ('199', '1');
INSERT INTO `sys_user_role`
VALUES ('199', '2');
INSERT INTO `sys_user_role`
VALUES ('203', '1');
INSERT INTO `sys_user_role`
VALUES ('2', '2');
INSERT INTO `sys_user_role`
VALUES ('263', '1');
INSERT INTO `sys_user_role`
VALUES ('264', '2');
INSERT INTO `sys_user_role`
VALUES ('267', '1');
INSERT INTO `sys_user_role`
VALUES ('268', '113');
INSERT INTO `sys_user_role`
VALUES ('268', '1');
INSERT INTO `sys_user_role`
VALUES ('269', '114');
INSERT INTO `sys_user_role`
VALUES ('270', '114');
INSERT INTO `sys_user_role`
VALUES ('271', '1');
INSERT INTO `sys_user_role`
VALUES ('1', '1');

# 权限表
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `deleteStatus` int                                                           DEFAULT NULL COMMENT '删除状态：0、已删除 1、未删除',
    `createTime`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `updateTime`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限名称',
    `tag`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限标签',
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
    `remark`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    `menu_id`      bigint                                                        DEFAULT NULL COMMENT '所属菜单',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 84
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='权限';

INSERT INTO `sys_permission`
VALUES ('1', '1', '2023-07-01 23:15:56', '2023-08-11 05:53:12', '所有权限', 'permission_all', '', 'admin123',
        '所有权限', '2');
INSERT INTO `sys_permission`
VALUES ('2', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:52', '新增', 'admin', null, 'admin123', null, '15');
INSERT INTO `sys_permission`
VALUES ('8', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:52', '部门分页查询', 'dept:page', '张三', 'admin123', '部门',
        '39');
INSERT INTO `sys_permission`
VALUES ('9', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:52', '保存或更新部门', 'dept:saveOrUpdate', '张三',
        'admin123', '部门', '39');
INSERT INTO `sys_permission`
VALUES ('10', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:52', '根据ID删除部门', 'dept:delById', '张三', 'admin123',
        '部门', '39');
INSERT INTO `sys_permission`
VALUES ('11', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:52', '根据ID查询部门', 'dept:getById', '张三', 'admin123',
        '部门', '39');
INSERT INTO `sys_permission`
VALUES ('12', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '批量删除部门', 'dept:remoteByIds', '张三', 'admin123',
        '部门', '39');
INSERT INTO `sys_permission`
VALUES ('13', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:52', '菜单分页查询', 'menu:page', '张三', 'admin123',
        '菜单', '32');
INSERT INTO `sys_permission`
VALUES ('14', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '保存或更新菜单', 'menu:saveOrUpdate', '张三',
        'admin123', '菜单', '32');
INSERT INTO `sys_permission`
VALUES ('15', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '根据ID删除菜单', 'menu:delById', '张三', 'admin123',
        '菜单', '32');
INSERT INTO `sys_permission`
VALUES ('16', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '根据ID查询菜单', 'menu:getById', '张三', 'admin123',
        '菜单', '32');
INSERT INTO `sys_permission`
VALUES ('17', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '批量删除菜单', 'menu:remoteByIds', '张三', 'admin123',
        '菜单', '32');
INSERT INTO `sys_permission`
VALUES ('18', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '权限分页查询', 'permission:page', '张三', 'admin123',
        '权限', '20');
INSERT INTO `sys_permission`
VALUES ('19', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '保存或更新权限', 'permission:saveOrUpdate', '张三',
        'admin123', '权限', '20');
INSERT INTO `sys_permission`
VALUES ('20', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '根据ID删除权限', 'permission:delById', '张三',
        'admin123', '权限', '20');
INSERT INTO `sys_permission`
VALUES ('21', '0', '2023-07-01 23:15:56', '2023-08-11 05:46:58', '根据ID查询权限', 'permission:getById', '张三',
        'admin123', '权限', '20');
INSERT INTO `sys_permission`
VALUES ('22', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '批量删除权限', 'permission:remoteByIds', '张三',
        'admin123', '权限', '20');
INSERT INTO `sys_permission`
VALUES ('23', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '角色分页查询', 'role:page', '张三', 'admin123',
        '角色', '8');
INSERT INTO `sys_permission`
VALUES ('24', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '保存或更新角色', 'role:saveOrUpdate', '张三',
        'admin123', '角色', '8');
INSERT INTO `sys_permission`
VALUES ('25', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '根据ID删除角色', 'role:delById', '张三', 'admin123',
        '角色', '8');
INSERT INTO `sys_permission`
VALUES ('26', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '根据ID查询角色', 'role:getById', '张三', 'admin123',
        '角色', '8');
INSERT INTO `sys_permission`
VALUES ('27', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '批量删除角色', 'role:remoteByIds', '张三', 'admin123',
        '角色', '8');
INSERT INTO `sys_permission`
VALUES ('28', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '用户分页查询', 'user:page', '张三', 'admin123',
        '用户', '2');
INSERT INTO `sys_permission`
VALUES ('29', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '保存或更新用户', 'user:saveOrUpdate', '张三',
        'admin123', '用户', '2');
INSERT INTO `sys_permission`
VALUES ('30', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:02', '根据ID删除用户', 'user:delById', '张三', 'admin123',
        '用户', '2');
INSERT INTO `sys_permission`
VALUES ('31', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '根据ID查询用户', 'user:getById', '张三', 'admin123',
        '用户', '2');
INSERT INTO `sys_permission`
VALUES ('32', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '批量删除用户', 'user:remoteByIds', '张三', 'admin123',
        '用户', '2');
INSERT INTO `sys_permission`
VALUES ('56', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '文章类型分页查询', 'articleclass:page', '张三',
        'admin123', '文章类型', '1');
INSERT INTO `sys_permission`
VALUES ('57', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '保存或更新文章类型', 'articleclass:saveOrUpdate',
        '张三', 'admin123', '文章类型', '1');
INSERT INTO `sys_permission`
VALUES ('58', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '根据ID删除文章类型', 'articleclass:delById', '张三',
        'admin123', '文章类型', '1');
INSERT INTO `sys_permission`
VALUES ('59', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '根据ID查询文章类型', 'articleclass:getById', '张三',
        'admin123', '文章类型', '1');
INSERT INTO `sys_permission`
VALUES ('60', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '批量删除文章类型', 'articleclass:removeBatchByIds',
        '张三', 'admin123', '文章类型', '1');
INSERT INTO `sys_permission`
VALUES ('61', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '文章分页查询', 'icon:page', '张三', 'admin123',
        '文章', '1');
INSERT INTO `sys_permission`
VALUES ('62', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:07', '保存或更新文章', 'icon:saveOrUpdate', '张三',
        'admin123', '文章', '1');
INSERT INTO `sys_permission`
VALUES ('63', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '根据ID删除文章', 'icon:delById', '张三', 'admin123',
        '文章', '1');
INSERT INTO `sys_permission`
VALUES ('64', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '根据ID查询文章', 'icon:getById', '张三', 'admin123',
        '文章', '1');
INSERT INTO `sys_permission`
VALUES ('65', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '批量删除文章', 'icon:removeBatchByIds', '张三',
        'admin123', '文章', '1');
INSERT INTO `sys_permission`
VALUES ('66', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '表信息分页查询', 'tableInfo:page', '张三', 'admin123',
        '表信息', '1');
INSERT INTO `sys_permission`
VALUES ('67', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '保存或更新表信息', 'tableInfo:saveOrUpdate', '张三',
        'admin123', '表信息', '1');
INSERT INTO `sys_permission`
VALUES ('68', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '根据ID删除表信息', 'tableInfo:delById', '张三',
        'admin123', '表信息', '1');
INSERT INTO `sys_permission`
VALUES ('69', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '根据ID查询表信息', 'tableInfo:getById', '张三',
        'admin123', '表信息', '1');
INSERT INTO `sys_permission`
VALUES ('70', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '批量删除表信息', 'tableInfo:removeBatchByIds', '张三',
        'admin123', '表信息', '1');
INSERT INTO `sys_permission`
VALUES ('71', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:12', '表属性分页查询', 'tableProperty:page', '张三',
        'admin123', '表属性', '1');
INSERT INTO `sys_permission`
VALUES ('72', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:16', '保存或更新表属性', 'tableProperty:saveOrUpdate',
        '张三', 'admin123', '表属性', '1');
INSERT INTO `sys_permission`
VALUES ('73', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:16', '根据ID删除表属性', 'tableProperty:delById', '张三',
        'admin123', '表属性', '1');
INSERT INTO `sys_permission`
VALUES ('74', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:16', '根据ID查询表属性', 'tableProperty:getById', '张三',
        'admin123', '表属性', '1');
INSERT INTO `sys_permission`
VALUES ('75', '0', '2023-07-01 23:15:56', '2023-08-11 05:47:16', '批量删除表属性', 'tableProperty:removeBatchByIds',
        '张三', 'admin123', '表属性', '1');
INSERT INTO `sys_permission`
VALUES ('80', '0', '2023-07-20 15:25:08', '2023-07-20 15:27:32', '游客权限', 'guest', 'admin123', 'admin123',
        '423432423', '0');
INSERT INTO `sys_permission`
VALUES ('81', '0', '2023-08-10 20:50:25', '2023-08-11 05:46:52', '文章-查询', 'article:query', 'admin123', 'admin123',
        '文章-查询权限', '70');
INSERT INTO `sys_permission`
VALUES ('82', '0', '2023-08-10 20:51:04', '2023-08-11 05:46:52', '文章-新增', 'article:add', 'admin123', 'admin123',
        '文章-新增权限', '70');
INSERT INTO `sys_permission`
VALUES ('83', '0', '2023-08-10 20:56:36', '2023-08-11 05:46:52', '路由-菜单', 'route_menu', 'admin123', 'admin123',
        '路由-菜单权限', '32');


# 用户权限表
DROP TABLE IF EXISTS `sys_user_permission`;
CREATE TABLE `sys_user_permission`
(
    `user_id` bigint DEFAULT NULL COMMENT '用户主键ID',
    `perm_id` bigint DEFAULT NULL COMMENT '权限主键ID'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户-权限';

INSERT INTO `sys_user_permission`
VALUES ('200', '1');
INSERT INTO `sys_user_permission`
VALUES ('200', '2');
INSERT INTO `sys_user_permission`
VALUES ('200', '8');
INSERT INTO `sys_user_permission`
VALUES ('200', '9');
INSERT INTO `sys_user_permission`
VALUES ('200', '10');
INSERT INTO `sys_user_permission`
VALUES ('200', '11');
INSERT INTO `sys_user_permission`
VALUES ('200', '12');
INSERT INTO `sys_user_permission`
VALUES ('200', '13');
INSERT INTO `sys_user_permission`
VALUES ('200', '14');
INSERT INTO `sys_user_permission`
VALUES ('200', '15');
INSERT INTO `sys_user_permission`
VALUES ('200', '16');
INSERT INTO `sys_user_permission`
VALUES ('200', '17');
INSERT INTO `sys_user_permission`
VALUES ('200', '18');
INSERT INTO `sys_user_permission`
VALUES ('200', '19');
INSERT INTO `sys_user_permission`
VALUES ('200', '20');
INSERT INTO `sys_user_permission`
VALUES ('200', '21');
INSERT INTO `sys_user_permission`
VALUES ('200', '22');
INSERT INTO `sys_user_permission`
VALUES ('200', '23');
INSERT INTO `sys_user_permission`
VALUES ('200', '24');
INSERT INTO `sys_user_permission`
VALUES ('200', '25');
INSERT INTO `sys_user_permission`
VALUES ('200', '26');
INSERT INTO `sys_user_permission`
VALUES ('200', '27');
INSERT INTO `sys_user_permission`
VALUES ('200', '28');
INSERT INTO `sys_user_permission`
VALUES ('200', '29');
INSERT INTO `sys_user_permission`
VALUES ('200', '30');
INSERT INTO `sys_user_permission`
VALUES ('200', '31');
INSERT INTO `sys_user_permission`
VALUES ('200', '32');
INSERT INTO `sys_user_permission`
VALUES ('199', '1');
INSERT INTO `sys_user_permission`
VALUES ('199', '2');
INSERT INTO `sys_user_permission`
VALUES ('199', '8');
INSERT INTO `sys_user_permission`
VALUES ('199', '9');
INSERT INTO `sys_user_permission`
VALUES ('199', '10');
INSERT INTO `sys_user_permission`
VALUES ('199', '11');
INSERT INTO `sys_user_permission`
VALUES ('199', '12');
INSERT INTO `sys_user_permission`
VALUES ('199', '13');
INSERT INTO `sys_user_permission`
VALUES ('199', '14');
INSERT INTO `sys_user_permission`
VALUES ('199', '15');
INSERT INTO `sys_user_permission`
VALUES ('199', '16');
INSERT INTO `sys_user_permission`
VALUES ('199', '17');
INSERT INTO `sys_user_permission`
VALUES ('199', '18');
INSERT INTO `sys_user_permission`
VALUES ('199', '19');
INSERT INTO `sys_user_permission`
VALUES ('199', '20');
INSERT INTO `sys_user_permission`
VALUES ('199', '21');
INSERT INTO `sys_user_permission`
VALUES ('199', '22');
INSERT INTO `sys_user_permission`
VALUES ('199', '23');
INSERT INTO `sys_user_permission`
VALUES ('199', '24');
INSERT INTO `sys_user_permission`
VALUES ('199', '25');
INSERT INTO `sys_user_permission`
VALUES ('199', '26');
INSERT INTO `sys_user_permission`
VALUES ('199', '27');
INSERT INTO `sys_user_permission`
VALUES ('199', '28');
INSERT INTO `sys_user_permission`
VALUES ('199', '29');
INSERT INTO `sys_user_permission`
VALUES ('199', '30');
INSERT INTO `sys_user_permission`
VALUES ('199', '31');
INSERT INTO `sys_user_permission`
VALUES ('199', '32');
INSERT INTO `sys_user_permission`
VALUES ('203', '1');
INSERT INTO `sys_user_permission`
VALUES ('203', '2');
INSERT INTO `sys_user_permission`
VALUES ('203', '8');
INSERT INTO `sys_user_permission`
VALUES ('203', '9');
INSERT INTO `sys_user_permission`
VALUES ('203', '10');
INSERT INTO `sys_user_permission`
VALUES ('203', '11');
INSERT INTO `sys_user_permission`
VALUES ('203', '12');
INSERT INTO `sys_user_permission`
VALUES ('203', '13');
INSERT INTO `sys_user_permission`
VALUES ('203', '14');
INSERT INTO `sys_user_permission`
VALUES ('203', '15');
INSERT INTO `sys_user_permission`
VALUES ('203', '16');
INSERT INTO `sys_user_permission`
VALUES ('203', '17');
INSERT INTO `sys_user_permission`
VALUES ('203', '18');
INSERT INTO `sys_user_permission`
VALUES ('203', '19');
INSERT INTO `sys_user_permission`
VALUES ('203', '20');
INSERT INTO `sys_user_permission`
VALUES ('203', '21');
INSERT INTO `sys_user_permission`
VALUES ('203', '22');
INSERT INTO `sys_user_permission`
VALUES ('203', '23');
INSERT INTO `sys_user_permission`
VALUES ('203', '24');
INSERT INTO `sys_user_permission`
VALUES ('203', '25');
INSERT INTO `sys_user_permission`
VALUES ('203', '26');
INSERT INTO `sys_user_permission`
VALUES ('203', '27');
INSERT INTO `sys_user_permission`
VALUES ('203', '28');
INSERT INTO `sys_user_permission`
VALUES ('203', '29');
INSERT INTO `sys_user_permission`
VALUES ('203', '30');
INSERT INTO `sys_user_permission`
VALUES ('203', '31');
INSERT INTO `sys_user_permission`
VALUES ('203', '32');
INSERT INTO `sys_user_permission`
VALUES ('2', '1');
INSERT INTO `sys_user_permission`
VALUES ('2', '2');
INSERT INTO `sys_user_permission`
VALUES ('263', '1');
INSERT INTO `sys_user_permission`
VALUES ('264', '1');
INSERT INTO `sys_user_permission`
VALUES ('267', '1');
INSERT INTO `sys_user_permission`
VALUES ('268', '1');
INSERT INTO `sys_user_permission`
VALUES ('269', '1');
INSERT INTO `sys_user_permission`
VALUES ('270', '83');
INSERT INTO `sys_user_permission`
VALUES ('270', '81');
INSERT INTO `sys_user_permission`
VALUES ('270', '82');
INSERT INTO `sys_user_permission`
VALUES ('271', '83');
INSERT INTO `sys_user_permission`
VALUES ('1', '1');