insert into autor (id, imie, nazwisko) values (1, 'Cay', 'Horstmann');
insert into autor (id, imie, nazwisko) values (2, 'Gary', 'Cornell');
insert into autor (id, imie, nazwisko) values (3, 'Francesco', 'Marchioni');
insert into autor (id, imie, nazwisko) values (4, 'Craig', 'Walls');
insert into autor (id, imie, nazwisko) values (5,'Robert', 'Ligouri');
insert into autor (id, imie, nazwisko) values (6, 'James', 'Ballard');
insert into autor (id, imie, nazwisko) values (7, 'Borys', 'Strugacki');
insert into autor (id, imie, nazwisko) values (8, 'Arkadij', 'Strugacki');
insert into autor (id, imie, nazwisko) values (9, 'Joshua', 'Bloch');
insert into autor (id, imie, nazwisko) values (10,'Oscar', 'Wilde');
insert into autor (id, imie, nazwisko) values (11, 'Ken', 'Kesey');
insert into autor (id, imie, nazwisko) values (12, 'John', 'Irving');
insert into autor (id, imie, nazwisko) values (13, 'Chuck', 'Palahniuk');

insert into kategoria(id, nazwa) values(1,'ScienceFiction');
insert into kategoria(id, nazwa) values(2, 'Techniczne');
insert into kategoria(id, nazwa) values(3,'Obyczajowe');
insert into kategoria(id, nazwa) values(4, 'Klasyka');


insert into ksiazka (id, isbn, tytul,kategoria_id ) values (1,'123-456-789-10', 'JBossAs7',2);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (2,'123-456-789-10', 'Java8LeksykonKieszonkowy',2);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (3,'123-456-789-10', 'JavaPodstawy',2);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (4,'123-456-789-10', 'Wiezowiec', 3);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (5,'123-456-789-10', 'PiknikNaSkrajuDrogi',1);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (6,'123-456-789-10', 'SpringInAction',2);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (7,'123-456-789-10', 'PortretDorianaGraya',4);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (8,'123-456-789-10', 'EffectiveJava',2);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (9,'123-456-789-10', 'LotNadKukulczymGniazdem',3);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (10,'123-456-789-10', 'UdlawSie',3);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (11,'123-456-789-10', 'Kolysanka',3);
insert into ksiazka (id, isbn, tytul,kategoria_id ) values (12,'123-456-789-10', 'ZukWMrowisku',1);

insert into Autor_Ksiazka(autor_id, ksiazka_id) values(1,3);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(2,3);

insert into Autor_Ksiazka(autor_id, ksiazka_id) values(2,1);

insert into Autor_Ksiazka(autor_id, ksiazka_id) values(3,1);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(4,6);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(5,2);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(13,11);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(13,10);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(11,9);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(7,5);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(8,5);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(7,12);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(8,12);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(10,7);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(6,4);
insert into Autor_Ksiazka(autor_id, ksiazka_id) values(9,8);






