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
    `description`
) values (
    1,
    'HEALTH',
    ''
), (
    2,
    'TENNIS',
    ''
), (
    3,
    'SOCCER',
    ''
),  (
    4,
    'PILATES',
    ''
), (
    5,
    'CROSS_FIT',
    ''
), (
    6,
    'BASKETBALL',
    ''
);