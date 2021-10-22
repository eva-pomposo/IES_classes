# Lab 1 Team practices for enterprise Java development

Neste diretório encontra-se a resolução da ficha Lab1, proposta pela cadeira Introdução à Engenharia de Software, curso de Engenharia Informática da Universidade de Aveiro.

Este README apresenta alguns passos relevantes, e não muito intuitivos, que foram feitos em alguns exercícios (secção 1.2, 1.3 1.4 e 1.5).

Além disso, contém notas importantes aprendidas na realização deste laboratório (secção Notas).

Por fim, pode-se encontrar as respostas das questões fornecidas na seção Review questions.


## 1.2 Build management with the Maven tool 

### e) 
As convenções de nomenclatura para groupId e artifactId, nesta alínea, são respetivamente, com.myweather.radar e my-weather-radar.

### g)
Alterei a versão java usada pelo compilador para a versão 11 (como o exemplo sugerido no enunciado);
Adicionei as seguintes propriedades, uma licença, uma organização, e um desenvolvedor;
Defini a codificação por meio da configuração, usando o UTF-8.

### h)
Declarei as dependências para a biblioteca Retrofit e Gson com a versão 2.9.0, para ambas, no POM.xml.

### j)
Efetuei a compilação e execução do projeto através da linha de comandos, no seguinte diretório: IES_98513/lab1/lab1_2/my-weather-radar, usando assim o seguinte comando para executar:
```
mvn exec:java -Dexec.mainClass="main.java.com.myweather.radar.WeatherStarter"
```
### k)
Efetuei a compilação e execução do projeto através da linha de comandos, no seguinte diretório: IES_98513/lab1/lab1_2/my-weather-radar, usando assim o seguinte comando para executar: 
```
mvn exec:java -Dexec.mainClass="main.java.com.myweather.radar.WeatherStarter" -Dexec.args="1010500"
```

## 1.4 Source code management using Git
### d)
Segunda alternativa

## 1.5 Wrapping-up & integrating concepts
No ficheiro pom.xml do projeto maven WeatherForecastByCity adicionei a dependência:
```
	<groupId>com.weatherForecastByCity</groupId>
  	<artifactId>WeatherForecastByCity</artifactId>
  	<version>1.0-SNAPSHOT</version>
```
Para compilar e executar o projeto realizei os seguintes passos respectivamente:

* no projeto IpmaApiClient:
``` 
mvn package
``` 

* Realizei o seguinte comando no projeto WeatherForecastByCity:
```
mvn install:install-file -Dfile="/home/eva/Documents/IES_98513/lab1/lab1_5/IpmaApiClient/target/IpmaApiClient-1.0-SNAPSHOT.jar" -DgroupId="ipma.apiClient" -DartifactId="IpmaApiClient" -Dversion="1.0-SNAPSHOT" -Dpackaging=jar 
```

* Ainda no projeto WeatherForecastByCity compilei e depois executei com o comando:
```
mvn exec:java -Dexec.mainClass="com.weatherForecastByCity.WeatherStarter" -Dexec.args="Aveiro"  
```

## Notas:

* Maven archetype: Archetype é uma Ferramenta de templates de projetos Maven, isto é, é um padrão que os projetos usando-o, seguem. Permite que os autores de projetos Maven forneçam templates para os utilizadores seguirem. 

* groupId: Identifica unicamente o projeto, deve seguir as "Java's package name rules", isto é, o mesmo começa pelo domain name revertido.

* artifactId: O nome do ficheiro jar (código compilado) sem a versão.

### Os comandos mais uteis no Maven:

Criar projeto Maven:
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
 ```

Compilar projeto:
```
 mvn package
```

Executar projeto:
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

## Review questions:

### A) Maven has three lifecycles: clean, site and default. Explain the main phases in the default lifecycle.
##### Lifecycle Phases

* validate: validate the project is correct and all necessary information is available
* compile: compile the source code of the project
* test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
* package: take the compiled code and package it in its distributable format, such as a JAR.
* integration-test: process and deploy the package if necessary into an environment where integration tests can be run
* verify: run any checks to verify the package is valid and meets quality criteria
* install: install the package into the local repository, for use as a dependency in other projects locally
* deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.

There are two other Maven lifecycles of note beyond the default list above. They are

* clean: cleans up artifacts created by prior builds
* site: generates site documentation for this project

### B) Maven is a build tool; is it appropriate to run your project to? 
O Maven é apropriado para correr um projeto, porque pode-se construir facilmente o projeto para jar de acordo com seus requisitos usando o Maven, além disso o maven pode adicionar todas as dependências precisas para o projeto automaticamente lendo o ficheiro pom, facilita o início do projeto em diferentes ambientes e não é necessário lidar com a injeção de dependências, compilação e processamento.

### C) What would be a likely sequence of Git commands required to contribute with a new feature to a given project? (i.e., get a fresh copy, develop some increment, post back the added functionality) 
* git pull
* git add .
* git commit -m "Lab 1 completed"
* git push
### D) There are strong opinions on how to write Git commit messages... Find some best practices online and give your own informed recommendations on how to write good commit messages (in a team project).  

Dicas de como escrever mensagens commit encontradas na internet:
* Separate subject from body with a blank line
* Limit the subject line to 50 characters
* Capitalize the subject line
* Do not end the subject line with a period
* Use the imperative mood in the subject line
* Wrap the body at 72 characters
* Use the body to explain what and why vs. how

Dicas que recomendo para escrever mensagens commit:
* Durante a realização de um projeto fazer commits assim que atingir um sub objetivo do projeto;
* Não fazer commits quando a compilação e execução do projeto dá  erro. 

### E) Docker automatically prepares the required volume space as you start a container. Why is it important that you take an extra step configuring the volumes for a (production) database?

Volumes são importantes para containers onde é necessário persistir os dados do mesmo em caso de falha. Em casos como o deploy de uma base de dados em Docker, os volumes são utilizados pois o Docker irá eliminar os dados quando o container é encerrado.
Além disso, os volumes são uma escolha melhor do que dados persistentes na camada gravável de um container, porque um volume não aumenta o tamanho dos containers que o utilizam, e o conteúdo do volume existe fora do ciclo de vida de um determinado container.