CREATE DATABASE bd_cliente
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


-- Table: public.cliente

-- DROP TABLE IF EXISTS public.cliente;

CREATE TABLE IF NOT EXISTS public.cliente
(
    id bigint NOT NULL DEFAULT nextval('cliente_id_seq'::regclass),
    apellido_materno character varying(255) COLLATE pg_catalog."default",
    apellido_paterno character varying(255) COLLATE pg_catalog."default",
    correo character varying(255) COLLATE pg_catalog."default",
    direccion character varying(255) COLLATE pg_catalog."default",
    fecha_nacimiento date,
    sexo character varying(255) COLLATE pg_catalog."default",
    nombres character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cliente_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cliente
    OWNER to postgres;
	
	INSERT INTO public.cliente
(apellido_materno, apellido_paterno, correo, direccion, fecha_nacimiento, sexo, nombres)
VALUES('Alvarado', ' Peralta', 'mail@mail.com', 'av. siempreviva 847', '2020-10-10', 'Femenino', 'Juan Alva');
INSERT INTO public.cliente
(apellido_materno, apellido_paterno, correo, direccion, fecha_nacimiento, sexo, nombres)
VALUES('Torres', 'Alvarez', 'sdfsd@nmakj.com', 'fasdhfkajsdhf', '2023-10-16', 'Masculino', 'Jhon');
INSERT INTO public.cliente
(apellido_materno, apellido_paterno, correo, direccion, fecha_nacimiento, sexo, nombres)
VALUES('Vasquez', 'Toro', 'mail@mail.com', 'lima', '2023-10-17', 'Masculino', 'Diana');
