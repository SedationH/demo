CREATE TABLE t_bank
(
    id      INT PRIMARY KEY AUTO_INCREMENT COMMENT '账号主键',
    account VARCHAR(20) NOT NULL UNIQUE COMMENT '账号',
    money   INT UNSIGNED COMMENT '金额,不能为负值'
);

INSERT INTO t_bank(account, money)
VALUES ('ergouzi', 1000),
       ('lvdandan', 1000);


select * from t_bank;