package wh.lyw.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ThirdTabPagerAdapter extends PagerAdapter {

    private List<Fragment> fragments;
    private FragmentManager fragmentManager;

    /**
     * @param fragments
     */
    public ThirdTabPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        this.fragmentManager = fragmentManager;
        this.fragments = fragments;
    }

    //	@Override
//	public Fragment getItem(int arg0) {
//		return fragments.get(arg0);
//	}
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) { // 如果fragment还没有added
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(fragment, fragment.getClass().getSimpleName());
            ft.commitAllowingStateLoss();
            /**
             * 在用FragmentTransaction.commit()方法提交FragmentTransaction对象后
             * 会在进程的主线程中，用异步的方式来执行。 如果想要立即执行这个等待中的操作，就要调用这个方法（只能在主线程中调用）。
             * 要注意的是，所有的回调和相关的行为都会在这个调用中被执行完成，因此要仔细确认这个方法的调用位置。
             */
            fragmentManager.executePendingTransactions();
        }

        if (fragment.getView().getParent() == null) {
            container.addView(fragment.getView()); // 为viewpager增加布局
        }

        return fragment.getView();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) fragments.get(position).getView());
    }
//	@Override
//	public void destroyItem(ViewGroup container, int position, Object object) {
//		super.destroyItem(container, position, object);
//	}
}