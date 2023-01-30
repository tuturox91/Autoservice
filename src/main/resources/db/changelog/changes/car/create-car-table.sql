--liquibase formatted sql
--changeset <sniklz>:<create-car-table>
CREATE TABLE IF NOT EXISTS public.cars
(
    id bigint NOT NULL,
    mark character varying(255) NOT NULL,
    model character varying(255) NOT NULL,
    "number" character varying(255) NOT NULL,
    production_year bigint NOT NULL,
    car_owner_id bigint NOT NULL,
    CONSTRAINT cars_pkey PRIMARY KEY (id),
    CONSTRAINT cars_owner_id_fk FOREIGN KEY (car_owner_id)
        REFERENCES public.car_owners (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.cars;