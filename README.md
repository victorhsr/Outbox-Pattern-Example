# Outbox Patern - Implementação de exemplo

Este projeto apresenta uma implementação do ``outbox pattern``, servindo de exemplo para o artigo publicado [aqui](http://meu_artigo_url).

Basicamente, temos:
* Um ``producer``, chamado ``user-api``, escrito em java ([Spring](https://spring.io/projects/spring-boot)), ele que implementa de fato o ``outbox``;
* Um ``consumer``, chamado ``recomendations`` escrito em javascript ([Node.js](https://nodejs.org/en/));
* Um ``message broker`` que utiliza o protocolo ``AMQP`` ([RabbitMQ](https://www.rabbitmq.com/));

# Utilização

Para iniciar a aplicação você irá precisar do [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/) devidamente instalados, e então, basta clonar o repositório e executar o comando :
```sh
docker-compose up
```

Para inciar o fluxo, basta realizar uma requisição POST para ``http://localhost:8081/api/v1/user`` com um JSON que segue a seguinte estrutura:
```JSON
    {
        "name": "Victor Hugo",
        "email": "victor.hugo.origins@gmail.com",
        "password": "123123123",
        "gender": "MALE"
    }
```

Será cadastrado um usuário com estes dados, registrada a solicitação de disparo de notificação e eventualmente, um ``schedule service`` irá detectar as mensagens de notificação pendentes e irá publicá-las na queue ``user_created_q`` por meio do nosso ``message broker``. A aplicação ``recomendations`` irá escutar as mensagens e exibir algumas informações sobre ela por meio do sistema de log.

---
Para uma explicação mais detalhada do que está acontecendo e o porque disto, recomendo a leitura do [artigo](http://meu_artigo_url) originou esse trabalho. Boa leitura!
