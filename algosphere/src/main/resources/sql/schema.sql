--Sequences
CREATE SEQUENCE "UserSeq";
--Tables
CREATE TABLE IF NOT EXISTS "User" (
    "id" BIGINT NOT NULL AUTO_INCREMENT,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    PRIMARY KEY ("id")
);