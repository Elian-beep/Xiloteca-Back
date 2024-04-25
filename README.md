
# Backend Xiloteca CESIT v2

API Rest dedicado ao controle dos dados e gerência de acessos aos dados catalogados pela Xiloteca CESIT.

## Contribuidores

- [Elian Batista](https://www.linkedin.com/in/elian-batista/)
## Stack utilizada

| **Back-end** |   |
|--------------|---|
| ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) |
| ![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white) | JDK 21 & Maven

## Relacionados

Segue projetos relacionados

[Front-Xiloteca](https://github.com/Elian-beep/Front-Xiloteca)
[Front-Xiloteca-Adm](https://github.com/Elian-beep/Front-Xiloteca-Adm)


## Rodando localmente

Clone o projeto

```bash
  git clone [link_do_clone_Xiloteca-Back]
```

Entre no diretório do projeto

```bash
  cd Back-API-Xiloteca
```

Instale as dependências

```bash
  mvn clean package
```

Inicie o servidor

```bash
  mvn spring-boot:run
```
## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no arquivo application.properties

`spring.data.mongodb.uri`
`spring.data.mongodb.username` `spring.data.mongodb.password`
`api.security.token.secret`


Estas variáveis de ambiente seguem para a conexão com o banco de dados e para a criptografia JWT.


## Público alvo

Esse projeto possui intuito em ser usado pelas seguintes entidades:

- Dashboard administrativo da Xiloteca CESIT


## Funcionalidades

- Visualização dos dados catalogados
- Pesquisa com 4 filtros distintos
- Direcionamento para visualização das fotos das amostras
- Exclusão dos dados
- Alteração das informações
- Login administrativo com segurança criptografada
- Conexão com banco de dados Mongo

