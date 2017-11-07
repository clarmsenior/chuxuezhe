package com.example.mayn.qingju.loginregister;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mayn.qingju.R;
import com.example.mayn.qingju.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class FgpsActivity extends BaseActivity {


    @InjectView(R.id.verify)
    Button verify;
    @InjectView(R.id.text_title)
    TextView textTitle;
    @InjectView(R.id.button_backward)
    Button buttonBackward;
    @InjectView(R.id.button_forward)
    Button buttonForward;
    @InjectView(R.id.layout_titlebar)
    RelativeLayout layoutTitlebar;
    @InjectView(R.id.phone_forget)
    EditText phoneForget;
    @InjectView(R.id.btn_sendcode_forget)
    Button btnSendcodeForget;
    @InjectView(R.id.checkcode)
    EditText checkcode;
    @InjectView(R.id.newpassword)
    EditText newpassword;
    @InjectView(R.id.linearLayout4)
    LinearLayout linearLayout4;
    CountDownTimer timer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fgps);
        ButterKnife.inject(this);
        settitle();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @OnClick({R.id.verify, R.id.text_title, R.id.button_backward, R.id.button_forward, R.id.layout_titlebar, R.id.phone_forget, R.id.btn_sendcode_forget, R.id.checkcode, R.id.newpassword, R.id.linearLayout4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.verify:
                break;
            case R.id.text_title:
                break;
            case R.id.button_backward:
                break;
            case R.id.button_forward:
                break;
            case R.id.layout_titlebar:
                break;
            case R.id.phone_forget:
                break;
            case R.id.btn_sendcode_forget:
                sendCode();
                timer.start();//发送验证码
                break;
            case R.id.checkcode:
                break;
            case R.id.newpassword:
                break;
            case R.id.linearLayout4:
                break;
        }
    }
    private void settitle() {//设置标题栏

        textTitle.setText("找回密码");
        // Drawable drawable = getApplicationContext().getResources().getDrawable(R.mipmap.fanhui);
        buttonBackward.setVisibility(View.VISIBLE);
    }
    private void sendCode() {//发送验证码

        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnSendcodeForget.setText(millisUntilFinished/1000+"");
            }

            @Override
            public void onFinish() {
                btnSendcodeForget.setEnabled(true);
                btnSendcodeForget.setText("发送验证码");

            }
        };
    }
}
