# Lab 1 Team practices for enterprise Java development

## 1.2 Build management with the Maven tool 

Maven archetype:

As convenções de nomenclatura para groupId e artifactId são respetivamente, com.myweather.radar e my-weather-radar.

Alinea g: Alterei a versao java usada pelo compilador para a versao 11 (como o exemplo sugerido no enunciado); Adicionei as seguintes propriedades, uma licença, uma organizaçao, e um desenvolvedor; Defini a codificação por meio da configuração, usando o UTF-8.

Alinea h: Declarei as dependencias para a biblioteca Retrofit e Gson com a versao 2.9.0, para ambas, no POM.xml.

Alinea j: Efetuei a compilaç~ao e execuçao do projeto através da linha de comandos, no seguinte diretório: IES_98513/lab1/lab1_2/my-weather-radar, usando assim o seguinte comando para executar: mvn exec:java -Dexec.mainClass="main.java.com.myweather.radar.WeatherStarter"

Alinea k: Efetuei a compilaç~ao e execuçao do projeto através da linha de comandos, no seguinte diretório: IES_98513/lab1/lab1_2/my-weather-radar, usando assim o seguinte comando para executar: mvn exec:java -Dexec.mainClass="main.java.com.myweather.radar.WeatherStarter" -Dexec.args="1010500" 

## 1.3 Source code management using Git

## 1.4 Source code management using Git
Aliena d: segunda alternativa

## 1.5 Wrapping-up & integrating concepts
No ficheiro pom.xml do projeto maven WeatherForecastByCity adicionei a dependencia:
	<groupId>com.weatherForecastByCity</groupId>
  	<artifactId>WeatherForecastByCity</artifactId>
  	<version>1.0-SNAPSHOT</version>
  	
mvn package no projeto IpmaApiClient;

Realizei o seguinte comando no projeto WeatherForecastByCity: mvn install:install-file -Dfile="/home/eva/Documents/IES_98513/lab1/lab1_5/IpmaApiClient/target/IpmaApiClient-1.0-SNAPSHOT.jar" -DgroupId="ipma.apiClient" -DartifactId="IpmaApiClient" -Dversion="1.0-SNAPSHOT" -Dpackaging=jar 

E dps este comando:
mvn exec:java -Dexec.mainClass="com.weatherForecastByCity.WeatherStarter" -Dexec.args="Aveiro"  

## Notas:
gitignore n funciona;
alinea e do 1.4

###Os comandos mais uteis no Maven:
 
## Review questions  
