--liquibase formatted sql
--changeset <sniklz>:<create-car-owners-id-sequence>

CREATE SEQUENCE IF NOT EXISTS public.car_owners_id_seq INCREMENT 1 START 1 MINVALUE 1;

 --rollback DROP SEQUENCE public.car_owners_id_seq;