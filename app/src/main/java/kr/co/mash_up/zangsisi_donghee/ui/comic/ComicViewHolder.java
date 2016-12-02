package kr.co.mash_up.zangsisi_donghee.ui.comic;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import kr.co.mash_up.zangsisi_donghee.R;
import kr.co.mash_up.zangsisi_donghee.base.ui.BaseViewHolder;
import kr.co.mash_up.zangsisi_donghee.common.OnItemClickListener;
import kr.co.mash_up.zangsisi_donghee.data.Comic;

/**
 * Created by Dong on 2016-12-02.
 */

public class ComicViewHolder extends BaseViewHolder<Comic> {

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private OnItemClickListener<Comic> mOnItemClickListener;

    public static ComicViewHolder newInstance(@NonNull ViewGroup parent, OnItemClickListener listener) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comic_list, parent, false);
        return new ComicViewHolder(itemView, listener);
    }

    public ComicViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView);

        mOnItemClickListener = listener;
    }

    @Override
    public void bind(Comic comic) {
        mTvTitle.setText(comic.getTitle());

        itemView.setOnClickListener(view -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(comic);
            }
        });
    }
}
