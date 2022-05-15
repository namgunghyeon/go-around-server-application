insert ignore into account(
    `id`,
    `email`,
    `username`,
    `password`,
    `created_at`,
    `updated_at`
) values (
    1,
    'test@gmail.com',
    'test@gmail.com',
    '$2a$10$C31uAQBZuNRkHMQ.0m4iLeND/ry0/FdJPCeyxVS0BhwgzJOgVebBe', -- xptmxm#1
    now(),
    now()
);

insert ignore into category(
    `id`,
    `code`,
    `display_name`,
    `description`
) values (
    1,
    'HEALTH',
    '헬스',
    ''
), (
    2,
    'TENNIS',
    '테니스',
    ''
), (
    3,
    'SOCCER',
    '축구',
    ''
),  (
    4,
    'PILATES',
    '필라테스',
    ''
), (
    5,
    'CROSS_FIT',
    '크로스핏',
    ''
), (
    6,
    'BASKETBALL',
    '농구',
    ''
);