-- http://www.randomtext.me/#/lorem/p-1/5-100
-- https://www.mockaroo.com/

create database if not exists social_media_db;

use social_media_db;

drop table if exists likes;
drop table if exists comments;
drop table if exists posts;
drop table if exists users;

create table users (
	id int(11) not null auto_increment,
	username char(20) not null,
	email char(40) not null,
	password char(30) not null,
	primary key (id)
);

create table posts (
	id int(11) not null auto_increment,
	poster_id int(11) not null,
	post_text char(250) not null,
	date_posted datetime not null,
	date_edited datetime not null,
	primary key (id),
	foreign key (poster_id) references users(id)
);

create table comments (
	id int(11) not null auto_increment,
	post_id int(11) not null,
	commenter_id int(11) not null,
	comment_text char(250) not null,
	date_commented datetime not null,
	date_edited datetime not null,
	primary key (id),
	foreign key (post_id) references posts(id),
	foreign key (commenter_id) references users(id)
);

create table likes (
	id int(11) not null auto_increment,
	user_id int(11) not null,
	post_or_comment_id int(11) not null,
	post_or_comment char(50) not null,
	date_liked datetime not null,
	primary key (id),
	foreign key (user_id) references users(id),
	foreign key (post_or_comment_id) references posts(id),
	foreign key (post_or_comment_id) references comments(id)
);

-- Insert sample data into users
insert into users (username, email, password) values ('apilgrim0', 'ascartifield0@state.gov', 'Goiwrrac');
insert into users (username, email, password) values ('llodden1', 'ivillage1@bloglines.com', 'G7abnvD');
insert into users (username, email, password) values ('cthumann2', 'pchardin2@netvibes.com', 'yNHDNO7OyAjB');
insert into users (username, email, password) values ('nwren3', 'rpedlow3@rakuten.co.jp', 'OoLeLh8vBm');
insert into users (username, email, password) values ('zalliberton4', 'wpensom4@soup.io', 'dgDCo9l');
insert into users (username, email, password) values ('fschorah5', 'blernihan5@go.com', 'dobmVy4');
insert into users (username, email, password) values ('iespinoza6', 'pbendik6@delicious.com', 'uBH13W');
insert into users (username, email, password) values ('dlinney7', 'dtupper7@bing.com', 'zlGSKK');
insert into users (username, email, password) values ('cmcguane8', 'sshouler8@w3.org', 'OXpcwr');
insert into users (username, email, password) values ('vmaccaull9', 'locaine9@quantcast.com', 'crbb22HNYyVk');

-- Insert sample data into posts
insert into posts (poster_id, post_text, date_posted, date_edited) value (1, 'Lorem ipsum rutrum congue commodo quis mollis mattis scelerisque mi consectetur adipiscing faucibus accumsan facilisis conubia, ultricies lectus at molestie semper', '2020-02-01 06:06', '2020-02-01 06:06');
insert into posts (poster_id, post_text, date_posted, date_edited) value (1, 'Lorem ipsum rutrum congue commodo quis mollis mattis scelerisque mi consectetur adipiscing faucibus accumsan facilisis conubia test test test', '2019-01-11', '2021-02-01 07:06');
insert into posts (poster_id, post_text, date_posted, date_edited) value (2, 'Lorem ipsum rutrum congue commodo consectetur adipiscing faucibus accumsan facilisis conubia, ultricies lectus at molestie semper', '2019-12-01 08:06', '2020-02-22 16:00');
insert into posts (poster_id, post_text, date_posted, date_edited) value (2, 'Lorem ipsum', '2011-01-01 12:23', '2020-02-02 07:11');
insert into posts (poster_id, post_text, date_posted, date_edited) value (2, 'consectetur adipiscing faucibus accumsan facilisis conubia', '2015-02-01 17:06', '2018-02-01 16:07');
insert into posts (poster_id, post_text, date_posted, date_edited) value (2, 'Lorem ipsum rutrum congue commodo quis mollis mattis scelerisque mi consectetur adipiscing faucibus accumsan facilisis conubia, ultricies lectus at molestie semper', '2021-02-01 09:06', '2021-03-01 16:01');
insert into posts (poster_id, post_text, date_posted, date_edited) value (3, 'volutpat commodo fermentum et torquent netus nisl erat etiam ultrices nibh, eget at hendrerit quisque inceptos himenaeos gravida duis porta, nostra elit justo laoreet sed eget netus dui leo inceptos nulla eleifend arcu', '2020-01-31 06:06', '2020-02-01 00:00');
insert into posts (poster_id, post_text, date_posted, date_edited) value (4, 'feugiat interdum aliquam odio eget ultricies mattis imperdiet vel fringilla rhoncus quisque risus vehicula accumsan malesuada mi nostra praesent.', '2000-04-11 11:06', '2001-04-12 00:12');
insert into posts (poster_id, post_text, date_posted, date_edited) value (5, 'Hac imperdiet et cursus consequat molestie adipiscing mi ullamcorper nibh id fermentum, orci dapibus augue justo aenean enim et etiam tellus congue est porta molestie dapibus class sollicitudin vestibulum lacus, ipsum facilisis dictum', '2018-06-11 06:06', '2018-07-30 13:00');
insert into posts (poster_id, post_text, date_posted, date_edited) value (6, 'Ut nunc pharetra rhoncus porta lectus iaculis risus rhoncus inceptos placerat, potenti eu ipsum ultrices enim diam ultrices ultricies auctor condimentum class, odio tempus habitasse ad vulputate rhoncus ante.', '2021-03-03 00:00', '2021-03-03 00:01');

-- Insert sample data into comments
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (1, 1, 'cRPLKTQANMUWKPUMN lPMX mWE nZ.', '2019-02-18 21:33:00', '2020-03-19 22:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (2, 1, 'lCPCLAALUEDUKNQCM wYGZ uBL eQ.', '2019-02-24 21:33:00', '2020-09-06 22:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (3, 3, 'fUMPXMYYDYNAOMNSZ eNIY zZO yU.', '2019-03-23 22:33:00', '2020-01-26 21:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (4, 2, 'pULIWSWETOCVXXBBC xOWF yVU gV.', '2019-03-22 22:33:00', '2020-07-23 22:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (5, 5, 'pUQJQDGBODXEJCMPG wTMB dTX mB.', '2019-03-31 22:33:00', '2020-05-24 22:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (6, 2, 'qIOILSKNQVEPSTOIX iHOO sOB nV.', '2019-01-25 21:33:00', '2020-11-27 21:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (7, 2, 'yZJTZWSQDZZXHGKGO uIVW mIR oP.', '2019-02-23 21:33:00', '2020-03-01 21:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (8, 6, 'pBOZBJDKMRXTUAXOS hPWT wUK tS.', '2019-03-01 21:33:00', '2019-09-24 22:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (9, 4, 'hDYJAGSVGSGYLJBTF bQNS fGX mP.', '2019-02-21 21:33:00', '2020-10-08 22:33:00');
insert into comments (post_id, commenter_id, comment_text, date_commented, date_edited) values (10, 7, 'dDJZNVDGSXTXUSVTQ uFHX nVA yE.', '2018-12-25 21:33:00', '2020-03-15 22:33:00');

-- Insert sample data into likes
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (10, 1, 'post', '2020-05-21 07:12:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (1, 1, 'post', '2020-12-17 19:34:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (4, 2, 'comment', '2020-06-28 20:49:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (9, 3, 'comment', '2021-01-12 20:59:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (1, 4, 'comment', '2020-04-30 10:52:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (4, 5, 'post', '2020-11-10 06:58:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (1, 6, 'post', '2020-11-06 02:54:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (3, 7, 'post', '2020-12-12 14:29:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (7, 10, 'post', '2020-04-25 05:47:00');
insert into likes (user_id, post_or_comment_id, post_or_comment, date_liked) values (9, 8, 'comment', '2020-04-22 02:44:00');