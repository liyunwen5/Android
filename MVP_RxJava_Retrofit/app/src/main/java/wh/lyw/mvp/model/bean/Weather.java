package wh.lyw.mvp.model.bean;

import java.util.List;

/**
 * Created by 天气预报
 */

public class Weather extends Object {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    private List<Results> results;



    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results {
        private String currentCity;
        private String pm25;
        private Object weather_data;
        private Object index;

        public String getCurrentCity() {
            return currentCity;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public Object getWeather_data() {
            return weather_data;
        }

        public void setWeather_data(Object weather_data) {
            this.weather_data = weather_data;
        }

        public Object getIndex() {
            return index;
        }

        public void setIndex(Object index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Results{" +
                    "currentCity='" + currentCity + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    ", weather_data=" + weather_data +
                    ", index=" + index +
                    '}';
        }
    }

}
