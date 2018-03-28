package com.zk.okhttp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zk.okhttp3.bean.TestBean;
import com.zk.okhttp3.impl.ImplCustom;
import com.zk.okhttp3.utils.OkHttp3Utlis;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String GET_URL = "http://v.juhe.cn/toutiao/index?type=历史&key=d05b58fa6901ad9bed77a1ef08bd6ccb";
    public static final String POST_URL = "http://v.juhe.cn/toutiao/index";
    private HashMap<String, String> map = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        postURL();
    }

    private void postURL() {
        map.put("type", "娱乐");
        map.put("key", "d05b58fa6901ad9bed77a1ef08bd6ccb");
        OkHttp3Utlis.getIntance().postBean(POST_URL, map, new ImplCustom(TestBean.class) {
            @Override
            protected void onMyRespone(Response response, Class classz) throws IOException {
                String result = response.body().string();
                TestBean bean = (TestBean) OkHttp3Utlis.getIntance().gson.fromJson(result, classz);
                String reason = bean.getReason();
                Log.e("222222222222", reason + "");
            }
        });
    }
}
