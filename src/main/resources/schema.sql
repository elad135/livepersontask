DROP TABLE IF EXISTS missed_intents;

CREATE TABLE missed_intents (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(250) NOT NULL,
  sub_category VARCHAR(250) NOT NULL,
  text VARCHAR(250) DEFAULT NULL
);

CREATE TABLE api_keys (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  api_key VARCHAR(250) NOT NULL
);

INSERT INTO api_keys (api_key) VALUES ('1111');