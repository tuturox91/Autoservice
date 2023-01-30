--liquibase formatted sql
--changeset <sniklz>:<create-masters-completed-orders-table>

CREATE TABLE IF NOT EXISTS public.masters_completed_orders
(
    master_id bigint NOT NULL,
    completed_orders_id bigint NOT NULL,
    CONSTRAINT completed_orders_fk FOREIGN KEY (completed_orders_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT masters_fk FOREIGN KEY (master_id)
        REFERENCES public.masters (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP public.masters_completed_orders;

