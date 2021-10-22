package com.weatherForecastByCity;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import ipma.apiClient.CityForecast;
import ipma.apiClient.IpmaCityForecast;
import ipma.apiClient.IpmaService;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //private static final int CITY_ID_AVEIRO = 1010500;
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = Logger.getLogger(WeatherStarter.class.getName());

    public static void  main(String[] args ) {
        Map<String, Integer> cities_ids = new HashMap<>();
        final String CITY = args[0];

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        //Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);
        Call<IpmaCityForecast> callSync = service.getCityID();

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            for(CityForecast city : forecast.getData()){
                String cidade = city.getLocal();
                int id = city.getGlobalIdLocal();
                cities_ids.put(cidade, id);
            }

            boolean encontrou_cidade = false;
            for (String city : cities_ids.keySet()) {
                if (city.equalsIgnoreCase(CITY)) {
                    encontrou_cidade = true;
                    
                    retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.ipma.pt/open-data/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    
                    service = retrofit.create(IpmaService.class);
                    callSync = service.getForecastForACity(cities_ids.get(city));

                    try {
                        apiResponse = callSync.execute();
                        forecast = apiResponse.body();

                        logger.info("\n");
                        logger.info("-----Previsão Meteorológica Diária até 5 dias na cidade de " + CITY +"-----");
                        logger.info("\n");

                        if (forecast != null) {
                            int count = 1;
                            for (CityForecast cidade : forecast.getData()) {
                                logger.info(count + "º dia:");
                                logger.info("Temperatura mínima: " + cidade.getTMin());
                                logger.info("Temperatura máxima: " + cidade.getTMax());
                                logger.info("\n");
                                count++;
                            }
                        } else {
                            logger.info( "No results!");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
    
                }
            }

            logger.info("A cidade " + CITY + " é inválida!");
            System.exit(0);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}