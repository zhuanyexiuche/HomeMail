package cn.edu.nju.homemail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by huangxiao on 2017/8/2.
 */

public class ProgrammeFragment extends Fragment {

    private ViewPager mHeadlineViewPager;

    public static Fragment newInstance() {
        Bundle args = new Bundle();

        ProgrammeFragment fragment = new ProgrammeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_programme, container, false);
        // TODO
        
        return v;
    }

}
