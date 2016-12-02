package kr.co.mash_up.zangsisi_donghee.ui.comic.episode;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.co.mash_up.zangsisi_donghee.common.OnItemClickListener;
import kr.co.mash_up.zangsisi_donghee.data.Episode;

/**
 * Created by Dong on 2016-12-02.
 */

public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {

    private ArrayList<Episode> mEpisodes;
    private Context mContext;

    OnItemClickListener<Episode> mOnItemClickListener;

    private void dymmyData() {
        Episode data;
        for (int i = 0; i < 20; i++) {
            data = new Episode();
            data.setTitle("title" + (i + 1));
            mEpisodes.add(data);
        }
    }

    public EpisodeListAdapter(Context context) {
        mContext = context;
        mEpisodes = new ArrayList<>();

        dymmyData();
    }

    public void setComics(ArrayList<Episode> episodes) {
        mEpisodes = episodes;
    }

    public void setOnItemClickListener(OnItemClickListener<Episode> listener) {
        mOnItemClickListener = listener;
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return EpisodeViewHolder.newInstance(parent, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {
        holder.bind(mEpisodes.get(position));
    }

    @Override
    public int getItemCount() {
        return mEpisodes.size();
    }
}
