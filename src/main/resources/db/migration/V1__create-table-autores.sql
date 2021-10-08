CREATE TABLE autores (
  id bigint NOT NULL AUTO_INCREMENT,
  dataNascimento date not NULL,
  email varchar(255) not NULL,
  miniCurriculo TEXT not NULL,
  nome varchar(255) not NULL,
  PRIMARY KEY (id)
);

