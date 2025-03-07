-- Table: public.telefoneuser

-- DROP TABLE public.telefoneuser;

CREATE TABLE public.telefoneuser
(
  id bigint NOT NULL DEFAULT nextval('user_telefone_seq'::regclass),
  numero character varying(255) NOT NULL,
  tipo character varying(255) NOT NULL,
  usuariopessoa bigint NOT NULL,
  CONSTRAINT telefone_id PRIMARY KEY (id),
  CONSTRAINT telefoneuser_usuariopessoa_fkey FOREIGN KEY (usuariopessoa)
      REFERENCES public.userposjava (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.telefoneuser
  OWNER TO postgres;


-- Table: public.userposjava

-- DROP TABLE public.userposjava;

CREATE TABLE public.userposjava
(
  id bigint NOT NULL DEFAULT nextval('usersequence'::regclass),
  nome character varying(255),
  email character varying(255),
  CONSTRAINT user_pk PRIMARY KEY (id),
  CONSTRAINT userposjava_id_key UNIQUE (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.userposjava
  OWNER TO postgres;


select * from telefoneuser as fone
inner join userposjava as userp
on fone.usuariopessoa = userp.id where userp.id = 3;