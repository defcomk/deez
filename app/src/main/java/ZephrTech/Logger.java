package ZephrTech;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;

public class Logger {
private static final String TAG ="LogME";

    public static void LogArrayRect(Rect[] arr)
    {
        int counter = 0;
        if (arr != null) {
            for (Rect rct : arr
                    ) {
                Log.d(TAG, "LogArrayRect: Index:" + counter);
                counter++;
                Log.d(TAG, "LogArrayRect: " + "Bottom: " + rct.bottom + "Top: "
                        + rct.top + "Left: " + rct.left + "Right: " + rct.right);

            }
        }
        else{ Log.d(TAG, "LogArrayRect: Array Null");}


    }

    public static void LogRect(Rect arr)
    {


                Log.d(TAG, "LogRect: " + "Bottom: " + arr.bottom + "Top: "
                        + arr.top + "Left: " + arr.left + "Right: " + arr.right);



    }

    public static void LogFloat(float arr)
    {


            Log.d(TAG, "LogFloat: "+arr);


    }

    public static void LogString(String arr)
    {


        Log.d(TAG, "LogString: "+arr);


    }

    public static void LogInt(int arr)
    {


        Log.d(TAG, "LogString: "+arr);


    }

    public static void LogArrayFloat(float[] arr)
    {
        int counter = 0;
        if (arr != null) {
            for (float rct : arr
                    ) {
                Log.d(TAG, "LogArrayFloat: Index:" + counter);
                counter++;
                Log.d(TAG, "LogArrayFloat: " +rct);

            }
        }
        else{ Log.d(TAG, "LogArrayFloat: Array Null");}


    }

    public static void LogArrayString(String[] arr)
    {
        int counter = 0;
        if (arr != null) {
            for (String rct : arr
                    ) {
                Log.d(TAG, "LogArrayString: Index:" + counter);
                counter++;
                Log.d(TAG, "LogArrayString: " +rct);

            }
        }
        else{ Log.d(TAG, "LogArrayString: Array Null");}


    }

    public static void  dumpByte(byte[] pdaf)
    {
        for (byte b:pdaf)
        {
            Log.v(TAG,"-"+(int)b);
        }
    }

    public static void LogEEPROM_WB(CameraCharacteristics ctor)
    {

        try {
            int ILLUMNUM = ctor.get(CameraCharacteristics.LENS_POSE_REFERENCE);

            float[] R = ctor.get(CameraCharacteristics.LENS_DISTORTION);

            float[] G = ctor.get(CameraCharacteristics.LENS_DISTORTION);

            float[] B = ctor.get(CameraCharacteristics.LENS_DISTORTION);


            Log.v(TAG, "ILLUMINATS FOUND: " +ILLUMNUM);
            for (int i = 0; i < R.length; i++) {
                Log.v(TAG, "AWB RED: " + R[i]);
                Log.v(TAG, "AWB Green: " + G[i]);
                Log.v(TAG, "AWB BLUE: " + B[i]);
            }
        }
        catch (Exception welp)
        {
            welp.getStackTrace();
        }
    }


}
