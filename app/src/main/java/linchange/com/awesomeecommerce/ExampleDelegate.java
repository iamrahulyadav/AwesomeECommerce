package linchange.com.awesomeecommerce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import linchange.com.core.delegates.AwesomeDelegate;
import linchange.com.core.net.RestClient;
import linchange.com.core.net.callback.IError;
import linchange.com.core.net.callback.IFailure;
import linchange.com.core.net.callback.ISuccess;

/**
 * Created by lkmc2 on 2017/12/29.
 * Fragment代理对象
 */

public class ExampleDelegate extends AwesomeDelegate {

    //设置布局
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    //绑定视图
    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .loader(getContext())
                .url("http://127.0.0.1/index")
                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.d("hahaha", response);
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
