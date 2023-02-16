--DROP TABLE IF EXISTS messages;
--drop constraint if exists uniq_messages;

--create table messages (
--    id SERIAL PRIMARY KEY,
--    name varchar(255),
--    surname varchar(255),
--    text varchar(255)
--);

--create unique index uniq_messages on messages (name, surname, messages);