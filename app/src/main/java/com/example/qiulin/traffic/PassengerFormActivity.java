package com.example.qiulin.traffic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.qiulin.traffic.beans.Code;
import com.example.qiulin.traffic.beans.Dangerous;
import com.example.qiulin.traffic.beans.Passenger;
import com.example.qiulin.traffic.beans.vo.User;
import com.example.qiulin.traffic.utils.CreateSql;
import com.example.qiulin.traffic.utils.DataUtil;
import com.example.qiulin.traffic.utils.DateUtil;
import com.example.qiulin.traffic.utils.Utils;
import com.example.qiulin.traffic.utils.okhttputils.OkHttpUtils;
import com.example.qiulin.traffic.utils.okhttputils.callback.BeanCallBack;
import com.example.qiulin.traffic.utils.okhttputils.request.PostRequest;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qiulin on 2015/1/21 0021.
 */
public class PassengerFormActivity extends AppCompatActivity {
    private ImageButton mFabButton;
    MaterialEditText jcsj,xsztxm,ch,jsrjszh,jsrxm,jsrjsztxm,jsrdh,jsrxctjrq,jsrzzjc,xzlb,hdzk,sjzk,cjrq,ltms,aqss,wfjl,czqk,lxjssj,djmj,ytglmj,bz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passengerform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("客运登记");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassengerFormActivity.this.onBackPressed();
            }
        });
        jcsj = (MaterialEditText) findViewById(R.id.jcsj);
        xsztxm = (MaterialEditText) findViewById(R.id.xsztxm);
        ch = (MaterialEditText) findViewById(R.id.ch);
        jsrjszh = (MaterialEditText) findViewById(R.id.jsrjszh);
        jsrxm = (MaterialEditText) findViewById(R.id.jsrxm);
        jsrjsztxm = (MaterialEditText) findViewById(R.id.jsrjsztxm);
        jsrdh = (MaterialEditText) findViewById(R.id.jsrdh);
        jsrxctjrq = (MaterialEditText) findViewById(R.id.jsrxctjrq);
        jsrzzjc = (MaterialEditText) findViewById(R.id.jsrzzjc);
        xzlb = (MaterialEditText) findViewById(R.id.xzlb);
        hdzk = (MaterialEditText) findViewById(R.id.hdzk);
        sjzk = (MaterialEditText) findViewById(R.id.sjzk);
        cjrq = (MaterialEditText) findViewById(R.id.cjrq);
        ltms = (MaterialEditText) findViewById(R.id.ltms);
        aqss = (MaterialEditText) findViewById(R.id.aqss);
        wfjl = (MaterialEditText) findViewById(R.id.wfjl);
        czqk = (MaterialEditText) findViewById(R.id.czqk);
        lxjssj = (MaterialEditText) findViewById(R.id.lxjssj);
        djmj = (MaterialEditText) findViewById(R.id.djmj);
        ytglmj = (MaterialEditText) findViewById(R.id.ytglmj);
        bz = (MaterialEditText) findViewById(R.id.bz);
        mFabButton = (ImageButton) findViewById(R.id.fab_button);
        mFabButton.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_floppy_o).color(Color.WHITE));
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = DataUtil.getDate(PassengerFormActivity.this);
                if(user == null || user.getID() == null){
                    Intent intent = new Intent(PassengerFormActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                }else{
                    Passenger d = new Passenger();
                    String temp = jcsj.getText().toString();
                    if(StringUtils.isBlank(temp)){
                        jcsj.setError("不能为空");
                        return;
                    }
                    d.setJcsj(jcsj.getText().toString());
                    d.setXsztxm(xsztxm.getText().toString());
                    d.setCh(ch.getText().toString());
                    d.setJsrjszh(jsrjszh.getText().toString());
                    d.setJsrxm(jsrxm.getText().toString());
                    d.setJsrjsztxm(jsrjsztxm.getText().toString());
                    d.setJsrdh(jsrdh.getText().toString());
                    d.setJsrxctjrq(jsrxctjrq.getText().toString());
                    d.setJsrzzjc(jsrzzjc.getText().toString());
                    d.setXzlb(xzlb.getText().toString());
                    d.setHdzk(hdzk.getText().toString());
                    d.setSjzk(sjzk.getText().toString());
                    d.setCjrq(cjrq.getText().toString());
                    d.setLtms(ltms.getText().toString());
                    d.setAqss(aqss.getText().toString());
                    d.setWfjl(wfjl.getText().toString());
                    d.setCzqk(czqk.getText().toString());
                    d.setLxjssj(lxjssj.getText().toString());
                    d.setDjmj(djmj.getText().toString());
                    d.setYtglmj(ytglmj.getText().toString());
                    d.setBz(bz.getText().toString());
                    d.setIsDel(0);
                    d.setCreateTime(DateUtil.format(new Date()));
                    d.setCreater(Long.valueOf(user.getID()));
                    String url = DataUtil.getUrl(PassengerFormActivity.this,"save");
                    String sql = CreateSql.getSqlInset(d);
                    OkHttpUtils.post(url).tag(this)
                            .params("sql", sql)
                            .mediaType(PostRequest.MEDIA_TYPE_PLAIN)//
                            .execute(new BeanCallBack<Code>() {
                                @Override
                                public void onResponse(boolean isFromCache, Code data, Request request, @Nullable Response response) {
                                    if(data.getCode() != null && data.getCode() == 0){
                                        PassengerListActivity.launch(PassengerFormActivity.this);
                                    }
                                }
                            }, PassengerFormActivity.this);
                }
            }
        });
        Utils.configureFab(mFabButton);
    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, PassengerFormActivity.class);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
