--liquibase formatted sql
--changeset <sniklz>:<create-owners-orders-table>
CREATE TABLE IF NOT EXISTS public.car_owners_orders
(
    car_owner_id bigint NOT NULL,
    orders_id bigint NOT NULL,
    CONSTRAINT fk6y1bha5n50fw4xbb3ya4xmd75 FOREIGN KEY (car_owner_id)
        REFERENCES public.car_owners (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkf92qllhtgpfjvp856tche7ow6 FOREIGN KEY (orders_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.owners_orders;