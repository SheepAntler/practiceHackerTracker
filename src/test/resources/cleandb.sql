delete from users;
INSERT INTO users VALUES (1,'fluffybunny','password','Elaine','Markowitz','emarkowitz@gmail.com', 'violin', 'beginner', '12', '2009-09-09', '8'),
                         (2,'madBratsche','password','Jonathan','Dunlop', 'madbratsche@gmail.com', 'viola', 'intermediate', '45', '2004-01-12', '2'),
                         (3,'sheepAntler','password','Elspeth','StalterClouse', 'sheepantler@gmail.com', 'violin', 'professional', '28', '1989-12-12', '18'),
                         (4,'GeezLouise','password','Louise','Janak', 'yesitiscalledaflugelhorn@gmail.com', 'flugelhorn', 'advanced', '44', '2002-06-04', '1'),
                         (5,'splish_splash','password','Mickey','McMahon', 'mickmick@gmail.com', 'bass', 'professional', '112', '1986-10-02', '28');

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
INSERT INTO studios VALUES (1,4),
                           (2,5),
                           (3,1),
                           (4,1),
                           (5,2);
