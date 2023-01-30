--liquibase formatted sql
--changeset <sniklz>:<create-owners-cars-table>
CREATE TABLE IF NOT EXISTS public.owners_cars
(
    owner_id bigint NOT NULL,
    car_id bigint NOT NULL,
    CONSTRAINT car_fk FOREIGN KEY (car_id)
        REFERENCES public.cars (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT owners_fk FOREIGN KEY (owner_id)
        REFERENCES public.car_owners (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.owners_cars;