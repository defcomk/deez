package deeznutz;

import android.graphics.Camera;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.util.Log;
import android.util.Range;

import java.util.Objects;

public class lol
{
    protected static int API2_ISO;
    protected static long API2_EXP;
    protected static int API2_Analog_ISO;
    //////////////////////////////////////////
    private static int ISO_AE;
    private static lol lol = new lol();
    private static long Shutter_AE;

    private static int SYS_ISO;
    private static long SYS_SHUTTER;

    private static long Shutter_Adjusted;
    private static float focusDistance;
    private static int focusMode;
    private static int isoVal;
    private static long shutterdurationl;
    private static final float CROP_1_255 = 5.9f;
    private static final float CROP_1_26 = 6.0f;
    private static final float CROP_1_23 = 5.6f;
    private static final long S_2_NS = 1000000000;

    private static int ISO_Out= 0;

    private static float ISO_to_Gain_Quant = 1.0f;

    public static void setApi2Exp(long api2Exp) {
        API2_EXP = api2Exp;
    }

    public static void setApi2Iso(int api2Iso) {
        API2_ISO = api2Iso;
    }


    public static void calc_quantization(CameraCharacteristics cameraCharacteristics)
    {
        Range i = cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);

        try {
            ISO_to_Gain_Quant = 100f /  (Integer)i.getLower();
        }catch (Exception ex)
        {
            ISO_to_Gain_Quant = 2f;
        }

    }

    public static float getISO_to_Gain_Quant()
    {
        return ISO_to_Gain_Quant;
    }

    public static float getSliderindex()
    {
        return isoVal;
    }




    public static float[] BlackShift(int paramInt1, int paramInt2)
    {
        if (paramInt2 == 0) {
            return new float[] { 64.0F, 64.0F, 64.0F, 64.0F };
        }
        if ((paramInt1 > 99) && (paramInt1 < 200)) {
            return new float[] { 63.875F, 64.0F, 64.8125F, 64.25F };
        }
        if ((paramInt1 > 200) && (paramInt1 < 400)) {
            return new float[] { 63.75F, 65.0F, 63.75F, 63.9375F };
        }
        if ((paramInt1 > 400) && (paramInt1 < 800)) {
            return new float[] { 63.75F, 63.75F, 64.75F, 63.6875F };
        }
        if ((paramInt1 > 800) && (paramInt1 < 1600)) {
            return new float[] { 63.5625F, 63.5F, 64.4375F, 63.5F };
        }
        if ((paramInt1 > 1600) && (paramInt1 < 3200)) {
            return new float[] { 64.125F, 64.625F, 63.9375F, 63.9375F };
        }
        if ((paramInt1 > 3200) && (paramInt1 < 6400)) {
            return new float[] { 63.3125F, 64.3125F, 67.92969F, 63.6875F };
        }
        if ((paramInt1 > 6400) && (paramInt1 < 12800)) {
            return new float[] { 61.6875F, 62.6875F, 62.9375F, 63.4375F };
        }
        if ((paramInt1 > 12800) && (paramInt1 < 19200)) {
            return new float[] { 59.75F, 63.4375F, 61.9375F, 63.0F };
        }
        if (paramInt1 < 19200) {
            return new float[] { 72.0F, 72.0F, 71.0F, 72.0F };
        }
        return new float[] { 62.25F, 64.6875F, 64.5625F, 64.875F };
    }

    public static float[] BlackShiftOBJ(Integer paramInteger1, Integer paramInteger2)
    {
        if (paramInteger2 == 1) {
            return new float[] { 16.0F, 16.0F, 16.0F, 16.0F };
        }
        if ((paramInteger1 > 3200) && (paramInteger1 < 6400)) {
            return new float[] { 65.0F, 65.0F, 64.0F, 65.0F };
        }
        if ((paramInteger1 > 6400) && (paramInteger1 < 8800)) {
            return new float[] { 65.0F, 65.0F, 65.0F, 64.0F };
        }
        if ((paramInteger1 > 8800) && (paramInteger1 < 12800)) {
            return new float[] { 66.0F, 66.0F, 66.0F, 67.0F };
        }
        return new float[] { 64.0F, 64.0F, 64.0F, 64.0F };
    }

    public static void calcdist(int paramInt)
    {

        if(Build.DEVICE.equals("beryllium") &&(paramInt>=2 && paramInt<=15))
        {
            paramInt = 16;
        }
        focusMode = paramInt;

        logMSG("SLIDER 1 IDX: "+isoVal);


        switch (paramInt)
        {
            case 1:
                focusDistance = 0.34270397f;
                break;
            case 2:
                focusDistance = 0.34270397f;
                break;
            case 3:
                focusDistance = 0.002f;
                break;
            case 4:
                focusDistance = 0.003f;
                break;
            case 5:
                focusDistance = 0.005f;
                break;
            case 6:
                focusDistance = 0.006f;
                break;
            case 7:
                focusDistance = 0.007f;
                break;
            case 8:
                focusDistance = 0.008f;
                break;
            case 9:
                focusDistance = 0.009f;
                break;
            case 10:
                focusDistance = 0.01f;
                break;
            case 11:
                focusDistance = 0.03f;
                break;
            case 12:
                focusDistance = 0.05f;
                break;
            case 13:
                focusDistance = 0.07f;
                break;
            case 14:
                focusDistance = 0.09f;
                break;
            case 15:
                focusDistance = 0.11f;
                break;
            case 16:
                focusDistance = 0.34270397f;
                break;
            case 17:
                focusDistance = 0.31f;
                break;
            case 18:
                focusDistance = 0.41f;
                break;
            case 19:
                focusDistance = 0.51f;
                break;
            case 20:
                focusDistance = 0.61f;
                break;
            case 21:
                focusDistance = 0.71f;
                break;
            case 22:
                focusDistance = 0.81f;
                break;
            case 23:
                focusDistance = 0.91f;
                break;
            case 24:
                focusDistance = 0.95f;
                break;
            case 25:
                focusDistance = 1.01f;
                break;
            case 26:
                focusDistance = 1.21f;
                break;
            case 27:
                focusDistance = 1.41f;
                break;
            case 28:
                focusDistance = 1.61f;
                break;
            case 29:
                focusDistance = 1.81f;
                break;
            case 30:
                focusDistance = 2.01f;
                break;
            case 31:
                focusDistance = 2.21f;
                break;
            case 32:
                focusDistance = 2.41f;
                break;
            case 33:
                focusDistance = 2.61f;
                break;
            case 34:
                focusDistance = 2.81f;
                break;
            case 35:
                focusDistance = 3.01f;
                break;
            case 36:
                focusDistance = 3.21f;
                break;
            case 37:
                focusDistance = 3.41f;
                break;
            case 38:
                focusDistance = 3.61f;
                break;
            case 39:
                focusDistance = 3.81f;
                break;
            case 40:
                focusDistance = 4.01f;
                break;
            case 41:
                focusDistance = 4.21f;
                break;
            case 42:
                focusDistance = 4.41f;
                break;
            case 43:
                focusDistance = 4.61f;
                break;
            case 44:
                focusDistance = 4.81f;
                break;
            case 45:
                focusDistance = 5.01f;
                break;
            case 46:
                focusDistance = 5.21f;
                break;
            case 47:
                focusDistance = 5.41f;
                break;
            case 48:
                focusDistance = 5.61f;
                break;
            case 49:
                focusDistance = 5.81f;
                break;
            case 50:
                focusDistance = 6.01f;
                break;
            case 51:
                focusDistance = 6.21f;
                break;
            case 52:
                focusDistance = 6.41f;
                break;
            case 53:
                focusDistance = 6.61f;
                break;
            case 54:
                focusDistance = 6.81f;
                break;
            case 55:
                focusDistance = 7.01f;
                break;
            case 56:
                focusDistance = 7.21f;
                break;
            case 57:
                focusDistance = 7.41f;
                break;
            case 58:
                focusDistance = 7.61f;
                break;
            case 59:
                focusDistance = 7.81f;
                break;
            case 60:
                focusDistance = 8.01f;
                break;
            case 61:
                focusDistance = 8.21f;
                break;
            case 62:
                focusDistance = 8.41f;
                break;
            case 63:
                focusDistance = 8.61f;
                break;
            case 64:
                focusDistance = 9.01f;
                break;
            case 65:
                focusDistance = 9.21f;
                break;
            case 66:
                focusDistance = 9.41f;
                break;
            case 67:
                focusDistance = 9.61f;
                break;
            case 68:
                focusDistance = 9.81f;
                break;
            case 69:
                focusDistance = 9.90f;
                break;
            case 70:
                focusDistance = 10.0f;
                break;
            default:
                focusDistance = 1.0E-4f;

        }
    }

    public static void setAPI2_Analog_ISO(int API2_Analog_ISO) {
        deeznutz.lol.API2_Analog_ISO = API2_Analog_ISO;
    }



    public static float[] getCCM_1()
    {
        return new float[] { 1.2341F, 0.666F, 0.0994F, -0.2806F, 1.0683F, 0.2451F, 0.0127F, 0.0727F, 0.5789F };
    }

    public static float[] getCCM_2()
    {
        return new float[] { 1.0612F, -0.4169F, -0.1001F, -0.3982F, 1.2675F, 0.1412F, -0.0558F, 0.162F, 0.5206F };
    }

    public static Float[] getFM_1()
    {
        Float[] arrayOfFloat = new Float[9];
        arrayOfFloat[0] = 0.4187F;
        arrayOfFloat[1] = Float.valueOf(0.4351F);
        arrayOfFloat[2] = Float.valueOf(0.1105F);
        arrayOfFloat[3] = Float.valueOf(0.1772F);
        arrayOfFloat[4] = Float.valueOf(0.7902F);
        arrayOfFloat[5] = Float.valueOf(0.0326F);
        arrayOfFloat[6] = Float.valueOf(0.047F);
        arrayOfFloat[7] = Float.valueOf(0.001F);
        arrayOfFloat[8] = Float.valueOf(0.7772F);
        return arrayOfFloat;
    }

    public static Float[] getFM_2()
    {
        Float[] arrayOfFloat = new Float[9];
        arrayOfFloat[0] = Float.valueOf(0.4226F);
        arrayOfFloat[1] = Float.valueOf(0.4079F);
        arrayOfFloat[2] = Float.valueOf(0.1337F);
        arrayOfFloat[3] = Float.valueOf(0.1871F);
        arrayOfFloat[4] = Float.valueOf(0.7745F);
        arrayOfFloat[5] = Float.valueOf(0.0384F);
        arrayOfFloat[6] = Float.valueOf(0.0618F);
        arrayOfFloat[7] = Float.valueOf(0.0047F);
        arrayOfFloat[8] = Float.valueOf(0.7586F);
        return arrayOfFloat;
    }

    public static Float getFocusDistance()
    {
        return Float.valueOf(focusDistance);
    }

    public static Integer getFocusMode()
    {
        return Integer.valueOf(focusMode);
    }

    public static int getFocusValue()
    {
        if (focusMode == 0) {
            return 5;
        }
        return 0;
    }


    public static lol getInstance()
    {
        return lol;
    }

    public static int getIsoVal()
    {
        if (isoVal == 9001) {
            return 26 * 4;
        }
        if (isoVal == 9002) {
            return 'È' * 4;
        }
        if (isoVal == 9003) {
            return '?' * 4;
        }
        if (isoVal == 9999) {
            return '?' * 4;
        }
        return 4 * isoVal;
    }

    public static long getShutter_Adjusted()
    {
        if ((isoVal == 9001) || (isoVal == 9002) || (isoVal == 9999) || (isoVal == 9003)) {
            return 19000000000L;
        }
        if (isoVal > 0)
        {
            if (isoVal < ISO_AE) {
                return Math.round(ISO_AE / isoVal * Shutter_AE);
            }
            return Shutter_AE;
        }
        return Shutter_AE;
    }

    private static int isoLut(int paramInt)
    {
        switch (paramInt)
        {
            case 0:
                return 0;

            case 1:
                return 100;

            case 2:
                return 156;
            case 3:
                return 200;
            case 4:
                return 312;
            case 5:
                return 400;
            case 6:
                return 625;
            case 7:
                return 800;
            case 8:
                return 1000;
            case 9:
                return 1250;
            case 10:
                return 1600;
            case 11:
                return 2500;
            case 12:
                return 3200;
            case 13:
                return 5000;
            case 14:
                return 6400;
            case 15:
                return 9600;
            case 16:
                return 10000;
            case 17:
                return 12800;
            case 18:
                return 25600;
            case 19:
                return 9001;
            case 20:
                return 9002;
            case 21:
                return 9003;
            case 22:
                return 9999;
            default:
                return 0;


        }
    }

    public static void logArray(float[] paramArrayOfFloat)
    {

        for (float f : paramArrayOfFloat) {
            Log.i("DeezNutz", "logArray Index: " + f);
        }
    }

    public static void logFloat(float paramFloat)
    {
        Log.i("DeezNutz", "logFloat: " + paramFloat);
    }

    public static void logInt(int paramInt)
    {
        Log.i("DeezNutz", "logINT: " + paramInt);
    }

    public static void logLong(long paramLong)
    {
        Log.i("DeezNutz", "logLong: " + paramLong);
    }

    public static void logMSG(String paramString)
    {
        Log.i("DeezNuts", "MSG: " + paramString);
    }

    public static void logRECT(Rect[] paramArrayOfRect)
    {
        int i = paramArrayOfRect.length;
        for (int j = 0; j < i; j++)
        {
            Rect localRect = paramArrayOfRect[j];
            Log.i("DeezNutz Array", "RECT LEFT: " + localRect.left + "RECT Right: " + localRect.right + "RECT Top: " + localRect.top + "RECT Bottom: " + localRect.bottom);
        }
    }

    public static void logRECToptical(Rect[] paramArrayOfRect)
    {
        int i = paramArrayOfRect.length;
        for (int j = 0; j < i; j++)
        {
            Rect localRect = paramArrayOfRect[j];
            Log.i("DeezNutz Optical", "RECT LEFT: " + localRect.left + "RECT Right: " + localRect.right + "RECT Top: " + localRect.top + "RECT Bottom: " + localRect.bottom);
        }
    }

    public static boolean onVaar()
    {
        return false;
    }

    public static void setISeek(int paramInt)
    {
        //isoVal = isoLut(paramInt);
        isoVal = paramInt;
        logMSG("SLIDER 0 IDX: "+isoVal);
    }

    public static void setSYSISO(Integer paramInteger)
    {
        SYS_ISO = paramInteger;
    }

    public static void setIsoAe(Integer paramInteger)
    {
        ISO_AE = paramInteger;
    }

    public static void setSHseek(int paramInt)
    {
        shutterdurationl = shutterLut(paramInt);
    }

    public static void setShutter_AE(Long paramLong)
    {
        Shutter_AE = paramLong;
    }

    public static void setSYSEXP(Long paramLong)
    {
        SYS_SHUTTER = paramLong;
    }

    private static long shutterLut(int paramInt)
    {
        switch (paramInt)
        {
            case 0:
                return 0L;

            case 1:
                return 33333L;

            case 2:
                return 66666L;
            case 3:
                return 100000L;
            case 4:
                return 125000L;
            case 5:
                return 156250L;
            case 6:
                return 312500L;
            case 7:
                return 400000L;
            case 8:
                return 500000L;
            case 9:
                return 625000L;
            case 10:
                return 800000L;
            case 11:
                return 1000000L;
            case 12:
                return 1250000L;
            case 13:
                return 1428571L;
            case 14:
                return 1666666L;
            case 15:
                return 2000000L;
            case 16:
                return 2500000L;
            case 17:
                return 3333333L;
            case 18:
                return 5000000L;
            case 19:
                return 10000000L;
            case 20:
                return 12500000L;
            case 21:
                return 17857142L;
            case 22:
                return 20000000L;
            case 23:
                return 25000000L;
            case 24:
                return 33333333L;
            case 25:
                return 62500000L;
            case 26:
                return 66666666L;
            case 27:
                return 100000000L;
            case 28:
                return 125000000L;
            case 29:
                return 166666666L;
            case 30:
                return 250000000L;
            case 31:
                return 333333333L;
            case 32:
                return 500000000L;
            case 33:
                return 1000000000L;
            case 34:
                return 2000000000L;
            case 35:
                return 3000000000L;
            case 36:
                return 4000000000L;
            default:
                return 33333333L;


        }
    }

    public static Long getEXPTGT()
    {

        return getSLIDER()[0];
    }

    public static int getISO_Out() {
        return ISO_Out;
    }

    public static Integer getISOTGT()
    {


        ISO_Out = Math.round(getSLIDER()[1] / ISO_to_Gain_Quant);

        return ISO_Out;


    }

    public static float essTEN_AG_CHECK(float in)
    {
        if (in < 1)
        {
            return 1.000000f;
        }
        else
            return in;

    }


    public static long[] getSLIDER()
    {
        switch (isoVal) {
            case 0:
                return new long[]{Shutter_AE, ISO_AE};
            case 1:
                return new long[]{SYS_SHUTTER, SYS_ISO};
            case 2:
                long div = Shutter_AE/SYS_SHUTTER;

                return new long[]{Shutter_AE, SYS_ISO/div};
            case 3:
                return new long[]{Shutter_AE, 200};
            case 4:
                return new long[]{Shutter_AE, 400};
            case 5:
                return new long[]{Shutter_AE, 800};
            case 6:
                return new long[]{Shutter_AE, 1600};
            case 7:
                return new long[]{Shutter_AE, 3200};
            case 8:
                return new long[]{Shutter_AE, 6400};
            case 9:
                return new long[]{Shutter_AE, 9600};
            case 10:
                return new long[]{Shutter_AE, 12800};
            case 11:
                return new long[]{Shutter_AE, 25600};
            case 12:
                return new long[]{Shutter_AE, 32000};
            case 13:
                return new long[]{Shutter_AE, 51200};
            case 14:
                return new long[]{Shutter_AE, 64000};
            case 15:
                return new long[]{Shutter_AE, 85000};
            case 16:
                return new long[]{Shutter_AE, 102400};

            case (1+16):
                return new long[]{getShutter(1), getISO(1)};
            case 2+16:
                return new long[]{getShutter(2), getISO(1)};
            case 3+16:
                return new long[]{getShutter(3), getISO(1)};
            case 4+16:
                return new long[]{getShutter(4), getISO(1)};
            case 5+16:
                return new long[]{getShutter(5), getISO(1)};
            case 6+16:
                return new long[]{getShutter(6), getISO(1)};
            case 7+16:
                return new long[]{getShutter(7), getISO(1)};
            case 8+16:
                return new long[]{getShutter(8), getISO(1)};
            case 9+16:
                return new long[]{getShutter(1), getISO(2)};
            case 10+16:
                return new long[]{getShutter(2), getISO(2)};
            case 11+16:
                return new long[]{getShutter(3), getISO(2)};
            case 12+16:
                return new long[]{getShutter(4), getISO(2)};
            case 13+16:
                return new long[]{getShutter(5), getISO(2)};
            case 14+16:
                return new long[]{getShutter(6), getISO(2)};
            case 15+16:
                return new long[]{getShutter(7), getISO(2)};
            case 16+16:
                return new long[]{getShutter(8), getISO(2)};
            case 17+16:
                return new long[]{getShutter(1), getISO(3)};
            case 18+16:
                return new long[]{getShutter(2), getISO(3)};
            case 19+16:
                return new long[]{getShutter(3), getISO(3)};
            case 20+16:
                return new long[]{getShutter(4), getISO(3)};
            case 21+16:
                return new long[]{getShutter(5), getISO(3)};
            case 22+16:
                return new long[]{getShutter(6), getISO(3)};
            case 23+16:
                return new long[]{getShutter(7), getISO(3)};
            case 24+16:
                return new long[]{getShutter(8), getISO(3)};
            case 25+16:
                return new long[]{getShutter(1), getISO(4)};
            case 26+16:
                return new long[]{getShutter(2), getISO(4)};
            case 27+16:
                return new long[]{getShutter(3), getISO(4)};
            case 28+16:
                return new long[]{getShutter(4), getISO(4)};
            case 29+16:
                return new long[]{getShutter(5), getISO(4)};
            case 30+16:
                return new long[]{getShutter(6), getISO(4)};
            case 31+16:
                return new long[]{getShutter(7), getISO(4)};
            case 32+16:
                return new long[]{getShutter(8), getISO(4)};
            case 33+16:
                return new long[]{getShutter(1), getISO(5)};
            case 34+16:
                return new long[]{getShutter(2), getISO(5)};
            case 35+16:
                return new long[]{getShutter(3), getISO(5)};
            case 36+16:
                return new long[]{getShutter(4), getISO(5)};
            case 37+16:
                return new long[]{getShutter(5), getISO(5)};
            case 38+16:
                return new long[]{getShutter(6), getISO(5)};
            case 39+16:
                return new long[]{getShutter(7), getISO(5)};
            case 40+16:
                return new long[]{getShutter(8), getISO(5)};
            case 41+16:
                return new long[]{getShutter(1), getISO(6)};
            case 42+16:
                return new long[]{getShutter(2), getISO(6)};
            case 43+16:
                return new long[]{getShutter(3), getISO(6)};
            case 44+16:
                return new long[]{getShutter(4), getISO(6)};
            case 45+16:
                return new long[]{getShutter(5), getISO(6)};
            case 46+16:
                return new long[]{getShutter(6), getISO(6)};
            case 47+16:
                return new long[]{getShutter(7), getISO(6)};
            case 48+16:
                return new long[]{getShutter(8), getISO(6)};
            case 49+16:
                return new long[]{getShutter(1), getISO(7)};
            case 50+16:
                return new long[]{getShutter(2), getISO(7)};
            case 51+16:
                return new long[]{getShutter(3), getISO(7)};
            case 52+16:
                return new long[]{getShutter(4), getISO(7)};
            case 53+16:
                return new long[]{getShutter(5), getISO(7)};
            case 54+16:
                return new long[]{getShutter(6), getISO(7)};
            case 55+16:
                return new long[]{getShutter(7), getISO(7)};
            case 56+16:
                return new long[]{getShutter(8), getISO(7)};
            case 57+16:
                return new long[]{getShutter(1), getISO(8)};
            case 58+16:
                return new long[]{getShutter(2), getISO(8)};
            case 59+16:
                return new long[]{getShutter(3), getISO(8)};
            case 60+16:
                return new long[]{getShutter(4), getISO(8)};
            case 61+16:
                return new long[]{getShutter(5), getISO(8)};
            case 62+16:
                return new long[]{getShutter(6), getISO(8)};
            case 63+16:
                return new long[]{getShutter(7), getISO(8)};
            case 64+16:
                return new long[]{getShutter(8), getISO(8)};
            case 65+16:
                return new long[]{getShutter(1), getISO(9)};
            case 66+16:
                return new long[]{getShutter(2), getISO(9)};
            case 67+16:
                return new long[]{getShutter(3), getISO(9)};
            case 68+16:
                return new long[]{getShutter(4), getISO(9)};
            case 69+16:
                return new long[]{getShutter(5), getISO(9)};
            case 70+16:
                return new long[]{getShutter(6), getISO(9)};
            case 71+16:
                return new long[]{getShutter(7), getISO(9)};
            case 72+16:
                return new long[]{getShutter(8), getISO(9)};
            case 73+16:
                return new long[]{getShutter(1), getISO(10)};
            case 74+16:
                return new long[]{getShutter(2), getISO(10)};
            case 75+16:
                return new long[]{getShutter(3), getISO(10)};
            case 76+16:
                return new long[]{getShutter(4), getISO(10)};
            case 77+16:
                return new long[]{getShutter(5), getISO(10)};
            case 78+16:
                return new long[]{getShutter(6), getISO(10)};
            case 79+16:
                return new long[]{getShutter(7), getISO(10)};
            case 80+16:
                return new long[]{getShutter(8), getISO(10)};
            case 81+16:
                return new long[]{ISO_100(), getISO(1)};
            default:
                return new long[]{getShutter(8), getISO(1)};
        }


    }

    private static long ISO_100()
    {
        float a = ISO_AE / 100;

        return (long)((float)Shutter_AE*a);
    }

    private static long getISO(int index)
    {
        switch (index)
        {
            case 1:
                return 100;
            case 2:
                return 200;
            case 3:
                return 400;
            case 4:
                return 800;
            case 5:
                return 1600;
            case 6:
                return 3200;
            case 7:
                return 6400;
            case 8:
                return 12800;
            case 9:
                return 16000;
            case 10:
                return 25600;
            default:
                return 100;
        }
    }

    public static String SlideVALUES(){
        return "AUTO,AE,100,200,400,800,1.6K,3.2K,6.4K,9.6K,12.8K,25.6K,32K,51.2K,64K,85K," +
                "102K,1S100,2s100,4s100,8s100,10s100,16s100,M100,32s100," +
                "1s200,2s200,4s200,8s200,10s200,16s200,M200,32s200," +
                "1s400,2s400,4s400,8s400,10s400,16s400,M400,32s400," +
                "1s800,2s800,4s800,8s800,10s800,16s800,M800,32s800," +
                "1s1.6k,2s1.6k,4s1.6k,8s1.6k,10s1.6k,16s1.6k,M1.6k,32s1.6k," +
                "1s3.2k,2s3.2k,4s3.2k,8s3.2k,10s3.2k,16s3.2k,M3.2k,32s3.2k," +
                "1s6.4k,2s6.4k,4s6.4k,8s6.4k,10s6.4k,16s6.4k,M6.4k,32s6.4k," +
                "1s12.8k,2s12.8k,4s12.8k,8s12.8k,10s12.8k,16s12.8k,M12.8k,32s12.8k," +
                "1s16.0k,2s16.0k,4s16.0k,8s16.0k,10s16k,16s16.0k,M16.0k,32s16.0k," +
                "1s25.6k,2s25.6k,4s25.6k,8s25.6k,10s25.6k,16s25.6k,M25.6k,32s25.6k,BIAS,MIN,TET";
    }

    private static long getShutter(int index)
    {
        switch (index)
        {
            case 1:
                return S_2_NS;
            case 2:
                return 2*S_2_NS;
            case 3:
                return 4*S_2_NS;
            case 4:
                return 8*S_2_NS;
            case 5:
                return 10*S_2_NS;
            case 6:
                return 16*S_2_NS;
            case 7:
                return 21509076830L;
            case 8:
                return 32*S_2_NS;
            default:
                return S_2_NS;
        }
    }

    private static long Rule500(float focalLength,String Sensor)
    {
        switch (Sensor)
        {
            case "IMX363":
            case "IMX362":
            case "S5K2L7":
            case "IMX345":
                return (long) (500f/(focalLength*CROP_1_255));
            case "IMX377":
            case "IMX378":
            case "IMX380":
            case "IMX477":
                return (long) (500f/(focalLength*CROP_1_255));
            default:
                return 19*S_2_NS;
        }
    }

}
