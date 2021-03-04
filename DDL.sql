create schema team_lol;

use team_lol;

create user 'user'@'localhost' identified by 'pass123';
grant select, insert, delete, update on team_lol.* to user@'localhost';


create table jgd_jogador(
    jgd_id bigint not null auto_increment,
    jgd_nick varchar(20) not null,
    jgd_rank varchar(30) not null,
    primary key(jgd_id),
    unique key uni_jogador_nick(jgd_nick)
);

create table cch_coach(
    cch_id bigint not null auto_increment,
    cch_nome varchar(30) not null,
    primary key(cch_id),
    unique key uni_coach_nome(cch_nome)
);

create table tme_time(
    tme_id bigint not null auto_increment,
    tme_nome varchar(30) not null,
    tme_coach bigint,
    foreign key (tme_coach) references cch_coach(cch_id),  
    primary key(tme_id),
    unique key uni_time_nome(tme_nome)
);

create table tmj_time_jogador(
    tmj_time bigint,
    tmj_jogador bigint,
    foreign key(tmj_time) references tme_time(tme_id),
    foreign key(tmj_jogador) references  jgd_jogador(jgd_id),

    unique key uni_jogador_time(tmj_time)
);




