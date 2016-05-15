
    create table Autor_Ksiazka (
        autor_id bigint not null,
        ksiazka_id bigint not null,
        primary key (autor_id, ksiazka_id)
    );

    create table autor (
        id bigint not null auto_increment,
        imie varchar(255),
        nazwisko varchar(255),
        primary key (id)
    );

    create table kategoria (
        id bigint not null auto_increment,
        nazwa varchar(255),
        primary key (id)
    );

    create table ksiazka (
        id bigint not null auto_increment,
        ISBN varchar(255),
        tytul varchar(255),
        kategoria_id bigint,
        primary key (id)
    );

    alter table Autor_Ksiazka 
        add constraint FK_8v83dap55g8ymhcf7h8hqixr5 
        foreign key (ksiazka_id) 
        references ksiazka (id);

    alter table Autor_Ksiazka 
        add constraint FK_h6s8qoauyrwe7ide7374g8wam 
        foreign key (autor_id) 
        references autor (id);

    alter table ksiazka 
        add constraint FK_t6cqiopmlvrscuobj86sjodpg 
        foreign key (kategoria_id) 
        references kategoria (id);
