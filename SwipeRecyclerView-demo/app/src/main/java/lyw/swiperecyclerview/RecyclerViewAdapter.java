package lyw.swiperecyclerview;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private Context mContext;
    private List<String> data;
    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<String> data) {
        this.data = data;
    }
    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.demo_layout_item, parent, false);
        return new ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.tv.setText("李云文" + data.get(position));
        //点击事件
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你敢再点我几厘米啊，我是" + position + "米", Toast.LENGTH_SHORT).show();
            }
        });
    }
//    注入到ViewHolder中
    class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv)
        TextView tv;
        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}


