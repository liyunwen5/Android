package wh.lyw.mvp.ui.activity;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import wh.lyw.mvp.R;
import wh.lyw.mvp.base.BaseActivity;
import wh.lyw.mvp.model.bean.Weather;
import wh.lyw.mvp.contract.MainContract;
import wh.lyw.mvp.presenter.SecondPresenter;
/**
 * Created by Thinkpad-e470 on 2017/4/22.
 */

public class SecondActivity extends BaseActivity<SecondPresenter> implements MainContract.View<Weather> {
    private static int WEATHER_URL1 = 1;
    private ProgressDialog mDialog;
    @BindView(R.id.button)
    public TextView mButton;
    @Override
    public int getLayoutResId() {
        return R.layout.activity_second;
    }
    @Override
    protected void init() {
        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setCancelable(false);
        mDialog.setMessage("正在李玉文");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getWeather1("南京",WEATHER_URL1);
            }
        });
    }

    @Override
    protected SecondPresenter onCreatePresenter() {
        return new SecondPresenter(this);
    }

    @Override
    public void showDialog() {
            mDialog.show();
    }
    @Override
    public void onSucceed(Weather weather,int i) {
        if(i==WEATHER_URL1){
            Toast.makeText(this, "请求成功"+weather.getResults().get(0).getWeather_data().toString(), Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onFail(String err) {
    }

    @Override
    public void hideDialog() {
        mDialog.dismiss();
    }
}
