----------------------------
--用户表
----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
      `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
      `login_enable` varchar(255) DEFAULT NULL COMMENT '是否禁用登录',
      `login_error` int(11) DEFAULT NULL COMMENT '登录错误次数记录',
      `login_last` datetime DEFAULT NULL COMMENT '最后一次登录时间',
      `user_avatar` varchar(255) DEFAULT NULL COMMENT '头像',
      `user_desc` varchar(255) DEFAULT NULL COMMENT '说明',
      `user_display_name` varchar(255) DEFAULT NULL COMMENT '显示名称',
      `user_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
      `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
      `user_pass` varchar(255) DEFAULT NULL COMMENT '密码',
      `user_site` varchar(255) DEFAULT NULL COMMENT '个人主页',
      `status` int(1) DEFAULT NULL COMMENT '0 正常 1 禁用 2 已删除',
      `reate_time` datetime DEFAULT NULL COMMENT '注册时间',
      PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='user表';

----------------------------
--角色表
----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role` varchar(255) DEFAULT NULL COMMENT '角色名称：admin，author，subscriber',
  `description` varchar(255) DEFAULT NULL COMMENT '角色名称：admin，author，subscriber',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='role表';

----------------------------
--权限
----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限：user:list，user:add等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='permission表';

----------------------------
--用户角色
----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(20) DEFAULT NULL COMMENT '用户Id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user_role表';

----------------------------
--角色权限
----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色Id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='role_permission表';



