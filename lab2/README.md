# Lab 2 Java at the server-side and the role of application containers

Neste diretório encontra-se a resolução da ficha Lab2, proposta pela cadeira Introdução à Engenharia de Software, curso de Engenharia Informática da Universidade de Aveiro.

Este README apresenta alguns passos relevantes, e não muito intuitivos, que foram feitos em alguns exercícios (secção 2.1, 2.2, 2.3 e 2.4).

Além disso, contém notas importantes aprendidas na realização deste laboratório (secção Notas).

Por fim, pode-se encontrar as respostas das questões fornecidas na seção Review questions.


## 2.1 Server-side programming with servlets  

### h)
Depois de fazer deploy do ficheiro war deste exercício através do Tomcat management interface, a página deste encontra-se na url: http://localhost:8080/lab2_1-1.0-SNAPSHOT/Alineah .

Como passar parametros???

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
    * O servidor vai ser executado na porta 8680.

## 2.3 Introduction to web apps with a full-featured framework (Spring Boot)

## 2.4 Wrapping-up & integrating concepts   

## Notas:

## Review questions:

### A. What are the responsibilities/services of a “servlet container”?

### B. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.) 

### C. Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies? 

### D. Which annotations are transitively included in the @SpringBootApplication?  

### E. Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them in you own words. 
