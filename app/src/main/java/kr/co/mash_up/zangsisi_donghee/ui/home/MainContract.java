package kr.co.mash_up.zangsisi_donghee.ui.home;


import java.util.List;

import kr.co.mash_up.zangsisi_donghee.base.BasePresenter;
import kr.co.mash_up.zangsisi_donghee.base.BaseView;
import kr.co.mash_up.zangsisi_donghee.data.Comic;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface MainContract {

    /**
     * View -> Presenter
     */
    interface Presenter extends BasePresenter {

        void loadComics(boolean forceUpdate);

        //Todo: 검색
    }

    /**
     * Presenter -> View
     */
    interface View extends BaseView<Presenter> {

        void setLodingIndicator(boolean active);

        void showComics(List<Comic> comics);

        void showNoComics();

        void showLodingComicsError();

        boolean isActive();
    }
}
