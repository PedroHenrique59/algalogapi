create table ocorrencia(
	id bigint not null auto_increment,
	entrega_id bigint not null,
    descricao text not null,
    data_registro datetime not null,
	primary key(id),
    foreign key(entrega_id) references entrega(id)
);