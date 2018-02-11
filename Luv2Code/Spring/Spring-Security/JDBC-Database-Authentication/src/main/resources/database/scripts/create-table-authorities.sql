CREATE TABLE public.authorities
(
  username CHARACTER VARYING(50) NOT NULL,
  authority CHARACTER VARYING(50) NOT NULL,

  CONSTRAINT authorities_idx_1 UNIQUE (username, authority),

  CONSTRAINT username FOREIGN KEY (username)
  REFERENCES public.users (username)
);