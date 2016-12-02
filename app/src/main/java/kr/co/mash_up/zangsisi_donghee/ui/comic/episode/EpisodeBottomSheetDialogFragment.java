package kr.co.mash_up.zangsisi_donghee.ui.comic.episode;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import kr.co.mash_up.zangsisi_donghee.R;

/**
 * Created by Dong on 2016-12-02.
 */

public class EpisodeBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private Unbinder mUnbinder;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.rv_episode)
    RecyclerView mRvEpisode;

    private EpisodeListAdapter mEpisodeListAdapter;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Todo: model save
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Todo: model restore
    }

    //Todo: receive model
    public EpisodeBottomSheetDialogFragment(){
        super();
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View contentView = View.inflate(getContext(), R.layout.fragment_episode_bottom_sheet, null);
        dialog.setContentView(contentView);
        mUnbinder = ButterKnife.bind(this, contentView);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetCallback);
        }

//        mTvTitle.setText();

        mEpisodeListAdapter = new EpisodeListAdapter(getContext());
        mEpisodeListAdapter.setOnItemClickListener(episode -> {
            //Todo: show detail activity
        });
        mRvEpisode.setHasFixedSize(true);
        mRvEpisode.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRvEpisode.setAdapter(mEpisodeListAdapter);
    }

    @Override
    public void onDestroyView() {
        mUnbinder.unbind();
        super.onDestroyView();
    }

    private BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    };
}
