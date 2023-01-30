--liquibase formatted sql
--changeset <sniklz>:<create-masters-table>
CREATE TABLE IF NOT EXISTS public.masters
(
    id bigint NOT NULL,
    full_name character varying(255),
    CONSTRAINT masters_pkey PRIMARY KEY (id)
)

--rollback DROP TABLE public.masters;