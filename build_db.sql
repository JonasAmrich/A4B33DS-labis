USE DATABASE public;

DROP TABLE IF EXISTS is1_customer CASCADE;
DROP TABLE IF EXISTS is1_device_feature CASCADE;
DROP TABLE IF EXISTS is1_device CASCADE;
DROP TABLE IF EXISTS is1_experiment CASCADE;
DROP TABLE IF EXISTS is1_feature_experiment CASCADE;
DROP TABLE IF EXISTS is1_feature CASCADE;
DROP TABLE IF EXISTS is1_form_structure CASCADE;
DROP TABLE IF EXISTS is1_form_type CASCADE;
DROP TABLE IF EXISTS is1_results CASCADE;
DROP TABLE IF EXISTS is1_room CASCADE;
DROP TABLE IF EXISTS is1_trial CASCADE;
DROP TABLE IF EXISTS is1_victim CASCADE;
DROP TABLE IF EXISTS is1_form_structure_type CASCADE;

CREATE SEQUENCE seq_is1_customer;
CREATE TABLE is1_customer (
	id_cust integer NOT NULL DEFAULT nextval('seq_is1_customer'),
	last_name text NOT NULL,
	first_name text,
	email text,
	phone text
);

CREATE TABLE is1_device_feature (
	id_dev integer NOT NULL,
	id_feat integer NOT NULL
);

CREATE SEQUENCE seq_is1_device;
CREATE TABLE is1_device (
	id_dev integer NOT NULL DEFAULT nextval('seq_is1_device'),
	title text NOT NULL,
	description text
);

CREATE SEQUENCE seq_is1_experiment;
CREATE TABLE is1_experiment (
	id_exp integer NOT NULL DEFAULT nextval('seq_is1_experiment'),
	title text NOT NULL,
	description text,
	budget integer  NOT NULL DEFAULT 0,
	status_code varchar(50),
	id_cust integer NOT NULL,
	id_ft integer NOT NULL
);

CREATE TABLE is1_experiment_status(
	status_code varchar(50) NOT NULL
);

CREATE TABLE is1_feature_experiment (
	id_exp integer NOT NULL,
	id_feat integer NOT NULL
);

CREATE SEQUENCE seq_is1_feature;
CREATE TABLE is1_feature (
	id_feat integer NOT NULL DEFAULT nextval('seq_is1_feature'),
	title text NOT NULL
);

CREATE SEQUENCE seq_is1_form_structure;
CREATE TABLE is1_form_structure (
	id_fs integer NOT NULL DEFAULT nextval('seq_is1_form_structure'),
	id_ft integer NOT NULL,
	name text,
  id_fstype text NOT NULL
);

CREATE SEQUENCE seq_is1_form_type;
CREATE TABLE is1_form_type (
	id_ft integer NOT NULL DEFAULT nextval('seq_is1_form_type'),
	name text
);

CREATE TABLE is1_form_structure_type ( 
	id_fstype text NOT NULL,
	description text
);

CREATE TABLE is1_results (
	id_trial integer NOT NULL,
	id_fs integer NOT NULL,
	res_value text
);

CREATE SEQUENCE seq_is1_room;
CREATE TABLE is1_room (
	id_room integer NOT NULL DEFAULT nextval('seq_is1_room'),
	name text,
	code varchar(50)
);

CREATE SEQUENCE seq_is1_trial;
CREATE TABLE is1_trial (
	id_trial integer NOT NULL DEFAULT nextval('seq_is1_trial'),
	timestamp_from timestamp,
	timestamp_to timestamp,
	cost integer DEFAULT 0 NOT NULL,
  id_exp integer NOT NULL,
	id_dev integer,
	id_room integer,
	id_vic integer NOT NULL
);

CREATE SEQUENCE seq_is1_victim;
CREATE TABLE is1_victim (
	id_vic integer NOT NULL DEFAULT nextval('seq_is1_victim'),
	last_name text NOT NULL,
	first_name text,
	email text,
	phone text,
	birth_date timestamp,
	credits integer DEFAULT 0 NOT NULL
);


/* UNIQUE */
ALTER TABLE is1_customer ADD CONSTRAINT UQ_is1_customer_id_cust UNIQUE (id_cust);
ALTER TABLE is1_device ADD CONSTRAINT UQ_is1_device_id_dev UNIQUE (id_dev);
ALTER TABLE is1_device ADD CONSTRAINT UQ_is1_device_title UNIQUE (title);
ALTER TABLE is1_experiment ADD CONSTRAINT UQ_is1_experiment_id_exp UNIQUE (id_exp);
ALTER TABLE is1_experiment ADD CONSTRAINT UQ_is1_experiment_title UNIQUE (title);
ALTER TABLE is1_experiment_status ADD CONSTRAINT UQ_is1_experiment_status_code UNIQUE (status_code);
ALTER TABLE is1_feature ADD CONSTRAINT UQ_is1_feature_id_feat UNIQUE (id_feat);
ALTER TABLE is1_feature ADD CONSTRAINT UQ_is1_feature_title UNIQUE (title);
ALTER TABLE is1_form_structure ADD CONSTRAINT UQ_is1_form_structure_id_fs UNIQUE (id_fs);
ALTER TABLE is1_form_type ADD CONSTRAINT UQ_is1_form_type_id_ft UNIQUE (id_ft);
ALTER TABLE is1_form_structure_type ADD CONSTRAINT UQ_is1_form_structure_type_id_fstype UNIQUE (id_fstype);
ALTER TABLE is1_room ADD CONSTRAINT UQ_is1_room_id_room UNIQUE (id_room);
ALTER TABLE is1_trial ADD CONSTRAINT UQ_is1_trial_id_trial UNIQUE (id_trial);
ALTER TABLE is1_victim ADD CONSTRAINT UQ_is1_victim_id_vic UNIQUE (id_vic);

/* PRIMARY KEYS*/
ALTER TABLE is1_customer ADD CONSTRAINT PK_is1_customer PRIMARY KEY (id_cust);
ALTER TABLE is1_device_feature ADD CONSTRAINT PK_is1_device_feature PRIMARY KEY (id_dev, id_feat);
ALTER TABLE is1_device ADD CONSTRAINT PK_is1_device PRIMARY KEY (id_dev);
ALTER TABLE is1_experiment ADD CONSTRAINT PK_is1_experiment PRIMARY KEY (id_exp);
ALTER TABLE is1_experiment_status ADD CONSTRAINT PK_is1_experiment_status PRIMARY KEY (status_code);
ALTER TABLE is1_feature_experiment ADD CONSTRAINT PK_is1_feature_experiment PRIMARY KEY (id_exp, id_feat);
ALTER TABLE is1_feature ADD CONSTRAINT PK_is1_features PRIMARY KEY (id_feat);
ALTER TABLE is1_form_structure ADD CONSTRAINT PK_is1_form_structure PRIMARY KEY (id_fs);
ALTER TABLE is1_form_type ADD CONSTRAINT PK_is1_form_type PRIMARY KEY (id_ft);
ALTER TABLE is1_form_structure_type ADD CONSTRAINT PK_fsctructype PRIMARY KEY (id_fstype);
ALTER TABLE is1_results ADD CONSTRAINT PK_is1_results PRIMARY KEY (id_trial, id_fs);
ALTER TABLE is1_room ADD CONSTRAINT PK_is1_room PRIMARY KEY (id_room);
ALTER TABLE is1_trial ADD CONSTRAINT PK_is1_trial PRIMARY KEY (id_trial);
ALTER TABLE is1_victim ADD CONSTRAINT PK_is1_victim PRIMARY KEY (id_vic);

/* FOREIGN KEYS */
ALTER TABLE is1_device_feature ADD CONSTRAINT FK_is1_device_feature_device FOREIGN KEY (id_dev) REFERENCES is1_device (id_dev);
ALTER TABLE is1_device_feature ADD CONSTRAINT FK_is1_device_feature_feature FOREIGN KEY (id_feat) REFERENCES is1_feature (id_feat);
ALTER TABLE is1_experiment ADD CONSTRAINT FK_is1_experiment_customer FOREIGN KEY (id_cust) REFERENCES is1_customer (id_cust) ON DELETE CASCADE;  /* test of on delete cascade */
ALTER TABLE is1_experiment ADD CONSTRAINT FK_is1_experiment_form_type FOREIGN KEY (id_ft) REFERENCES is1_form_type (id_ft);
ALTER TABLE is1_experiment ADD CONSTRAINT FK_is1_experiment_status FOREIGN KEY (status_code) REFERENCES is1_experiment_status (status_code);
ALTER TABLE is1_feature_experiment ADD CONSTRAINT FK_is1_feature_experiment_experiment FOREIGN KEY (id_exp) REFERENCES is1_experiment (id_exp);
ALTER TABLE is1_feature_experiment ADD CONSTRAINT FK_is1_feature_experiment_feature FOREIGN KEY (id_feat) REFERENCES is1_feature (id_feat);
ALTER TABLE is1_form_structure ADD CONSTRAINT FK_is1_form_structure_form_type FOREIGN KEY (id_ft) REFERENCES is1_form_type (id_ft);
ALTER TABLE is1_form_structure ADD CONSTRAINT FK_is1_form_structure_form_structure_type FOREIGN KEY (id_fstype) REFERENCES is1_form_structure_type (id_fstype);
ALTER TABLE is1_results ADD CONSTRAINT FK_is1_results_form_structure FOREIGN KEY (id_fs) REFERENCES is1_form_structure (id_fs);
ALTER TABLE is1_results ADD CONSTRAINT FK_is1_results_trial FOREIGN KEY (id_trial) REFERENCES is1_trial (id_trial);
ALTER TABLE is1_trial ADD CONSTRAINT FK_is1_trial_experiment FOREIGN KEY (id_exp) REFERENCES is1_experiment (id_exp);
ALTER TABLE is1_trial ADD CONSTRAINT FK_is1_trial_device FOREIGN KEY (id_dev) REFERENCES is1_device (id_dev);
ALTER TABLE is1_trial ADD CONSTRAINT FK_is1_trial_room FOREIGN KEY (id_room) REFERENCES is1_room (id_room);
ALTER TABLE is1_trial ADD CONSTRAINT FK_is1_trial_victim FOREIGN KEY (id_vic) REFERENCES is1_victim (id_vic);
