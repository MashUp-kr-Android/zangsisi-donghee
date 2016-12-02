package kr.co.mash_up.zangsisi_donghee.ui.comic.episode;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import kr.co.mash_up.zangsisi_donghee.common.OnItemClickListener;
import kr.co.mash_up.zangsisi_donghee.R;
import kr.co.mash_up.zangsisi_donghee.base.ui.BaseViewHolder;
import kr.co.mash_up.zangsisi_donghee.data.Episode;

/**
 * Created by Dong on 2016-12-02.
 */

public class EpisodeViewHolder extends BaseViewHolder<Episode> {

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private OnItemClickListener<Episode> mOnItemClickListener;

    public static EpisodeViewHolder newInstance(@NonNull ViewGroup parent, OnItemClickListener listener) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_episode_list, parent, false);
        return new EpisodeViewHolder(itemView, listener);
    }

    public EpisodeViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView);

        mOnItemClickListener = listener;
    }

    @Override
    public void bind(Episode episode) {
        mTvTitle.setText(episode.getTitle());

        itemView.setOnClickListener(view -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onClick(episode);
            }
        });
    }
}
