
-- Drop tables if they exist
DROP TABLE IF EXISTS student_history;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS career;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `career`
--

CREATE TABLE IF NOT EXISTS career (
  id_career int(11) NOT NULL PRIMARY KEY,
  name varchar(255) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE IF NOT EXISTS student (
  age int(11) NOT NULL,
  id_student int(11) NOT NULL PRIMARY KEY,
  dni bigint(20) NOT NULL,
  number_of_librety bigint(20) NOT NULL,
  genre varchar(255) NOT NULL,
  lastname varchar(255) NOT NULL,
  names varchar(255) NOT NULL,
  residence_city varchar(255) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student_history`
--

CREATE TABLE IF NOT EXISTS student_history (
  egress_date date DEFAULT NULL,
  id_career int(11) NOT NULL,
  id_student int(11) NOT NULL,
  inscription_date date NOT NULL,
  PRIMARY KEY (id_career, id_student)
) ;


ALTER TABLE student_history
 ADD CONSTRAINT FK_student FOREIGN KEY (id_student) REFERENCES student (id_student),
 ADD CONSTRAINT FK_career FOREIGN KEY (id_career) REFERENCES career (id_career);

insert into career (id_career, name) values (1, 'Akita University of Economics and Law');
insert into career (id_career, name) values (2, 'Suwon Catholic University');
insert into career (id_career, name) values (3, 'Tohoku Fukushi University');
insert into career (id_career, name) values (4, 'Zanjan University');
insert into career (id_career, name) values (5, 'Azusa Pacific University');
insert into career (id_career, name) values (6, 'China Foreign Affairs University');
insert into career (id_career, name) values (7, 'Qom University');
insert into career (id_career, name) values (8, 'Asa University Bangladesh');
insert into career (id_career, name) values (9, 'Australlian College of Kuwait ');
insert into career (id_career, name) values (10, 'Al-Yamamah College');
insert into career (id_career, name) values (11, 'Universität Hannover');
insert into career (id_career, name) values (12, 'Royal University of Phnom Penh');
insert into career (id_career, name) values (13, 'Islamic Azad University, Khorasgan');
insert into career (id_career, name) values (14, 'University of Wisconsin - Green Bay');
insert into career (id_career, name) values (15, 'National Museum Institute of History of Art, Conservation and Museology');
insert into career (id_career, name) values (16, 'Vanguard University of Southern California');
insert into career (id_career, name) values (17, 'Pacific University');
insert into career (id_career, name) values (18, 'Kwantleen University College');
insert into career (id_career, name) values (19, 'Grantham University');
insert into career (id_career, name) values (20, 'Hawassa University');


insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (47, 1, 32408962, 57617, 'Female', 'Dyos', 'Bertie', 'Kurów');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (28, 2, 32247025, 64941, 'Male', 'Calafate', 'Cheston', 'Guadalupe');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (37, 3, 38680152, 4377, 'Female', 'Noriega', 'Patti', 'Tabanan');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (32, 4, 32540904, 1477, 'Female', 'Sturmey', 'Siobhan', 'Wakuya');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (41, 5, 32149062, 93839, 'Male', 'Nurse', 'Reidar', 'Quintã');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (28, 6, 49047305, 9857, 'Female', 'Klemke', 'Megen', 'Cikalong');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (44, 7, 31018092, 30428, 'Female', 'Edgeler', 'Lita', 'Dauriya');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (30, 8, 39398749, 93062, 'Female', 'Bagg', 'Dione', 'Lubochnia');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (22, 9, 34843698, 98508, 'Male', 'ducarme', 'Andrej', 'Mapiri');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (29, 10, 48547784, 93770, 'Male', 'Knappitt', 'Moss', 'Kovylkino');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (34, 11, 49967496, 66831, 'Female', 'Niess', 'Kassia', 'Aoluguya Ewenke Minzu');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (48, 12, 34645700, 15454, 'Male', 'McMeekan', 'Bradly', 'Ḩalāwah');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (21, 13, 46521065, 48051, 'Male', 'Domsalla', 'Bartholomew', 'Cateel');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (43, 14, 38419227, 78552, 'Male', 'Sansome', 'Bryant', 'Al Ḩusayn');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (30, 15, 33877319, 45056, 'Female', 'De Gregario', 'Kiah', 'Kabare');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (45, 16, 38660815, 15324, 'Male', 'MacTeggart', 'Maximilien', 'Chironkamba');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (48, 17, 40102282, 84267, 'Male', 'Rosle', 'Ruperto', 'Fryanovo');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (29, 18, 47069840, 12533, 'Female', 'Sandels', 'Bekki', 'Augusta');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (37, 19, 32681481, 27702, 'Male', 'Balding', 'Wyn', 'Słupno');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (23, 20, 38552987, 8763, 'Female', 'Pablo', 'Ertha', 'Wangjiang');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (46, 21, 39938048, 56200, 'Female', 'Rhys', 'Kristi', 'Cibolang');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (34, 22, 43414490, 3227, 'Female', 'Gonthard', 'Drusilla', 'Pravdinsk');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (47, 23, 36866403, 23864, 'Female', 'Labes', 'Modesty', 'Avranches');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (48, 24, 32678827, 68671, 'Polygender', 'Willman', 'Klaus', 'Jaguaribe');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (29, 25, 38332453, 73037, 'Male', 'Caghan', 'Abdel', 'Abua');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (40, 26, 44965312, 57219, 'Male', 'Sundin', 'Marcelo', 'Annotto Bay');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (20, 27, 33191571, 34575, 'Male', 'Sharville', 'Rutledge', 'Mandal');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (40, 28, 47101967, 34236, 'Male', 'MacCauley', 'Davy', 'Skýros');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (29, 29, 34380080, 13620, 'Female', 'Rivett', 'Robin', 'Tabatinga');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (31, 30, 34866351, 99153, 'Female', 'Hyde-Chambers', 'Linell', 'Schaan');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (26, 31, 43834471, 20837, 'Female', 'Daw', 'Bertie', 'Hangzhou');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (25, 32, 37210587, 1509, 'Female', 'Tomlins', 'Margot', 'Suru');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (26, 33, 37426706, 12732, 'Female', 'Normanton', 'Stefanie', 'Moog');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (46, 34, 40595628, 98248, 'Female', 'Dupey', 'Letisha', 'Succha');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (41, 35, 37308403, 7416, 'Male', 'End', 'Major', 'El Tránsito');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (33, 36, 34950448, 5213, 'Male', 'Manston', 'Fredric', 'Zhangxiang');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (38, 37, 31311124, 87778, 'Female', 'Silvermann', 'Jaquelin', 'Daming');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (47, 38, 47110024, 73691, 'Male', 'Rubartelli', 'Arlin', 'Urrao');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (33, 39, 36010393, 24974, 'Male', 'Ghidetti', 'Thaddeus', 'Xuguang');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (18, 40, 31824851, 85983, 'Male', 'Coughlan', 'Foss', 'Kikinda');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (48, 41, 38115569, 33900, 'Male', 'Clee', 'Benyamin', 'Santa Ana');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (24, 42, 45562805, 23962, 'Female', 'Flahy', 'Shay', 'Funehikimachi-funehiki');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (26, 43, 38047694, 7597, 'Male', 'Prangley', 'Mikael', 'Pomiechówek');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (43, 44, 31627954, 82462, 'Female', 'Bonsey', 'Tomasine', 'Desē');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (34, 45, 45898443, 88746, 'Female', 'Kinchlea', 'Jerrilyn', 'Hezhang');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (50, 46, 45592146, 22362, 'Male', 'Beglin', 'Kinsley', 'Xiaochi');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (43, 47, 42808250, 86934, 'Male', 'Styan', 'Etienne', 'Pasrūr');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (45, 48, 35863249, 2474, 'Male', 'Titta', 'Cassius', 'Huachos');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (38, 49, 42100760, 42486, 'Male', 'Lightwing', 'Ferguson', 'Mithi');
insert into student (age, id_student , dni, number_of_librety, genre, lastname, names, residence_city) values (23, 50, 40456799, 78350, 'Female', 'Schober', 'Juieta', 'Lysekil');

insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2001-11-22 21:21:30', 15, 26, '1998-01-07 11:13:01');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2004-01-27 16:50:24', 1, 23, '2009-09-17 20:54:45');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2000-02-25 04:05:28', 6, 43, '2009-08-17 14:16:38');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2014-02-25 07:52:50', 15, 43, '2005-05-26 21:46:46');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2015-05-29 22:33:18', 12, 5, '1996-12-26 04:58:36');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2009-12-12 21:18:43', 6, 19, '2012-03-25 19:57:21');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2007-11-02 09:26:26', 4, 31, '1999-01-12 18:34:58');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2004-02-05 21:39:09', 16, 26, '2022-05-15 20:48:20');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('1990-12-12 14:45:58', 7, 6, '1999-07-07 10:55:46');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2015-01-11 14:04:56', 13, 2, '2003-11-01 12:38:23');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2004-07-23 18:51:06', 13, 21, '1996-03-01 22:13:07');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('1996-12-15 12:52:59', 12, 48, '2002-11-30 05:59:06');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2015-03-29 06:06:47', 10, 16, '2004-02-11 08:58:24');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2022-03-22 14:03:55', 6, 16, '2016-08-15 02:02:20');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('1997-05-16 14:54:28', 20, 47, '2022-06-05 15:41:18');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2022-01-06 13:16:08', 16, 50, '1998-05-13 18:08:53');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('1995-08-18 23:28:58', 7, 18, '1998-04-14 17:24:09');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2007-05-14 18:25:15', 5, 2, '1999-11-26 16:52:40');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('1998-09-11 05:47:33', 12, 11, '1998-04-06 14:05:46');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('1998-10-20 22:33:53', 17, 23, '2015-06-13 22:01:54');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2014-06-14 04:56:43', 19, 20, '2014-10-27 09:27:16');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2021-06-01 12:13:27', 17, 35, '2017-09-26 05:47:37');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2020-07-06 04:06:47', 4, 47, '1997-02-20 06:48:19');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('1994-04-02 06:07:59', 14, 20, '2015-05-20 09:33:49');
insert into student_history (egress_date, id_career, id_student, inscription_date) values ('2012-08-06 14:08:57', 19, 26, '2004-10-26 17:10:18');

