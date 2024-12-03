CREATE SEQUENCE public.sys_data_collection_sdc_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.sys_data_collection_sdc_id_seq
    OWNER TO postgres;
	
-- Table: public.system_data_collection

--DROP TABLE public.system_data_collection;

CREATE TABLE public.system_data_collection
(
	sdc_id integer NOT NULL DEFAULT nextval('sys_data_collection_sdc_id_seq'::regclass),
    "project_Id" integer,
    "Page_Id" integer,
    "Position_Id" integer,
    "Control_Id" integer,
    "Value_Id" integer,
    image_value bytea,
    text_value text COLLATE pg_catalog."default",
    number_value numeric,
    "Date_Value" date,
    "Boolean_Value" boolean,
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

ALTER TABLE public.system_data_collection
    OWNER to postgres;