-- Creator:       MySQL Workbench 6.3.9/ExportSQLite Plugin 0.1.0
-- Author:        MrJustreborn
-- Caption:       New Model
-- Project:       Name of the project
-- Changed:       2017-05-10 15:19
-- Created:       2017-05-10 15:19
PRAGMA foreign_keys = OFF;

-- Schema: mydb
ATTACH "mydb.sdb" AS "mydb";
BEGIN;
CREATE TABLE "mydb"."survey"(
  "idsurvey" INTEGER PRIMARY KEY,
  "id" VARCHAR(45),
  "title" VARCHAR(255),
  "answer" VARCHAR(255)
);
COMMIT;
