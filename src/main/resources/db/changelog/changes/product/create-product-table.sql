--liquibase formatted sql
--changeset <sniklz>:<create-prodcut-table>
CREATE TABLE IF NOT EXISTS public.products
(
    id bigint NOT NULL,
    cost numeric(38,2),
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT products_pkey PRIMARY KEY (id)
)

--rollback DROP TABLE  public.products;