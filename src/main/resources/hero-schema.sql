drop table if exists hero CASCADE;
create table hero (id integer generated by default as identity, name varchar(255) not null, power_level integer not null, powers varchar(255) not null, tragic_backstory varchar(255) not null, primary key (id));

