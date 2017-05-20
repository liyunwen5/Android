package wh.lyw.mvp.contract;

import wh.lyw.mvp.base.BaseModel;
import wh.lyw.mvp.base.BasePresenter;
import wh.lyw.mvp.base.BaseView;
import wh.lyw.mvp.model.bean.Person;
import wh.lyw.mvp.model.bean.Weather;
import rx.Observable;

/**
 * Created by Nicholas on 2016/10/30.
 */

public interface MainContract {

    interface View<T> extends BaseView {

        void showDialog();

        void onSucceed(T data,int i);

        void onFail(String err);

        void hideDialog();

    }


    interface Model extends BaseModel {
        Observable<Person> getGank();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getGank(int i);
    }
    /**请求天气信息*/
    interface SecondModel extends BaseModel {
        Observable<Weather> getWeather2(String str);
    }

    abstract class Presenter2 extends BasePresenter<View, SecondModel> {
        public abstract void getWeather1(String str,int i);
    }
}
