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

CREATE TABLE IF NOT EXISTS category
(
    `id`                        BIGINT NOT NULL auto_increment,
    `code`                      VARCHAR (100) NOT NULL comment '카테고리 이름',
    `display_name`              VARCHAR (100) NOT NULL comment '화면 표시 이름',
    `description`               VARCHAR (100) NOT NULL comment '설명',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );

CREATE TABLE IF NOT EXISTS account_favorite_category
(
    `account_id`                BIGINT NOT NULL comment '사용자 아이디',
    `category_id`               BIGINT NOT NULL comment '카테고리 아이디',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( account_id,  category_id)
    );

CREATE TABLE IF NOT EXISTS feed
(
    `id`                        BIGINT NOT NULL auto_increment,
    `category_id`               BIGINT NOT NULL comment '카테고리 아이디',
    `account_id`                BIGINT NOT NULL comment '사용자 아이디',
    `title`                     VARCHAR (100) NOT NULL comment '제목',
    `content`                   VARCHAR (100) NOT NULL comment '내용',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
);

CREATE TABLE IF NOT EXISTS feed_comment
(
    `id`                        BIGINT NOT NULL auto_increment,
    `feed_id`                   BIGINT NOT NULL comment '피드 아이디',
    `feed_parent_id`            BIGINT NOT NULL comment '상위 피드',
    `content`                   VARCHAR (100) NOT NULL comment '내용',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );

CREATE TABLE IF NOT EXISTS feed_attachment
(
    `id`                        BIGINT NOT NULL auto_increment,
    `feed_id`                   BIGINT NOT NULL comment '피드 아이디',
    `url`                       VARCHAR (100) NOT NULL comment 'url',
    `type`                      VARCHAR (100) NOT NULL comment '첨부파일 타입',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );


-- feed_survey 지우고 feed_survey_item 하고 feed_id하고 연결?
CREATE TABLE IF NOT EXISTS feed_survey
(
    `id`                        BIGINT NOT NULL auto_increment,
    `feed_id`                   BIGINT NOT NULL comment '피드 아이디',
    `title`                     VARCHAR (100) NOT NULL comment '제목',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );

CREATE TABLE IF NOT EXISTS feed_survey_item
(
    `id`                        BIGINT NOT NULL auto_increment,
    `feed_survey_id`            BIGINT NOT NULL comment '설문조사 아이디',
    `item_title`                VARCHAR (100) NOT NULL comment '설문조사 항목',
    `count`                     VARCHAR (100) NOT NULL comment '카운트',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );

CREATE TABLE IF NOT EXISTS feed_survey_item_response_history
(
    `id`                        BIGINT NOT NULL auto_increment,
    `feed_id`                   BIGINT NOT NULL comment '설문조사 아이디',
    `feed_survey_item_id`       BIGINT NOT NULL comment '설문조사 아이디',
    `account_id`                VARCHAR (100) NOT NULL comment '설문조사 항목',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );

CREATE TABLE IF NOT EXISTS feed_tag
(
    `id`                        BIGINT NOT NULL auto_increment,
    `feed_id`                   BIGINT NOT NULL comment '카테고리 아이디',
    `name`                      VARCHAR (100) NOT NULL comment '이름',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );



-- 사용하지 않음
CREATE TABLE IF NOT EXISTS topic
(
    `id`                        BIGINT NOT NULL auto_increment,
    `category_id`               BIGINT NOT NULL comment '카테고리 아이디',
    `code`                      VARCHAR (100) NOT NULL comment '토픽 이름',
    `description`               VARCHAR (100) NOT NULL comment '설명',
    `created_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`                TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY ( id )
    );

