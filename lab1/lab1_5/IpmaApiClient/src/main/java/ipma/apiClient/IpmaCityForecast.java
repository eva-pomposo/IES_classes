package ipma.apiClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * list of city's forecasts (class was generated by jsonschema2pojo )
 */
public class IpmaCityForecast {

        @SerializedName("owner")
        @Expose
        private String owner;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("data")
        @Expose
        private List<CityForecast> data = null;
        
        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public List<CityForecast> getData() {
            return data;
        }

        public void setData(List<CityForecast> data) {
            this.data = data;
        }

}

