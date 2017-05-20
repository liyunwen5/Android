package lyw.swiperecyclerview;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class MainActivity extends AppCompatActivity {
    @Bind(R.id.swipeRecyclerView)
     SwipeRecyclerView recyclerView;
    private List<String> data;
    private RecyclerViewAdapter adapter;
    private int pagerSize = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity_main);
        ButterKnife.bind(this);
        //set color
        recyclerView.getSwipeRefreshLayout()
                .setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        //set layoutManager
        recyclerView.getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.getRecyclerView().setLayoutManager(new GridLayoutManager(this, 3));
        //recyclerView.getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        //禁止下拉刷新
//        recyclerView.setRefreshEnable(false);

        //禁止加载更多
//        recyclerView.setLoadMoreEnable(false);

        //设置emptyView
        /*TextView textView = new TextView(this);
        textView.setText("empty view");
        recyclerView.setEmptyView(textView);*/

        //设置footerView
        //recyclerView.setFooterView(new SimpleFooterView(this));

        //由于SwipeRecyclerView中对GridLayoutManager的SpanSizeLookup做了处理，因此对于使用了
        //GridLayoutManager又要使用SpanSizeLookup的情况，可以这样使用！
        /*recyclerView.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 3;
            }
        });*/

        //设置去除footerView 的分割线
       /* recyclerView.getRecyclerView().addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                paint.setColor(0xFFEECCCC);

                Rect rect = new Rect();
                int left = parent.getPaddingLeft();
                int right = parent.getWidth() - parent.getPaddingRight();
                final int childCount = parent.getChildCount() - 1;
                for (int i = 0; i < childCount; i++) {
                    final View child = parent.getChildAt(i);

                    //获得child的布局信息
                    final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                    final int top = child.getBottom() + params.bottomMargin;
                    final int itemDividerHeight = 1;//px
                    rect.set(left + 50, top, right - 50, top + itemDividerHeight);
                    c.drawRect(rect, paint);
                }
            }
        });*/

        //设置noMore
//        recyclerView.onNoMore("-- end --");

        //设置网络处理
//        recyclerView.onNetChange(true);

        //设置错误信息
        //recyclerView.onError("error");
        data = new ArrayList<>();
        adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnLoadListener(new SwipeRecyclerView.OnLoadListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        data.clear();
                        pagerSize++;
                        for (int i = 0; i < pagerSize; i++) {
                            data.add(0, String.valueOf(i));
//                            data.add(String.valueOf(i));
                        }
                        adapter.setData(data);
                        recyclerView.complete();
                        adapter.notifyDataSetChanged();

                    }
                }, 1000);

            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < pagerSize; i++) {
                            data.add(String.valueOf(i));
                        }

                        if (data.size() > 20) {
                            recyclerView.onNoMore("-- 结束--");
                        } else {
                            adapter.setData(data);
                            recyclerView.stopLoadingMore();
                            adapter.notifyDataSetChanged();
                        }
                    }
                }, 1000);
            }
        });

        //设置自动下拉刷新，切记要在recyclerView.setOnLoadListener()之后调用
        //因为在没有设置监听接口的情况下，setRefreshing(true),调用不到OnLoadListener
        recyclerView.setRefreshing(true);
    }

    @OnClick(R.id.swipeRecyclerView)
    public void onViewClicked() {
    }
}