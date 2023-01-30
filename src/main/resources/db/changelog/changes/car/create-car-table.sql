--liquibase formatted sql
--changeset <sniklz>:<create-car-table>
CREATE TABLE IF NOT EXISTS public.cars
(
    id bigint NOT NULL,
    mark character varying(255) COLLATE pg_catalog."default",
    model character varying(255) COLLATE pg_catalog."default",
    "number" character varying(255) COLLATE pg_catalog."default",
    production_year bigint,
    car_owner_id bigint,
    CONSTRAINT cars_pkey PRIMARY KEY (id),
    CONSTRAINT fkrd9flvvxb566qdh2o210qxvkt FOREIGN KEY (car_owner_id)
        REFERENCES public.car_owners (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.cars;