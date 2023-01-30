--liquibase formatted sql
--changeset <sniklz>:<create-orders-product-table>
CREATE TABLE IF NOT EXISTS public.orders_products
(
    order_id bigint NOT NULL,
    products_id bigint NOT NULL,
    CONSTRAINT orders_fk FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT products_fk FOREIGN KEY (products_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.orders_products;