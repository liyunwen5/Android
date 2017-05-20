package wh.lyw.mvp.presenter;
import wh.lyw.mvp.model.bean.Weather;
import wh.lyw.mvp.contract.MainContract;
import wh.lyw.mvp.model.request.MainModel;
import rx.Subscriber;
import rx.Subscription;
/**
 * Created by Thinkpad-e470 on 2017/4/22.
 */
public class SecondPresenter extends MainContract.Presenter2 {

    public SecondPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel();
    }

    @Override
    public void getWeather1(String str, final int i) {
        Subscription subscribe = mModel.getWeather2(str)
                .subscribe(new Subscriber<Weather>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFail(e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(Weather weather) {
                        mView.onSucceed(weather,i);
                    }
                });


        addSubscribe(subscribe);

    }
}
