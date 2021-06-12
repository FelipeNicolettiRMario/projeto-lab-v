create schema team_lol;

use team_lol;

create user 'user'@'localhost' identified by 'pass123';
grant select, insert, delete, update on team_lol.* to user@'localhost';

create table cch_coach(
    cch_id bigint not null auto_increment,
    cch_nome varchar(30) not null,
    cch_senha varchar(40) not null,
    primary key(cch_id),
    unique key uni_coach_nome(cch_nome)
);

create table tme_time(
    tme_id bigint not null auto_increment,
    tme_nome varchar(30) not null,
    tme_coach bigint,
    foreign key (tme_coach) references cch_coach(cch_id),  
    primary key(tme_id),
    unique key uni_time_nome(tme_nome),
    unique key uni_time_coach(tme_coach)
);

create table jgd_jogador(
    jgd_id bigint not null auto_increment,
    jgd_nick varchar(20) not null,
    jgd_rank varchar(30) not null,
    jgd_time bigint,
    jgd_senha varchar(200) not null,
    jgd_role varchar(50),
    foreign key(jgd_time) references tme_time(tme_id),
    primary key(jgd_id),
    unique key uni_jogador_nick(jgd_nick)
);

insert into cch_coach(cch_nome,cch_senha) values ("Leslie","1234");
insert into tme_time(tme_nome,tme_coach) values ("Pain",1);
insert into jgd_jogador(jgd_nick,jgd_rank,jgd_time,jgd_senha) values ("Kami","Mestre",1,"1234");

