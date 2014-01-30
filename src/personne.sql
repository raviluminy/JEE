DROP TABLE IF EXISTS Personne CASCADE;
CREATE TABLE Personne (
Id              INTEGER,
Nom             VARCHAR(256)    NOT NULL,
Prenom          VARCHAR(256)    NOT NULL,
Mail            VARCHAR(256)    NOT NULL,
Site            VARCHAR(256),
Anniversaire    VARCHAR(10),
Mdp             VARCHAR(256)    NOT NULL,

CONSTRAINT PK_Personne PRIMARY KEY (Id),
CONSTRAINT Format_Mail CHECK (Mail ~ '^[a-z0-9._-]+[@][a-z0-9._-]{2,}[.][a-z]{2,4}$'),
CONSTRAINT Format_Site CHECK (Site ~ '^[w]{3}[.][(0-9)*a-zA-Z_]+[.][a-zA-Z_]{2,4}$'),
CONSTRAINT Format_Anniversaire CHECK (Anniversaire ~ '^(([0][1-9]|[2][0-9])|[3][0-1])([.]|[:]|[-]|[/])([0][1-9]|[1][0-2])([.]|[:]|[-]|[/])([19][0-9]{3}|[20][0-9]{3})$')
);
