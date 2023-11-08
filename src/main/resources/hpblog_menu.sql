DROP TABLE IF EXISTS `sys_menu`;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
create table `sys_menu`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `deleteStatus` int                                                           DEFAULT NULL COMMENT '删除状态：0、已删除 1、未删除',
    `createTime`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `updateTime`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单名称',
    `path`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单地址请求路径',
    `component`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '组件名:如果不填,默认就是菜单路径,从前端src目录开始计算,例如:src/views/ads/index.vue',
    `title`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标题',
    `type`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '类型：0、目录 1、菜单 2、接口',
    `icon`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
    `showLink`     bit(1)                                                        DEFAULT NULL COMMENT '链接',
    `rank`         int                                                           DEFAULT NULL COMMENT '排序:值越小越靠前',
    `parent_id`    int                                                           DEFAULT NULL COMMENT '父菜单',
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '1', '2023-06-29 15:13:26', '2023-07-10 13:25:44', 'SysPerm', '/sysperm', null, '系统权限', '0', 'uil:setting', '', '1', '0', null, null);
INSERT INTO `sys_menu` VALUES ('2', '1', '2023-06-29 15:13:26', '2023-07-01 18:55:48', 'User', '/system/user/list', null, '用户管理', '1', 'ph:user', '', '1', '1', null, null);
INSERT INTO `sys_menu` VALUES ('4', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'UserAdd', '/user/saveOrUpdate', null, '用户新增', '2', 'ph:user', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('5', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'UserUpdate', '/user/update', null, '用户修改', '2', 'ph:user', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('6', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'UserDelete', '/user/delById', null, '用户删除', '2', 'ph:user', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('7', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'UserQuery', '/user/page', null, '用户查询', '2', 'ph:user', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('8', '1', '2023-06-29 15:13:26', '2023-07-01 18:55:48', 'Role', '/system/role/list', null, '角色管理', '1', 'eos-icons:role-binding-outlined', '', '1', '1', null, null);
INSERT INTO `sys_menu` VALUES ('10', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'RoleAdd', '/role/saveOrUpdate', null, '角色新增', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('11', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'RoleUpdate', '/role/update', null, '角色修改', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('12', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'RoleDelete', '/role/delById', null, '角色删除', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('13', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'RoleQuery', '/role/page', null, '角色查询', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('14', '0', '2023-07-03 10:40:30', '2023-08-11 05:59:36', 'Ads', '/ads', null, '广告管理', '0', 'ri:advertisement-line', '', '1', '0', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('15', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:32', 'AdsList', '/ads/index', null, '广告列表', '1', 'ri:advertisement-line', '', '1', '14', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('16', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:28', 'AdsAdd', '/ads/add', null, '广告新增', '2', 'ri:advertisement-line', '', '1', '15', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('17', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:28', 'AdsUpdate', '/ads/update', null, '广告修改', '2', 'ri:advertisement-line', '', '1', '15', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('18', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:28', 'AdsDelete', '/ads/delete', null, '广告删除', '2', 'ri:advertisement-line', '', '1', '15', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('19', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:28', 'AdsQuery', '/ads/query', null, '广告查询', '2', 'ri:advertisement-line', '', '1', '15', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('20', '1', '2023-06-29 15:13:26', '2023-07-01 18:55:48', 'Perm', '/system/perm/list', null, '权限管理', '1', 'arcticons:permissionsmanager', '', '1', '1', null, null);
INSERT INTO `sys_menu` VALUES ('22', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'PermAdd', '/perm/saveOrUpdate', null, '权限新增', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('23', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'AuthUpdate', '/auth/update', null, '权限修改', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('24', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'PermDelete', '/perm/delById', null, '权限删除', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('25', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'AuthQuery', '/perm/page', null, '权限查询', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('26', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:15', 'Partner', '/partner', null, '合作商管理', '1', 'mdi:partnership-outline', '', '1', '0', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('27', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:10', 'PartnerList', '/partner/list', null, '合作商', '2', 'mdi:partnership-outline', '', '1', '26', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('28', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:06', 'PartnerAdd', '/partner/add', null, '合作商新增', '2', 'mdi:partnership-outline', '', '1', '27', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('29', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:06', 'PartnerUpdate', '/partner/update', null, '合作商修改', '2', 'mdi:partnership-outline', '', '1', '27', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('30', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:06', 'PartnerDelete', '/partner/delete', null, '合作商删除', '2', 'mdi:partnership-outline', '', '1', '27', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('31', '0', '2023-06-29 15:13:26', '2023-08-11 05:59:06', 'PartnerQuery', '/partner/query', null, '合作商查询', '2', 'mdi:partnership-outline', '', '1', '27', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('32', '1', '2023-06-29 15:13:26', '2023-07-01 18:55:48', 'Menu', '/system/menu/list', null, '菜单管理', '1', 'ep:menu', '', '1', '1', null, null);
INSERT INTO `sys_menu` VALUES ('34', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'MenuAdd', '/menu/saveOrUpdate', null, '菜单新增', '2', 'ep:menu', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('35', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'MenuUpdate', '/menu/saveOrUpdate', null, '菜单修改', '2', 'ep:menu', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('36', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'MenuDelete', '/menu/delById', null, '菜单删除', '2', 'ep:menu', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('37', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'MenuQuery', '/menu/page', null, '菜单查询', '2', 'ep:menu', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('38', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'Route', '/route/getRoutes', null, '路由', '2', 'material-symbols:route', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('39', '1', '2023-06-29 15:13:26', '2023-07-01 18:55:48', 'Dept', '/system/dept/list', null, '部门管理', '1', 'mingcute:department-fill', '', '1', '1', null, null);
INSERT INTO `sys_menu` VALUES ('40', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'DeptAdd', '/dept/saveOrUpdate', null, '部门新增', '2', 'mingcute:department-fill', '', '1', '39', null, null);
INSERT INTO `sys_menu` VALUES ('41', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'DeptUpdate', '/dept/saveOrUpdate', null, '部门修改', '2', 'mingcute:department-fill', '', '1', '39', null, null);
INSERT INTO `sys_menu` VALUES ('42', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'DeptDelete', '/dept/delById', null, '部门删除', '2', 'mingcute:department-fill', '', '1', '39', null, null);
INSERT INTO `sys_menu` VALUES ('43', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'DeptQuery', '/dept/page', null, '部门查询', '2', 'mingcute:department-fill', '', '1', '39', null, null);
INSERT INTO `sys_menu` VALUES ('44', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'DeptQuery', '/dept/getDeptList', null, '部门查询', '2', 'mingcute:department-fill', '', '1', '39', null, null);
INSERT INTO `sys_menu` VALUES ('45', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'MenuList', '/menu/getMenuList', null, '菜单查询', '2', 'ep:menu', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('46', '0', '2023-07-10 13:53:29', '2023-08-11 05:58:47', 'supplier', '/system/gong', null, '供应商', '0', 'mdi:business-card-outline', '', '1', '0', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('47', '0', '2023-07-10 13:56:14', '2023-08-11 05:58:41', 'invoice2', '/invoice2', null, '发票管理1', '1', 'mdi:invoice', '', '1', '46', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('48', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'MenuRemote', '/menu/removeBatchByIds', null, '菜单批量删除', '2', 'ep:menu', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('49', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'GetRoleList', '/role/getRoleList', null, '查询所有角色', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('50', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'GetPermList', '/perm/getPermList', null, '权限查询', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('51', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'GetRoleList', '/role/getSelectedRolesByMenuId', null, '根据菜单查询角色', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('52', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'GetPermList', '/perm/getSelectedPermsByMenuId', '', '根据菜单查询权限', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('53', '1', '2023-06-29 15:13:26', '2023-07-03 11:06:38', 'MenuSaveAuth', '/menu/saveAuth', null, '授权', '2', 'ep:menu', '', '1', '32', null, null);
INSERT INTO `sys_menu` VALUES ('54', '0', '2023-07-10 13:56:14', '2023-08-11 05:58:41', 'invoice1', '/invoice1', null, '发票管理2', '1', 'mdi:invoice', '', '1', '46', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('55', '1', '2023-07-11 13:28:43', '2023-07-11 13:34:29', 'UserBatchDeleteByIds', '/user/removeBatchByIds', null, '用户批量删除', '2', 'ph:user', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('56', '1', '2023-07-11 15:49:05', '2023-07-12 10:50:44', 'resetpasswordById', '/user/ReSetPassword', '', '重置密码', '2', 'ph:user', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('57', '1', '2023-07-11 17:08:19', '2023-07-11 17:08:31', 'getSelectedRolesByUserId', '/role/getSelectedRolesByUserId', null, '查询角色', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('58', '1', '2023-07-11 17:09:14', '2023-07-11 17:09:38', 'getSelectedPermsByUserId', '/perm/getSelectedPermsByUserId', null, '查询权限', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('59', '1', '2023-07-11 17:20:40', '2023-07-12 10:50:39', 'saveAuth', '/user/saveAuth', '', '用户授权', '2', 'ph:user', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('60', '1', '2023-07-11 19:24:14', '2023-07-11 19:24:41', 'remoteByIds', '/role/removeBatchByIds', null, '批量删除角色', '2', 'eos-icons:role-binding-outlined', '', '1', '8', null, null);
INSERT INTO `sys_menu` VALUES ('61', '1', '2023-07-11 19:42:03', '2023-07-12 09:22:48', 'remoteByIds', '/perm/removeBatchByIds', null, '批量删除权限', '2', 'arcticons:permissionsmanager', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('62', '0', '2023-07-12 10:01:17', '2023-07-12 10:06:37', '543', '543534', '', '54543', '2', '54', '', '4', '0', null, null);
INSERT INTO `sys_menu` VALUES ('63', '0', '2023-07-12 10:06:26', '2023-07-12 10:06:37', '4324', '2343', '', '3243', '2', '4324', '\0', '1', '0', null, null);
INSERT INTO `sys_menu` VALUES ('64', '0', '2023-07-12 13:29:06', '2023-07-12 13:29:11', '3243', '432423', '', '32432', '1', '432', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('65', '0', '2023-07-12 13:29:24', '2023-07-12 13:29:45', '2', '2', '', '2', '2', '2', '', '1', '2', null, null);
INSERT INTO `sys_menu` VALUES ('66', '0', '2023-07-12 13:29:33', '2023-07-12 13:29:51', '2', '2', '', '2', '2', '', '', '1', '20', null, null);
INSERT INTO `sys_menu` VALUES ('67', '0', '2023-07-12 13:30:01', '2023-08-11 05:56:27', '3', '3', '', '3', '2', '', '', '3', '20', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('68', '0', '2023-07-12 13:32:36', '2023-07-12 13:32:39', '4324', '3', '', '3', '2', '', '', '1', '0', null, null);
INSERT INTO `sys_menu` VALUES ('69', '1', '2023-07-12 15:43:25', '2023-07-14 21:39:13', 'ArticleManage', '/article', '', '文章管理', '0', 'icon-park-outline:add', '', '1', '0', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('70', '1', '2023-07-12 15:44:22', '2023-07-14 21:39:30', 'ArticleList', '/system/article/list', '', '文章列表', '1', 'zondicons:add-outline', '', '1', '69', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('71', '1', '2023-07-12 15:45:56', '2023-07-12 15:45:56', 'article_page', '/article/page', null, '文章分页查询', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '70', null, null);
INSERT INTO `sys_menu` VALUES ('72', '1', '2023-07-12 15:46:45', '2023-07-12 15:46:45', 'article_saveOrUpdate', '/article/saveOrUpdate', null, '新增或者更新文章', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '70', null, null);
INSERT INTO `sys_menu` VALUES ('73', '1', '2023-07-12 15:47:28', '2023-07-12 15:47:28', 'article_delById', '/article/delById', null, '根据ID删除文章', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '70', null, null);
INSERT INTO `sys_menu` VALUES ('74', '1', '2023-07-12 15:48:01', '2023-07-12 15:48:01', 'article_getById', '/article/getById', null, '根据ID查询文章', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '70', null, null);
INSERT INTO `sys_menu` VALUES ('75', '1', '2023-07-12 15:52:03', '2023-07-12 15:52:03', 'removeBatchByIds', '/article/removeBatchByIds', null, '批量删除', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '70', null, null);
INSERT INTO `sys_menu` VALUES ('84', '1', '2023-07-12 15:44:22', '2023-07-14 21:39:39', 'ArticleClassList', '/system/articleClass/list', '', '文章类型列表', '1', 'jam:write-f', '', '1', '69', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('85', '1', '2023-07-12 15:45:56', '2023-07-12 15:45:56', 'ArticleClass_page', '/articleClass/page', null, '文章类型分页查询', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '84', null, null);
INSERT INTO `sys_menu` VALUES ('86', '1', '2023-07-12 15:46:45', '2023-07-12 15:46:45', 'ArticleClass_saveOrUpdate', '/articleClass/saveOrUpdate', null, '新增或者更新文章类型', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '84', null, null);
INSERT INTO `sys_menu` VALUES ('87', '1', '2023-07-12 15:47:28', '2023-07-12 15:47:28', 'ArticleClass_delById', '/articleClass/delById', null, '根据ID删除文章类型', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '84', null, null);
INSERT INTO `sys_menu` VALUES ('88', '1', '2023-07-12 15:48:01', '2023-07-12 15:48:01', 'ArticleClass_getById', '/articleClass/getById', null, '根据ID查询文章类型', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '84', null, null);
INSERT INTO `sys_menu` VALUES ('89', '1', '2023-07-12 15:52:03', '2023-07-12 15:52:03', 'ArticleClass_removeBatchByIds', '/articleClass/removeBatchByIds', null, '批量删除文章类型', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '84', null, null);
INSERT INTO `sys_menu` VALUES ('97', '1', '2023-07-12 15:43:25', '2023-08-10 15:26:59', 'IconManage', '/icon', '', '图标管理', '0', 'svg-spinners:blocks-shuffle-2', '', '1', '0', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('98', '1', '2023-07-12 15:44:22', '2023-08-10 15:26:05', 'IconList', '/system/icon/list', '', '图标管理', '1', 'svg-spinners:blocks-shuffle-2', '', '1', '97', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('99', '1', '2023-07-12 15:45:56', '2023-07-12 18:56:15', 'Icon_page', '/icon/page', '', '图标分页查询', '2', 'logos:eta-icon', '\0', '1', '98', null, null);
INSERT INTO `sys_menu` VALUES ('100', '1', '2023-07-12 15:46:45', '2023-07-12 18:56:06', 'Icon_saveOrUpdate', '/icon/saveOrUpdate', '', '新增或者更新图标', '2', 'logos:eta-icon', '\0', '1', '98', null, null);
INSERT INTO `sys_menu` VALUES ('101', '1', '2023-07-12 15:47:28', '2023-07-12 18:56:01', 'Icon_delById', '/icon/delById', '', '根据ID删除图标', '2', 'logos:eta-icon', '\0', '1', '98', null, null);
INSERT INTO `sys_menu` VALUES ('102', '1', '2023-07-12 15:48:01', '2023-07-12 18:55:56', 'Icon_getById', '/icon/getById', '', '根据ID查询图标', '2', 'logos:eta-icon', '\0', '1', '98', null, null);
INSERT INTO `sys_menu` VALUES ('103', '1', '2023-07-12 15:52:03', '2023-07-12 18:55:50', 'Icon_removeBatchByIds', '/icon/removeBatchByIds', '', '批量删除图标', '2', 'logos:eta-icon', '\0', '1', '98', null, null);
INSERT INTO `sys_menu` VALUES ('104', '1', '2023-07-12 19:47:53', '2023-07-12 19:48:09', 'getIconList', '/icon/getIconList', '', '查询所有图标', '2', 'logos:eta-icon', '', '1', '98', null, null);
INSERT INTO `sys_menu` VALUES ('105', '0', '2023-07-12 20:55:04', '2023-07-12 20:55:14', '432', '432432', '', '432', '2', 'svg-spinners:bars-scale', '', '1', '0', null, null);
INSERT INTO `sys_menu` VALUES ('106', '1', '2023-07-12 15:43:25', '2023-07-20 15:33:01', 'TableInfoManage', '/tableInfo', '', '系统工具', '0', 'icon-park-solid:system', '', '1', '0', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('107', '1', '2023-07-12 15:44:22', '2023-08-23 09:04:26', 'TableInfoList', '/system/tableInfo/list', '', '代码生成器', '1', 'mdi:build', '', '1', '106', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('108', '1', '2023-07-12 15:45:56', '2023-07-12 15:45:56', 'TableInfo_page', '/tableInfo/page', null, '表信息分页查询', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('109', '1', '2023-07-12 15:46:45', '2023-07-12 15:46:45', 'TableInfo_saveOrUpdate', '/tableInfo/saveOrUpdate', null, '新增或者更新表信息', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('110', '1', '2023-07-12 15:47:28', '2023-07-12 15:47:28', 'TableInfo_delById', '/tableInfo/delById', null, '根据ID删除表信息', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('111', '1', '2023-07-12 15:48:01', '2023-07-12 15:48:01', 'TableInfo_getById', '/tableInfo/getById', null, '根据ID查询表信息', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('112', '1', '2023-07-12 15:52:03', '2023-07-12 15:52:03', 'TableInfo_removeBatchByIds', '/tableInfo/removeBatchByIds', null, '批量删除表信息', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('115', '1', '2023-07-12 15:45:56', '2023-07-12 15:45:56', 'TableProperty_page', '/tableProperty/page', null, '表属性分页查询', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('116', '1', '2023-07-12 15:46:45', '2023-07-12 15:46:45', 'TableProperty_saveOrUpdate', '/tableProperty/saveOrUpdate', null, '新增或者更新表属性', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('117', '1', '2023-07-12 15:47:28', '2023-07-12 15:47:28', 'TableProperty_delById', '/tableProperty/delById', null, '根据ID删除表属性', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('118', '1', '2023-07-12 15:48:01', '2023-07-12 15:48:01', 'TableProperty_getById', '/tableProperty/getById', null, '根据ID查询表属性', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('119', '1', '2023-07-12 15:52:03', '2023-07-12 15:52:03', 'TableProperty_removeBatchByIds', '/tableProperty/removeBatchByIds', null, '批量删除表属性', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', null, null);
INSERT INTO `sys_menu` VALUES ('120', '1', '2023-07-12 15:52:03', '2023-07-12 15:52:03', 'TableProperty_removeBatchByIds', '/tableProperty/getByTableInfoId', null, '根据表ID查询表属性', '2', 'fluent-mdl2:knowledge-article', '\0', '1', '107', '', '');
INSERT INTO `sys_menu` VALUES ('121', '1', '2023-07-13 15:25:10', '2023-07-13 15:25:15', 'saveTableProperties', '/tableProperty/saveTableProperties', null, '批量新增字段', '2', 'zondicons:add-outline', '\0', '1', '107', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('122', '1', '2023-07-14 10:14:20', '2023-07-14 10:14:20', 'createTable', '/tableInfo/createTable', '', '创建表', '2', 'icon-park-outline:add', '\0', '1', '107', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('123', '1', '2023-07-14 10:20:03', '2023-07-14 10:21:13', 'databaseManage', '', '', '数据库管理', '1', 'fluent:alert-on-20-regular', '', '1', '106', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('124', '1', '2023-07-14 14:15:32', '2023-07-14 14:15:59', 'generatorByTableInfoId', '/tableInfo/generatorByTableInfoId', '', '代码生成', '2', 'svg-spinners:12-dots-scale-rotate', '\0', '1', '107', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('125', '1', '2023-07-14 21:18:55', '2023-07-14 21:18:55', 'asyncDatabase', '/tableInfo/asyncDatabase', '', '同步数据库', '2', 'radix-icons:update', '\0', '1', '107', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('126', '1', '2023-07-17 20:21:25', '2023-07-17 20:25:22', 'flow', '/flow', '', '工作流管理', '0', 'material-symbols:menu-book-outline', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('127', '1', '2023-07-12 15:43:25', '2023-07-17 20:27:10', 'ProcessDefinitionManage', '/system/ProcessDefinition/list', '', '流程定义', '1', 'svg-spinners:blocks-wave', '', '1', '126', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('128', '0', '2023-07-12 15:44:22', '2023-07-19 14:08:02', 'ProcessDefinitionList', '/system/ProcessDefinition/list', null, '流程定义列表', '1', 'fluent-mdl2:knowledge-article', '', '1', '127', null, 'CTO');
INSERT INTO `sys_menu` VALUES ('129', '1', '2023-07-12 15:45:56', '2023-07-17 20:25:37', 'ProcessDefinition_page', '/ProcessDefinition/page', null, '流程定义分页查询', '2', 'fluent-mdl2:knowledge-article', '', '1', '127', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('130', '1', '2023-07-12 15:46:45', '2023-07-17 20:25:36', 'ProcessDefinition_saveOrUpdate', '/ProcessDefinition/saveOrUpdate', null, '新增或者更新流程定义', '2', 'fluent-mdl2:knowledge-article', '', '1', '127', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('131', '1', '2023-07-12 15:47:28', '2023-07-17 20:25:36', 'ProcessDefinition_delById', '/ProcessDefinition/delById', null, '根据ID删除流程定义', '2', 'fluent-mdl2:knowledge-article', '', '1', '127', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('132', '1', '2023-07-12 15:48:01', '2023-07-17 20:25:35', 'ProcessDefinition_getById', '/ProcessDefinition/getById', null, '根据ID查询流程定义', '2', 'fluent-mdl2:knowledge-article', '', '1', '127', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('133', '1', '2023-07-12 15:52:03', '2023-07-17 20:25:35', 'ProcessDefinition_removeBatchByIds', '/ProcessDefinition/removeBatchByIds', null, '批量删除流程定义', '2', 'fluent-mdl2:knowledge-article', '', '1', '127', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('134', '1', '2023-07-18 10:01:06', '2023-07-18 10:01:50', 'deploy', '/processDefinition/deploy', '', '流程部署', '2', 'zondicons:add-outline', '', '1', '127', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('136', '1', '2023-07-12 15:44:22', '2023-08-11 03:59:42', 'LeaveList', '/system/leave/list', '', '请假流程管理', '1', 'clarity:on-holiday-solid', '', '1', '126', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('137', '1', '2023-07-12 15:45:56', '2023-07-18 14:49:19', 'Leave_page', '/leave/page', null, '请假流程分页查询', '2', 'fluent-mdl2:knowledge-article', '', '1', '136', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('138', '1', '2023-07-12 15:46:45', '2023-07-18 14:49:19', 'Leave_saveOrUpdate', '/leave/saveOrUpdate', null, '新增或者更新请假流程', '2', 'fluent-mdl2:knowledge-article', '', '1', '136', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('139', '1', '2023-07-12 15:47:28', '2023-07-18 14:49:18', 'Leave_delById', '/leave/delById', null, '根据ID删除请假流程', '2', 'fluent-mdl2:knowledge-article', '', '1', '136', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('140', '1', '2023-07-12 15:48:01', '2023-07-18 14:49:18', 'Leave_getById', '/leave/getById', null, '根据ID查询请假流程', '2', 'fluent-mdl2:knowledge-article', '', '1', '136', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('141', '1', '2023-07-12 15:52:03', '2023-07-18 14:49:18', 'Leave_removeBatchByIds', '/leave/removeBatchByIds', null, '批量删除请假流程', '2', 'fluent-mdl2:knowledge-article', '', '1', '136', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('142', '1', '2023-07-18 15:32:10', '2023-07-18 15:51:17', 'getByUsername', '/leave/getByUsername', '', 'getByUsername', '2', '', '', '1', '136', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('143', '1', '2023-07-18 16:44:23', '2023-07-18 16:44:23', 'getProcessDefinitions', '/leave/getProcessDefinitions', '', 'getProcessDefinitions', '2', '', '', '1', '136', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('144', '1', '2023-07-18 22:28:51', '2023-07-18 22:28:51', 'viewImage', '/leave/viewImage', '', 'viewImage', '2', '', '', '1', '136', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('146', '1', '2023-07-12 15:44:22', '2023-08-11 04:00:48', 'TaskList', '/system/task/list', '', '待办任务', '1', 'lucide:list-todo', '', '1', '126', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('147', '1', '2023-07-12 15:45:56', '2023-07-19 09:31:55', 'Task_page', '/task/page', null, '流程任务分页查询', '2', 'fluent-mdl2:knowledge-article', '', '1', '146', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('148', '1', '2023-07-12 15:46:45', '2023-07-19 09:31:55', 'Task_saveOrUpdate', '/task/saveOrUpdate', null, '新增或者更新流程任务', '2', 'fluent-mdl2:knowledge-article', '', '1', '146', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('149', '1', '2023-07-12 15:47:28', '2023-07-19 09:31:54', 'Task_delById', '/task/delById', null, '根据ID删除流程任务', '2', 'fluent-mdl2:knowledge-article', '', '1', '146', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('150', '1', '2023-07-12 15:48:01', '2023-07-19 09:31:54', 'Task_getById', '/task/getById', null, '根据ID查询流程任务', '2', 'fluent-mdl2:knowledge-article', '', '1', '146', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('151', '1', '2023-07-12 15:52:03', '2023-07-19 09:31:53', 'Task_removeBatchByIds', '/task/removeBatchByIds', null, '批量删除流程任务', '2', 'fluent-mdl2:knowledge-article', '', '1', '146', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('152', '1', '2023-07-19 13:38:04', '2023-07-19 13:38:07', 'agree', '/task/agree', '', '同意审批', '2', 'jam:write', '', '1', '146', 'CTO', 'CTO');
INSERT INTO `sys_menu` VALUES ('153', '1', '2023-07-19 14:07:38', '2023-07-19 14:07:38', 'isEnd', '/leave/isEnd', '', '请假审批情况', '2', 'svg-spinners:blocks-scale', '', '1', '136', 'CTO', 'CTO');
INSERT INTO `sys_menu` VALUES ('154', '1', '2023-07-20 09:01:24', '2023-07-20 13:23:56', 'qt', '/qt', '', '定时器管理', '0', 'svg-spinners:blocks-scale', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('155', '1', '2023-07-20 09:02:29', '2023-07-20 09:14:42', 'page', '/system/quartz/list', '', '定时器管理', '1', 'svg-spinners:blocks-shuffle-2', '', '1', '154', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('157', '1', '2023-07-20 09:06:18', '2023-07-20 09:06:18', 'page', '/quartz/page', '', '定时器分页查询', '2', 'svg-spinners:blocks-wave', '', '1', '155', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('165', '1', '2023-07-20 09:42:42', '2023-07-20 09:42:51', 'saveOrUpdate', '/quartz/saveOrUpdate', '', '新增或修改定时器', '2', 'svg-spinners:bars-scale', '', '1', '155', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('166', '1', '2023-07-20 10:39:45', '2023-07-20 10:39:45', 'deletejob', '/quartz/deletejob', '', '删除定时器', '2', 'carbon:delete', '', '1', '155', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('167', '1', '2023-07-20 11:00:27', '2023-07-20 11:00:27', 'changeStatus', '/quartz/changeStatus', '', '暂停恢复定时器', '2', 'svg-spinners:bars-rotate-fade', '', '1', '155', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('176', '1', '2023-07-12 15:44:22', '2023-08-11 04:01:41', 'JobList', '/system/job/list', '', '任务类管理', '1', 'lucide:list-todo', '', '1', '154', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('177', '1', '2023-07-12 15:45:56', '2023-07-20 12:20:59', 'QuartzJob_page', '/quartzJob/page', null, '任务类管理分页查询', '2', 'fluent-mdl2:knowledge-article', '', '1', '176', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('178', '1', '2023-07-12 15:46:45', '2023-07-20 12:20:59', 'QuartzJob_saveOrUpdate', '/quartzJob/saveOrUpdate', null, '新增或者更新任务类管理', '2', 'fluent-mdl2:knowledge-article', '', '1', '176', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('179', '1', '2023-07-12 15:47:28', '2023-07-20 12:20:58', 'QuartzJob_delById', '/quartzJob/delById', null, '根据ID删除任务类管理', '2', 'fluent-mdl2:knowledge-article', '', '1', '176', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('180', '1', '2023-07-12 15:48:01', '2023-07-20 12:20:58', 'QuartzJob_getById', '/quartzJob/getById', null, '根据ID查询任务类管理', '2', 'fluent-mdl2:knowledge-article', '', '1', '176', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('181', '1', '2023-07-12 15:52:03', '2023-07-20 12:20:58', 'QuartzJob_removeBatchByIds', '/quartzJob/removeBatchByIds', null, '批量删除任务类管理', '2', 'fluent-mdl2:knowledge-article', '', '1', '176', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('182', '1', '2023-07-20 13:29:51', '2023-07-20 13:29:51', 'joblist', '/quartzJob/list', '', '查询所有定时器任务类', '2', 'jam:write-f', '', '1', '176', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('183', '0', '2023-07-20 15:50:38', '2023-07-20 15:50:42', '343243', '23432432', '', '432432', '1', 'zondicons:add-solid', '\0', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('184', '1', '2023-07-20 17:21:22', '2023-07-20 17:21:25', 'ajaxFileuPload', '/upload/ajaxFileuPload', '', '文件上传', '2', 'mdi:user-outline', '', '1', '1', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('185', '1', '2023-07-24 10:40:25', '2023-07-24 10:40:25', 'register', '/register', '', '用户注册', '2', 'gridicons:add-outline', '', '1', '2', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('200', '1', '2023-07-24 16:03:54', '2023-07-24 16:21:06', 'ExceptionLogManage', '/el', '', '日志管理', '0', 'ph:user', '', '1', '0', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('201', '1', '2023-07-24 16:03:54', '2023-07-24 16:25:27', 'ExceptionLogList', '/system/exceptionLog/list', '', '异常记录', '1', 'ph:user', '', '1', '200', null, 'admin123');
INSERT INTO `sys_menu` VALUES ('202', '1', '2023-07-24 16:03:55', '2023-07-24 16:03:55', 'ExceptionLog_page', '/exceptionLog/page', null, '日志异常记录分页查询', '2', 'ph:user', '', '1', '201', null, null);
INSERT INTO `sys_menu` VALUES ('203', '1', '2023-07-24 16:03:55', '2023-07-24 16:03:55', 'ExceptionLog_saveOrUpdate', '/exceptionLog/saveOrUpdate', null, '新增或者更新日志异常记录', '2', 'ph:user', '', '1', '201', null, null);
INSERT INTO `sys_menu` VALUES ('204', '1', '2023-07-24 16:03:55', '2023-07-24 16:03:55', 'ExceptionLog_delById', '/exceptionLog/delById', null, '根据ID删除日志异常记录', '2', 'ph:user', '', '1', '201', null, null);
INSERT INTO `sys_menu` VALUES ('205', '1', '2023-07-24 16:03:55', '2023-07-24 16:03:55', 'ExceptionLoggetById', '/exceptionLog/getById', null, '根据ID查询日志异常记录', '2', 'ph:user', '', '1', '201', null, null);
INSERT INTO `sys_menu` VALUES ('206', '1', '2023-07-24 16:03:55', '2023-07-24 16:03:55', 'ExceptionLog_removeBatchByIds', '/exceptionLog/removeBatchByIds', null, '批量删除日志异常记录', '2', 'ph:user', '', '1', '201', null, null);
INSERT INTO `sys_menu` VALUES ('207', '1', '2023-07-24 16:19:12', '2023-07-24 16:19:24', 'generateMenu', '/tableInfo/generateMenu', '', '生成菜单', '2', 'svg-spinners:blocks-wave', '\0', '1', '107', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('208', '0', '2023-07-24 16:19:38', '2023-07-24 16:22:27', 'OperationLogManage', '/elg', '', '日志操作记录管理', '0', 'ph:user', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('209', '1', '2023-07-24 16:19:38', '2023-07-24 16:25:21', 'OperationLogList', '/system/operationLog/list', '', '操作记录', '1', 'ph:user', '', '1', '200', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('210', '1', '2023-07-24 16:19:38', '2023-07-24 16:19:38', 'OperationLog_page', '/operationLog/page', null, '日志操作记录分页查询', '2', 'ph:user', '', '1', '209', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('211', '1', '2023-07-24 16:19:38', '2023-07-24 16:19:38', 'OperationLog_saveOrUpdate', '/operationLog/saveOrUpdate', null, '新增或者更新日志操作记录', '2', 'ph:user', '', '1', '209', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('212', '1', '2023-07-24 16:19:38', '2023-07-24 16:19:38', 'OperationLog_delById', '/operationLog/delById', null, '根据ID删除日志操作记录', '2', 'ph:user', '', '1', '209', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('213', '1', '2023-07-24 16:19:38', '2023-07-24 16:19:38', 'OperationLoggetById', '/operationLog/getById', null, '根据ID查询日志操作记录', '2', 'ph:user', '', '1', '209', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('214', '1', '2023-07-24 16:19:38', '2023-07-24 16:19:38', 'OperationLog_removeBatchByIds', '/operationLog/removeBatchByIds', null, '批量删除日志操作记录', '2', 'ph:user', '', '1', '209', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('215', '0', '2023-08-11 01:06:05', '2023-08-11 01:42:20', 'GoodsManage', '/goods', null, '商品表管理', '0', 'ph:user', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('216', '0', '2023-08-11 01:06:05', '2023-08-11 01:42:14', 'GoodsList', '/system/goods/list', null, '商品表列表', '1', 'ph:user', '', '1', '215', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('217', '0', '2023-08-11 01:06:05', '2023-08-11 01:42:07', 'Goods_page', '/goods/page', null, '商品表分页查询', '2', 'ph:user', '', '1', '216', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('218', '0', '2023-08-11 01:06:05', '2023-08-11 01:42:07', 'Goods_saveOrUpdate', '/goods/saveOrUpdate', null, '新增或者更新商品表', '2', 'ph:user', '', '1', '216', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('219', '0', '2023-08-11 01:06:05', '2023-08-11 01:42:07', 'Goods_delById', '/goods/delById', null, '根据ID删除商品表', '2', 'ph:user', '', '1', '216', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('220', '0', '2023-08-11 01:06:05', '2023-08-11 01:42:07', 'GoodsgetById', '/goods/getById', null, '根据ID查询商品表', '2', 'ph:user', '', '1', '216', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('221', '0', '2023-08-11 01:06:05', '2023-08-11 01:42:07', 'Goods_removeBatchByIds', '/goods/removeBatchByIds', null, '批量删除商品表', '2', 'ph:user', '', '1', '216', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('222', '0', '2023-08-11 02:02:26', '2023-08-11 05:49:08', 'GoodsManage', '/GoodsManage', '', '商品管理', '0', 'ep:goods-filled', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('223', '0', '2023-08-11 02:02:26', '2023-08-11 05:49:03', 'GoodsList', '/system/goods/list', '', '商品管理列表', '1', 'ph:user', '', '1', '222', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('224', '0', '2023-08-11 02:02:26', '2023-08-11 05:48:51', 'Goods_page', '/goods/page', null, '商品管理分页查询', '2', 'ph:user', '', '1', '223', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('225', '0', '2023-08-11 02:02:26', '2023-08-11 05:48:51', 'Goods_saveOrUpdate', '/goods/saveOrUpdate', null, '新增或者更新商品管理', '2', 'ph:user', '', '1', '223', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('226', '0', '2023-08-11 02:02:27', '2023-08-11 05:48:51', 'Goods_delById', '/goods/delById', null, '根据ID删除商品管理', '2', 'ph:user', '', '1', '223', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('227', '0', '2023-08-11 02:02:27', '2023-08-11 05:48:51', 'GoodsgetById', '/goods/getById', null, '根据ID查询商品管理', '2', 'ph:user', '', '1', '223', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('228', '0', '2023-08-11 02:02:27', '2023-08-11 05:48:51', 'Goods_removeBatchByIds', '/goods/removeBatchByIds', null, '批量删除商品管理', '2', 'ph:user', '', '1', '223', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('229', '0', '2023-08-11 02:09:46', '2023-08-11 02:11:03', 'GoodsTypeManage', '/goodsType', null, '商品类型管理', '0', 'ph:user', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('230', '0', '2023-08-11 02:09:46', '2023-08-11 03:06:38', 'GoodsTypeList', '/system/goodsType/list', '', '商品类型列表', '1', 'ph:user', '', '1', '222', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('231', '0', '2023-08-11 02:09:46', '2023-08-11 03:06:31', 'GoodsType_page', '/goodsType/page', null, '商品类型分页查询', '2', 'ph:user', '', '1', '230', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('232', '0', '2023-08-11 02:09:46', '2023-08-11 03:06:31', 'GoodsType_saveOrUpdate', '/goodsType/saveOrUpdate', null, '新增或者更新商品类型', '2', 'ph:user', '', '1', '230', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('233', '0', '2023-08-11 02:09:46', '2023-08-11 03:06:31', 'GoodsType_delById', '/goodsType/delById', null, '根据ID删除商品类型', '2', 'ph:user', '', '1', '230', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('234', '0', '2023-08-11 02:09:46', '2023-08-11 03:06:31', 'GoodsTypegetById', '/goodsType/getById', null, '根据ID查询商品类型', '2', 'ph:user', '', '1', '230', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('235', '0', '2023-08-11 02:09:46', '2023-08-11 03:06:31', 'GoodsType_removeBatchByIds', '/goodsType/removeBatchByIds', null, '批量删除商品类型', '2', 'ph:user', '', '1', '230', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('236', '0', '2023-08-11 03:11:25', '2023-08-11 03:14:18', 'GoodsTypeManage', '/goodsType', null, '商品类型管理', '0', 'ph:user', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('237', '0', '2023-08-11 03:11:25', '2023-08-11 03:14:13', 'GoodsTypeList', '/system/goodsType/list', null, '商品类型列表', '1', 'ph:user', '', '1', '236', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('238', '0', '2023-08-11 03:11:25', '2023-08-11 03:14:09', 'GoodsType_page', '/goodsType/page', null, '商品类型分页查询', '2', 'ph:user', '', '1', '237', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('239', '0', '2023-08-11 03:11:25', '2023-08-11 03:14:09', 'GoodsType_saveOrUpdate', '/goodsType/saveOrUpdate', null, '新增或者更新商品类型', '2', 'ph:user', '', '1', '237', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('240', '0', '2023-08-11 03:11:25', '2023-08-11 03:14:09', 'GoodsType_delById', '/goodsType/delById', null, '根据ID删除商品类型', '2', 'ph:user', '', '1', '237', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('241', '0', '2023-08-11 03:11:25', '2023-08-11 03:14:09', 'GoodsTypegetById', '/goodsType/getById', null, '根据ID查询商品类型', '2', 'ph:user', '', '1', '237', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('242', '0', '2023-08-11 03:11:25', '2023-08-11 03:14:09', 'GoodsType_removeBatchByIds', '/goodsType/removeBatchByIds', null, '批量删除商品类型', '2', 'ph:user', '', '1', '237', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('243', '0', '2023-08-11 03:18:20', '2023-08-11 03:27:45', 'GoodsTypeManage', '/goodsType', null, '商品类型管理', '0', 'ph:user', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('244', '0', '2023-08-11 03:18:20', '2023-08-11 05:49:03', 'GoodsTypeList', '/system/goodsType/list', '', '商品类型列表', '1', 'ph:user', '', '1', '222', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('245', '0', '2023-08-11 03:18:20', '2023-08-11 05:48:55', 'GoodsType_page', '/goodsType/page', null, '商品类型分页查询', '2', 'ph:user', '', '1', '244', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('246', '0', '2023-08-11 03:18:20', '2023-08-11 05:48:55', 'GoodsType_saveOrUpdate', '/goodsType/saveOrUpdate', null, '新增或者更新商品类型', '2', 'ph:user', '', '1', '244', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('247', '0', '2023-08-11 03:18:20', '2023-08-11 05:48:55', 'GoodsType_delById', '/goodsType/delById', null, '根据ID删除商品类型', '2', 'ph:user', '', '1', '244', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('248', '0', '2023-08-11 03:18:21', '2023-08-11 05:48:55', 'GoodsTypegetById', '/goodsType/getById', null, '根据ID查询商品类型', '2', 'ph:user', '', '1', '244', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('249', '0', '2023-08-11 03:18:21', '2023-08-11 05:48:55', 'GoodsType_removeBatchByIds', '/goodsType/removeBatchByIds', null, '批量删除商品类型', '2', 'ph:user', '', '1', '244', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('250', '0', '2023-08-11 03:44:31', '2023-08-11 03:45:30', 'GoodsAddressManage', '/GoodsAddressManage', null, '商品地址管理', '0', 'ph:user', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('251', '0', '2023-08-11 03:44:31', '2023-08-11 05:49:03', 'GoodsAddressList', '/system/goodsAddress/list', '', '商品地址列表', '1', 'ph:user', '', '1', '222', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('252', '0', '2023-08-11 03:44:31', '2023-08-11 05:49:00', 'GoodsAddress_page', '/goodsAddress/page', null, '商品地址分页查询', '2', 'ph:user', '', '1', '251', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('253', '0', '2023-08-11 03:44:31', '2023-08-11 05:49:00', 'GoodsAddress_saveOrUpdate', '/goodsAddress/saveOrUpdate', null, '新增或者更新商品地址', '2', 'ph:user', '', '1', '251', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('254', '0', '2023-08-11 03:44:31', '2023-08-11 05:49:00', 'GoodsAddress_delById', '/goodsAddress/delById', null, '根据ID删除商品地址', '2', 'ph:user', '', '1', '251', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('255', '0', '2023-08-11 03:44:31', '2023-08-11 05:49:00', 'GoodsAddressgetById', '/goodsAddress/getById', null, '根据ID查询商品地址', '2', 'ph:user', '', '1', '251', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('256', '0', '2023-08-11 03:44:31', '2023-08-11 05:49:00', 'GoodsAddress_removeBatchByIds', '/goodsAddress/removeBatchByIds', null, '批量删除商品地址', '2', 'ph:user', '', '1', '251', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('257', '0', '2023-08-11 03:48:02', '2023-08-11 03:51:54', 'testmenu', '/testmenu/list', '', '测试菜单', '0', 'svg-spinners:blocks-scale', '', '1', '0', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('258', '0', '2023-08-11 03:48:37', '2023-08-11 03:51:48', 'testmenu2', '/system/goods/list', '', '测试菜单2', '1', 'svg-spinners:blocks-wave', '', '1', '257', 'admin123', 'admin123');
INSERT INTO `sys_menu` VALUES ('259', '0', '2023-08-11 03:50:50', '2023-08-11 03:51:42', 'testapi', '/goodsAddress/page', '', '测试接口', '2', 'mdi:user-outline', '', '1', '258', 'admin123', 'admin123');

