--liquibase formatted sql
--changeset <sniklz>:<create-master-id-sequence>
CREATE SEQUENCE IF NOT EXISTS public.masters_id_seq INCREMENT 1 START 1 MINVALUE 1;


--rollback DROP SEQUENCE public.masters_id_seq;

