package kr.co.mash_up.zangsisi_donghee.ui.comic;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import kr.co.mash_up.zangsisi_donghee.R;
import kr.co.mash_up.zangsisi_donghee.base.ui.BaseFragment;
import kr.co.mash_up.zangsisi_donghee.ui.comic.episode.EpisodeBottomSheetDialogFragment;


public class ComicListFragment extends BaseFragment {

    public static final String TAG = ComicListFragment.class.getSimpleName();

    @BindView(R.id.rv_comic)
    RecyclerView mRvComic;

    private static final String ARG_TITLE = "title";
    private String mTitle;

    private ComicListAdapter mComicListAdapter;

    public String getTitle() {
        return mTitle;
    }

    public ComicListFragment() {
        // Required empty public constructor
    }

    public static ComicListFragment newInstance(String title) {
        ComicListFragment fragment = new ComicListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comic_list;
    }

    @Override
    public void initView(View rootView) {
        mComicListAdapter = new ComicListAdapter(getActivity());
        mComicListAdapter.setOnItemClickListener(comic -> {
            // Todo: pass model
            EpisodeBottomSheetDialogFragment bottomSheetDialogFragment = new EpisodeBottomSheetDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("comicId", comic.getId());
            bottomSheetDialogFragment.setArguments(bundle);
            bottomSheetDialogFragment.show(getChildFragmentManager(), bottomSheetDialogFragment.getTag());
        });
        mRvComic.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRvComic.setHasFixedSize(true);
        mRvComic.setAdapter(mComicListAdapter);
    }
}
