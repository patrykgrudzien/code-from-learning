CREATE TABLE user_role
(
  user_id integer NOT NULL,
  role_id integer NOT NULL,

  -- primary key
  CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id),

  -- foreign key #1
  CONSTRAINT fk_role_id FOREIGN KEY (role_id)
      REFERENCES role (role_id),

  -- foreign key #2
  CONSTRAINT fk_user_id FOREIGN KEY (user_id)
      REFERENCES spring_security_tech_primes_mysql."user" (user_id),

  -- unique key
  CONSTRAINT uk_role_id UNIQUE (role_id)
)