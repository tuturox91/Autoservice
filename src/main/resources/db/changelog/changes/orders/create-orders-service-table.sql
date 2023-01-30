--liquibase formatted sql
--changeset <sniklz>:<create-orders-service-table>
CREATE TABLE IF NOT EXISTS public.orders_services
(
    order_id bigint NOT NULL,
    services_id bigint NOT NULL,
    CONSTRAINT fkq863ndc65lt9lgj0jg1h8ravg FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fktf3befn48p2sqt2k9qbs1cso3 FOREIGN KEY (services_id)
        REFERENCES public.services (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.orders_services;