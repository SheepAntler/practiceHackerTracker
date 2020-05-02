delete from users;
INSERT INTO users VALUES (1,'fluffybunny','password','Elaine','Markowitz','emarkowitz@gmail.com',12,'2009-09-09','Portland','OR',12345,56),
                         (2,'madBratsche','password','Jonathan','Dunlop','madbratsche@gmail.com',45,'2004-01-12','Cleveland','OH',12345,78),
                         (3,'sheepAntler','password','Elspeth','StalterClouse','sheepantler@gmail.com',28,'1989-12-12','Chicago','IL',54321,20),
                         (4,'GeezLouise','password','Louise','Janak','yesitiscalledaflugelhorn@gmail.com',44,'2002-06-04','Madison','WI',53703,12),
                         (5,'splish_splash','password','Mickey','McMahon','mickmick@gmail.com',112,'1986-10-02','Bangor','ME',53421,45);

delete from practice_logs;
INSERT INTO practice_logs VALUES (1,1,'2020-02-24','2020-02-24 09:10:11','2020-02-24 10:10:11','scales, arpeggios, concerto','test','test'),
                                 (2,4,'2019-12-25','2019-12-25 08:42:36','2019-12-25 09:32:06','scales','Nat\'s Knapsack Strap Snapped','test'),
                                 (3,1,'2020-01-01','2020-01-01 01:01:01','2020-01-01 20:20:20','arpeggios','test','test'),
                                 (4,2,'2019-03-18','2019-03-18 04:01:22','2019-03-18 06:00:00','orchestra music, scales','test','test'),
                                 (5,3,'2020-01-21','2020-01-21 01:07:30','2020-01-21 02:00:00','eating muffins, scales','test','test');

delete from practice_hacks;
INSERT INTO practice_hacks VALUES (1,3,'intermediate','cello','play scales for 20 minutes'),
                                  (2,3,'advanced','violin','play scales for 60 minutes'),
                                  (3,1,'beginner','viola','practice making 5 slow bow hands in a row'),
                                  (4,2,'beginner','trumpet','i honestly have no idea what trumpet players practice'),
                                  (5,5,'advanced','general','use a metronome'),
                                  (6,3,'beginner','violin','do a violin workout: description of a violin workout');

delete from studios;
INSERT INTO studios VALUES (1,4,'trumpet','Trumpet Topia','456 Bell Street','Portland','OR',44567),
                           (2,5,'trombone',null,'1123 Trombone Ct.','Madison','WI',53711),
                           (3,1,'violin','The Suzuki House','1004 Something Something Rd.','Stevens Point','WI',44980),
                           (4,2,'viola',null,'421 Mohs Street','Boise','ID',66789),
                           (5,1,'concertina','The Suzuki House','1004 Something Something Rd.','Stevens Point','WI',44980);

delete from studio_students;
INSERT INTO studio_students VALUES (1,5),
                                   (2,4),
                                   (3,3),
                                   (4,3),
                                   (5,5),
                                   (5,1);

delete from user_roles;
INSERT INTO user_roles VALUES (1,1,'fluffybunny','student'),
                              (2,3,'sheepAntler','practiceHacker'),
                              (3,5,'splish_splash','practiceHacker'),
                              (4,2,'madBratsche','teacher');

delete from instruments;
INSERT INTO instruments VALUES (1,2,'viola','intermediate'),
                               (2,3,'violin','professional'),
                               (3,4,'flugelhorn','advanced'),
                               (4,5,'bass','professional'),
                               (5,1,'cello','beginner');