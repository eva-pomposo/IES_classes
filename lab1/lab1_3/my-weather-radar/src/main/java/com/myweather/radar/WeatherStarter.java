package com.myweather.radar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.myweather.radar.IpmaCityForecast;
import com.myweather.radar.IpmaService;
import com.myweather.radar.CityForecast;

import java.util.logging.Logger;

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
        final int CITY_ID = Integer.parseInt(args[0]);

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        //Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info( "max temp for today: " + forecast.getData().
                        listIterator().next().getTMax());
            } else {
                logger.info( "No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info(" === Meteorologia para os próximos cinco dias === ");
                int counter = 1;
                for(CityForecast meteorologia : forecast.getData()) {
                    String dia = (counter == 1) ? "Hoje" : (counter == 2) ? "Amanhã" : String.valueOf(counter) + "º dia";
                    logger.info(" ================================================ ");
                    logger.info("                        " + dia + "                ");
                    logger.info( "Temperatura mínima: " + meteorologia.getTMin() + "ºC");
                    logger.info( "Temperatura máxima: " + meteorologia.getTMax() + "ºC");
                    logger.info( "Direção vento: " + meteorologia.getPredWindDir());
                    logger.info( "Probabilidade de precipitação: " + meteorologia.getPrecipitaProb() + "%");
                    counter++;
                }
            } else {
                logger.info( "ID de cidade inexistente na base de dados");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}