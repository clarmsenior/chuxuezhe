package com.example.mayn.qingju.assignment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.mayn.qingju.R;
/**
 * @author Zhenhua on 2017/5/22 17:30.
 * @email zhshan@ctrip.com
 */

public class HoveringAdapter extends RecyclerView.Adapter {
    private Context context;
    private String[] data;

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_CONTENT = 2;
    private static final int TYPE_FOOTER = 3;

    public HoveringAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return new HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.zhuanrang_head, parent, false));
            case TYPE_CONTENT:
                return new ContentViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_assignment_tabyout, parent, false));
            case TYPE_FOOTER:
                return new FooterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recy, parent, false));
            default:
                return new ContentViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_assignment_tabyout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentViewHolder) {

        } else if (holder instanceof HeaderViewHolder){

        } else if (holder instanceof FooterViewHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public int getItemViewType(int position) {
        switch (data[position]) {
            case "header":
                return TYPE_HEADER;
            case "content":
                return TYPE_CONTENT;
            case "footer":
                return TYPE_FOOTER;
            default:
                return TYPE_CONTENT;
        }
    }

    /***********************Multiple Types of ViewHolders****************************/
    public static class HeaderViewHolder extends RecyclerView.ViewHolder{

        public TextView text;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.xingming);
        }
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        public ContentViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView ageTv;
        TextView rootView;
        public FooterViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_name_tv);

            itemView.findViewById(R.id.recycler_view_test_rv);
            ageTv = (TextView) itemView
                    .findViewById(R.id.recycler_view_test_item_person_age_tv);
            rootView = itemView
                    .findViewById(R.id.card_view);
        }
    }
}
