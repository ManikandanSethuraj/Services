package com.manikandansethuraj.musicmachineservice;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by MANIKANDAN_SETHURAJ on 2016-08-04.
 */
public class DownloadHandler extends Handler {
    private DoenloadService service;

    @Override
    public void handleMessage(Message msg) {



        downloadSongs(msg.obj.toString());
        service.stopSelf(msg.arg1);

        //   super.handleMessage(msg);
    }

    public void downloadSongs(String song){

        long time = System.currentTimeMillis() + 10000;
        while (time > System.currentTimeMillis()){
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("Download Handler",song+" Downloaded");
    }

    public void setService(DoenloadService service) {
        this.service = service;
    }
}
