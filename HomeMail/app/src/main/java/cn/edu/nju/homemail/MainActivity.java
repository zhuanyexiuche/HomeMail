package cn.edu.nju.homemail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mListenBtn;
    private Button mCommunityBtn;
    private Button mMoreBtn;

    private Map<Button, Fragment> mMapBtnFragment;

    private void initFragment() {
        mMapBtnFragment = new HashMap<>(3);

        Fragment programmeFragment = ProgrammeFragment.newInstance();
        Fragment communityFragment = CommunityFragment.newInstance();
        Fragment moreFragment = MoreFragment.newInstance();

        mMapBtnFragment.put(mListenBtn, programmeFragment);
        mMapBtnFragment.put(mCommunityBtn, communityFragment);
        mMapBtnFragment.put(mMoreBtn, moreFragment);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListenBtn = (Button) findViewById(R.id.listen_btn);
        mCommunityBtn = (Button) findViewById(R.id.community_btn);
        mMoreBtn = (Button) findViewById(R.id.more_btn);

        initFragment();

        mListenBtn.setOnClickListener(this);
        mCommunityBtn.setOnClickListener(this);
        mMoreBtn.setOnClickListener(this);

        mListenBtn.callOnClick();
    }

    private void changeFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onClick(View view) {
        // Make sure the action is made by image_button
        if (!(view instanceof Button)) {
            return;
        }
        //Adjust button state
        Button button = (Button) view;
        mListenBtn.setEnabled(true);
        mCommunityBtn.setEnabled(true);
        mMoreBtn.setEnabled(true);
        button.setEnabled(false);

        Fragment fragment = mMapBtnFragment.get(button);
        changeFragment(fragment);
    }

}
