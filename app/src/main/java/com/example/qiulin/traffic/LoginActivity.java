package com.example.qiulin.traffic;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.example.qiulin.traffic.beans.User;
import com.example.qiulin.traffic.rest.AbstractAsyncActivity;
import com.example.qiulin.traffic.utils.DataUtil;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AbstractAsyncActivity {
    private EditText userNameText;
    private EditText pwdText;
    private ProgressBar pb;
    private Button btn;
    private TextView nameErrorTextView;
    private TextView passwordErrorTextView;
    private CheckBox pwdCheckbox;
    private User user;
    private Button setbtn;
    private Button regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = new User();
        userNameText = (EditText) findViewById(R.id.userNameText);
        pwdText = (EditText) findViewById(R.id.passWordText);
        nameErrorTextView = (TextView) findViewById(R.id.nameErrorTextView);
        passwordErrorTextView = (TextView) findViewById(R.id.passwordErrorTextView);
        pwdCheckbox = (CheckBox) findViewById(R.id.pwdCheckbox);
        System.out.print(pwdCheckbox.getText());
        btn = (Button) findViewById(R.id.loginBtn);
        setbtn = (Button) findViewById(R.id.setBtn);
        regbtn = (Button) findViewById(R.id.regBtn);
        pb = (ProgressBar) findViewById(R.id.btnProgress);
        pb.setIndeterminate(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDialog dialog = new MaterialDialog.Builder(LoginActivity.this)
                        .title("设置")
                        .theme(Theme.LIGHT)
                        .customView(R.layout.set_ip_view, false)
                        .callback(new MaterialDialog.ButtonCallback() {
                            @Override
                            public void onNegative(MaterialDialog dialog){
                                View view = dialog.getCustomView();
                                MaterialEditText edit1 = (MaterialEditText) view.findViewById(R.id.ip1);
                                MaterialEditText edit2 = (MaterialEditText) view.findViewById(R.id.ip2);
                                String ip1 = edit1.getText().toString().trim();
                                String ip2 = edit2.getText().toString().trim();
                                Map map = new HashMap();
                                map.put("ip1",ip1);
                                map.put("ip2",ip2);
                                DataUtil.saveConf(LoginActivity.this, map);
                            }
                        })
                        .positiveText("取消")
                        .negativeText("确定")
                        .show();
                View view = dialog.getCustomView();
                MaterialEditText edit1 = (MaterialEditText) view.findViewById(R.id.ip1);
                MaterialEditText edit2 = (MaterialEditText) view.findViewById(R.id.ip2);
                Object obj1 = DataUtil.getProp(LoginActivity.this, "ip1", "conf");
                Object obj2 = DataUtil.getProp(LoginActivity.this, "ip2", "conf");
                if(obj1 != null){
                    edit1.setText(obj1.toString());
                }
                if(obj2 != null){
                    edit2.setText(obj2.toString());
                }
            }
        });
        pwdCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pwdText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else{
                    pwdText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }

    private boolean validate()
    {
        hideError();
        String userName = userNameText.getText().toString().trim();
        String pwd = pwdText.getText().toString().trim();
        if ("".equals(userName))
        {
            nameErrorTextView.setText("用户名不能为空");
            nameErrorTextView.setVisibility(View.VISIBLE);
            btn.setEnabled(true);
            return false;
        }
        if ("".equals(pwd))
        {
            passwordErrorTextView.setText("密码不能为空");
            passwordErrorTextView.setVisibility(View.VISIBLE);
            btn.setEnabled(true);
            return false;
        }
        String url = "http://" + String.valueOf(DataUtil.getProp(LoginActivity.this, "ip1", "conf")) +"/traffic/car/findcar.do";
        new HttpTask().execute(userName,pwd,url);
        return true;
    }
    private void hideError(){
        nameErrorTextView.setVisibility(View.GONE);
        passwordErrorTextView.setVisibility(View.GONE);
    }

    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, LoginActivity.class);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    private void displayResponse(Boolean response) {
        Boolean isValidate = response;
        if (!isValidate) {
            btn.setEnabled(true);
            pb.setVisibility(View.GONE);
        } else {
            DataUtil.saveDate(LoginActivity.this, user);
            Intent intent = new Intent(LoginActivity.this,
                    MainActivity.class);
            startActivity(intent);
            finish();
        }
        Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
    }
    private class HttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            showLoadingProgressDialog();
        }

        @Override
        protected Integer doInBackground(String... params) {
            try {
                String userName = params[0];
                String pwd = params[1];
                String url = params[2];
                if("123".equals(userName) && "123".equals(pwd)){
                    user.setId("1");
                    user.setUserName(userName);
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                    restTemplate.getForObject(url, String.class).toString();
                    return 0;
                }else{
                    return 2;
                }
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
            } catch (ResourceAccessException e) {
                    return 1;
            } catch (Exception e){
                e.printStackTrace();
            }
            return 1;
        }
        @Override
        protected void onPostExecute(Integer result) {
//            DataUtil.saveDate(LoginActivity.this, user);
//            Intent intent = new Intent(LoginActivity.this,
//                    MainActivity.class);
//            startActivity(intent);
//            finish();
//            return;
            if (result == 2) {
                btn.setEnabled(true);
                passwordErrorTextView.setText("用户名与密码不符");
                passwordErrorTextView.setVisibility(View.VISIBLE);
                dismissProgressDialog();
            } else if (result == 1) {
                btn.setEnabled(true);
                passwordErrorTextView.setText("网络连接失败");
                passwordErrorTextView.setVisibility(View.VISIBLE);
                dismissProgressDialog();
            } else {
                DataUtil.saveDate(LoginActivity.this, user);
                Intent intent = new Intent(LoginActivity.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

    }
}



