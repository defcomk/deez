package com.example.jacckline.myapplication;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.codeaurora.qcamera3.ExtendoKeys;

import ZephrTech.DynUtil;
import ZephrTech.Google.Pissel3;
import ZephrTech.Logger;
import deeznutz.lol;

public class MainActivity extends AppCompatActivity {
private static Context ctex;
lol loco2 = lol.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.ctex = getApplicationContext();

        setContentView(R.layout.activity_main);

    }

    public static Context getCtex(){
        return MainActivity.ctex;

    }


    private void initLOL(Rect[] Trekt)
    {



        lol.calcdist(5);
        Log.i("LOLLOG", "focusPOS "+ lol.getFocusDistance());
        float[] locoo = lol.getCCM_1();
        float[] locoo2 = lol.getCCM_2();

        ExtendoKeys.VIDEO_HDR.getName();

        logInt(ExtendoKeys.VIDEO_HDR_ON);


        logInt(lol.getISOTGT());

        logLong(lol.getEXPTGT());


        Logger.LogArrayRect(Trekt);

        Pissel3 pissel3 = new Pissel3();
        logFloat(pissel3.NOISE_MODEL()[0]);


       ExtendoKeys.DYN_B.getName();

       logFloat(DynUtil.WB_B()[0]);

       float[] a = DynUtil.WB_B();

       ExtendoKeys.PDAF.getName();
       byte[] q = new byte[]{(byte) 1,(byte)2,(byte)3,(byte)4,(byte)5};
       
       Logger.dumpByte(q);

    }

    private void switchMAN()
    {

    }

    private void slide()
    {

    }


    private void getFocus()
    {
        if(loco2.getFocusMode()>0)
        {
            switchMAN();
        }

    }

    private void du()
    {



        logMSG("Helo");

        logLong(55L);
        logFloat(88f);
        logInt(777);

        lol loco = lol.getInstance();

        loco.calcdist(58);
        loco.setISeek(60);
        loco.setIsoAe(500);
        loco.setShutter_AE(5000L);
        logLong(loco.getShutter_Adjusted());
        logFloat(loco.getFocusDistance());
        logInt(loco.getFocusValue());

        logArray(lol.BlackShift(12800,1));
        logArray(lol.BlackShiftOBJ(12800,1));

    }

    private void co()
    {

        lol.SlideVALUES();
        logLong(lol.getSLIDER()[0]);

        logInt((int) lol.getSLIDER()[1]);

        logInt((int) (lol.getSLIDER()[1]/1.8));
    }

    public static void logMSG(String A)
    {
        Log.i("DeezNuts","MSG: "+A);
    }

    public static void logLong (long L)
    {
        Log.i("DeezNutz", "logLong: "+L);
    }

    public static void logFloat (float L)
    {
        Log.i("DeezNutz", "logFloat: "+L);
    }

    public static void logInt (int L)
    {
        Log.i("DeezNutz", "logINT: "+L);
    }

    public static void logArray (float[] L)
    {
        for (float a:L
             ) {
            Log.i("DeezNutz", "logArray Index: "+a);

        }


    }
}
