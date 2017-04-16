package com.bing.lan.md5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("EncryptUtil");
    }

    protected final LogUtil log = LogUtil.getLogUtil(getClass(), LogUtil.LOG_VERBOSE);

    public native String stringFromJNI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        MD5Util.MD5("123");

        String str = "woshilanbing";
        log.d("onCreate(): String: " + str);

        String encode = EncryptUtil.encode(str, str.length());

        log.d("onCreate(): encode: " + encode);

        String decode = EncryptUtil.decode(encode, encode.length());

        log.d("onCreate(): decode: " + decode);




    }
}
