--liquibase formatted sql
--changeset <sniklz>:<create-services-table>
CREATE TABLE IF NOT EXISTS public.services
(
    id bigint NOT NULL,
    cost numeric(38,2),
    status character varying(255),
    master_id bigint,
    CONSTRAINT services_pkey PRIMARY KEY (id),
    CONSTRAINT master_fk FOREIGN KEY (master_id)
        REFERENCES public.masters (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback DROP TABLE public.services;