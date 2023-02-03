--liquibase formatted sql
--changeset <sniklz>:<create-car-owners-table>
CREATE TABLE IF NOT EXISTS public.car_owners
(
    id bigint NOT NULL,
    CONSTRAINT car_owners_pkey PRIMARY KEY (id)
);

--rollback DROP TABLE public.car_owners;