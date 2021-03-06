

/* Create Sequences */

CREATE SEQUENCE SEQ_NEW_TABLE_NO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_POST_NO INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE MEMBERS
(
	ID nvarchar2(15) NOT NULL,
	PassWord nvarchar2(20) NOT NULL,
	Name nvarchar2(10) NOT NULL,
	Gender nvarchar2(10) NOT NULL,
	Tel nvarchar2(15) NOT NULL,
	LifeaAgePlan nvarchar2(15) NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE POST
(
	NO number NOT NULL,
	ID nvarchar2(15) NOT NULL,
	TITLE nvarchar2(50) NOT NULL,
	POSTDATE date DEFAULT SYSDATE NOT NULL,
	CONTENT nvarchar2(1000) NOT NULL,
	DOWNCOUNT NUMBER,
	PRIMARY KEY (NO)
);



/* Create Foreign Keys */

ALTER TABLE POST
	ADD FOREIGN KEY (ID)
	REFERENCES MEMBERS (ID)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_NEW_TABLE_NO BEFORE INSERT ON POST
FOR EACH ROW
BEGIN
	SELECT SEQ_NEW_TABLE_NO.nextval
	INTO :new.NO
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_POST_NO BEFORE INSERT ON POST
FOR EACH ROW
BEGIN
	SELECT SEQ_POST_NO.nextval
	INTO :new.NO
	FROM dual;
END;

/




