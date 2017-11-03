package com.example.mayn.qingju.assignment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.andview.refreshview.XRefreshView;
import com.example.mayn.qingju.R;
import com.example.mayn.qingju.assignment.adapter.SimpleAdapter;
import com.example.mayn.qingju.assignment.test.Person;
import com.example.mayn.qingju.customcontrol.ObservableScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * 转让界面
 * Created by tsh on 2017/10/24.
 */

public class AssignmentFragment extends Fragment {
    //@InjectView(R.id.tv_topView)
    //TextView tvTopView;
    @InjectView(R.id.ll_topView)
    LinearLayout llTopView;
    @InjectView(R.id.sv_contentView)
    ObservableScrollView svContentView;
    @InjectView(R.id.ll_fixedView)
    LinearLayout llFixedView;
    @InjectView(R.id.button)
    Button button;
    @InjectView(R.id.button2)
    Button button2;
    @InjectView(R.id.button3)
    Button button3;
    @InjectView(R.id.rela_assitant)
    RelativeLayout relaAssitant;
    @InjectView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @InjectView(R.id.relativeLayout3)
    RelativeLayout relativeLayout3;
    @InjectView(R.id.recycler_view_test_rv)
    RecyclerView recyclerViewTestRv;
    @InjectView(R.id.xrefreshview)
    XRefreshView xrefreshview;
    private int mHeight;
    //private TextView mTextView;
    private int mLoadCount = 0;
    SimpleAdapter adapter;
    GridLayoutManager layoutManager;
    List<Person>personList=new ArrayList<>();
    public AssignmentFragment() {

    }


    public static AssignmentFragment newInstance() {

        Bundle args = new Bundle();
        args.putString("text", "转让界面");
        AssignmentFragment fragment = new AssignmentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assignment, container, false);

        initViews(view);

        ButterKnife.inject(this, view);
        initData();
        xrefreshview.setPullLoadEnable(true);
        recyclerViewTestRv.setHasFixedSize(true);
        adapter = new SimpleAdapter(personList,getContext());
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewTestRv.setLayoutManager(layoutManager);
        recyclerViewTestRv.setAdapter(adapter);
//        xRefreshView1.setAutoLoadMore(false);
        xrefreshview.setPinnedTime(1000);
        xrefreshview.setMoveForHorizontal(true);
        /*ViewTreeObserver viewTreeObserver = llTopView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                llTopView.getViewTreeObserver().removeGlobalOnLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {


                        mHeight = llTopView.getTop();
                    }
                });

            }
        });*/
        xrefreshview.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xrefreshview.stopRefresh();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            adapter.insert(new Person("More ", "21"),
                                    adapter.getAdapterItemCount());
                        }
                        mLoadCount++;
                        if (mLoadCount >= 3) {
                            xrefreshview.setLoadComplete(true);
                        } else {
                            // 刷新完成必须调用此方法停止加载
                            xrefreshview.stopLoadMore();
                        }
                    }
                }, 1000);
            }
        });

        svContentView.setOnObservableScrollViewScrollChanged(new ObservableScrollView.OnObservableScrollViewScrollChanged() {
            @Override
            public void onObservableScrollViewScrollChanged(int l, int t, int oldl, int oldt) {
                if (t >= llTopView.getTop()) {
                    if (relaAssitant.getParent() != llFixedView) {
                        llTopView.removeView(relaAssitant);
                        llFixedView.addView(relaAssitant);
                    }
                } else {
                    if (relaAssitant.getParent() != llTopView) {
                        llFixedView.removeView(relaAssitant);
                        llTopView.addView(relaAssitant);
                    }
                }

            }
        });

        return view;
    }

    private void initViews(View view) {
        //mTextView = view.findViewById(R.id.tv_assignment);
        Bundle bundle = getArguments();

        //mTextView.setText(bundle == null ? "" : bundle.getString("text"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button://综合排序
                break;
            case R.id.button2://价格
                break;
            case R.id.button3://地区
                break;

        }
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            Person person = new Person("name" + i, "" + i);
            personList.add(person);
        }
    }



}
