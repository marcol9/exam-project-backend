DELETE FROM candidate where id > 0;
DELETE FROM party where id > 0;

INSERT INTO party (id,letter,name) values (1,'A','party 1');
INSERT INTO party (id,letter,name) values (2,'A','party 2');
INSERT INTO party (id,letter,name) values (3,'A','party 3');

INSERT INTO candidate (id,name,party_id) values (1,'John Johnny1',1);
INSERT INTO candidate (id,name,party_id) values (2,'John Johnny2',1);
INSERT INTO candidate (id,name,party_id) values (3,'John Johnny3',2);
INSERT INTO candidate (id,name,party_id) values (4,'John Johnny4',3);