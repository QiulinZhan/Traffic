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
import com.example.qiulin.traffic.beans.vo.User;
import com.example.qiulin.traffic.layout.DateTimePickDialogUtil;
import com.example.qiulin.traffic.utils.CreateSql;
import com.example.qiulin.traffic.utils.DataUtil;
import com.example.qiulin.traffic.utils.DateUtil;
import com.example.qiulin.traffic.utils.Utils;
import com.example.qiulin.traffic.utils.okhttputils.OkHttpUtils;
import com.example.qiulin.traffic.utils.okhttputils.callback.BeanCallBack;
import com.example.qiulin.traffic.utils.okhttputils.request.PostRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.rengwuxian.materialedittext.MaterialEditText;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qiulin on 2015/1/21 0021.
 */
public class DangerousFormActivity extends AppCompatActivity {
    private ImageButton mFabButton;
    private static Gson gson = new Gson();
    MaterialEditText checkTime,isGua,txzNo,driverCode,driverName,nextCheckTime,driverCode2,zg,yyrxm,yyz,yydh,ghcjmc,
            ghcjlxr,ghcjdh,hzzl,szzl,qydj,hwxz,clxcjyrq,aqss,ltms,wfjl,ytglmj,yjcli,bz,djmj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangerousform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("危化品运输登记");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangerousFormActivity.this.onBackPressed();
            }
        });
        checkTime = (MaterialEditText) findViewById(R.id.checkTime);
        checkTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        DangerousFormActivity.this, checkTime.getText().toString());
                dateTimePicKDialog.dateTimePicKDialog(checkTime);
            }
        });
        isGua = (MaterialEditText) findViewById(R.id.isGua);
        txzNo = (MaterialEditText) findViewById(R.id.txzNo);
        driverCode = (MaterialEditText) findViewById(R.id.driverCode);
        driverName = (MaterialEditText) findViewById(R.id.driverName);
        nextCheckTime = (MaterialEditText) findViewById(R.id.nextCheckTime);
        nextCheckTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        DangerousFormActivity.this, nextCheckTime.getText().toString());
                dateTimePicKDialog.dateTimePicKDialog(nextCheckTime);
            }
        });
        driverCode2 = (MaterialEditText) findViewById(R.id.driverCode2);
        zg = (MaterialEditText) findViewById(R.id.zg);
        yyrxm = (MaterialEditText) findViewById(R.id.yyrxm);
        yyz = (MaterialEditText) findViewById(R.id.yyz);
        yydh = (MaterialEditText) findViewById(R.id.yydh);
        ghcjmc = (MaterialEditText) findViewById(R.id.ghcjmc);
        ghcjlxr = (MaterialEditText) findViewById(R.id.ghcjlxr);
        ghcjdh = (MaterialEditText) findViewById(R.id.ghcjdh);
        hzzl = (MaterialEditText) findViewById(R.id.hzzl);
        szzl = (MaterialEditText) findViewById(R.id.szzl);
        qydj = (MaterialEditText) findViewById(R.id.qydj);
        hwxz = (MaterialEditText) findViewById(R.id.hwxz);
        clxcjyrq = (MaterialEditText) findViewById(R.id.clxcjyrq);
        clxcjyrq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        DangerousFormActivity.this, clxcjyrq.getText().toString());
                dateTimePicKDialog.dateTimePicKDialog(clxcjyrq);
            }
        });
        aqss = (MaterialEditText) findViewById(R.id.aqss);
        ltms = (MaterialEditText) findViewById(R.id.ltms);
        wfjl = (MaterialEditText) findViewById(R.id.wfjl);
        djmj = (MaterialEditText) findViewById(R.id.djmj);
        ytglmj = (MaterialEditText) findViewById(R.id.ytglmj);
        yjcli = (MaterialEditText) findViewById(R.id.yjcli);
        bz = (MaterialEditText) findViewById(R.id.bz);

        mFabButton = (ImageButton) findViewById(R.id.fab_button);
        mFabButton.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_floppy_o).color(Color.WHITE));
        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = DataUtil.getDate(DangerousFormActivity.this);
                if(user == null || user.getID() == null){
                    Intent intent = new Intent(DangerousFormActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                }else{
                    Dangerous d = new Dangerous();

                    String temp = checkTime.getText().toString();
                    if(StringUtils.isBlank(temp)){
                        checkTime.setError("不能为空");
                        return;
                    }
                    d.setJcsj(checkTime.getText().toString());
                    temp = isGua.getText().toString();
                    if(StringUtils.isNumeric(temp)){
                        d.setSfgc(Integer.valueOf(temp));
                    }else{
                        d.setSfgc(Integer.valueOf(0));
                    }
                    d.setTxzbh(txzNo.getText().toString());
                    d.setJsrjszh(driverCode.getText().toString());
                    d.setJsrxm(driverName.getText().toString());
                    d.setJsrxctjrq(nextCheckTime.getText().toString());
                    d.setJsrjsztxm(driverCode2.getText().toString());
                    d.setJsrjszg(zg.getText().toString());
                    d.setYyyxm(yyrxm.getText().toString());
                    d.setYyyyyz(yyz.getText().toString());
                    d.setYyydh(yydh.getText().toString());
                    d.setGhcjmc(ghcjmc.getText().toString());
                    d.setGhcjlxr(ghcjlxr.getText().toString());
                    d.setGhcjdh(ghcjdh.getText().toString());
                    d.setHzzl(hzzl.getText().toString());
                    d.setSzzl(szzl.getText().toString());
                    d.setQydj(qydj.getText().toString());
                    d.setHwxz(hwxz.getText().toString());
                    d.setCjrq(clxcjyrq.getText().toString());
                    d.setAqss(aqss.getText().toString());
                    d.setLtms(ltms.getText().toString());
                    d.setWfjl(wfjl.getText().toString());
                    d.setDjmj(djmj.getText().toString());
                    d.setYtglmj(ytglmj.getText().toString());
                    d.setBz(bz.getText().toString());
                    d.setIsDel(0);
                    d.setCreateTime(DateUtil.format(new Date()));
                    d.setCreater(Long.valueOf(user.getID()));
                    String url = DataUtil.getUrl(DangerousFormActivity.this,"save");
                    String sql = CreateSql.getSqlInset(d);
                    OkHttpUtils.post(url).tag(this)
                            .params("sql", sql)
                            .mediaType(PostRequest.MEDIA_TYPE_PLAIN)//
                            .execute(new BeanCallBack<Code>() {
                                @Override
                                public void onResponse(boolean isFromCache, Code data, Request request, @Nullable Response response) {
                                    if(data.getCode() != null && data.getCode() == 0){
                                        DangerousListActivity.launch(DangerousFormActivity.this);
                                    }
                                }
                            }, DangerousFormActivity.this);
                }

            }
        });
        Utils.configureFab(mFabButton);
    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.head_in, R.anim.head_out);
        Intent intent = new Intent(activity, DangerousFormActivity.class);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
