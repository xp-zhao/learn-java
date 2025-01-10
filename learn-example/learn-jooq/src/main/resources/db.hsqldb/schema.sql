DROP TABLE account IF EXISTS;

CREATE TABLE account
(
    id        INTEGER IDENTITY PRIMARY KEY,
    username  VARCHAR(50)
);