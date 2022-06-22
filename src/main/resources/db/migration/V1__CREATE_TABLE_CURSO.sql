CREATE TABLE curso(
    id bigint not null,
    nome varchar(50),
    categoria varchar(50),
    primary key(id)
);

INSERT INTO curso VALUES(1, 'Kotlin', 'PROGRAMACAO');
