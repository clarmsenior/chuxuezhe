package com.example.mayn.qingju.loginregister;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mayn.qingju.R;
import com.example.mayn.qingju.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

public class AlipaybindActivity extends BaseActivity {

    @InjectView(R.id.text_title)
    TextView textTitle;
    @InjectView(R.id.button_backward)
    Button buttonBackward;
    @InjectView(R.id.button_forward)
    Button buttonForward;
    @InjectView(R.id.btn_querenbangding)
    Button btnQuerenbangding;
    @InjectView(R.id.lipayaccount)
    EditText lipayaccount;
    @InjectView(R.id.receiverinfo)
    EditText receiverinfo;
    @InjectView(R.id.btn_sendcode_alipay)
    Button btnSendcodeAlipay;
    @InjectView(R.id.checkcode_alipay)
    TextView checkcodeAlipay;
    @InjectView(R.id.alipay_code)
    EditText alipayCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alipaybind);
        ButterKnife.inject(this);
        settitle();
    }

    @OnClick({R.id.text_title, R.id.button_backward, R.id.button_forward, R.id.btn_querenbangding, R.id.lipayaccount, R.id.receiverinfo, R.id.btn_sendcode_alipay, R.id.checkcode_alipay, R.id.alipay_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_title:
                break;
            case R.id.button_backward:
                Toasty.info(getApplicationContext(), "点击了返回", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_forward:
                break;
            case R.id.btn_querenbangding:
                break;
            case R.id.lipayaccount:
                break;
            case R.id.receiverinfo:
                break;
            case R.id.btn_sendcode_alipay:
                break;
            case R.id.checkcode_alipay:
                break;
            case R.id.alipay_code:
                break;
        }
    }
    private void settitle() {//设置标题栏

        textTitle.setText("支付宝绑定");
        // Drawable drawable = getApplicationContext().getResources().getDrawable(R.mipmap.fanhui);
        buttonBackward.setVisibility(View.VISIBLE);
    }
}
