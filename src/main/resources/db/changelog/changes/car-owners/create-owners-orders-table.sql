--liquibase formatted sql
--changeset <sniklz>:<create-owners-orders-table>
CREATE TABLE IF NOT EXISTS public.owners_orders
(
    owner_id bigint NOT NULL,
    order_id bigint NOT NULL,
    CONSTRAINT owners_fk FOREIGN KEY (owner_id)
        REFERENCES public.car_owners (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT orders_fk FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.owners_orders;