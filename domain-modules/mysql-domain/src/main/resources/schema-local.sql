CREATE TABLE IF NOT EXISTS account
(
    `id`                        BIGINT NOT NULL auto_increment,
    `email`                     VARCHAR (100) NOT NULL comment '이메일',
    `username`                  VARCHAR (100) NOT NULL comment '사용자 이름',
    `password`                  VARCHAR (100) NOT NULL comment '비밀번호',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
);