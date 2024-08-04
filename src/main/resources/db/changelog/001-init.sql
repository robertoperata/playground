create table if not exists book (
    pubdate   date,
    id        bigint not null primary key,
    size      bigint,
    authors   varchar(255),
    publisher varchar(255),
    title     varchar(255)
);

alter table book
    owner to play;

