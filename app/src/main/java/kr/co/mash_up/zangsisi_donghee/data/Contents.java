package kr.co.mash_up.zangsisi_donghee.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dong on 2016-12-02.
 */
public class Contents extends RealmObject {

    @PrimaryKey
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
