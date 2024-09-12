
# Sobre o uso da API

## Funcionalidade de usuário

### Exemplo para criar um novo usuário
Para adicionar um novo usuário, envie uma requisição em JSON para o seguinte link:

`http://localhost:8080/api/user/add`

Exemplo de corpo da requisição em JSON:

```json
{
    "nome": "João da Silva",
    "cpf": "12345678900",
    "telefone": "(11) 98765-4321",
    "email": "joao.silva@example.com",
    "endereco": "Rua Exemplo, 123, São Paulo, SP",
    "login": "joaosilva",
    "senha": "senhaSecreta123",
    "rank": "usuario"
}
```

### Exemplo para deletar um usuário
Para deletar um usuário, utilize o link abaixo, substituindo `{id}` pelo ID do usuário que deseja excluir:

`http://localhost:8080/api/user/delete{id}`

### Exemplo para atualizar um usuário
Para atualizar os dados de um usuário, envie uma requisição com as informações atualizadas no seguinte link, substituindo `{id}` pelo ID do usuário:

`http://localhost:8080/api/user/update{id}`

Exemplo de corpo da requisição:

```json
{
    "nome": "João da Silva",
    "cpf": "12345678900",
    "telefone": "(11) 98765-4321",
    "email": "joao.silva@example.com",
    "endereco": "Rua Exemplo, 123, São Paulo, SP",
    "login": "joaosilva",
    "senha": "senhaSecreta123"
}
```

## Funcionalidade de login

### Exemplo de autenticação
Para realizar o login, utilize o link abaixo, substituindo `{username}` pelo nome de usuário e `{password}` pela senha:

`http://localhost:8080/api/user/login{username}password{password}`

Exemplo:
`/loginSYNCpassword1415`

Login: `SYNC`  
Senha: `1415`

### Exemplo de recuperação de senha
Para recuperar a senha de um usuário, utilize o link abaixo, substituindo `{email}` pelo e-mail cadastrado:

`http://localhost:8080/api/user/usersLogin{email}`

## Funcionalidade de gerenciamento de veículos

### Exemplo para adicionar um veículo
Para adicionar um novo veículo, envie uma requisição em JSON para o seguinte link:

`http://localhost:8080/api/veiculos/addveiculo`

Exemplo de corpo da requisição:

```json
{
    "clienteID": 1,  // ID do cliente
    "veiculo": "Fusca",
    "placa": "ABC-1234",
    "modelo": "Volkswagen",
    "ano": 1975
}
```

### Exemplo para consultar veículos de um cliente
Para consultar os veículos associados a um cliente, utilize o link abaixo, substituindo `{id}` pelo ID do cliente:

`http://localhost:8080/api/veiculos/consultar/veiculos/{id}`

Exemplo de retorno, caso o cliente com ID 1 possua três veículos:

```json
[
    {
        "id": 1,
        "clienteID": 1,
        "veiculo": "Fusca",
        "placa": "ABC-1234",
        "modelo": "Volkswagen",
        "ano": 1975,
        "stateCar": "Ausente"
    },
    {
        "id": 2,
        "clienteID": 1,
        "veiculo": "Fusca preto",
        "placa": "ABC-X4D",
        "modelo": "Volkswagen",
        "ano": 1975,
        "stateCar": "Ausente"
    },
    {
        "id": 5,
        "clienteID": 1,
        "veiculo": "Fusca",
        "placa": "ABC-1234",
        "modelo": "Volkswagen",
        "ano": 1975,
        "stateCar": "Ausente"
    }
]
```
