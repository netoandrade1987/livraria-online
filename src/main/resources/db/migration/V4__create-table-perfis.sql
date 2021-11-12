CREATE TABLE perfis (
  id bigint NOT NULL AUTO_INCREMENT primary key,
  nome varchar(100) not NULL,
);



CREATE TABLE perfis_usuarios (
	usuario_id bigint not null,
	perfil_id bigint not null,
	
	primary key (usuario_id, perfil_id),
	foreign key (usuario_id) references usuarios(id),
	foreign key (perfil_id) references perfils(id)
	
);


insert into perfis values(1,'ROLE_ADMIN');
insert into perfis values(2,'ROLE_COMUN');



