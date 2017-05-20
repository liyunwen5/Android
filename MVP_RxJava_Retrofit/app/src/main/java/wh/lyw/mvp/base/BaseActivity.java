package wh.lyw.mvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Nicholas on 2016/10/30.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    /**
     * 这里用来返回res-->layout 里面布局
     */
    public abstract int getLayoutResId();

    /**
     * 加载视图
     */
    protected abstract void init();


    protected abstract P onCreatePresenter();
}
