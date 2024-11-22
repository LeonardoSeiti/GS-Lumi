# Projeto Lume - Global Solution 
O aplicativo de automação residencial é uma solução inovadora que utiliza inteligência artificial (IA) para gerenciar eletrodomésticos de forma eficiente, aprendendo padrões de uso e otimizando o consumo de energia. Com foco na sustentabilidade e na conveniência, o produto é voltado para pessoas que buscam automatizar suas residências e reduzir desperdícios energéticos.

## Integrantes do grupo

- [Ezequiel Bispo de Jesus](https://github.com/EzequielBispo) - RM 99573 - Turma  2TDSPY

- [Helena Cristina](https://github.com/19helena) - RM 551873 - Turma  2TDSPY

- [Kelvin Gomes](https://github.com/kelving0mes) - RM 98126 - Turma  2TDSPN 

- [Leonardo Seiti](https://github.com/LeonardoSeiti) - RM 550207 - Turma  2TDSPN

### Documentação da API
- [Link](https://wb-gs-lumi.azurewebsites.net/swagger-ui/index.html)

### Vídeo demonstração
[Youtube]()

### Requisitos para uso de forma local
- [Maven ver. 3.8.X+](https://maven.apache.org/download.cgi)
- [Java JDK 17](https://www.oracle.com/br/java/technologies/downloads/#java17)
- IDE VSCode or InteliJ
- [Repositório](https://github.com/LeonardoSeiti/GS-Lumi)
- [Spring Boot Extension Pack for VScode](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
- [Extension Pack for Java for VScode](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

  ## Requisitos

- [ ] CRUD de CLientes
- [ ] CRUD de Dispositivos
- [ ] CRUD de Rotinas
- [ ] Autenticação

### Endpoints 

- [Listar Cliente](#listar-cliente)
- [Cadastrar Cliente](#cadastrar-cliente)
- [Apagar Cliente](#apagar-cliente)
- [Atualizar Cliente](#atualizar-cliente)


### Listar Cliente

`GET` /cliente

Retorna um array com os clientes.

#### Exemplo de Resposta

```js
[
    {
      "id": 1,
      "email": "teste@email.com",
      "senha": "$2a$10$8XUVs9yunl2TrdR593uF5eXnmLQNLVXf.FhCa8b6rfnbjroa1Iy9O"
    }
]
```
### Cadastrar Cliente

`POST` /cliente

 Cria o cadastro de clientes.

#### Exemplo de Resposta

```js
[
    {
      "id": 1,
      "email": "teste@email.com",
      "senha": "$2a$10$8XUVs9yunl2TrdR593uF5eXnmLQNLVXf.FhCa8b6rfnbjroa1Iy9O"
    }
]
```

### Apagar Cliente

`DELETE` /cliente/`{id}`

 Deleta o cadastro de clientes.

#### Exemplo de Resposta
Apaga a categoria com o `id` informado no path

### Atualizar Cliente

`PUT` /cliente/`{id}`

Atualiza os dados da categoria com o `id` informado no path, utilizando as informações do corpo da requisição



