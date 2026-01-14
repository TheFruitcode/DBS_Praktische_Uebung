CREATE DATABASE campusconnect;

use campusconnect;

CREATE TABLE Student(
    student_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150),
    email VARCHAR(100),
    PRIMARY KEY (student_id)
);

CREATE TABLE Dozent(
    dozent_id INT NOT NULL,
    name VARCHAR(150),
    department VARCHAR(80),
    PRIMARY KEY (dozent_id)
);

CREATE TABLE Kurs(
    kurs_id INT NOT NULL,
    title VARCHAR(50),
    dozent_id INT,
    PRIMARY KEY (kurs_id),
    FOREIGN KEY (dozent_id) REFERENCES Dozent(dozent_id)
);

CREATE TABLE Anmeldungen(
    student_id INT,
    kurs_id INT,
    semester INT,
    FOREIGN KEY (student_id) REFERENCES Student(student_id),
    FOREIGN KEY (kurs_id) REFERENCES Kurs(kurs_id)
);