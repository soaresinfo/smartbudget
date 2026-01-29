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

curl -X GET http://localhost:8080/budget/api/v1/expenses   -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc2OTE5Nzk5NiwiZXhwIjoxNzY5MTk5NDM2fQ.diKSr3BHKl7S-zWo7Csr3yBbleG4Ro9Qim6pntpO7Ec"   -H "Content-Type: application/json"

#Conectando no mysql
mysql -h 127.0.0.1 -P3306 -u root -proot
```