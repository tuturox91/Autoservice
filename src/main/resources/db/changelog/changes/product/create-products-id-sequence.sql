--liquibase formatted sql
--changeset <sniklz>:<create-product-id-sequence>
CREATE SEQUENCE IF NOT EXISTS public.products_id_seq INCREMENT 1 START 1 MINVALUE 1;


--rollback DROP SEQUENCE public.products_id_seq;

