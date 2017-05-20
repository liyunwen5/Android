package wh.lyw.mvp.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import wh.lyw.mvp.model.bean.Person;
import wh.lyw.mvp.model.bean.Weather;

/**
 * Created by Nicholas on 2016/10/30.
 */
public interface ApiService {

    String BASE_URL="http://gank.io/";
    String WEATHER_URL="http://api.map.baidu.com/telematics/";

    @GET("api/data/Android/10/{page}")
    Observable<Person> getGank(@Path("page") String page);
    @GET("v3/weather")
    Observable<Weather> getWeatherss(@Query("location") String location, @Query("output") String output, @Query("ak") String ak);


}
