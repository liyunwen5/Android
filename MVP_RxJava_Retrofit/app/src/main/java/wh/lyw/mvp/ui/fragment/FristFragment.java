package wh.lyw.mvp.ui.fragment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import wh.lyw.mvp.R;
import wh.lyw.mvp.base.BaseFragment;
import wh.lyw.mvp.presenter.MainPresenter;

/**
 * Created by Thinkpad-e470 on 2017/4/30.
 */

public class FristFragment extends BaseFragment<MainPresenter> {
    @BindView(R.id.wenwen)
    TextView mTextview;

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_frist;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        mTextview.setText("逼荷");
    }


    @Override
    protected MainPresenter onCreatePresenter() {
        return null;
    }
}
