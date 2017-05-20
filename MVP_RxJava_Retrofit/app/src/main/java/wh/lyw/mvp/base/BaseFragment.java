package wh.lyw.mvp.base;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import butterknife.ButterKnife;

/**
 * Created by Nicholas on 2016/11/5.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P mPresenter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setSystemBarTransparent();
        if (getContentViewLayoutID() != 0) {
            return inflater.inflate(getContentViewLayoutID(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initViewsAndEvents(view);
    }
    protected abstract void initViewsAndEvents(View view);





    @Override
    public void onResume() {
        super.onResume();

        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }

    }

    /**
     * 这里用来返回res-->layout 里面布局
     */
    protected abstract int getContentViewLayoutID();


    /**
     * 初始化状态栏
     */
    private void setSystemBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 沉浸式状态栏 就是让顶部状态栏透明的设置
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // KITKAT解决方案
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    protected abstract P onCreatePresenter();
}
