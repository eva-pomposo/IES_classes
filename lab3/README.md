# Lab 3 Multi-layer web applications with Spring Boot

Neste diretório encontra-se a resolução da ficha Lab3, proposta pela cadeira Introdução à Engenharia de Software, curso de Engenharia Informática da Universidade de Aveiro.

Este README apresenta alguns passos relevantes, e não muito intuitivos, que foram feitos em alguns exercícios (secção 3.1, 3.2 e 3.3).

Por fim, pode-se encontrar as respostas das questões fornecidas na seção Review questions.

## 3.1 Accessing databases in SpringBoot 

### b)

1. **The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?**
O novo repository é instanciado através da anotaçao @Autowired.

2. **List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?**
Os métodos invocados no “userRepository” pelo “UserController” sao:
* findAll()
* save(user)
* findById(id)
* delete(user)

Os métodos sao defenidos na classe "UserRepository", estes sao herdados pela interface CrudRepository.

3. **Where is the data being saved?**
Na Base de dados in-memory.

4. **Where is the rule for the “not empty” email address defined?**
Na classe User, na seguinte anotaçao: @NotBlank(message = "Phone is mandatory")

## 3.2 Multilayer applications: exposing data with REST interface

Para testar a minha aplicaçao usando o Postman segui os seguintes passos:

* Comando para remover todos os Docker que estavam a correr:
    ```
    docker rm -f $(docker ps -aq)
    ```

* Comando para correr o Docker:
    ```
    docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d    mysql/mysql-server:5.7
    ```

* Comando para instalar o Postman:
    ```
    sudo snap install postman 
    ```

* Comando para correr a aplicaçao:
    ```
   ./mvnw spring-boot:run
    ```

* Abrir o Postman, e criar um basico HTTP request: "Create a basic HTTP request"

* Seguir as capturas de ecra que se podem encontrar na pasta...


## 3.3 Wrapping-up and integrating concepts


## Review questions:

### A. Explain the differences between the RestController and Controller components used in different parts of this lab. 

The @Controller is a common annotation that is used to mark a class as Spring MVC Controller while @RestController is a special controller used in RESTFul web services and the equivalent of @Controller + @ResponseBody.

### B. Create a visualization of the Spring Boot layers (UML diagram or similar), displaying the key abstractions in the solution of 3.3, in particular: entities, repositories, services and REST controllers. Describe the role of the elements modeled in the diagram.

### C. Explain the annotations @Table, @Colum, @Id found in the Employee entity. 

O nome da tabela, onde a entidade Employee é guardada, é atribuida da seguinte forma: @Table(name=tableName)

O nome das colunas da tabela sao atribuidas da seguinte forma: @Column(name = "colname", nullable = boolean)

O nome do atributo da chave primária é identificado da seguinte forma: @Id. Com o @GeneratedValue é possivel defenir a estrategia, para a geraçao da chave. Por exemplo, caso queiramos que este atributo seja gerado automaticamente após a inserçao de um Employee, defenimos a estrategia GenerationType.AUTO com a anotaçao @GeneratedValue.

### D. Explain the use of the annotation @AutoWired (in the Rest Controller class). 

A anotaçao @AutoWired serve para injetar o bean de um repository numa variável. É uma anotaçao de injeçao de dependencia. 