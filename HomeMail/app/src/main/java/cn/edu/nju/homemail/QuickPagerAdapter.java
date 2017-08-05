package cn.edu.nju.homemail;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by huangxiao on 2017/8/4.
 */

public class QuickPagerAdapter<T extends View> extends PagerAdapter {

    private List<T> mViewList;

    public QuickPagerAdapter(List<T> viewList) {
        mViewList = viewList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
