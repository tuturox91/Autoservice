--liquibase formatted sql
--changeset <sniklz>:<create-services-id-sequence>
CREATE SEQUENCE IF NOT EXISTS public.services_id_seq INCREMENT 1 START 1 MINVALUE 1;


--rollback DROP SEQUENCE public.services_id_seq;

