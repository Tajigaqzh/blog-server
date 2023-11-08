DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `deleteStatus` int                                                          DEFAULT NULL COMMENT '删除状态：0、已删除 1、未删除',
    `createTime`   datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `updateTime`   datetime                                                     DEFAULT NULL COMMENT '更新时间',
    `dept_name`    varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '部门名称',
    `order_num`    int                                                          DEFAULT '0' COMMENT '显示顺序',
    `manager`      varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '负责人',
    `phone`        varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '联系电话',
    `email`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
    `status`       bit(1)                                                       DEFAULT NULL COMMENT '部门状态（0正常 1停用）',
    `create_by`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
    `update_by`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
    `parent_id`    bigint                                                       DEFAULT '0' COMMENT '父部门ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 213
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='部门';


INSERT INTO `sys_dept`
VALUES ('1', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '红猪科技', '0', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '0');
INSERT INTO `sys_dept`
VALUES ('2', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '北京分公司', '1', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '1');
INSERT INTO `sys_dept`
VALUES ('3', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '上海分公司', '2', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '1');
INSERT INTO `sys_dept`
VALUES ('4', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '研发部门', '1', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '2');
INSERT INTO `sys_dept`
VALUES ('5', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '市场部门', '2', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '2');
INSERT INTO `sys_dept`
VALUES ('6', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '测试部门', '3', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '2');
INSERT INTO `sys_dept`
VALUES ('7', '1', '2023-07-04 09:13:48', '2023-07-11 21:15:23', '财务部门', '4', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '2');
INSERT INTO `sys_dept`
VALUES ('8', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '运维部门', '5', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '3');
INSERT INTO `sys_dept`
VALUES ('9', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '市场部门', '1', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '3');
INSERT INTO `sys_dept`
VALUES ('10', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '财务部门', '2', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '3');
INSERT INTO `sys_dept`
VALUES ('11', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '深圳分公司', '2', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '1');
INSERT INTO `sys_dept`
VALUES ('12', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '技术部门', '1', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '11');
INSERT INTO `sys_dept`
VALUES ('13', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '采购部门', '2', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '11');
INSERT INTO `sys_dept`
VALUES ('14', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '生产部门', '3', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '11');
INSERT INTO `sys_dept`
VALUES ('15', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '设备部门', '4', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '11');
INSERT INTO `sys_dept`
VALUES ('16', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '物控部门', '5', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '11');
INSERT INTO `sys_dept`
VALUES ('17', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '质量部门', '1', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '11');
INSERT INTO `sys_dept`
VALUES ('18', '1', '2023-07-04 09:13:48', '2023-07-04 09:13:48', '工艺部门', '2', '张三', '17368578463',
        '4407509@qq.com', '', 'admin', '', '11');
INSERT INTO `sys_dept`
VALUES ('208', '0', '2023-07-11 21:10:29', '2023-07-11 21:14:50', '4324', '1', '43243', '2432', '432', '', '', '',
        '5');
INSERT INTO `sys_dept`
VALUES ('209', '0', '2023-07-12 13:13:13', '2023-07-12 13:13:18', '4324', '1', '324', '3', '3243@qqc.om', '', '', '',
        '1');
INSERT INTO `sys_dept`
VALUES ('210', '0', '2023-07-12 13:13:28', '2023-07-12 13:13:43', '423', '1', '432', '432', '432', '', '', '', '4');
INSERT INTO `sys_dept`
VALUES ('211', '0', '2023-07-20 15:59:03', '2023-07-21 16:51:35', '集团总部', '1', '4324', '17368578463',
        '4408509@qq.com', '\0', 'admin123', 'admin123', '0');
INSERT INTO `sys_dept`
VALUES ('212', '1', '2023-08-11 03:54:24', '2023-08-11 03:54:24', '测试部门', '1', '张三', '17368546956',
        '4407509@qq.com', '', 'admin123', 'admin123', '1');
