-- CREATE TABLE IF NOT EXISTS page
-- (
--     id        BIGINT AUTO_INCREMENT PRIMARY KEY,
--     title     VARCHAR(255) NOT NULL,
--     content   TEXT,
--     parent_id BIGINT
-- );
drop table if exists page;

create table page
(
    id        bigint primary key auto_increment,
    parent_id bigint,
    title     varchar(50) not null,
    content   TEXT,
    foreign key (parent_id) references page(id)
    ON DELETE CASCADE
);