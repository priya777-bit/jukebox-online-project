-- Creating Database Of Juke-Box -- TASK 1 Songs ..

create database jukebox;
use jukebox;

-- Creating Table Genre ..

create table genre
(
	genre_id int primary key auto_increment,
    genre_name char(50)
);
select * from genre;
-- Creating Table Album ..

create table album
(
	album_id int primary key auto_increment,
    album_name char(50),
    album_release_date date default (current_date())

);
select * from album;
-- Creating Artist Table ..

create table artist
(
	artist_id int primary key auto_increment,
    artist_name char(50),
    artist_gender char(20)
);
select * from artist;
-- Creating Table Song ..

create table song
(
	song_id int primary key auto_increment,
    song_name char(100),
    song_duration char(20),
    genre_id int,
    album_id int,
    artist_id int,
    foreign key(genre_id) references genre(genre_id),
    foreign key(album_id) references album(album_id),
    foreign key(artist_id) references artist(artist_id)
);

insert into song(song_name,song_duration,genre_id,album_id,artist_id) 
values(labb par aye geet suhane	9:00	9	9	72);

alter table song auto_increment = 1000;

-- Show Song Table ..

select * from song;
 
-- Creating View For All Tables ..

create view gen_alb_art_song as
select g.genre_name , al.album_name , al.album_release_date
, art.artist_name , art.artist_gender , s.song_name , s.song_duration from genre as g
, album as al , artist as art , song as s;

create view gen_alb_art_song as 
select ge.genre_name,al.album_name,al.album_release_date,art.artist_name,art.artist_gender
,sn.song_name,sn.song_duration from genre ge join song sn on ge.genre_id=sn.genre_id
join artist art on sn.artist_id=art.artist_id join album al on sn.album_id=al.album_id;

-- Show View ..

select * from gen_alb_art_song;

select * from artist;
select * from album;
select * from genre;
select * from song;

delete from artist where artist_name is null;

drop view gen_alb_art_song;

-- Podcast Start .. TASK 2 ..

-- Creating Table For Type For Podcast ..

create table podcasttype
(
	podcasttype_id int primary key auto_increment,
    podcasttype_name char(50)
);

-- Show Podcast Type ..

select * from podcasttype;

-- Inserting In Podcast Type ..

insert into podcasttype (podcasttype_name) values('hybrid');

-- Creating Table For Narrator ..

create table narrator
(
	narrator_id int primary key auto_increment,
    narrator_name char(50)
);

-- Show Narrator Table ..

select * from narrator;

-- Inserting In Narrator ..

insert into narrator (narrator_name) values('vikas adam');

-- Creating Table For Celebrity ..

create table celebrity
(
	celebrity_id int primary key auto_increment,
    celebrity_name char(50)
);

-- Show Celebrity Table ..

select * from celebrity;

-- Inserting In Celebrity ..

insert into celebrity (celebrity_name) values ('mukesh ambani');

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

insert into podcast (podcast_name,podcasttype_id,celebrity_id,narrator_id) 
values ('how to fail',2,4,3);

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

alter table podcastepisode
add  episode_release_date date default(current_date());

-- Show PodCast Episode ..

select * from podcastepisode;

-- Inserting In Podcast Episode ..

insert into podcastepisode (episode_name,episode_number,episode_duration,podcast_id,episode_release_date)
 values ('day dreamer',15,'45:00',10,'2020-01-31');

--  Creating View For Getting All Values ..

create view type_nar_celeb_pod_podepi as
select t.podcasttype_name,n.narrator_name,c.celebrity_name
,p.podcast_name,pe.episode_name,pe.episode_number,pe.episode_duration,pe.episode_release_date
from podcasttype t join podcast p on t.podcasttype_id=p.podcasttype_id 
join narrator n on n.narrator_id=p.narrator_id
join celebrity c on c.celebrity_id=p.celebrity_id 
join podcastepisode pe on pe.podcast_id=p.podcast_id;

-- Show View ..

select * from type_nar_celeb_pod_podepi;

select * from podcast where podcast_name = 'this american life';

drop view type_nar_celeb_pod_podepi;

-- PLAYLIST START .. TASK 3 ..

-- Creating Playlist Table ..

create table playlist
(
	playlist_id int primary key  auto_increment,
    playlist_name char(50)
);

-- Inserting In Playlist ..

insert into playlist(playlist_name) values('song1');

-- Show Playlist Table ..

select * from playlist;

-- Inserting Into PlayList Values ..



-- Creating Playlist Content Table ..

create table playlistcontent
(
	content_id int primary key auto_increment,
    content_duration char(30),
    playlist_id int,
    track_id int,
    foreign key(playlist_id)references playlist(playlist_id)
);

-- Drop Table PlayListContent ..

drop table playlistcontent;

-- Drop Key Constraint ..

alter table playlistcontent
drop foreign key song_id;

-- Inserting Into PlayListContent ..

insert into playlistcontent (content_duration,playlist_id,track_id) values ('01:20:22',1,10);
insert into playlistcontent (content_duration,playlist_id,track_id) values ('01:20:22',1,25);

select * from song;
select * from podcastepisode;

describe playlistcontent;

-- Show PlaylistContent Table ..

select * from playlistcontent;

-- Creating View For Playlist ..

create view p_play as
select p.playlist_name , pl.content_duration ,
s.song_name , s.song_duration , pe.episode_name , pe.episode_duration
from playlist p join playlistcontent pl on p.playlist_id=pl.playlist_id
left outer join song s on pl.track_id=s.song_id
left outer join podcastepisode pe on pl.track_id=pe.podcast_episode_id;

select * from p_play;

drop view p_play;