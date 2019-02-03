package ZephrTech;

import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StaticMeta {

    public static final CaptureRequest.Key<Integer> VIDEO_HDR;
    public static final int VIDEO_HDR_ON = 1;
    public static final int VIDEO_HDR_OFF = 0;

    public static final CaptureRequest.Key<Integer> SHARPNESS;
    public static final int SHARPNESS_MIN = 0;
    public static final int SHARPNESS_MAX = 36;

    public static final CaptureRequest.Key<Integer> SATURATION;
    public static final int SATURATION_MIN = 0;
    public static final int SATURATION_MAX = 10;

    public static final CaptureRequest.Key<Integer> ISO_PRIORITY;
    public static final int ISO_AUTO = 0;
    public static final int ISO_AUTO_HJR = 1;
    public static final int ISO_100 = 2;
    public static final int ISO_200 = 3;
    public static final int ISO_400 = 4;
    public static final int ISO_800 = 5;
    public static final int ISO_1600 = 6;
    public static final int ISO_3200 = 7;

    public static final CaptureRequest.Key<Integer> AEC_METERING_MODE;
    public static final int AEC_METERING_MODE_FRAME_AVERAGE = 0;
    public static final int AEC_METERING_MODE_CENTER_WEIGHTED = 1;
    public static final int AEC_METERING_MODE_SPOT_METERING = 2;
    public static final int AEC_METERING_MODE_SPOT_METERING_ADV = 5;
    public static final int AEC_METERING_MODE_CENTER_WEIGHTED_ADV = 6;

    static {
        VIDEO_HDR = getKeyClass("org.codeaurora.qcamera3.video_hdr_mode.vhdr_mode",Integer.class);
        SHARPNESS = getKeyClass("org.codeaurora.qcamera3.sharpness.strength",Integer.class);
        SATURATION = getKeyClass("org.codeaurora.qcamera3.saturation.use_saturation",Integer.class);

        ISO_PRIORITY = getKeyClass("org.codeaurora.qcamera3.iso_exp_priority.select_priority",Integer.class);
        AEC_METERING_MODE = getKeyClass("org.codeaurora.qcamera3.exposure_metering.exposure_metering_mode",Integer.class);




    }

    private static <T> CaptureRequest.Key getKeyClass(String string, Class<T> type)
    {
        try {
            Constructor<?>[] ctors = CaptureRequest.Key.class.getDeclaredConstructors();
            Constructor<CaptureRequest.Key> constructor = (Constructor<CaptureRequest.Key>) ctors[2];
            constructor.setAccessible(true);
            return constructor.newInstance(string,type);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static float[] MotoRAWFiX()
    {
        return new float[] {1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F};
    }

    public static Rect[] OpticalBlackMeta(){
        Rect R = new Rect(0,0,4032,16);
        Rect G1 = new Rect(0,0,4032,16);
        Rect G2 = new Rect(0,0,4032,16);
        Rect B = new Rect(0,0,4032,16);

        return new Rect[]{R,G1,G2,B};

    }


}
