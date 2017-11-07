package com.example.mayn.qingju.loginregister;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mayn.qingju.R;
import com.example.mayn.qingju.base.BaseActivity;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class RegisterActivity extends BaseActivity {

    @InjectView(R.id.text_title)
    TextView textTitle;
    @InjectView(R.id.button_backward)
    Button buttonBackward;
    @InjectView(R.id.button_forward)
    Button buttonForward;
    @InjectView(R.id.layout_titlebar)
    RelativeLayout layoutTitlebar;
    @InjectView(R.id.email)
    AutoCompleteTextView email;
    @InjectView(R.id.yanzhengma)
    AutoCompleteTextView yanzhengma;
    @InjectView(R.id.mima_zhece)
    AutoCompleteTextView mimaZhece;
    @InjectView(R.id.querenmima)
    AutoCompleteTextView querenmima;
    @InjectView(R.id.linearLayout5)
    LinearLayout linearLayout5;
    @InjectView(R.id.btn_zhuce)
    Button btnZhuce;
    @InjectView(R.id.sendcode)
    TextView sendcode;
    CountDownTimer timer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.inject(this);
        settitle();
        init();

    }

    @OnClick({R.id.text_title, R.id.button_backward, R.id.button_forward, R.id.layout_titlebar, R.id.email, R.id.yanzhengma,
            R.id.mima_zhece, R.id.querenmima, R.id.linearLayout5, R.id.btn_zhuce, R.id.sendcode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_title:
                break;
            case R.id.button_backward:
                finish();
                break;
            case R.id.button_forward:
                break;
            case R.id.layout_titlebar:
                break;
            case R.id.email:
                break;
            case R.id.yanzhengma:
                break;
            case R.id.mima_zhece:
                break;
            case R.id.querenmima:
                break;
            case R.id.linearLayout5:
                break;
            case R.id.btn_zhuce:

                Toasty.info(getApplicationContext(), "点击了注册", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.sendcode:
                sendCode();
                timer.start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
    private void init(){
                   Logger.addLogAdapter(new AndroidLogAdapter());
                    Logger.d("hello");
                }
    private void settitle() {//设置标题栏

        textTitle.setText("注册");
       // Drawable drawable = getApplicationContext().getResources().getDrawable(R.mipmap.fanhui);
        buttonBackward.setVisibility(View.VISIBLE);
    }
    private void sendCode() {//发送验证码

         timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sendcode.setText(millisUntilFinished/1000+"");
            }

            @Override
            public void onFinish() {
                sendcode.setEnabled(true);
                sendcode.setText("发送验证码");

            }
        };
    }
}
