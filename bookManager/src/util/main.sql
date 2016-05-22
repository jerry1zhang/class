create table reader(
	rid int(10) primary key,
	accounts varchar(10),
	pwd varchar(10),
	name varchar(10),
	IDcard varchar(10),
	LastLoginTime varchar(10),
	rkid int(10)
);
create table book(
	bid int(10) primary key,
	name varchar(10),
	bDate date,
	bPress varchar(10),
	bAuthor varchar(10),
	bValue int(10),
	bookKindsNo int(10)
);
create table bookKinds(
	bookKindsNo int(10) primary key,
	bookKindsName varchar(10)
);
create table bookLibHistory(
	bookLibHistoryNo int(10) primary key,
	bno int(10),
	rid int(10),
	hdate date
);
create table Manager(
	mid int(10) primary key,
	mname varchar(10),
	mpwd varchar(10),
	powerLevel int(2)
);