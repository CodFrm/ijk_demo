package com.example.codef.ijkplay_demo.ijkplayer;

/**
 * Created by codef on 2018/2/7.
 */

public interface IVideoEvent {
    void onFullScreen();

    boolean onError(int i);

    void onReception();

    void onBackstage();

    boolean onSharSwitch(String Name, String Url);
}
