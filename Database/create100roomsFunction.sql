DROP PROCEDURE IF EXISTS insert100RoomsFunction;

delimiter $$

CREATE PROCEDURE insert100RoomsFunction()

BEGIN

DECLARE i INT DEFAULT 1;

WHILE (i<=100) DO
             INSERT INTO tblroom VALUES(null, i, 1, 1);
               SET i=i+1;
END WHILE;

END$$

delimiter ;


call insert100RoomsFunction();