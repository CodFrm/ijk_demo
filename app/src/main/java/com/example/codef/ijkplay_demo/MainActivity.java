package com.example.codef.ijkplay_demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.codef.ijkplay_demo.ijkplayer.IVideoEvent;
import com.example.codef.ijkplay_demo.ijkplayer.ijkvideo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements IVideoEvent {
    ijkvideo ijk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        initPlayer();
    }

    public void initPlayer() {
        ijk = new ijkvideo(this);
        ijk.setEvent(this);
        ijk.createPlayer(0, 0, 1080, 640);
        String url = "https://ltsbsy.qq.com/uwMRJfz-r5jAYaQXGdGnC2_ppdhgmrDlPaRvaV7F2Ic/yh_2B1nhzSQO8pmHVDtC_heqD2D06Rz5orVR78ZbYmE8RDaw66GCnh-s_uM3MT0rDXMgm-lc2iBQVB2tO4q5pf4igyQpobr1KYPLRY5i1iYL5N6dWJE6JfrubGKHAnE9dg8cZ3XcE3VfpH2z93vIhLbLiqxidzUQ/y0016tj0qvh.321002.ts.m3u8?ver=4";
        ijk.toggleAspectRatio(3);
//        ijk.addHeader("test","header");
//        ijk.addHeader("emmm","qwerqwe");
//        ijk.addShar("test","emm");
        //ijk.selectShar("呵呵");
//        ijk.clearHeader();
        ijk.setVideoUrl(url);

        ijk.start();
    }

    @Override
    public void onReception() {
        ijk.start();
    }

    @Override
    public boolean onSharSwitch(String Name, String Url) {
        return false;
    }

    @Override
    public void onBackstage() {
        ijk.pause();
    }


    public void btnClick(View v) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                ijk.setTitle("我是标题标题我是标题标题我是标题标题我是标题标题我是标题标题我是标题标题我是标题标题我是标题标题我是标题标题我是标题标题我是标题标题");
                ijk.addShar("测试", "http://mvvideo10.meitudata.com/5a73fac39cd785585_H264_15.mp4?k=70bc472f07e2e87e16a91f102bedfdfc&t=5a841e82");
                ijk.addShar("呵呵", "http://192.168.1.10/v.f4v");
                ijk.addShar("会更好的", "http://182.61.16.216:1086/app/cache/m3u8/b747824b910f2e7c48d84555db972000.xml");
                ijk.selectShar("会更好的");
            }

        });
//        ijk.fullScreen();
    }

    @Override
    public void onFullScreen() {
        int a = 0;
        a = a + 2;
        Log.e(null, "error");
    }

    @Override
    public boolean onError(int i) {
        ((TextView) findViewById(R.id.text_error)).setText(i);
        Log.e(null, "error:code:" + i);
        return false;
    }

    @Override
    public void onDestroy() {
        ijk.deletePlayer();
        super.onDestroy();
    }
}
