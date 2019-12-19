SELECT avg (mark) from marks WHERE student = 1;
SELECT mark, lesson from marks;
SELECT lesson from marks WHERE  student = 2;

SELECT * FROM marks m
    LEFT JOIN lessons l
                            ON m.lesson  = l.id;

SELECT lesson from marks WHERE  student =1;
SELECT name from lessons;
SELECT avg (mark) from marks group by student;