--liquibase formatted sql
--changeset <sniklz>:<create-car-owners-cars-table>

CREATE TABLE IF NOT EXISTS public.car_owners_cars
(
    car_owner_id bigint NOT NULL,
    cars_id bigint NOT NULL,
    CONSTRAINT fklp4yqp054wns0jfi8m4k2kiog FOREIGN KEY (cars_id)
        REFERENCES public.cars (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpaquvhq4q7xn7ha9qw9gb07y7 FOREIGN KEY (car_owner_id)
        REFERENCES public.car_owners (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.car_owners_cars;