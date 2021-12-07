-- Creating Database Of Juke-Box

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

