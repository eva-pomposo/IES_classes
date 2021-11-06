# Lab 2 Java at the server-side and the role of application containers

Neste diretório encontra-se a resolução da ficha Lab2, proposta pela cadeira Introdução à Engenharia de Software, curso de Engenharia Informática da Universidade de Aveiro.

Este README apresenta alguns passos relevantes, e não muito intuitivos, que foram feitos em alguns exercícios (secção 2.1, 2.2, 2.3 e 2.4).

Além disso, contém notas importantes aprendidas na realização deste laboratório (secção Notas).

Por fim, pode-se encontrar as respostas das questões fornecidas na seção Review questions.


## 2.1 Server-side programming with servlets  

### h)
Depois de fazer deploy do ficheiro war deste exercício através do Tomcat management interface, a página deste encontra-se na url: http://localhost:8080/lab2_1-1.0-SNAPSHOT/Alineah .

## 2.2 Server-side programming with embedded servers 

* ficheiro EmbeddedJettyExample.java: Exemplo de Embedded Jetty Server fornecido no site indicado no guiao;
    * Compilar:
    ```
    mvn package
    ```
    * Executar:
    ```
    mvn exec:java -Dexec.mainClass="com.lab2_2.EmbeddedJettyExample"
    ```
    * O servidor vai ser executado na porta 8680.
    
* ficheiro AlineaA: Exemplo de Servlet do exercício 2.1 alinea h com uma abordagem de servidor embutido.
    * Compilar:
    ```
    mvn package
    ```
    * Executar:
    ```
    mvn exec:java -Dexec.mainClass="com.lab2_2.AlineaA"
    ```
    * O servidor vai ser executado na porta 8680;
    * Para passar o parametro username basta ir ao link: http://localhost:8680/?username=Eva (exemplo de passar "Eva" no username)

## 2.3 Introduction to web apps with a full-featured framework (Spring Boot)

### a)
* Compilar:
```
mvn install -DskipTests && java -jar target\webapp1-0.0.1-SNAPSHOT.jar 
```
* Executar:
```
./mvnw spring-boot:run
```

### c)
* Acessar o endpoint através da linha de comandos:
```
curl -v http://localhost:8080/greetingAlineaC?param=eva
```

## Review questions:

### A. What are the responsibilities/services of a “servlet container”?

O “servlet container” gera páginas web dinâmicas usando Java. Interage com os servlets java, comunicando-se entre os navegadores clientes e os servlets.
O fluxo de trabalho do “servlet container” procede-se aproximadamente da seguinte forma: O "servlet container" recebe os pedidos do servidor da web, perante isto, o "servlet container" envia as solicitações para um servlet. O servlet é recuperado e carregado no espaço de endereço do container, o "servlet container" processa os pedidos HTTP, e por fim o servlet da Web gera os dados. 

### B. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.) 

O Spring Boot usa a dinâmica do Model-View-Controller, possui controllers para tratar de requisições e cria modelos com os dados desejados. Os modelos são usados nos templates de View para gerar uma visualização dos dados. O DispatcherServlet do Spring encarrega-se de todas as solicitações para os controllers e oferece outras funcionalidades para ajudar no desenvolvimento de aplicativos da web.

### C. Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies? 

Os Spring Boot starters resolvem o problema de gerenciamento de dependências em um projeto complexo. Os starter POMs são um conjunto de descritores de dependência convenientes que podem ser incluídos no aplicativo, com eles, obtemos todo o Spring, sem ter que procurar por códigos de amostra e copiar e colar os descritores de dependência. 

### D. Which annotations are transitively included in the @SpringBootApplication?  

As anotações incluídas transitivamente no @SpringBootApplication são:
* @EnableAutoConfiguration: ativa o mecanismo de configuração automática do Spring Boot;
* @ComponentScan: ativa a @Component no pacote onde a app está localizada;
* @Configuration: permite registrar beans extras no contexto ou importar classes de configuração adicionais

### E. Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them in you own words. 

As 5 melhores práticas para o design de REST API são:
* REST APIs should accept and respond with JSON: JSON é o padrão para transferência de dados, quase toda tecnologia de rede pode usá-lo;
* Use nouns instead of verbs in endpoint paths: O método de solicitação HTTP já possui o verbo. Os verbos em nossos caminhos de endpoint de API não são úteis;
* Handle errors gracefully and return standard error codes: Mostrar os erros aos utilizadores da API, permite que eles entendem o problema, e assim o consigam resolver (caso o erro não seja tratado no sistema);
* Name collections with plural nouns: Ajuda os programadores iniciantes a entenderem que vamos referenciar vários objetos;
* Allow filtering, sorting, and pagination: Caso o banco de dados seja muito grande, retornar todos os dados irá ser um processo lento e poderá gerar problemas no sistema, o que não acontece se filtrarmos os dados. O paginate dos dados também permite gastar poucos recursos, ao mostrar os resultados por vez. 