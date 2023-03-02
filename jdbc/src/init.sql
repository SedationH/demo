# 初始化开始
CREATE DATABASE atguigu;

USE atguigu;

CREATE TABLE t_user
(
    id       INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户主键',
    account  VARCHAR(20) NOT NULL UNIQUE COMMENT '账号',
    PASSWORD VARCHAR(64) NOT NULL COMMENT '密码',
    nickname VARCHAR(20) NOT NULL COMMENT '昵称'
);

INSERT INTO t_user(account, PASSWORD, nickname)
VALUES ('root', '123456', '经理'),
       ('admin', '666666', '管理员');

# 初始化结束

SELECT id, account, PASSWORD, nickname FROM t_user;

select * from t_user;

select * from t_user
    where account = 'root' and PASSWORD = '123456';

