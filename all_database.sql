-- Table: public."Recursive_Constants"

-- DROP TABLE public."Recursive_Constants";

CREATE TABLE public."Recursive_Constants"
(
    recursive_id bigint NOT NULL DEFAULT nextval('recursive_constants_id_seq'::regclass),
    index integer,
    key character varying(250) COLLATE pg_catalog."default",
    possible_combination character varying(2000) COLLATE pg_catalog."default",
    record_active_ind character(1) COLLATE pg_catalog."default",
    CONSTRAINT "Recursive_Constants_pkey" PRIMARY KEY (recursive_id)
        USING INDEX TABLESPACE mytablespace
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Recursive_Constants"
    OWNER to postgres;

-- Index: key_id

-- DROP INDEX public.key_id;

CREATE INDEX key_id
    ON public."Recursive_Constants" USING btree
    (key COLLATE pg_catalog."default")
    TABLESPACE mytablespace;
	
-- Table: public.control_name

-- DROP TABLE public.control_name;

CREATE TABLE public.control_name
(
    control_id integer NOT NULL,
    control_name character varying COLLATE pg_catalog."default",
    CONSTRAINT control_name_pkey PRIMARY KEY (control_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.control_name
    OWNER to postgres;	
	
-- Table: public.page_control

-- DROP TABLE public.page_control;

CREATE TABLE public.page_control
(
    pc_id integer NOT NULL DEFAULT nextval('pc_id_seq'::regclass),
    project_id integer,
    page_id integer,
    position_id numeric,
    control_id integer,
    group_id integer,
    name_id character varying COLLATE pg_catalog."default",
    default_value character varying COLLATE pg_catalog."default",
    data_type character varying COLLATE pg_catalog."default",
    field_help character varying COLLATE pg_catalog."default",
    add_user character varying COLLATE pg_catalog."default",
    add_time timestamp with time zone,
    update_user character varying COLLATE pg_catalog."default",
    update_time timestamp with time zone,
    verify_user character varying COLLATE pg_catalog."default",
    verify_time time with time zone,
    active boolean
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.page_control
    OWNER to postgres;	
	
-- Table: public.profile

-- DROP TABLE public.profile;

CREATE TABLE public.profile
(
    profile_id integer NOT NULL DEFAULT nextval('profile_profile_id_seq'::regclass),
    profile_name character varying COLLATE pg_catalog."default" NOT NULL,
    profile_description character varying COLLATE pg_catalog."default",
    created time with time zone,
    active "char",
    profile_type character varying COLLATE pg_catalog."default",
    CONSTRAINT profile_pkey PRIMARY KEY (profile_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.profile
    OWNER to postgres;

-- Table: public.project

-- DROP TABLE public.project;

CREATE TABLE public.project
(
    project_id integer NOT NULL DEFAULT nextval('project_project_id_seq'::regclass),
    project_name character varying COLLATE pg_catalog."default",
    project_type character varying COLLATE pg_catalog."default",
    project_description character varying COLLATE pg_catalog."default",
    active "char",
    CONSTRAINT project_pkey PRIMARY KEY (project_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.project
    OWNER to postgres;


-- Table: public.project_data_setup

-- DROP TABLE public.project_data_setup;

CREATE TABLE public.project_data_setup
(
    pds_id integer NOT NULL DEFAULT nextval('project_data_setup_pds_id_seq'::regclass),
    project_id integer,
    value_id_from integer,
    value_id_to integer,
    sent boolean,
    received boolean,
    sent_time time with time zone,
    received_time time with time zone,
    CONSTRAINT project_data_setup_pkey PRIMARY KEY (pds_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.project_data_setup
    OWNER to postgres;

-- Table: public.project_profile_map

-- DROP TABLE public.project_profile_map;

CREATE TABLE public.project_profile_map
(
    ppm_id integer NOT NULL DEFAULT nextval('project_profile_map_ppm_id_seq'::regclass),
    project_id integer,
    profile_id integer,
    active "char",
    CONSTRAINT project_profile_map_pkey PRIMARY KEY (ppm_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.project_profile_map
    OWNER to postgres;


-- Table: public.pure_tamil_names

-- DROP TABLE public.pure_tamil_names;

CREATE TABLE public.pure_tamil_names
(
    ptn_id integer NOT NULL DEFAULT nextval('pure_tamil_names_ptn_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    sex character(5) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pure_tamil_names_pkey PRIMARY KEY (ptn_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pure_tamil_names
    OWNER to postgres;


-- Table: public.system_data_collection

-- DROP TABLE public.system_data_collection;

CREATE TABLE public.system_data_collection
(
    sdc_id integer NOT NULL DEFAULT nextval('sys_data_collection_sdc_id_seq'::regclass),
    project_id integer,
    page_id integer,
    position_id integer,
    control_id integer,
    value_id integer,
    image_value bytea,
    text_value text COLLATE pg_catalog."default",
    number_value numeric,
    date_value date,
    boolean_value boolean,
    add_user character varying COLLATE pg_catalog."default",
    add_time timestamp with time zone,
    update_user character varying COLLATE pg_catalog."default",
    update_time timestamp with time zone,
    verify_user character varying COLLATE pg_catalog."default",
    verify_time time with time zone,
    active boolean,
    image_name character varying COLLATE pg_catalog."default",
    image_length integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.system_data_collection
    OWNER to postgres;


-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
    user_id integer NOT NULL DEFAULT nextval('user_user_id_seq'::regclass),
    user_name character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default",
    last_login time with time zone,
    retry numeric,
    last_client_sync time with time zone,
    last_server_sync time with time zone,
    active character varying COLLATE pg_catalog."default",
    email_id character varying COLLATE pg_catalog."default",
    phone_no character varying COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (user_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;

-- Table: public.user_data_collection

-- DROP TABLE public.user_data_collection;

CREATE TABLE public.user_data_collection
(
    udc_id integer NOT NULL DEFAULT nextval('user_data_collection_udc_id_seq'::regclass),
    project_id integer,
    page_id integer,
    position_id numeric,
    control_id integer,
    value_id integer,
    image_value bytea,
    text_value text COLLATE pg_catalog."default",
    number_value numeric,
    date_value date,
    boolean_value boolean,
    add_user character varying COLLATE pg_catalog."default",
    add_time timestamp with time zone,
    update_user character varying COLLATE pg_catalog."default",
    update_time timestamp with time zone,
    verify_user character varying COLLATE pg_catalog."default",
    verify_time time with time zone,
    active boolean
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_data_collection
    OWNER to postgres;


-- Table: public.user_profile_map

-- DROP TABLE public.user_profile_map;

CREATE TABLE public.user_profile_map
(
    upm_id integer NOT NULL DEFAULT nextval('user_profile_map_upm_id_seq'::regclass),
    user_id integer,
    profile_id integer,
    active "char",
    CONSTRAINT user_profile_map_pkey PRIMARY KEY (upm_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_profile_map
    OWNER to postgres;	