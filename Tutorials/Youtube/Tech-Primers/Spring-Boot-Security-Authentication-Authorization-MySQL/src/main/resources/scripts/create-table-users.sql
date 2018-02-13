CREATE TABLE users
(
  user_id integer NOT NULL,
  active integer,
  email character varying(255),
  last_name character varying(255),
  name character varying(255),
  password character varying(255),
  CONSTRAINT user_pkey PRIMARY KEY (user_id)
)