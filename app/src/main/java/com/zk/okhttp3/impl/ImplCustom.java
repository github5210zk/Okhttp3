package com.zk.okhttp3.impl;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 自定义回调
 */

public abstract class ImplCustom implements Callback {
    protected Class classz;
    //通过构造器传入类Bean
    public ImplCustom(Class classz) {
        this.classz = classz;
    }


    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        onMyRespone ( response, classz );
    }

    protected abstract void onMyRespone(Response response, Class classz) throws IOException;

}