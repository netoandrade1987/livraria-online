CREATE TABLE livros (
  id bigint NOT NULL AUTO_INCREMENT,
  dataLancamento date not NULL,
  numeroPaginas int not NULL,
  titulo varchar(255) not NULL,
  autor_id bigint not NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (autor_id) REFERENCES autores (id)
);