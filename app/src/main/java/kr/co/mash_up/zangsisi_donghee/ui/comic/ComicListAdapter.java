package kr.co.mash_up.zangsisi_donghee.ui.comic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.co.mash_up.zangsisi_donghee.common.OnItemClickListener;
import kr.co.mash_up.zangsisi_donghee.data.Comic;

/**
 * Created by Dong on 2016-12-02.
 */

public class ComicListAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private ArrayList<Comic> mComics;
    private Context mContext;

    OnItemClickListener<Comic> mOnItemClickListener;

    private void dymmyData() {
        Comic comic;
        for (int i = 0; i < 20; i++) {
            comic = new Comic();
            comic.setTitle("title" + (i + 1));
            mComics.add(comic);
        }
    }

    public ComicListAdapter(Context context) {
        mContext = context;
        mComics = new ArrayList<>();

        dymmyData();
    }

    public void setComics(ArrayList<Comic> comics) {
        mComics = comics;
    }

    public void setOnItemClickListener(OnItemClickListener<Comic> listener) {
        mOnItemClickListener = listener;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ComicViewHolder.newInstance(parent, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        holder.bind(mComics.get(position));
    }

    @Override
    public int getItemCount() {
        return mComics.size();
    }
}
