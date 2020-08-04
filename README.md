# iMusica - RPG Battle

## Introdução

 Este projeto tem como objetivo implementar um serviço web REST que simule uma batalha de RPG em turnos, bem como, um cliente em linha de comando que faça uso do serviço REST.

### Prerequisitos

```
JDK 8+
```

### Como executar?

Primeiro, inicie a API pela linha de comando. Navegue pelo terminal até a pasta api e execute o seguinte comando:
```
./mvnw spring-boot:run
```
Por padrão, o serviço irá iniciar na porta 8080.

Em seguida, abra outro terminal e navegue até a pasta client e execute os seguintes comandos:
```
./mvnw compile
./mvnw exec:java
```
Se tudo der certo, será exibida uma tela inicial no terminal solicitando um nickname e um tipo de Héroi.
Informe os dados desejados e aguarde o resultado da batalha.
