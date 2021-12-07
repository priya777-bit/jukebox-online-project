-- Creating Databse For Podcast ..

create database podcast;
use podcast;

-- Creating Table For Type For Podcast ..

create table podcasttype
(
	podcasttype_id int primary key auto_increment,
    podcasttype_name char(50)
);

-- Creating Table For Narrator ..

create table narrator
(
	narrator_id int primary key auto_increment,
    narrator_name char(50)
);

-- Creating Table For Celebrity ..

create table celebrity
(
	celebrity_id int primary key auto_increment,
    celebrity_name char(50)
);

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

-- Creating Table For Podcast Episode ..

create table podcastepisode
(
	podcast_episode_id int primary key auto_increment,
    episode_name char(50),
    episode_number int,
    episode_duration date default (current_date()),
    podcast_id int,
    foreign key(podcast_id)references podcast(podcast_id)
);

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