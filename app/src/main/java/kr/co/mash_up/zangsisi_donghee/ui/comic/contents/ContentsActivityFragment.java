package kr.co.mash_up.zangsisi_donghee.ui.comic.contents;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.mash_up.zangsisi_donghee.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContentsActivityFragment extends Fragment {

    public ContentsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contents, container, false);
    }
}
