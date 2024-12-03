CREATE SEQUENCE public.pc_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.pc_id_seq
    OWNER TO postgres;
	
-- Table: public.page_control

DROP TABLE public.page_control;

CREATE TABLE public.page_control
(
    pc_id integer NOT NULL DEFAULT nextval('pc_id_seq'::regclass),
    project_id integer,
    page_id integer,
    position_id integer,
    control_id integer,
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