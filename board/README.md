# Board de Tarefas

Projeto em **Java com Spring Boot** para gerenciar tarefas, com CRUD completo e filtros por status, prioridade e responsável. Ideal para portfólio e aprendizado de desenvolvimento backend.

---

## **Funcionalidades**

- Criar, listar, atualizar e deletar tarefas
- Filtrar tarefas por:
    - Status (`TO_DO`, `IN_PROGRESS`, `DONE`)
    - Prioridade (`LOW`, `MEDIUM`, `HIGH`)
    - Usuário responsável
- Banco de dados H2 em memória com dados de exemplo (`data.sql`)
- Estrutura organizada em camadas: Controller → Service → Repository → Model

---

## **Tecnologias**

- Java 17+
- Spring Boot 3+
- Spring Data JPA
- H2 Database
- Maven ou Gradle
- Lombok (opcional)

---

## **Estrutura do projeto**
```
board/
├─ src/main/java/com/board/
│ ├─ BoardApplication.java
│ ├─ model/Task.java
│ ├─ repository/TaskRepository.java
│ ├─ service/TaskService.java
│ └─ controller/TaskController.java
├─ src/main/resources/
│ ├─ application.properties
│ └─ data.sql
├─ .gitignore
└─ pom.xml (ou build.gradle)
```

## **Configuração e execução**
```
1. Clone o repositório:
git clone <URL_DO_REPOSITORIO>
cd board

2. Rode a aplicação:
mvn spring-boot:run
# ou com Gradle
./gradlew bootRun

3. Acesse o console H2 (opcional):
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:boarddb
User: sa
Password: (vazio)

```
## **Endpoints REST**

```
             ----- CRUD BÁSICO -----
| Método | Endpoint    | Descrição               |
| ------ | ----------- | ----------------------- |
| POST   | /tasks      | Criar nova tarefa       |
| GET    | /tasks      | Listar todas as tarefas |
| PUT    | /tasks/{id} | Atualizar tarefa por ID |
| DELETE | /tasks/{id} | Deletar tarefa por ID   |
```
```
                          ----- Filtros avançados ----- 
| Método | Endpoint                                   | Descrição                       |
| ------ | ------------------------------------------ | ------------------------------- |
| GET    | /tasks/status/{status}                     | Listar tarefas por status       |
| GET    | /tasks/priority/{priority}                 | Listar tarefas por prioridade   |
| GET    | /tasks/assignee/{assignee}                 | Listar tarefas por responsável  |
| GET    | /tasks/status/{status}/priority/{priority} | Listar por status + prioridade  |
| GET    | /tasks/status/{status}/assignee/{assignee} | Listar por status + responsável |
```
# **Exemplo de requisição**
Criar uma nova tarefa via POST /tasks:
```
{
"title": "Aprender Spring Boot",
"description": "Estudar Spring Boot do zero",
"status": "TO_DO",
"priority": "HIGH",
"assignee": "Fernando",
"createdAt": "2025-08-25T10:00:00"
}
```

# **Observações:**
• O banco H2 é em memória, então os dados reiniciam a cada execução.

• Para contribuir, edite o código e faça commit normalmente.

• Dados de exemplo são carregados automaticamente via data.sql.

```
Autor:
• Fernando Luiz.
• Projeto para aprendizado e portfólio backend Java.
• https://www.linkedin.com/in/xfernandoluiz/