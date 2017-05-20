-- Creator:       MySQL Workbench 6.3.9/ExportSQLite Plugin 0.1.0
-- Author:        MrJustreborn
-- Caption:       New Model
-- Project:       Name of the project
-- Changed:       2017-05-10 12:11
-- Created:       2017-05-10 12:05
PRAGMA foreign_keys = OFF;

-- Schema: mydb
ATTACH "mydb.sdb" AS "mydb";
BEGIN;
CREATE TABLE "mydb"."survey"(
  "idsurvey" INTEGER PRIMARY KEY NOT NULL,
  "name" VARCHAR(45)
);
CREATE TABLE "mydb"."question"(
  "idquestion" INTEGER NOT NULL,
  "survey_idsurvey" INTEGER NOT NULL,
  "question" VARCHAR(255),
  PRIMARY KEY("idquestion","survey_idsurvey"),
  CONSTRAINT "fk_question_survey"
    FOREIGN KEY("survey_idsurvey")
    REFERENCES "survey"("idsurvey")
);
CREATE INDEX "mydb"."question.fk_question_survey_idx" ON "question" ("survey_idsurvey");
CREATE TABLE "mydb"."answer"(
  "idanswers" INTEGER NOT NULL,
  "question_idquestion" INTEGER NOT NULL,
  "question_survey_idsurvey" INTEGER NOT NULL,
  "answer" VARCHAR(255),
  PRIMARY KEY("idanswers","question_idquestion","question_survey_idsurvey"),
  CONSTRAINT "question_idquestion_UNIQUE"
    UNIQUE("question_idquestion"),
  CONSTRAINT "question_survey_idsurvey_UNIQUE"
    UNIQUE("question_survey_idsurvey"),
  CONSTRAINT "fk_answers_question1"
    FOREIGN KEY("question_idquestion","question_survey_idsurvey")
    REFERENCES "question"("idquestion","survey_idsurvey")
);
CREATE INDEX "mydb"."answer.fk_answers_question1_idx" ON "answer" ("question_idquestion","question_survey_idsurvey");
COMMIT;
