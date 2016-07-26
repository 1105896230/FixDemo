package com.example.administrator.fixdemo;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by "林其望".
 * DATE: 2016:07:26:14:25
 * email:1105896230@qq.com
 */

public class AliFixApplication extends Application {


    private PatchManager patchManager;
    private String appversion = "";

    @Override
    public void onCreate() {
        super.onCreate();
        patchManager = new PatchManager(this);
//        每次appversion变更 会删除所有的补丁，如果appversion 不变，补丁不会删除
        String s = BuildConfig.VERSION_CODE + "";
        Log.e("application", s);
        patchManager.init(s);//current version
        patchManager.loadPatch();
        addPath();
    }

    public String getAppversion() {
        try {
            appversion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appversion;
    }

    private void addPath() {
        String path = Environment.getExternalStorageDirectory().getPath() + "/Alarms/out.apatch";
        Log.e("path", path);

        File file = new File(path);
        Log.e("size", file.length() + "");
        if (file.exists()) {
            try {
                patchManager.addPatch(path);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("e", e.getMessage());
            }
        }
    }
}
