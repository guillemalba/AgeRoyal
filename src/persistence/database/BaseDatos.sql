Drop table if exists Player cascade;
Create table Player(
    name          varchar(255),
    mail          varchar(255),
    password      varchar(255),
    victorias     int,
    totalGames    int,
    ratio         float,
    primary key (name)
);

Drop table if exists Game cascade;
Create table Game(
    name            varchar(255),
    data            varchar(255),
    win             boolean,
    player          varchar(255),
    primary key(name),
    foreign key (player) references Player(name)
);

Drop table if exists TroopDeployed cascade;
create table TroopDeployed(
    id              serial,
    time_deployed   int,
    posX            int,
    posY            int,
    troop           int,
    isUser          boolean,
    game            varchar(255),
    primary key(id),
    foreign key(game) references Game(name)
);
