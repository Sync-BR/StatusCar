# Sobre o uso do api
...
## Funcionalidade de usuário.
### Exemplo para criar um novo usuario
Link para adicioanr usuario em json: `http://localhost:8080/api/user/add`

    {
    "nome": "João da Silva",
    "cpf": "12345678900",
    "telefone": "(11) 98765-4321",
    "email": "joao.silva@example.com",
    "endereco": "Rua Exemplo, 123, São Paulo, SP",
    "login": "joaosilva",
    "senha": "senhaSecreta123"
    }
### Exemplo para deletar um usuario
Link para deletar um usuario: http://localhost:8080/api/user/delete{ìd} <-Adicione o id no final do link>

### Exemplo para efetuar uma atualização de um usuario
Link para update:  http://localhost:8080/api/user/update{id}
corpo para enviar com os dados atualizado.

        {
        "nome": "João da Silva",
        "cpf": "12345678900",
        "telefone": "(11) 98765-4321",
        "email": "joao.silva@example.com",
        "endereco": "Rua Exemplo, 123, São Paulo, SP",
        "login": "joaosilva",
        "senha": "senhaSecreta123"
        }

## Funcionalide de login.
..
### Exemplo de autenticação
Link para efetuar o login: http://localhost:8080/api/user/login{username}password{password}
Substituir os parametros {} pelo usuario e senha, Exemplo: /loginSYNCpassword1415

Login: SYNC

Senha: 1415
### Exemplo de recuperação de senha:
Link para recuperar uma senha: http://localhost:8080/api/user/usersLogin{email}
Substituir {} pelo email cadastrado.

