--liquibase formatted sql
--changeset <sniklz>:<create-orders-id-sequence>
CREATE SEQUENCE IF NOT EXISTS public.orders_id_seq INCREMENT 1 START 1 MINVALUE 1;


--rollback DROP SEQUENCE public.orders_id_seq;

