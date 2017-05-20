package wh.lyw.mvp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import wh.lyw.mvp.R;
import wh.lyw.mvp.adapter.ThirdTabPagerAdapter;
import wh.lyw.mvp.base.BaseActivity;
import wh.lyw.mvp.base.BasePresenter;
import wh.lyw.mvp.ui.fragment.FristFragment;

/**
 * Created by Thinkpad-e470 on 2017/4/30.
 */

public class ThirdActivity extends BaseActivity{
    @BindView(R.id.viewPager)
    public ViewPager viewPager;
    @BindView(R.id.iv_home)
    public ImageView ivHome;
    @BindView(R.id.iv_msg)
    public ImageView ivMsg;
    @BindView(R.id.iv_frame)
    public ImageView ivFrame;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_third;
    }
    @Override
    protected void init() {
        viewPager.addOnPageChangeListener(fragmentChangeListener);
        initFragments();
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    private void initFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new FristFragment());
        fragments.add(new FristFragment());
        fragments.add(new FristFragment());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new ThirdTabPagerAdapter(
                getSupportFragmentManager(), fragments));
        viewPager.setCurrentItem(0);
    }

    @OnClick({R.id.ll_home, R.id.ll_msg, R.id.ll_frame})
    public void bottomClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                viewPager.setCurrentItem(0);
                setBottomImage(1);
                break;
            case R.id.ll_msg:
                viewPager.setCurrentItem(1);
                setBottomImage(2);
                break;
            case R.id.ll_frame:
                viewPager.setCurrentItem(2);
                setBottomImage(3);
                break;

        }
    }

    /**
     * 设置底部按钮图片
     */
    private void setBottomImage(int type) {
        switch (type) {
            case 1:
                resetBottomBtn();
                ivHome.setImageResource(R.mipmap.tab_shouye_up);
                break;
            case 2:
                resetBottomBtn();
                ivMsg.setImageResource(R.mipmap.tab_xinxi_up);
                break;
            case 3:
                resetBottomBtn();
                ivFrame.setImageResource(R.mipmap.tab_nongshi_up);
                break;

        }
    }

    /**
     * 重置底部导航按钮图片
     */
    private void resetBottomBtn() {
        ivHome.setImageResource(R.mipmap.tab_shouyex);
        ivMsg.setImageResource(R.mipmap.tab_xinxi);
        ivFrame.setImageResource(R.mipmap.tab_nongshi);
    }




    /**
     * 切换Fragment的监听
     */
    private ViewPager.OnPageChangeListener fragmentChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrollStateChanged(int destIndex) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int destIndex) {
            // TODO Auto-generated method stub
            if (destIndex == 0) {// 主页
                setBottomImage(1);
            } else if (destIndex == 1) {//主页
                setBottomImage(2);
            } else if (destIndex == 2) {//主页
                setBottomImage(3);
            }
        }
    };
}
