package io.xdag.xdagwallet.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import io.xdag.common.base.BaseFragment;
import io.xdag.common.base.ToolbarActivity;
import io.xdag.xdagwallet.R;
import io.xdag.xdagwallet.adapter.TransactionAdapter;

/**
 * created by lxm on 2018/5/24.
 * <p>
 * desc :
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_rv) RecyclerView mRecyclerView;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initView(View rootView) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new TransactionAdapter());
    }


    @Override public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            ((ToolbarActivity) mContext).mToolbar.setVisibility(View.GONE);
        }
    }


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}