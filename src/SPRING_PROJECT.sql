CREATE TABLE MEMBERS(
    MID VARCHAR(20),
    MPW VARCHAR(20),
    MNAME NVARCHAR2(5),
    MBIRTH DATE
);

ALTER TABLE MEMBERS
ADD CONSTRAINT PK_MID PRIMARY KEY(MID);
ALTER TABLE MEMBERS
MODIFY MPW NOT NULL;


CREate table members(
    mid nvarchar2(20), -- 아이디(pk)
    mpw nvarchar2(20) not null, -- 비밀번호
    mname nvarchar2(5) not null, -- 이름
    mbirth date, -- 생년월일
    maddr nvarchar2(100), -- 주소
    memail nvarchar2(50), -- 이메일
    mprofile nvarchar2(200), --프로필 이미지
    mstate nchar(1), -- 회원상태('0' 탈퇴, '1' 정상)
    constraint pk_mid primary key(mid)
);

select * from members;
delete from members;
commit;

create table boards(
    bno number, -- 글 번호
    btitle nvarchar2 (50) not null,
    bwriter nvarchar2(20), -- 글 작성자
    bcontent nvarchar2(2000), -- 글 내용
    bdate date,                 --글 작성일(sysdate) 
    bhits number,               --글 조회수(초기값 0)
    bfilename nvarchar2(200),
    bstate nchar(1),
    
    constraint pk_bno primary key(bno),
    constraint fk_bwriter foreign key(bwriter) references members(mid)
);

desc boards;
select * from boards;

create table comments(
    cno number, 
    cwriter nvarchar2(20) not null,
    ccontent nvarchar2(500) not null,
    chits number,
    cdate date,
    c_bno number,
    cstate nchar(1),
    constraint pk_cno primary key(cno),
    constraint fk_cBno foreign key(c_bno) references boards(bno)
);
desc comments;
select * from comments;
commit;

SELECT NVL(MAX(CNO) , 0) + 1 FROM COMMENTS;
select * from members;

-- 게시글 추천 정보 테이블
create table boardlike(
    lmid nvarchar2(20) not null,
    lbno number not null,
    lstate nchar(1) not null, --상태('0': 추천, '1':비추천)
constraint fk_lmid foreign key(lmid) references members(mid),
constraint fk_lbno foreign key(lbno) references boards(bno),
constraint pk_lmid_lbno primary key(lmid, lbno)
);

desc boardlike;

select lstate, count(*) as count from boardlike where lbno = 1 group by lstate;

insert into boardlike values ('test02', 1, '1');
insert into boardlike values ('admin', 1, '0');
commit;
delete from boardlike;

