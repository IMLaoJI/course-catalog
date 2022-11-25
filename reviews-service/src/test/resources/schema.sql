create table if not exists reviews
(
    id               integer generated by default as identity
        constraint pk_reviews
            primary key,
    text             varchar(3000),
    author           varchar(255),
    created_at       timestamp,
    last_modified_at timestamp,
    course_id        integer
);

