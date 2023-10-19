CREATE TABLE Homework(
                         id int auto_increment,
                         name varchar(255),
                         description varchar(255),
                         primary key (id)
);

INSERT INTO Homework(name, description) VALUES ('Igor', 'broy1');
INSERT INTO Homework(name, description) VALUES ('Alex', 'broy2');
INSERT INTO Homework(name, description) VALUES ('Jax', 'broy3');

CREATE TABLE Lesson(
                       id int auto_increment,
                       name varchar(255),
                       updatedAt datetime,
                       homework_id int,
                       primary key (id),
                       foreign key (homework_id) references Homework(id)
);

INSERT INTO Lesson(name, updatedAt, homework_id) VALUES ('Igor', now(), 1);
INSERT INTO Lesson(name, updatedAt, homework_id) VALUES ('Alex', now(), 2);
INSERT INTO Lesson(name, updatedAt, homework_id) VALUES ('Jax', now(), 3);
-- INSERT INTO Lesson(name, updatedAt, homework_id) VALUES ('Jax', now(), 4); -- ERROR

CREATE TABLE Schedule(
                         id int auto_increment,
                         name varchar(255),
                         updatedAt datetime,
                         lessons int,
                         primary key (id),
                         foreign key (lessons) references Lesson(id)
);

INSERT INTO Schedule(name, updatedAt, lessons) VALUES ('Igor', now(), 1);
INSERT INTO Schedule(name, updatedAt, lessons) VALUES ('Alex', now(), 1);
INSERT INTO Schedule(name, updatedAt, lessons) VALUES ('Jax1', now(), 1);
-- INSERT INTO Schedule(name, updatedAt, lessons) VALUES ('Jax', now(), 4); -- ERROR

