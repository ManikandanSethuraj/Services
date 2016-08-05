package com.manikandansethuraj.musicmachineservice;

import android.os.Looper;

/**
 * Created by MANIKANDAN_SETHURAJ on 2016-08-04.
 */
public class DownloadThread extends Thread {

    DownloadHandler downloadHandler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        downloadHandler = new DownloadHandler();
        Looper.loop();


    }
}
