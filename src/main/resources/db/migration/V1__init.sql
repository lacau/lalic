CREATE TABLE public.product (
	id int8 NOT NULL,
	id_xtech varchar(45) NOT NULL,
	reference varchar(45) NOT NULL,
	name varchar(45) NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY (id)
)
WITH (OIDS=FALSE);
CREATE UNIQUE INDEX product_id_xtech_unique ON public.product (id_xtech);
CREATE SEQUENCE IF NOT EXISTS seq_product;