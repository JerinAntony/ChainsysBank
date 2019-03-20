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

CREATE TABLE TRN_CITY
(city_id NUMBER(10) CONSTRAINT trn_city_id_pk PRIMARY KEY,
city_name VARCHAR2(50) CONSTRAINT city_name_uk UNIQUE NOT NULL,
pincode NUMBER(6) CONSTRAINT pincode_uk UNIQUE NOT NULL);


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


CREATE TABLE TRN_USER_VERFCTN
(user_verfctn_id NUMBER(10) CONSTRAINT trn_user_verfctn_id_pk PRIMARY KEY,
user_id NUMBER(10),
security_code NUMBER(6) CONSTRAINT verfctn_security_code_uk UNIQUE NOT NULL,
count_status NUMBER(1) DEFAULT 0,
created_by NUMBER(10),
created_date TIMESTAMP,
modified_by NUMBER(10),
modified_date TIMESTAMP);


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
account_id NUMBER NOT NULL CONSTRAINT fk_user_trnscn_account REFERENCES TRN_ACCOUNT(account_id),
to_account NUMBER NOT NULL CONSTRAINT fk_payee_account REFERENCES TRN_PAYEE(payee_id),
amount NUMBER(10,2) NOT NULL,
trans_mode NUMBER NOT NULL CONSTRAINT fk_trans_mode REFERENCES TRN_MODE(mode_id),
trans_status VARCHAR2(10) NOT NULL CONSTRAINT fk_trans_status REFERENCES TRN_STATUS(status_id),
created_by NUMBER,
created_date TIMESTAMP,
updated_by NUMBER,
updated_date TIMESTAMP);

CREATE TABLE TRN_PAYEE
(payee_id NUMBER CONSTRAINT trn_payee_id_pk PRIMARY KEY,
user_id NUMBER CONSTRAINT fk_trn_payee_userid REFERENCES TRN_USERS(users_id),
account_holder_name VARCHAR2(30) NOT NULL,
account_no NUMBER(12) NOT NULL,
ifsc_code NUMBER NOT NULL CONSTRAINT fk_ifsc_code REFERENCES TRN_BANK_IFSC_CODE(id), 
created_by NUMBER,
created_date TIMESTAMP,
updated_by NUMBER,
updated_date TIMESTAMP);


CREATE TABLE TRN_USER_LOAN
(user_loan_id NUMBER CONSTRAINT trn_user_loan_id_pk PRIMARY KEY,
user_id NUMBER CONSTRAINT fk_user_loan_userid REFERENCES TRN_USERS(users_id),
loan_type VARCHAR2(15) NOT NULL,
loan_account_no VARCHAR2(15) NOT NULL,
amount NUMBER(10,2) NOT NULL,
outstanding_balance NUMBER(10,2) NOT NULL,
interest NUMBER(10,2) NOT NULL,
period NUMBER(10,2) NOT NULL,
monthly_pay NUMBER(10,2) NOT NULL,
created_by NUMBER,
created_date TIMESTAMP,
updated_by NUMBER,
updated_date TIMESTAMP);
