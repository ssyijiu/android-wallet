package io.xdag.common.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import io.xdag.common.R;
import java.util.ArrayList;
import java.util.List;

/**
 * created by lxm on 2018/5/25.
 * <p>
 * desc :
 */
public abstract class ListFragment<T> extends RefreshFragment {

    protected BaseQuickAdapter<T, BaseViewHolder> mAdapter;
    protected List<T> mDataList = new ArrayList<>();
    protected RecyclerView mRecyclerView;


    @Override
    protected int getLayoutResId() {
        return R.layout.layout_recycler;
    }


    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        mRecyclerView = rootView.findViewById(R.id.recycler);
        mAdapter = createAdapter();
        mRecyclerView.setLayoutManager(getLayoutManger());
        mRecyclerView.setAdapter(mAdapter);
    }


    @NonNull
    protected BaseQuickAdapter<T, BaseViewHolder> createAdapter() {
        return new BaseQuickAdapter<T, BaseViewHolder>(getItemLayout(), mDataList) {
            @Override
            protected void convert(BaseViewHolder helper, T item) {
                ListFragment.this.convert(helper, item);
            }
        };
    }


    protected abstract RecyclerView.LayoutManager getLayoutManger();


    protected int getItemLayout() {
        return 0;
    }


    protected void convert(BaseViewHolder helper, T item) {
    }
}
