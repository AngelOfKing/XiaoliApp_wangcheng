package com.google.xiaoliapp.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout commonBody = (RelativeLayout) findViewById(R.id.common_body);

        //添加布局，三个参数后面为true，两个直接就是父容器
        LayoutInflater.from(this).inflate(R.layout.activity_login, commonBody);
        TextView textView = (TextView)this.findViewById(R.id.common_head_text);
        textView.setText("登陆账户");

        HttpUtils utils = new HttpUtils(3000);
        //设置请求字段
        RequestParams params = new RequestParams("utf-8");
        params.addQueryStringParameter("mobile","1008611");
        params.addQueryStringParameter("password","123456");
        params.addQueryStringParameter("pincode","pincode");

        //登陆请求
        utils.send(HttpRequest.HttpMethod.GET,
                "http://xl.wx.21future.com/index.php?s=appapi&a=reg",
                params,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String string = responseInfo.toString();
                        try {
                            JSONObject object = new JSONObject(string);
                            int status = object.getInt("status");
                            if(status==1){
                                Log.d("--------","登陆成功");
                            }else if(status==0){
                                Log.d("--------","登陆失败");
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        Log.d("Login",e.toString());
                    }
                }
        );

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_login://登陆
                break;
            case R.id.btn_register://注册
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.forget_password://忘记密码
                Intent intentPsw = new Intent(this,ForgetPSWActivity.class);
                startActivity(intentPsw);
                break;
            case R.id.btn_looking://随便看看
                break;
        }
    }






}
