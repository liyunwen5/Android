package wh.lyw.mvp.presenter;

import wh.lyw.mvp.model.bean.Person;
import wh.lyw.mvp.contract.MainContract;
import wh.lyw.mvp.model.request.MainModel;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Nicholas on 2016/10/30.
 */

public class MainPresenter extends MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel();
    }


    @Override
    public void getGank(final int i) {

        Subscription subscribe = mModel.getGank()
                .subscribe(new Subscriber<Person>() {

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
                    public void onNext(Person gank) {
                        mView.onSucceed(gank ,i);
                    }
                });


        addSubscribe(subscribe);
    }

}
