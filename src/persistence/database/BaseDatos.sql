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
    data            date,
    public          varchar(255),
    win             boolean,
    player          varchar(255),
    primary key(name),
    foreign key (player) references Player(name)
);

Drop table if exists Troops cascade;
create table Troops(
    id          serial,
    name        varchar(255),
    life        int,
    cost        int,
    rangeDmg    float,
    primary key(id)
);


Drop table if exists Ofensive cascade;
create table Ofensive(
    id          int,
    movVel      int,
    primary key(id),
    foreign key(id) references Troops(id)
);

Drop table if exists Defensive cascade;
create table Defensive(
    id          int,
    carac1      int,
    primary key (id),
    foreign key (id) references Troops(id)
);

Drop table if exists Ofensive1 cascade;
create table Ofensive1(
    id          int,
    carac1      int,
    primary key(id),
    foreign key(id) references Ofensive(id)
);

Drop table if exists Ofensive2 cascade;
create table Ofensive2(
    id          int,
    carac1      int,
    primary key(id),
    foreign key(id) references Ofensive(id)
);

Drop table if exists Defensive1 cascade;
create table Defensive1(
    id          int,
    carac1      int,
    primary key(id),
    foreign key(id) references Defensive(id)
);

Drop table if exists Defensive2 cascade;
create table Defensive2(
    id          int,
    carac1      int,
    primary key(id),
    foreign key(id) references Defensive(id)
);

Drop table if exists Movement cascade;
create table Movement(
    id              serial,
    TempsMov        float,
    starPosition    varchar(255),
    endPosition     varchar(255),
    accion          varchar(255),
    trop            int,
    game            varchar(255),
    primary key(id),
    foreign key(game) references Game(name),
    foreign key(trop) references Troops(id)
);

select * from player;
