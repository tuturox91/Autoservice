--liquibase formatted sql
--changeset <sniklz>:<create-masters-completed-orders-table>

CREATE TABLE IF NOT EXISTS public.masters_completed_orders
(
    master_id bigint NOT NULL,
    completed_orders_id bigint NOT NULL,
    CONSTRAINT fk4icsu52vm1l2scqj0sroq3lcy FOREIGN KEY (completed_orders_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkjxp2x9of5tc4smolrabx78lwf FOREIGN KEY (master_id)
        REFERENCES public.masters (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP public.masters_completed_orders;

