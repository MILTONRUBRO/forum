CREATE TABLE curso(
    id bigint not null auto_increment,
    nome varchar(50),
    categoria varchar(50),
    primary key(id)
);

INSERT INTO curso VALUES(1, 'Kotlin', 'PROGRAMACAO');
