CREATE TABLE IF NOT EXISTS page
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    title     VARCHAR(255) NOT NULL,
    content   TEXT,
    parent_id BIGINT
);