package wh.lyw.mvp.model.request;

import wh.lyw.mvp.api.ApiEngine;
import wh.lyw.mvp.model.bean.Person;
import wh.lyw.mvp.model.bean.Weather;
import wh.lyw.mvp.contract.MainContract;
import wh.lyw.mvp.rx.RxSchedulers;
import rx.Observable;

/**
 * Created by Nicholas on 2016/10/30.
 */

public class MainModel implements MainContract.Model,MainContract.SecondModel {
//第一个请求
    @Override
    public Observable<Person> getGank() {
        return ApiEngine.getInstance().getApiService()
                .getGank("1")
                .compose(RxSchedulers.<Person>switchThread());
    }
    //天气第二个请求
    @Override
    public  Observable<Weather> getWeather2(String str) {
        System.out.print("=============="+str);
            return ApiEngine.getInstance().getWeather()
                    .getWeatherss(str,"json","6tYzTvGZSOpYB5Oc2YGGOKt8")
                    .compose(RxSchedulers.<Weather>switchThread());
    }
}
