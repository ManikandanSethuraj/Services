package com.manikandansethuraj.musicmachineservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

/**
 * Created by MANIKANDAN_SETHURAJ on 2016-08-03.
 */
public class DoenloadService extends Service {

    private DownloadHandler mdownloadHandler;
    @Override
    public void onCreate() {
        super.onCreate();
        DownloadThread thread = new DownloadThread();
        thread.setName("DownloadSongThread");
        thread.start();

        while (thread.downloadHandler == null){

        }

            mdownloadHandler = thread.downloadHandler;
           mdownloadHandler.setService(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String songName = intent.getStringExtra(MainActivity.KEY_SONG);
        Message message = Message.obtain();
        message.obj = songName;
        message.arg1 = startId;
        mdownloadHandler.sendMessage(message);


        // downloadSongs(SongName);
        return Service.START_REDELIVER_INTENT;
       // return super.onStartCommand(intent, flags, startId);
    }




    @Nullable



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
