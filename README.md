# KAIKEI

## master <-- Branch(Commit)

PPT참조

## master --> Branch (Rebase) 하는법

Spring --> Window --> Show view --> other --> git Repositories 추가

git Repositories --> TeamSpring_src --> Branches --> Local --> (자신의 Branch ) --> Rebase
  --> Remote Tracking --> origin/master --> Rebase
# SQL

CREATE TABLE account
(
	company_cd           VARCHAR(10) NOT NULL,
	acc_cd               VARCHAR(4) NOT NULL,
	title                VARCHAR(255) NOT NULL,
	ent_id               VARCHAR(30) NOT NULL,
	ent_date             DATE NOT NULL,
	ent_prog             VARCHAR(255) NOT NULL,
	mod_id               VARCHAR(30) NOT NULL,
	mod_date             DATE NOT NULL,
	mod_prog             VARCHAR(255) NOT NULL
);

ALTER TABLE account
ADD CONSTRAINT XPKaccount PRIMARY KEY (company_cd,acc_cd);

CREATE TABLE childcd
(
	c_cd                 VARCHAR(6) NOT NULL,
	p_cd                 VARCHAR(3) NOT NULL,
	title                VARCHAR(255) NOT NULL,
	avail                VARCHAR(1) NOT NULL,
	group1               VARCHAR(255) NULL,
	group2               VARCHAR(255) NULL,
	group3               VARCHAR(255) NULL
);

ALTER TABLE childcd
ADD CONSTRAINT XPKchildcode PRIMARY KEY (c_cd,p_cd);

CREATE TABLE company
(
	company_cd           VARCHAR(10) NOT NULL,
	state_cd             VARCHAR(6) NOT NULL,
	title                VARCHAR(255) NOT NULL,
	reg_cd               VARCHAR(20) NULL,
	fax                  VARCHAR(20) NULL,
	phone                VARCHAR(20) NULL,
	domain               VARCHAR(255) NULL,
	bank_title           VARCHAR(255) NULL,
	bank_acc             VARCHAR(255) NULL,
	ent_id               VARCHAR(30) NOT NULL,
	ent_date             DATE NOT NULL,
	ent_prog             VARCHAR(255) NOT NULL,
	mod_id               VARCHAR(30) NOT NULL,
	mod_date             DATE NOT NULL,
	mod_prog             VARCHAR(255) NOT NULL
);

ALTER TABLE company
ADD CONSTRAINT XPKcompany PRIMARY KEY (company_cd);

CREATE TABLE customer
(
	company_cd           VARCHAR(10) NOT NULL,
	cus_cd               VARCHAR(5) NOT NULL,
	title                VARCHAR(255) NOT NULL,
	reg_cd               VARCHAR(20) NULL,
	domain               VARCHAR(255) NULL,
	fax                  VARCHAR(20) NULL,
	ceo_name             VARCHAR(20) NULL,
	ceo_phone            VARCHAR(20) NULL,
	ceo_email            VARCHAR(255) NULL,
	worker_name          VARCHAR(20) NULL,
	worker_phone         VARCHAR(20) NULL,
	worker_email         VARCHAR(255) NULL,
	memo                 VARCHAR(255) NULL,
	ent_id               VARCHAR(30) NOT NULL,
	entdate              DATE NOT NULL,
	ent_prog             VARCHAR(255) NOT NULL,
	mod_id               VARCHAR(30) NOT NULL,
	mod_date             DATE NOT NULL,
	mod_prog             VARCHAR(255) NOT NULL
);

ALTER TABLE customer
ADD CONSTRAINT XPKcustomer PRIMARY KEY (company_cd,cus_cd);

CREATE TABLE parentcd
(
	p_cd                 VARCHAR(3) NOT NULL,
	title                VARCHAR(255) NOT NULL,
	avail                VARCHAR(1) NOT NULL,
	group1               VARCHAR(255) NULL,
	group2               VARCHAR(255) NULL,
	group3               VARCHAR(255) NULL
);

ALTER TABLE parentcd
ADD CONSTRAINT XPKparentcode PRIMARY KEY (p_cd);

CREATE TABLE statements
(
	company_cd           VARCHAR(10) NOT NULL,
	seq                  INTEGER NOT NULL,
	account_cd           VARCHAR(4) NOT NULL,
	customer_cd          VARCHAR(5) NOT NULL,
	date                 VARCHAR(8) NOT NULL,
	classify             VARCHAR(20) NOT NULL,
	debtor               INTEGER NOT NULL,
	creditor             VARCHAR(20) NULL,
	abs                  VARCHAR(255) NULL,
	ent_id               VARCHAR(30) NOT NULL,
	ent_date             DATE NOT NULL,
	ent_prog             VARCHAR(255) NOT NULL,
	mod_id               VARCHAR(30) NOT NULL,
	mod_date             DATE NOT NULL,
	mod_prog             VARCHAR(255) NOT NULL
);

ALTER TABLE statements
ADD CONSTRAINT XPKstatement PRIMARY KEY (company_cd,seq);

CREATE TABLE users
(
	id                   VARCHAR(30) NOT NULL,
	password             BINARY(30) NOT NULL,
	company_cd           VARCHAR(10) NULL,
	posit_cd             VARCHAR(6) NOT NULL,
	auth_cd              VARCHAR(6) NOT NULL,
	state_cd             VARCHAR(6) NOT NULL,
	name                 VARCHAR(20) NOT NULL,
	email                VARCHAR(255) NOT NULL,
	phone                VARCHAR(30) NULL,
	ent_id               VARCHAR(50) NOT NULL,
	ent_date             DATE NOT NULL,
	ent_prog             VARCHAR(255) NOT NULL,
	mod_id               VARCHAR(30) NOT NULL,
	mod_date             DATE NOT NULL,
	mod_prog             VARCHAR(255) NOT NULL
);

ALTER TABLE users
ADD CONSTRAINT XPKuser PRIMARY KEY (id);
