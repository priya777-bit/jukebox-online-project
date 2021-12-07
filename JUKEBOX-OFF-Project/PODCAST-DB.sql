-- Creating Databse For Podcast ..

create database podcast;
use podcast;

-- Creating Table For Type For Podcast ..

create table podcasttype
(
	podcasttype_id int primary key auto_increment,
    podcasttype_name char(50)
);

-- Show Podcast Type ..

select * from podcasttype;

-- Inserting In Podcast Type ..

insert into podcasttype (podcasttype_name) values('fiction');

-- Creating Table For Narrator ..

create table narrator
(
	narrator_id int primary key auto_increment,
    narrator_name char(50)
);

-- Show Narrator Table ..

select * from narrator;

-- Inserting In Narrator ..

insert into narrator (narrator_name) values('dnyaneshwar maharaj');

-- Creating Table For Celebrity ..

create table celebrity
(
	celebrity_id int primary key auto_increment,
    celebrity_name char(50)
);

-- Show Celebrity Table ..

select * from celebrity;

-- Inserting In Celebrity ..

insert into celebrity (celebrity_name) values ('a.p.j.adbul kalam');

-- Creating Table For Podcast ..

create table podcast
(
	podcast_id int primary key auto_increment,
    podcast_name char(50),
    podcasttype_id int,
    narrator_id int,
    celebrity_id int,
    foreign key(podcasttype_id)references podcasttype(podcasttype_id),
    foreign key(narrator_id)references narrator(narrator_id),
    foreign key(celebrity_id)references celebrity(celebrity_id)
);

-- Show Podcast Table ..

select * from podcast;

-- Inserting In Podcast ..

insert into podcast (podcast_name,podcasttype_id,narrator_id,celebrity_id) 
values ('spooked2',1,4,3);

-- Creating Table For Podcast Episode ..

create table podcastepisode
(
	podcast_episode_id int primary key auto_increment,
    episode_name char(50),
    episode_number int,
    episode_duration char(30),
    podcast_id int,
    foreign key(podcast_id)references podcast(podcast_id)
);

-- Inserting In Podcast Episode ..

insert into podcastepisode (episode_name,episode_number,episode_duration,podcast_id)
 values ('chunk 1',2,'2:12:20',12);

--  Creating View For Getting All Values ..

create view type_nar_celeb_pod_podepi as
select t.podcasttype_name,n.narrator_name,c.celebrity_name
,p.podcast_name,pe.episode_name,pe.episode_number,pe.episode_duration 
from podcasttype t join podcast p on t.podcasttype_id=p.podcasttype_id 
join narrator n on n.narrator_id=p.narrator_id
join celebrity c on c.celebrity_id=p.celebrity_id 
join podcastepisode pe on pe.podcast_id=p.podcast_id;

-- Show View ..

select * from type_nar_celeb_pod_podepi;
