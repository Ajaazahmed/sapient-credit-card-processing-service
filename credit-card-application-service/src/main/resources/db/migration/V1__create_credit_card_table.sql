CREATE TABLE credit_card (
  card_name varchar(255) NOT NULL,
  card_number bigint NOT NULL,
  card_balance double default 0 NOT NULL,
  card_limit integer NOT NULL
);
