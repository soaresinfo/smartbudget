# SmartBudget
Sistema para controle financeiro orçamentário familiar

## Pré requisitos para execução local
- Necessário ter instalado docker/podman para execução de testes unitários
- Java versão 17

```Shell Script
#Subindo container mysql
docker compose up -d

#Parando container mysql e limpando dados
docker compose down -v

#Teste de login com curl
curl --json '{"username":"admin","password":"password"}' http://localhost:8080/budget/api/v1/auth/token
```