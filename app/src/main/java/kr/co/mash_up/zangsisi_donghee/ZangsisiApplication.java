package kr.co.mash_up.zangsisi_donghee;

import android.app.Application;
import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.annotations.RealmModule;
import kr.co.mash_up.zangsisi_donghee.data.Comic;
import kr.co.mash_up.zangsisi_donghee.data.Contents;
import kr.co.mash_up.zangsisi_donghee.data.Episode;

/**
 * Created by Dong on 2016-12-02.
 */

public class ZangsisiApplication extends Application {

    private static final int REALM_SCHEMA_VERSION = 1;
    private static ZangsisiApplication instance;

    public static ZangsisiApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Realm.init(this);

        //Todo: test용 제거
        Realm.deleteRealm(buildRealmConfiguration());

        Realm.setDefaultConfiguration(buildRealmConfiguration());
    }

    @NonNull
    private RealmConfiguration buildRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .name("Zangsisi.realm")
                .schemaVersion(REALM_SCHEMA_VERSION)
                .modules(new ZangsisiModule())
                .build();
    }

    @Override
    public void onTerminate() {

        super.onTerminate();
    }

    /*
          모듈 생성
          원하는 클래스만 Realm에 포함시킬 수 있다.
         */
    @RealmModule(classes = {Comic.class, Episode.class, Contents.class})
    private class ZangsisiModule {
    }
}
