drop table IF EXISTS page;

create table IF NOT EXISTS page
(
    id        bigint primary key auto_increment,
    parent_id bigint,
    title     varchar(50) not null,
    content   TEXT,
        foreign key (parent_id) references page(id)
        ON DELETE CASCADE
);