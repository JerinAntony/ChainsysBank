CREATE TABLE TRN_USERS
(users_id NUMBER(10) CONSTRAINT trn_users_id_pk PRIMARY KEY,
login_id VARCHAR2(20) CONSTRAINT login_id_uk UNIQUE NOT NULL,
first_name VARCHAR2(50) NOT NULL,
middle_name VARCHAR2(50),
sur_name VARCHAR2(50),
phone_number NUMBER(10)NOT NULL,
email VARCHAR2(60) CONSTRAINT email_uk UNIQUE NOT NULL,
password VARCHAR2(30) NOT NULL,
operational_flag CHAR(1) CONSTRAINT operational_flag_check CHECK(operational_flag IN('A','I')),
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

--------------------------------------

CREATE TABLE TRN_CITY
(city_id NUMBER(10) CONSTRAINT trn_city_id_pk PRIMARY KEY,
city_name VARCHAR2(50) CONSTRAINT city_name_uk UNIQUE NOT NULL,
pincode NUMBER(6) CONSTRAINT pincode_uk UNIQUE NOT NULL);

-------------------------------------------

CREATE TABLE TRN_PRMT_ADDRS
(prmt_addrs_id NUMBER(10) CONSTRAINT trn_prmt_addrs_id_pk PRIMARY KEY,
user_id NUMBER(10),
address_one VARCHAR2(100) NOT NULL,
address_two VARCHAR2(100),
city_id NUMBER(10),
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

-------------------------------------------

CREATE TABLE TRN_CURT_ADDRS
(curt_addrs_id NUMBER(10) CONSTRAINT trn_curt_addrs_id_pk PRIMARY KEY,
user_id NUMBER(10),
address_one VARCHAR2(100) NOT NULL,
address_two VARCHAR2(100),
city_id NUMBER(10),
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

-----------------------------------------------

CREATE TABLE TRN_USER_VERFCTN
(user_verfctn_id NUMBER(10) CONSTRAINT trn_user_verfctn_id_pk PRIMARY KEY,
user_id NUMBER(10),
security_code NUMBER(6) CONSTRAINT verfctn_security_code_uk UNIQUE NOT NULL,
count_status NUMBER(1) DEFAULT 0,
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

-------------------------------------------------

CREATE TABLE TRN_ACCOUNT
(account_id NUMBER(10) CONSTRAINT trn_account_id_pk PRIMARY KEY,
user_id NUMBER(10),
account_no NUMBER(15) NOT NULL,
account_type VARCHAR2(20) NOT NULL,
opening_date DATE NOT NULL,
balance NUMBER(10,2) DEFAULT 0,
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

-------------------------------------------------

Alter table TRN_ACCOUNT modify account_no varchar2(50);

CREATE TABLE TRN_PROFILE
(profile_id NUMBER(10) CONSTRAINT trn_profile_id_pk PRIMARY KEY,
user_id NUMBER(10),
gender CHAR(1) NOT NULL,
date_of_birth DATE NOT NULL,
occupation VARCHAR2(50) NOT NULL,
aadhar_no NUMBER(16) NOT NULL,
pancard VARCHAR2(20) NOT NULL,
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

----------------------------------------

CREATE TABLE TRN_USER_TRNSCN
(user_trnscn_id NUMBER CONSTRAINT trn_user_trnscn_id_pk PRIMARY KEY,
remark VARCHAR2(100),
account_id NUMBER(10),
to_account NUMBER(10),
amount NUMBER(10,2) NOT NULL,
trans_mode VARCHAR2(50),
trans_status VARCHAR2(50),
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

-------------------------------------------------

CREATE TABLE TRN_PAYEE
(payee_id NUMBER(10) CONSTRAINT trn_payee_id_pk PRIMARY KEY,
user_id NUMBER(10),
account_holder_name VARCHAR2(50) NOT NULL,
account_no varchar2(50) NOT NULL,
ifsc_code NUMBER(10), 
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);

-----------------------------------------
