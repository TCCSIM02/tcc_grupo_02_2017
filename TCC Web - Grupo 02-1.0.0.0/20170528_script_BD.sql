DROP SCHEMA IF EXISTS `TCC` ;
CREATE SCHEMA IF NOT EXISTS `TCC` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `TCC` ;

-- -----------------------------------------------------
-- Table `TCC`.`Unidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Unidade` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Unidade` (
  `codUnidade` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `razaoSocial` VARCHAR(200) NOT NULL COMMENT 'Razao Social registrada pela empresa',
  `nomeFantasia` VARCHAR(150) NULL COMMENT 'Nome Fantasia da Empresa',
  `cNPJ` VARCHAR(18) NOT NULL COMMENT 'Numero de CPNJ da empresa',
  `nomeRede` VARCHAR(45) NOT NULL COMMENT 'Nome da rede de unidades, se ela fizer parte de uma.',
  `endereco` VARCHAR(200) NOT NULL COMMENT 'Endereco da unidade',
  `cEP` VARCHAR(9) NOT NULL COMMENT 'CEP onde esta localizada a unidade',
  `cidade` VARCHAR(50) NOT NULL COMMENT 'Cidade onde esta localizada a unidade',
  `uF` VARCHAR(2) NOT NULL COMMENT 'UF onde esta localizada a unidade',
  `pais` VARCHAR(20) NOT NULL COMMENT 'Pais onde esta localizada a unidade',
  `representante` VARCHAR(45) NOT NULL COMMENT 'Nome do representante da unidade',
  `tel1` VARCHAR(15) NOT NULL COMMENT 'Telefone 1 (Principal) da unidade',
  `tel2` VARCHAR(15) NULL COMMENT 'Telefone secundario da unidade',
  `cel` VARCHAR(15) NULL COMMENT 'Celular de contato com a unidade',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se a unidade esta ativa',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro da unidade',
  PRIMARY KEY (`codUnidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`NivelUsuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`NivelUsuario` ;

CREATE TABLE IF NOT EXISTS `TCC`.`NivelUsuario` (
  `codNivel` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `nomeNivel` VARCHAR(45) NOT NULL COMMENT 'Nome do nivel de permissao do usuario',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se nivel de usuario está ativo.',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro do Nivel de usuario',
  PRIMARY KEY (`codNivel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Login` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Login` (
  `codLogin` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária',
  `codNivel` INT NULL COMMENT 'Codigo do nivel para este o codigo de login',
  `nomeLogin` VARCHAR(20) NOT NULL COMMENT 'Nome de login que vai ser utilizado para entrar no software',
  `senha` VARCHAR(12) NOT NULL COMMENT 'Senha que vai ser utilizada para entrar no software',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se o login esta ativo',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data que o login foi cadastrado',
  PRIMARY KEY (`codLogin`),
  INDEX `codNivel_idx` (`codNivel` ASC),
  CONSTRAINT `codNivel_codLogin`
    FOREIGN KEY (`codNivel`)
    REFERENCES `TCC`.`NivelUsuario` (`codNivel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Atendente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Atendente` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Atendente` (
  `codAtendente` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codUnidade` INT NULL COMMENT 'Codigo da Unidade do Atendente',
  `codLogin` INT NULL COMMENT 'Codigo de Usuario (login) do Atendente',
  `nomeAtendente` VARCHAR(65) NOT NULL COMMENT 'Nome do Atendente',
  `cPF` VARCHAR(14) NOT NULL COMMENT 'CPF do atendente',
  `dataNascimento` DATETIME NOT NULL COMMENT 'Data de nascimento do atendente',
  `email` VARCHAR(100) NOT NULL COMMENT 'Email para contato com o Atendente',
  `estadoCivil` VARCHAR(20) NULL COMMENT 'Estado civil do atendente',
  `nacionalidade` VARCHAR(35) NOT NULL COMMENT 'Nacionalidade do Atendente',
  `endereco` VARCHAR(200) NOT NULL COMMENT ' Endereco do Atendente',
  `cEP` VARCHAR(9) NOT NULL COMMENT 'CEP de residencia do atendente',
  `cidade` VARCHAR(50) NOT NULL COMMENT 'Cidade de residencia do atendente',
  `uF` VARCHAR(2) NOT NULL COMMENT 'UF de residencia do atendente',
  `pais` VARCHAR(20) NOT NULL COMMENT 'Pais de residencia do atendente',
  `tel1` VARCHAR(15) NOT NULL COMMENT 'Telefone 1 (principal) de residencia do atendente',
  `tel2` VARCHAR(15) NULL COMMENT 'Telefone 2 de residencia do atendente',
  `cel` VARCHAR(15) NULL COMMENT 'Celular de contato do atendente',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se o atendente esta ativo',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro do atendente',
  PRIMARY KEY (`codAtendente`),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  INDEX `codLogin_idx` (`codLogin` ASC),
  CONSTRAINT `codUnidade_codAtendente`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codLogin_codAtendente`
    FOREIGN KEY (`codLogin`)
    REFERENCES `TCC`.`Login` (`codLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Medico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Medico` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Medico` (
  `codMedico` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codUnidade` INT NULL COMMENT 'Codigo de Unidade do Medico',
  `codLogin` INT NULL COMMENT 'Codigo de usuario (login) do medico',
  `nomeMedico` VARCHAR(65) NOT NULL COMMENT 'Nome do Medico',
  `cPF` VARCHAR(14) NOT NULL COMMENT 'CPF do medico',
  `cRM` VARCHAR(20) NULL COMMENT 'CRM do medico caso ele o tenha',
  `cRO` VARCHAR(20) NULL COMMENT 'CRO do medico caso ele o tenha',
  `dataNascimento` DATETIME NOT NULL COMMENT 'Data de nascimento do medico ',
  `email` VARCHAR(100) NOT NULL COMMENT 'Email de contato do medico',
  `estadoCivil` VARCHAR(20) NOT NULL COMMENT 'Estado civil do medico',
  `nacionalidade` VARCHAR(40) NOT NULL COMMENT 'Nascionalidade do medico',
  `endereco` VARCHAR(200) NOT NULL COMMENT ' Endereco do Medico',
  `cEP` VARCHAR(9) NOT NULL COMMENT 'CEP de residencia do medico',
  `cidade` VARCHAR(50) NOT NULL COMMENT 'Cidade de residencia do medico',
  `uF` VARCHAR(2) NOT NULL COMMENT 'UF de residencia do medico',
  `pais` VARCHAR(20) NOT NULL COMMENT 'Pais de residencia do medico',
  `tel1` VARCHAR(15) NOT NULL COMMENT 'Telefone 1 (principal) de contato do Medico',
  `tel2` VARCHAR(15) NULL COMMENT 'Telefone 2 de contato do Medico',
  `cel` VARCHAR(15) NULL COMMENT 'Celular de contato do Medico',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se o medico esta ativo',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro do medico',
  PRIMARY KEY (`codMedico`),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  INDEX `codLogin_idx` (`codLogin` ASC),
  CONSTRAINT `codUnidade_codMedico`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codLogin_codMedico`
    FOREIGN KEY (`codLogin`)
    REFERENCES `TCC`.`Login` (`codLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Paciente` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Paciente` (
  `codPaciente` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codLogin` INT NULL COMMENT 'Codigo de usuario (login) do Paciente',
  `numConvenio` VARCHAR(20) NOT NULL COMMENT 'Numero de convenio do paciente',
  `nomePaciente` VARCHAR(65) NOT NULL COMMENT 'Nome do paciente',
  `cPF` VARCHAR(14) NOT NULL COMMENT 'CPF do paciente',
  `dataNascimento` DATETIME NOT NULL COMMENT 'Data de nascimento do paciente',
  `email` VARCHAR(100) NOT NULL COMMENT 'Email para contato com o paciente',
  `estadoCivil` VARCHAR(20) NULL COMMENT 'Estado civil do paciente',
  `nacionalidade` VARCHAR(35) NOT NULL COMMENT 'Nacionalidade do paciente',
  `endereco` VARCHAR(200) NOT NULL COMMENT ' Endereco do Paciente',
  `cEP` VARCHAR(9) NOT NULL COMMENT 'CEP de residencia do paciente',
  `uF` VARCHAR(2) NOT NULL COMMENT 'UF de residencia do paciente',
  `pais` VARCHAR(20) NOT NULL COMMENT 'Pais de residencia do paciente',
  `tel1` VARCHAR(15) NOT NULL COMMENT 'Telefone 1 (principal) de contato do Paciente',
  `tel2` VARCHAR(15) NULL COMMENT 'Telefone 2 de contato do Paciente',
  `cel` VARCHAR(15) NULL COMMENT 'Celular de contato do Paciente',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador de paciente ativo',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro do Paciente',
  PRIMARY KEY (`codPaciente`),
  INDEX `codLogin_idx` (`codLogin` ASC),
  CONSTRAINT `codLogin_codPaciente`
    FOREIGN KEY (`codLogin`)
    REFERENCES `TCC`.`Login` (`codLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Administrador` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Administrador` (
  `codAdministrador` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codLogin` INT NULL COMMENT 'Codigo de usuario do administrador',
  `codUnidade` INT NULL COMMENT 'Codigo de unidade do administrador',
  `nomeAdministrador` VARCHAR(65) NOT NULL COMMENT 'Nome do Administrador',
  `cPF` VARCHAR(14) NOT NULL COMMENT 'CPF do Administrador',
  `dataNascimento` DATETIME NOT NULL COMMENT 'Data de nascimento do administrador',
  `email` VARCHAR(100) NOT NULL COMMENT 'Email de contato com o Administrador',
  `estadoCivil` VARCHAR(20) NULL COMMENT 'Estado civil do administrador',
  `nacionalidade` VARCHAR(40) NOT NULL COMMENT 'Nacionalidade do Administrador',
  `endereco` VARCHAR(200) NOT NULL COMMENT ' Endereco do Administrador',
  `cEP` VARCHAR(9) NOT NULL COMMENT 'CEP de residencia do administrador',
  `cidade` VARCHAR(50) NOT NULL COMMENT 'Cidade de residencia do administrador',
  `uF` VARCHAR(2) NOT NULL COMMENT 'UF de residencia do administrador',
  `pais` VARCHAR(20) NOT NULL COMMENT 'Pais de residencia do administrador',
  `tel1` VARCHAR(15) NOT NULL COMMENT 'Telefone 1 (principal) de contato do Administrador',
  `tel2` VARCHAR(15) NULL COMMENT 'Telefone 2 de contato do Administrador',
  `cel` VARCHAR(15) NULL COMMENT 'Celular de contato do Administrador',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se o administrador esta ativo',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro do administrador',
  PRIMARY KEY (`codAdministrador`),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  INDEX `codLogin_idx` (`codLogin` ASC),
  CONSTRAINT `codUnidade_codAdministrador`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codLogin_codAdministrador`
    FOREIGN KEY (`codLogin`)
    REFERENCES `TCC`.`Login` (`codLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Plano`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Plano` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Plano` (
  `codPlano` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `nomePlano` VARCHAR(45) NOT NULL COMMENT 'Nome do Plano',
  `registroAns` VARCHAR(45) NOT NULL COMMENT 'Registro ANS do Plano',
  `tipoPlano` VARCHAR(45) NOT NULL COMMENT 'Tipo de plano (Plus/Premium/Basico...)',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se o Plano esta ativo',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro do plano',
  PRIMARY KEY (`codPlano`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`AssociativaPlanoUnidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`AssociativaPlanoUnidade` ;

CREATE TABLE IF NOT EXISTS `TCC`.`AssociativaPlanoUnidade` (
  `codAssoc` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codPlano` INT NULL COMMENT 'Codigo do Plano que a unidade atende',
  `codUnidade` INT NULL COMMENT 'Codigo da unidade para cada plano atendido',
  PRIMARY KEY (`codAssoc`),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  INDEX `codPlano_idx` (`codPlano` ASC),
  CONSTRAINT `codUnidade_codAssoc`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codPlano_codAssoc`
    FOREIGN KEY (`codPlano`)
    REFERENCES `TCC`.`Plano` (`codPlano`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Consulta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Consulta` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Consulta` (
  `codConsulta` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codMedico` INT NULL COMMENT 'Codigo do medico responsavel pela consulta',
  `codPaciente` INT NULL COMMENT 'Codigo do paciente da consulta',
  `codUnidade` INT NULL COMMENT 'Codigo da unidade onde esta sendo feita a consulta',
  `statusConsulta` VARCHAR(45) NOT NULL COMMENT 'Status da consulta (Andamento/Finalizada/Retorno)',
  `diagnostico` VARCHAR(200) NOT NULL COMMENT 'Diagnostico apresentado na consulta',
  `dataConsultaInicio` DATETIME COMMENT 'Data de realizacao consulta',
  `dataConsultaFim` DATETIME COMMENT 'Data de realizacao consulta',
  `valorConsulta` VARCHAR(45) NOT NULL COMMENT 'Valor da consulta',
  PRIMARY KEY (`codConsulta`),
  INDEX `codMedico_idx` (`codMedico` ASC),
  INDEX `codPaciente_idx` (`codPaciente` ASC),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  CONSTRAINT `codMedico_codConsulta`
    FOREIGN KEY (`codMedico`)
    REFERENCES `TCC`.`Medico` (`codMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codPaciente_codConsulta`
    FOREIGN KEY (`codPaciente`)
    REFERENCES `TCC`.`Paciente` (`codPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codUnidade_codConsulta`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Exame` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Exame` (
  `codExame` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codPaciente` INT NULL COMMENT 'Codigo do paciente do exame',
  `codMedico` INT NULL COMMENT 'Codigo do medico responsavel no Exame',
  `codConsulta` INT NULL COMMENT 'Codigo da consulta relacionada a promocao',
  `descricao` VARCHAR(500) NOT NULL COMMENT 'Descricao do Exame',
  `resultado` VARCHAR(100) NOT NULL COMMENT 'Resultado do Exame',
  `valorExame` VARCHAR(45) NOT NULL COMMENT 'Valor do exame',
  PRIMARY KEY (`codExame`),
  INDEX `codPaciente_idx` (`codPaciente` ASC),
  INDEX `codMedico_idx` (`codMedico` ASC),
  INDEX `codConsulta_idx` (`codConsulta` ASC),
  CONSTRAINT `codPaciente_codExame`
    FOREIGN KEY (`codPaciente`)
    REFERENCES `TCC`.`Paciente` (`codPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codMedico_codExame`
    FOREIGN KEY (`codMedico`)
    REFERENCES `TCC`.`Medico` (`codMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codConsulta_codExame`
    FOREIGN KEY (`codConsulta`)
    REFERENCES `TCC`.`Consulta` (`codConsulta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Promocao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Promocao` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Promocao` (
  `codPromocao` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codUnidade` INT NULL COMMENT 'Codigo da unidade onde a promocao esta ativa',
  `codExame` INT NULL COMMENT 'Codigo do exame que esta incluido na promocao',
  `codPaciente` INT NULL COMMENT 'Codigo do paciente ',
  `valorPromocao` DECIMAL(10,2) NOT NULL COMMENT 'Valor da promocao',
  `dataInicio` DATETIME COMMENT 'Data de inicio da promocao',
  `dataTermino` DATETIME COMMENT 'Data que a promocao termina',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se a promocao esta ativa',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro da promocao',
  PRIMARY KEY (`codPromocao`),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  INDEX `codExame_idx` (`codExame` ASC),
  INDEX `codPaciente_idx` (`codPaciente` ASC),
  CONSTRAINT `codUnidade_codPromocao`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codExame_codPromocao`
    FOREIGN KEY (`codExame`)
    REFERENCES `TCC`.`Exame` (`codExame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codPaciente_codPromocao`
    FOREIGN KEY (`codPaciente`)
    REFERENCES `TCC`.`Paciente` (`codPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`PreTriagem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`PreTriagem` ;

CREATE TABLE IF NOT EXISTS `TCC`.`PreTriagem` (
  `codPreTriagem` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria ',
  `codPaciente` INT NULL COMMENT 'Codigo do paciente desta triagem',
  `alergiaMedicamento` VARCHAR(1000) NOT NULL COMMENT 'Descricao da pre-triagem (Sintomas)',
  `alergiaAlimentares` VARCHAR(1000) NOT NULL COMMENT 'Observacoes de alergias',
  `peso` DECIMAL(3,2) NOT NULL COMMENT 'Peso atual',
  `altura` DECIMAL(3,2) NOT NULL COMMENT 'Altura atual',
  `medicamentoContinuo` VARCHAR(500) NOT NULL COMMENT 'Uso de medicamentos continuos e controlados',
  `cirurgia` VARCHAR(45) NOT NULL COMMENT 'Cirurgias recentes, vale os ultimos 2 anos',
  `antecedentesPessoais` VARCHAR(100) NOT NULL COMMENT 'Se existem doencas cronicas na familia',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se a pre-triagem esta ativa.',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro da pre-triagem',
  PRIMARY KEY (`codPreTriagem`),
  INDEX `codPaciente_idx` (`codPaciente` ASC),
  CONSTRAINT `codPaciente_codPreTriagem`
    FOREIGN KEY (`codPaciente`)
    REFERENCES `TCC`.`Paciente` (`codPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Receituario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Receituario` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Receituario` (
  `codReceituario` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codMedico` INT NULL COMMENT 'Codigo do medico responsavel pela receita',
  `codPaciente` INT NULL COMMENT 'Codigo do paciente atribuido a receita',
  `codUnidade` INT NULL COMMENT 'Codigo da unidade onde foi gerada a receita',
  `descricaoReceita` VARCHAR(500) NOT NULL COMMENT 'Descricao sobre a receita',
  `qtdDose` VARCHAR(45) NOT NULL COMMENT 'Quantidade de doses da medicacao',
  `periodo` VARCHAR(45) NOT NULL COMMENT 'Periodo de medicacao',
  `duracao` VARCHAR(45) NOT NULL COMMENT 'Duracao da medicacao',
  `recomendacoes` VARCHAR(45) NOT NULL COMMENT 'Recomendacoes do medico',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Inidicador se a receita esta ativa.',
  `dataLimite` DATE NOT NULL COMMENT 'Data limite para vencimento da receita.',
  PRIMARY KEY (`codReceituario`),
  INDEX `codMedico_idx` (`codMedico` ASC),
  INDEX `codPaciente_idx` (`codPaciente` ASC),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  CONSTRAINT `codMedico_codReceituario`
    FOREIGN KEY (`codMedico`)
    REFERENCES `TCC`.`Medico` (`codMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codPaciente_codReceituario`
    FOREIGN KEY (`codPaciente`)
    REFERENCES `TCC`.`Paciente` (`codPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codUnidade_codReceituario`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Agendamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Agendamento` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Agendamento` (
  `codAgendamento` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codPaciente` INT NULL COMMENT 'Codigo do Paciente agendado',
  `codMedico` INT NULL COMMENT 'Codigo do medico que atende o agendamento',
  `codUnidade` INT NULL COMMENT 'Codigo da unidade onde foi agendado',
  `codAtendente` INT NULL COMMENT 'Codigo do atendente que fez o agendamento',
  `dataAgendamento` DATETIME NOT NULL COMMENT 'Data estabelecida para o agendamento',
  `statusAgendamento` VARCHAR(45) NOT NULL COMMENT 'Status do agendamento (A Confirmar/Ativo/Cancelado)',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se o agendamento esta ativo.',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro do agendamento.',
  PRIMARY KEY (`codAgendamento`),
  INDEX `codPaciente_idx` (`codPaciente` ASC),
  INDEX `codMedico_idx` (`codMedico` ASC),
  INDEX `codUnidade_idx` (`codUnidade` ASC),
  INDEX `codAtendente_idx` (`codAtendente` ASC),
  CONSTRAINT `codPaciente_codAgendamento`
    FOREIGN KEY (`codPaciente`)
    REFERENCES `TCC`.`Paciente` (`codPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codMedico_codAgendamento`
    FOREIGN KEY (`codMedico`)
    REFERENCES `TCC`.`Medico` (`codMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codUnidade_codAgendamento`
    FOREIGN KEY (`codUnidade`)
    REFERENCES `TCC`.`Unidade` (`codUnidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codAtendente_codAgendamento`
    FOREIGN KEY (`codAtendente`)
    REFERENCES `TCC`.`Atendente` (`codAtendente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Especialidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Especialidade` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Especialidade` (
  `codEspecialidade` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `descricao` VARCHAR(100) NOT NULL COMMENT 'Descricao da especialidade',
  `flagAtivo` BIT NULL DEFAULT 1 COMMENT 'Indicador se a especialidade esta ativa.',
  PRIMARY KEY (`codEspecialidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`AssociativaMedicoEspecialidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`AssociativaMedicoEspecialidade` ;

CREATE TABLE IF NOT EXISTS `TCC`.`AssociativaMedicoEspecialidade` (
  `codMedicoEspecialidade` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codMedico` INT NULL COMMENT 'Codigo do medico para o codigo da especialidade',
  `codEspecialidade` INT NULL COMMENT 'Codigo da especialidade do medico',
  PRIMARY KEY (`codMedicoEspecialidade`),
  INDEX `codMedico_idx` (`codMedico` ASC),
  INDEX `codEspecialidade_idx` (`codEspecialidade` ASC),
  CONSTRAINT `codMedico_codMedicoEspecialidade`
    FOREIGN KEY (`codMedico`)
    REFERENCES `TCC`.`Medico` (`codMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codEspecialidade_codMedicoEspecialidade`
    FOREIGN KEY (`codEspecialidade`)
    REFERENCES `TCC`.`Especialidade` (`codEspecialidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`CadernetaVacina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`CadernetaVacina` ;

CREATE TABLE IF NOT EXISTS `TCC`.`CadernetaVacina` (
  `codCaderneta` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codPaciente` INT NULL COMMENT 'Codigo do paciente desta caderneta de vacinas',
  `flagAtivo` BIT NULL COMMENT 'Indicador se a caderneta esta ativa',
  `dataCadastro` DATETIME NOT NULL COMMENT 'Data de cadastro desta caderneta',
  PRIMARY KEY (`codCaderneta`),
  INDEX `codPaciente_idx` (`codPaciente` ASC),
  CONSTRAINT `codPaciente_codCaderneta`
    FOREIGN KEY (`codPaciente`)
    REFERENCES `TCC`.`Paciente` (`codPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`Vacinas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`Vacinas` ;

CREATE TABLE IF NOT EXISTS `TCC`.`Vacinas` (
  `codVacina` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave primaria',
  `faixaEtaria` VARCHAR(45) NOT NULL COMMENT 'Faixa de idade para esta vacina',
  `idade` VARCHAR(3) NOT NULL COMMENT 'Idade exata para tomar esta vacina',
  `dose` DECIMAL(10,2) NOT NULL COMMENT 'Dose em ML desta vacina',
  `doencaEvitada` VARCHAR(200) NOT NULL COMMENT 'Doencas evitadas',
  `observacoes` VARCHAR(150) NULL COMMENT 'Observacoes sobre esta vacina',
  PRIMARY KEY (`codVacina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TCC`.`AssociativaCadernetaVacina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TCC`.`AssociativaCadernetaVacina` ;

CREATE TABLE IF NOT EXISTS `TCC`.`AssociativaCadernetaVacina` (
  `codCadernetaVacina` INT NOT NULL AUTO_INCREMENT COMMENT 'Chave Primaria',
  `codCaderneta` INT NULL COMMENT 'Codigo da caderneta associado a vacina',
  `codVacina` INT NULL COMMENT 'Codigo da vacina associado a caderneta',
  PRIMARY KEY (`codCadernetaVacina`),
  INDEX `codCaderneta_idx` (`codCaderneta` ASC),
  INDEX `codVacina_idx` (`codVacina` ASC),
  CONSTRAINT `codCaderneta_codCadernetaVacina`
    FOREIGN KEY (`codCaderneta`)
    REFERENCES `TCC`.`CadernetaVacina` (`codCaderneta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `codVacina_codCadernetaVacina`
    FOREIGN KEY (`codVacina`)
    REFERENCES `TCC`.`Vacinas` (`codVacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



INSERT INTO `TCC`.`Plano` ( `nomePlano`, `registroAns`, `tipoPlano`, `flagAtivo`, `dataCadastro`)
VALUES ('Dix100', 12355648, 'Premium', 1, '2017-05-20 00:00:00');

SELECT * FROM Tcc.Plano;