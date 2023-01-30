--liquibase formatted sql
--changeset <sniklz>:<create-car-id-sequence>

CREATE SEQUENCE IF NOT EXISTS public.cars_id_seq INCREMENT 1 START 1 MINVALUE 1;

--rollback DROP TABLE public.cars_id_seq;