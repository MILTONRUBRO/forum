CREATE TABLE usuario(
    id bigint not null auto_increment,
    nome varchar(50),
    email varchar(50),
    primary key(id)
);

INSERT INTO usuario VALUES(1, 'Lagertha Lothbrok', 'lagertha@email.com');