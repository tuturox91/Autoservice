--liquibase formatted sql
--changeset <sniklz>:<create-orders-table>
CREATE TABLE IF NOT EXISTS public.orders
(
    id bigint NOT NULL,
    accept_order_time timestamp(6) without time zone,
    complete_time timestamp(6) without time zone,
    description character varying(255) COLLATE pg_catalog."default",
    order_status character varying(255) COLLATE pg_catalog."default",
    result_cost numeric(38,2),
    car_id bigint,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT fkd2p23ixwrrt395glgi9nnbj23 FOREIGN KEY (car_id)
        REFERENCES public.cars (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.orders;