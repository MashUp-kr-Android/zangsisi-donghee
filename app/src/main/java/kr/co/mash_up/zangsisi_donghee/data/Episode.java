package kr.co.mash_up.zangsisi_donghee.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dong on 2016-12-02.
 */

public class Episode extends RealmObject {

    @PrimaryKey
    private String id;

    private String title;

    private RealmList<Contents> contentses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RealmList<Contents> getContentses() {
        return contentses;
    }

    public void setContentses(RealmList<Contents> contentses) {
        this.contentses = contentses;
    }
}
