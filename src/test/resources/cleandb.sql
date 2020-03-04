delete from users;
INSERT INTO users VALUES (1,'fluffybunny','password','Elaine','Markowitz','emarkowitz@gmail.com','beginner','12','2009-09-09','Portland','OR',12345),
                         (2,'madBratsche','password','Jonathan','Dunlop','madbratsche@gmail.com','intermediate','45','2004-01-12','Cleveland','OH',12345),
                         (3,'sheepAntler','password','Elspeth','StalterClouse','sheepantler@gmail.com','professional','28','1989-12-12','Chicago','IL',54321),
                         (4,'GeezLouise','password','Louise','Janak','yesitiscalledaflugelhorn@gmail.com','advanced','44','2002-06-04','Madison','WI',53703),
                         (5,'splish_splash','password','Mickey','McMahon','mickmick@gmail.com','professional','112','1986-10-02','Bangor','ME',53421);

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
                                  (5,5,'advanced','general','use a metronome');

delete from studios;
INSERT INTO studios VALUES (1,4,'trumpet'),
                           (2,5,'trombone'),
                           (3,1,'violin'),
                           (4,1,'viola'),
                           (5,2,'concertina');

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
INSERT INTO instruments VALUES (1,2,'viola'),
                               (2,3,'violin'),
                               (3,4,'flugelhorn'),
                               (4,3,'tin whistle'),
                               (5,3,'autoharp');