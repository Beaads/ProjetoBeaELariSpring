CREATE TABLE Colaborador(
                            codigoColaborador int PRIMARY KEY not null,
                            nomeColaborador VARCHAR (80),
                            dataNascimento TEXT
);

CREATE TABLE Permissao(
                          codigoPermissao int PRIMARY KEY not null,
                          nomePermissao VARCHAR (80)
);

CREATE TABLE Colaborador_Permissao(
                                      codigoColaborador int not null UNIQUE,
                                      codigoPermissao int not null UNIQUE,
                                      foreign key (codigoColaborador) references  Colaborador(codigoColaborador),
                                      foreign key (codigoPermissao) references Permissao(codigoPermissao),
                                      CONSTRAINT pk_Colaborador_Permissao PRIMARY KEY(codigoColaborador,codigoPermissao)
);




CREATE TABLE Colaborador(
		codigoColaborador BIGSERIAL PRIMARY KEY,
		nomeColaborador VARCHAR (255),
		dataNascimento VARCHAR(10),
		qtdMaxPermissoes int
);
CREATE TABLE Permissao(
		  codigoPermissao BIGSERIAL PRIMARY KEY,
		  nomePermissao VARCHAR (255)
);

CREATE TABLE Colaborador_Permissao(
		  codigoColaborador int not null,
		  codigoPermissao int not null,
		  foreign key (codigoColaborador) references  Colaborador(codigoColaborador),
		  foreign key (codigoPermissao) references Permissao(codigoPermissao),
		  CONSTRAINT pk_Colaborador_Permissao PRIMARY KEY(codigoColaborador,codigoPermissao)
);