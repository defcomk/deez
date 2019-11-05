package ZephrTech;

import android.hardware.camera2.CaptureRequest;
import android.util.Log;

public class Intercept {


    public static void getHyperFocal(CaptureRequest.Key KeYE,Object data)

    {
        if(KeYE == CaptureRequest.LENS_FOCUS_DISTANCE)
        {
            Log.d("Inteceptor","Focus Distance: "+String.valueOf(data));
            Log.d("Inteceptor","Focus Distance: "+String.valueOf((float)data));
        }
    }
}
