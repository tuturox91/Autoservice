--liquibase formatted sql
--changeset <sniklz>:<create-orders-table>
CREATE TABLE IF NOT EXISTS public.orders
(
    id bigint NOT NULL,
    car_id bigint,
    accept_order_time timestamp(6) without time zone,
    complete_time timestamp(6) without time zone,
    description character varying(255),
    order_status character varying(255),
    result_cost numeric(38,2),
    CONSTRAINT orders_pkey PRIMARY KEY (id)
)

--rollback DROP TABLE public.orders;