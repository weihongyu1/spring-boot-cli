CREATE
DATABASE db_tbl_spring_boot_cli;
USE
db_tbl_spring_boot_cli;

CREATE TABLE `tbl_user`
(
    `id`          int unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username`    varchar(255) NOT NULL COMMENT '用户名',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_username` (`username`) USING BTREE COMMENT '用户名唯一索引'
) DEFAULT CHARSET=utf8mb4 COMMENT '用户信息表';