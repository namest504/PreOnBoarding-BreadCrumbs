INSERT INTO page (id, title, content, parent_id)
VALUES
    (1, '홈', '홈 페이지입니다.', NULL),
    (2, '소개', '소개 페이지입니다.', NULL),
    (3, '연락처', '연락처 페이지입니다.', NULL),
    (4, '팀', '소개 페이지의 팀 섹션입니다.', 1),
    (5, '목적', '소개 페이지의 목적 섹션입니다.', 1),
    (6, '이메일', '연락처 페이지의 이메일 섹션입니다.', 3),
    (7,'전화번호','전화번호 페이지.',3),
    (8, '휴대폰 기종', '휴대폰 기종 페이지입니다.',7),
    (9, '멤버', '멤버 페이지입니다.',4),
    (10, '이메일 종류', '이메일 종류 페이지입니다.',6),
    (11, '멤버 프로필', '멤버 프로필 페이지입니다.',9),
    (12, '주제', '목적 페이지의 주제입니다.',5);