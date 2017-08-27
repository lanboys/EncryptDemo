package com.bing.lan.md5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("EncryptUtil");
    }

    protected final LogUtil log = LogUtil.getLogUtil(getClass(), LogUtil.LOG_VERBOSE);
    private EditText mEt_text;
    private Button mBtn_encrypt_encode;
    private TextView mTv_encrypt_encode;
    private Button mBtn_encrypt_decode;
    private TextView mTv_encrypt_decode;
    private CheckBox mCk_encrypt_type;

    public native String stringFromJNI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText("Jni Test: " + stringFromJNI());

        mEt_text = (EditText) findViewById(R.id.et_text);
        mBtn_encrypt_encode = (Button) findViewById(R.id.btn_encrypt_encode);
        mTv_encrypt_encode = (TextView) findViewById(R.id.tv_encrypt_encode);

        mBtn_encrypt_decode = (Button) findViewById(R.id.btn_encrypt_decode);
        mTv_encrypt_decode = (TextView) findViewById(R.id.tv_encrypt_decode);
        mCk_encrypt_type = (CheckBox) findViewById(R.id.ck_encrypt_type);
    }

    public void encode(View view) {
        String str = mEt_text.getText().toString().trim();
        String encode;
        if (mCk_encrypt_type.isChecked()) {
            //jni
            encode = EncryptUtil.encode(str, str.length());
        } else {
            //md5
            encode = MD5Util.MD5(str);
        }
        mTv_encrypt_encode.setText(encode);
    }

    public void decode(View view) {

        String str = mTv_encrypt_encode.getText().toString().trim();
        String decode;
        if (mCk_encrypt_type.isChecked()) {
            //jni
            decode = EncryptUtil.decode(str, str.length());
        } else {
            //md5
            decode = "md5无法解密";
        }
        mTv_encrypt_decode.setText("解密结果: " + decode);
    }
}
