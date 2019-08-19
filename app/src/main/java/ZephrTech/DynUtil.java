package ZephrTech;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.LensShadingMap;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.TonemapCurve;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Surface;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import deeznutz.lol;

public class DynUtil {
    
    static final int OPERATION_MODE_NORMAL = 0;

    static final int OPERATION_MODE_HS = 0;

    static final int OPERATION_BERYLLIUM_EIS = 0;

    static final int OPERATION_CEPHEUS_QCFA = 0;

    private static int YUVSIZEX = 4000;

    private static int YUVSIZEY = 3000;

    private static boolean RAW10 = false;



    private static  int itr= 0;

    public static float frame_a_gain = 0;
    public static float frame_d_gain = 0;

    public static View Seeker1 = null;

    public static Activity locoTivity=null;

    public static boolean BL_LOCKED = false;

    static float[][] hol_up = (float[][])null;

    public static void a_gain (float in)
    {
        frame_a_gain = in * 100;
    }

    public static void d_gain (float in)


    {
        frame_d_gain = in * 100;

    }

    private static int ISO()
    {
        //return Math.round(frame_a_gain*frame_d_gain);
        return lol.getISOResult();
    }

    public static void setImageFormat(int width,int height,int imageFormat)
    {

        Log.d("Deez ImageReader","Index["+itr+"}"+" Width:"+width+" Height:"+height+" Format:"+imageFormat);
        itr++;

        if (imageFormat == 37 && width >5500)
        {
            RAW10 = true;
            YUVSIZEX = width/2;
            YUVSIZEY = height/2;
        }
        else {
            RAW10 = false;
            YUVSIZEX = width;
            YUVSIZEY = height;
        }

    }


    public static int getRawX(int x)
    {
        if(RAW10)
        {
            return YUVSIZEX;
        }
        else
        {
            return x;
        }
    }

    public static int getRawY(int y)
    {
        if(RAW10)
        {
            return YUVSIZEY;
        }
        else
        {
            return y;
        }
    }



    public static Rect Twelvy(Rect in)
    {
        Logger.LogRect(in);
        if(in.bottom == 6000||in.top ==6000||in.right ==6000||in.left ==6000){
            Logger.LogRect(new Rect(0,0,4000,3000));
            return new Rect(0,0,4000,3000);
        }
        else
        {
            return in;
        }


    }



    public static int Forty8Strip(int res)
    {
        if(res==8000)
        {
            return 4000;
        }
       else if(res==6000)
        {
            return 3000;
        }
        else
        {
            return res;
        }
    }

    private void liukang()
    {
        String ax = getModelForDCP(0,"d");

        getRawX(4032);

        int a = Forty8Strip(3000);
        Rect b = Twelvy(null);
    }


    @TargetApi(24)
    public void CreateCaptureSession(List<Surface> outputs, CameraCaptureSession.StateCallback callback, Handler handler)
            throws CameraAccessException{
        List<OutputConfiguration> outputConfigurations = new ArrayList<>(outputs.size());
        for (Surface surface: outputs)
        {
            outputConfigurations.add(new OutputConfiguration(surface));

        }

        //createCaptureSession_Xternal(CameraDevice.class,"CreateCaptureSessionInternal",outputConfigurations,callback,handler,OPERATION_MODE_NORMAL);
    }

    public static Object createCaptureSession_Xternal(Object obj, String methodName, Object... params){
        int paramCount = params.length;
        Method method;
        Object requiredObj = null;
        Class<?>[] classArray = new Class<?>[paramCount];
        for(int i = 0; i < paramCount; i++)
        {
            classArray[i] = params[i].getClass();
        }
        try{
            method = obj.getClass().getDeclaredMethod(methodName,classArray);
            method.setAccessible(true);
            requiredObj = method.invoke(obj,params);
        }catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return requiredObj;
    }

    public static Integer NUM()
    {
        return 5;
    }

    public static String getModelForDCP(int ActiveCam,String SysModel)
    {
        if(ActiveCam==0)
        {
            return SysModel+"IMX";
        }
        else
        {
             return SysModel+"OV";
        }
    }


    public static float[] CEPHEUS_CT1(int ActiveCam,float[]passaux)
    {
        if(ActiveCam==0)
        {
            return new float[]{1.109375f,-0.5234375f, -0.171875f, -0.96875f, 1.875f, 0.0390625f, 0.046875f, -0.171875f, 0.8984375f};
        }
        else {
            return passaux;
        }

    }

    public static float[] CEPHEUS_CT2(int ActiveCam,float[]passaux)
    {
        if(ActiveCam==0)
        {
            return new float[]{1.4375f, -0.6796875f, -0.21875f, -0.96875f,1.875f, 0.0390625f, 0.0390625f, -0.140625f, 0.734375f};
        }
        else {
            return passaux;
        }
    }

    public static float[] WB_R()
    {
        return new float[]{0.50878906f,0.62109375f,0.7226525f,0f,0f};

    }

    public static Float WB_G()
    {
        return 1.00097656f;

    }

    public static float[] WB_B()
    {
        return new float[]{0.70312500f,0.53808594f,0.35156250f,0f,0f};

    }

    private static boolean isAux(int facing )
    {
        return (facing == 2 || facing == 3);

    }



    public static float[] Linearization(int ActiveCam,float[] passthough) {
        if(ActiveCam == 1)
        {
            int i = 0;
            float[] Ye = Linearization_ov13855(passthough);
            for (float x:Ye
                 ) {
                i++;

                Log.d("Deez BL OV","["+i+"] "+x);

            }
            BL_LOCKED = true;
            return Ye;



        }
        else {
            int i = 0;
            float[] Ye = Linearization_586(passthough);
            for (float x:Ye
                    ) {
                i++;

                Log.d("Deez BL IMX","["+i+"] "+x);

            }
            BL_LOCKED = true;
            return Ye;
        }
    }

    private static int ISOASUS()
    {
        //return Math.round(frame_a_gain*frame_d_gain);
        return lol.getISO_Out()/4;
    }

    public static float[] Linearization_586(float[] passthough) {
        if(BL_LOCKED)
        {
            return Linearization_586_48MP(passthough);
        }
        else {
            return Linearization_586_12MP(passthough);
        }
    }

    public static float[] Linearization_586_12MP(float[] passthough) {

        Log.d("Deez BL IMX12","ISO]"+ISO());

        if (ISO() > 0 && ISO() <= 70) {
            return new float[]{64.0625f, 64.0625f, 64f, 64f};
        }
        else if(ISO() >70 && ISO() <= 120)
        {
            return new float[]{64.0625f, 64.125f, 64.0625f, 64.0625f};
        }
        else if(ISO() >120 && ISO() <= 220)
        {
            return new float[]{64.125f, 64.125f, 64.0625f, 64.0625f};
        }
        else if(ISO() >220 && ISO() <= 420)
        {
            return new float[]{64.25f, 64.25f, 64.0625f, 64.0625f};
        }
        else if(ISO() >420 && ISO() <= 820)
        {
            return new float[]{64.25f, 64.3125f, 64.3125f, 64.3125f};
        }
        else if(ISO() >820 && ISO() <= 1220)
        {
            return new float[]{64.4375f, 64.4375f, 64.5f, 64.5f };
        }
        else if(ISO() >1220 && ISO() <= 1620)
        {
            return new float[]{64.5625f, 64.625f, 64.6875f, 64.6875f};
        }
        else if(ISO() >1620 && ISO() <= 2220)
        {
            return new float[]{64.6875f, 64.75f, 64.9375f, 64.9375f};
        }
        else if(ISO() >2200 && ISO() <= 3170)
        {
            return new float[]{64.9375f, 65.3125f, 65.3125f, 65.3125f };
        }
        else if(ISO() >3170 && ISO() <= 25600)
        {
            return new float[]{65.5f, 65.5f, 65.9375f, 66f };
        }
        else
        {
            return passthough;
        }
    }


    public static float[] Linearization_586_48MP(float[] passthough) {

        Log.d("Deez BL IMX48","ISO]"+ISO());

        if (ISO() > 0 && ISO() <= 70) {
            return new float[]{64.25f, 64.25f, 64.25f,64.25f};
        }
        else if(ISO() >70 && ISO() <= 120)
        {
            return new float[]{64.25f, 64.1875f, 64.1875f, 64.25f};
        }
        else if(ISO() >120 && ISO() <= 220)
        {
            return new float[]{64.1875f, 64.125f, 64.125f, 64.1875f};
        }
        else if(ISO() >220 && ISO() <= 420)
        {
            return new float[]{64.0625f, 64f, 64f, 64.0625f};
        }
        else if(ISO() >420 && ISO() <= 820)
        {
            return new float[]{64.0625f, 63.9375f, 63.9375f, 64.0625f};
        }
        else if(ISO() >820 && ISO() <= 1220)
        {
            return new float[]{64f, 63.875f, 63.875f, 64f};
        }
        else if(ISO() >1220 && ISO() <= 1620)
        {
            return new float[]{64.0625f, 63.875f, 63.875f, 64.0625f};
        }
        else if(ISO() >1620 && ISO() <= 2220)
        {
            return new float[]{64.25f, 63.9375f,  63.875f, 64.25f};
        }
        else if(ISO() >2200 && ISO() <= 3170)
        {
            return new float[]{64.4375f, 64.875f, 64.8125f, 64.5625f };
        }
        else if(ISO() >3170 && ISO() <= 25600)
        {
            return new float[]{66.1875f, 68.5f, 68.4375f, 66.375f  };
        }
        else
        {
            return passthough;
        }
    }
    public static float[] Linearization_ov13855(float[] passthough) {
        Log.d("Deez BL OV","ISO]"+ISO());


        if (ISO() > 0 && ISO() <= 70) {
            return new float[]{64.1875f,64.1875f,64.1875f,64.1875f};
        }
        else if(ISO() >70 && ISO() <= 120)
        {
            return new float[]{64.1875f,64.1875f,64.25f,64.25f};
        }
        else if(ISO() >120 && ISO() <= 220)
        {
            return new float[]{64.25f,64.25f,64.3125f,64.3125f};
        }
        else if(ISO() >220 && ISO() <= 420)
        {
            return new float[]{64.25f,64.25f,64.375f,64.3125f};
        }
        else if(ISO() >420 && ISO() <= 820)
        {
            return new float[]{62.5f,62.625f,62.6875f,62.5f};
        }
        else if(ISO() >820 && ISO() <= 900)
        {
            return new float[]{64.5f,65.5f,65.5f,64.5f};
        }
        else if(ISO() >900 && ISO() <= 1100)
        {
            return new float[]{64.3125f,64.4375f,64.375f,64.4375f};
        }
        else if(ISO() >1100 && ISO() <= 6400)
        {
            return new float[]{65f,65.5f,65.5f,65};
        }

        else
        {
            return passthough;
        }
    }

    public static float[] getZF6_BL_586(float[] passthough)
    {
        int X = 16;
        if (ISOASUS()>1 && ISOASUS() <= 25)
        {
            return new float[]{1083/X,1116/X,1117/X,1079/X};
        }
        else if(ISOASUS() >25 && ISOASUS() <= 75)
        {
            return new float[]{1083/X,1112/X,1113/X,1075/X};
        }
        else if(ISOASUS() > 75 && ISOASUS() <= 125)
        {
            return new float[]{1081/X,1114/X,1114/X,1077/X};
        }
        else if(ISOASUS() > 125 && ISOASUS() <= 175)
        {
            return new float[]{1073/X,1105/X,1105/X,1068/X};
        }
        else if(ISOASUS() > 175 && ISOASUS() <= 225)
        {
            return new float[]{1079/X,1105/X,1105/X,1069/X};
        }
        else if(ISOASUS() > 225 && ISOASUS() <= 275)
        {
            return new float[]{1073/X,1105/X,1106/X,1069/X};
        }
        else if(ISOASUS() > 275 && ISOASUS() <= 325)
        {
            return new float[]{1075/X,1107/X,1108/X,1072/X};
        }
        else if(ISOASUS() > 325 && ISOASUS() <= 375)
        {
            return new float[]{1061/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 375 && ISOASUS() <= 425)
        {
            return new float[]{1061/X,1091/X,1091/X,1057/X};
        }
        else if(ISOASUS() > 425 && ISOASUS() <= 475)
        {
            return new float[]{1062/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 475 && ISOASUS() <= 525)
        {
            return new float[]{1062/X,1091/X,1091/X,1057/X};
        }
        else if(ISOASUS() > 525 && ISOASUS() <= 575)
        {
            return new float[]{1062/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 575 && ISOASUS() <= 625)
        {
            return new float[]{1062/X,1093/X,1093/X,1059/X};
        }
        else if(ISOASUS() > 625 && ISOASUS() <= 675)
        {
            return new float[]{1060/X,1091/X,1091/X,1058/X};
        }
        else if(ISOASUS() > 675 && ISOASUS() <= 725)
        {
            return new float[]{1062/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 725 && ISOASUS() <= 775)
        {
            return new float[]{1062/X,1091/X,1092/X,1059/X};
        }
        else if(ISOASUS() > 775 && ISOASUS() <= 825)
        {
            return new float[]{1059/X,1088/X,1088/X,1054/X};
        }
        else if(ISOASUS() > 825 && ISOASUS() <= 875)
        {
            return new float[]{1060/X,1090/X,1091/X,1056/X};
        }
        else if(ISOASUS() > 875 && ISOASUS() <= 925)
        {
            return new float[]{1063/X,1093/X,1094/X,1058/X};
        }
        else if(ISOASUS() > 925 && ISOASUS() <= 975)
        {
            return new float[]{1064/X,1094/X,1095/X,1059/X};
        }
        else if(ISOASUS() > 975 && ISOASUS() <= 1025)
        {
            return new float[]{1063/X,1094/X,1094/X,1058/X};
        }
        else if(ISOASUS() > 1025 && ISOASUS() <= 1625)
        {
            return new float[]{1065/X,1096/X,1097/X,1061/X};
        }
        else if(ISOASUS() > 1625 && ISOASUS() <= 2025)
        {
            return new float[]{1065/X,1095/X,1095/X,1061/X};
        }
        else if(ISOASUS() > 2025 && ISOASUS() <= 6440)
        {
            return new float[]{1064/X,1094/X,1094/X,1058/X};
        }
        else
        {
            return passthough;
        }
    }

    public static float[] getZF6_BL_OV13855(float[] passthough)
    {
        int X = 16;
        if (ISOASUS()>1 && ISOASUS() <= 25)
        {
            return new float[]{1083/X,1116/X,1117/X,1079/X};
        }
        else if(ISOASUS() >25 && ISOASUS() <= 75)
        {
            return new float[]{1083/X,1112/X,1113/X,1075/X};
        }
        else if(ISOASUS() > 75 && ISOASUS() <= 125)
        {
            return new float[]{1081/X,1114/X,1114/X,1077/X};
        }
        else if(ISOASUS() > 125 && ISOASUS() <= 175)
        {
            return new float[]{1073/X,1105/X,1105/X,1068/X};
        }
        else if(ISOASUS() > 175 && ISOASUS() <= 225)
        {
            return new float[]{1079/X,1105/X,1105/X,1069/X};
        }
        else if(ISOASUS() > 225 && ISOASUS() <= 275)
        {
            return new float[]{1073/X,1105/X,1106/X,1069/X};
        }
        else if(ISOASUS() > 275 && ISOASUS() <= 325)
        {
            return new float[]{1075/X,1107/X,1108/X,1072/X};
        }
        else if(ISOASUS() > 325 && ISOASUS() <= 375)
        {
            return new float[]{1061/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 375 && ISOASUS() <= 425)
        {
            return new float[]{1061/X,1091/X,1091/X,1057/X};
        }
        else if(ISOASUS() > 425 && ISOASUS() <= 475)
        {
            return new float[]{1062/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 475 && ISOASUS() <= 525)
        {
            return new float[]{1062/X,1091/X,1091/X,1057/X};
        }
        else if(ISOASUS() > 525 && ISOASUS() <= 575)
        {
            return new float[]{1062/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 575 && ISOASUS() <= 625)
        {
            return new float[]{1062/X,1093/X,1093/X,1059/X};
        }
        else if(ISOASUS() > 625 && ISOASUS() <= 675)
        {
            return new float[]{1060/X,1091/X,1091/X,1058/X};
        }
        else if(ISOASUS() > 675 && ISOASUS() <= 725)
        {
            return new float[]{1062/X,1091/X,1092/X,1058/X};
        }
        else if(ISOASUS() > 725 && ISOASUS() <= 775)
        {
            return new float[]{1062/X,1091/X,1092/X,1059/X};
        }
        else if(ISOASUS() > 775 && ISOASUS() <= 825)
        {
            return new float[]{1059/X,1088/X,1088/X,1054/X};
        }
        else if(ISOASUS() > 825 && ISOASUS() <= 875)
        {
            return new float[]{1060/X,1090/X,1091/X,1056/X};
        }
        else if(ISOASUS() > 875 && ISOASUS() <= 925)
        {
            return new float[]{1063/X,1093/X,1094/X,1058/X};
        }
        else if(ISOASUS() > 925 && ISOASUS() <= 975)
        {
            return new float[]{1064/X,1094/X,1095/X,1059/X};
        }
        else if(ISOASUS() > 975 && ISOASUS() <= 1025)
        {
            return new float[]{1063/X,1094/X,1094/X,1058/X};
        }
        else if(ISOASUS() > 1025 && ISOASUS() <= 1625)
        {
            return new float[]{1065/X,1096/X,1097/X,1061/X};
        }
        else if(ISOASUS() > 1625 && ISOASUS() <= 2025)
        {
            return new float[]{1065/X,1095/X,1095/X,1061/X};
        }
        else if(ISOASUS() > 2025 && ISOASUS() <= 6440)
        {
            return new float[]{1064/X,1094/X,1094/X,1058/X};
        }
        else
        {
            return passthough;
        }
    }

    public static float[] getPseudoBL(float[] passthough)
    {
        Log.v("deez bl"," ISO "+ISO());
            if (ISO()>0&&ISO()<=50)
            {
                return new float[]{63.75f,63.75f,64.0f,64f};
            }
             else if (ISO()>51&&ISO()<=104)
             {
            return new float[]{63.75f,63.75f,64.0f,64f};
             }
            else if (ISO()>=105&&ISO()<=154)
            {
                return new float[]{63.75f,64f,64.0f,64f};
            }
            else if (ISO()>=155&&ISO()<=204)
            {
                return new float[]{63.75f,64f,64.0f,64f};
            }
            else if (ISO()>=205&&ISO()<=253)
            {
                return new float[]{63.75f,64f,64.0f,64f};
            }
            else if (ISO()>=254&&ISO()<=302)
            {
                return new float[]{64f,64f,64.0f,64f};
            }
            else if (ISO()>=303&&ISO()<=351)
            {
                return new float[]{63.75f,64f,64.0f,63.75f};
            }
            else if (ISO()>=352&&ISO()<=400)
            {
                return new float[]{63.75f,64f,64f,63.75f};
            }
            else if (ISO()>=401&&ISO()<=454)
            {
                return new float[]{64f,64f,64f,64f};
            }
            else if (ISO()>=455&&ISO()<=503)
            {
                return new float[]{63.75f,64f,64.0f,63.75f};
            }
            else if (ISO()>=504&&ISO()<=553)
            {
                return new float[]{63.75f,64f,64.0f,63.75f};
            }
            else if (ISO()>=554&&ISO()<=604)
            {
                return new float[]{63.75f,64f,64.0f,64f};
            }
            else if (ISO()>=605&&ISO()<=654)
            {
                return new float[]{63.75f,64f,64.0f,64f};
            }
            else if (ISO()>=655&&ISO()<=704)
            {
                return new float[]{63.75f,64f,64.0f,64f};
            }
            else if (ISO()>=705&&ISO()<=753)
            {
                return new float[]{64f,64f,64f,64f};
            }
            else if (ISO()>=754&&ISO()<=803)
            {
                return new float[]{63.75f,64f,64.0f,64f};
            }
            else if (ISO()>=804&&ISO()<=854)
            {
                return new float[]{63.75f,64f,64.0f,63.75f};
            }
            else if (ISO()>=855&&ISO()<=904)
            {
                return new float[]{64f,64.25f,64.25f,64f};
            }
            else if (ISO()>=905&&ISO()<=954)
            {
                return new float[]{64,64f,64.0f,64};
            }
            else if (ISO()>=955&&ISO()<=1003)
            {
                return new float[]{64,64.25f,64.25f,64};
            }
            else if (ISO()>=1004&&ISO()<=1053)
            {
                return new float[]{64,64f,64.0f,64};
            }
            else if (ISO()>=1054&&ISO()<=1104)
            {
                return new float[]{64,64f,64.0f,64f};
            }
            else if (ISO()>=1105&&ISO()<=1154)
            {
                return new float[]{64,64f,64.0f,64};
            }
            else if (ISO()>=1155&&ISO()<=1204)
            {
                return new float[]{63.75f,64.25f,64.25f,64f};
            }
            else if (ISO()>=1205&&ISO()<=1253)
            {
                return new float[]{63.75f,64.25f,64.0f,63.75f};
            }
            else if (ISO()>=1254&&ISO()<=1303)
            {
                return new float[]{64,64.5f,64.25f,64};
            }
            else if (ISO()>=1304&&ISO()<=1354)
            {
                return new float[]{64f,63.75f,64,64};
            }
            else if (ISO()>=1355&&ISO()<=1404)
            {
                return new float[]{64,64.5f,63.75f,64f};
            }
            else if (ISO()>=1405&&ISO()<=1454)
            {
                return new float[]{63.75f,64.5f,64.25f,64f};
            }
            else if (ISO()>=1455&&ISO()<=1503)
            {
                return new float[]{63.75f,64f,63.75f,63.75f};
            }
            else if (ISO()>=1504&&ISO()<=1553)
            {
                return new float[]{64,64.5f,64.25f,64f};
            }
            else if (ISO()>=1554&&ISO()<=1604)
            {
                return new float[]{63.75f,64.5f,64.25f,64};
            }
            else if (ISO()>=1605&&ISO()<=1654)
            {
                return new float[]{64,64.25f,64.0f,64};
            }
            else if (ISO()>=1655&&ISO()<=1704)
            {
                return new float[]{63.75f,64.5f,64.25f,63.75f};
            }
            else if (ISO()>=1705&&ISO()<=1753)
            {
                return new float[]{64,64f,63.75f,64};
            }
            else if (ISO()>=1754&&ISO()<=1803)
            {
                return new float[]{64,64f,63.75f,64.25f};
            }
            else if (ISO()>=1804&&ISO()<=1854)
            {
                return new float[]{64,64.25f,64.0f,64.25f};
            }else if (ISO()>=1855&&ISO()<=1904)
            {
                return new float[]{63.75f,64.5f,64.25f,63.75f};
            }
            else if (ISO()>=1905&&ISO()<=1954)
            {
                return new float[]{63.75f,64.5f,64.25f,63.75f};
            }
            else if (ISO()>=1955&&ISO()<=2003)
            {
                return new float[]{63.75f,64.5f,64.25f,63.75f};
            }
            else if (ISO()>=2004&&ISO()<=2053)
            {
                return new float[]{64.25f,64.5f,64.25f,64.25f};
            }
            else if (ISO()>=2054&&ISO()<=2104)
            {
                return new float[]{64,64.5f,64,64};
            }
            else if (ISO()>=2105&&ISO()<=2154)
            {
                return new float[]{63.75f,64.25f,63.75f,64f};
            }
            else if (ISO()>=2155&&ISO()<=2204)
            {
                return new float[]{63.75f,64.25f,63.75f,64};
            }else if (ISO()>=2205&&ISO()<=2253)
            {
                return new float[]{63.75f,64.25f,64.0f,64};
            }
            else if (ISO()>=2254&&ISO()<=2303)
            {
                return new float[]{63.75f,64.5f,64.25f,64};
            }
            else if (ISO()>=2304&&ISO()<=2354)
            {
                return new float[]{64,63.75f,64.0f,64};
            }
            else if (ISO()>=2355&&ISO()<=2404)
            {
                return new float[]{64.25f,64f,63.75f,64.25f};
            }
            else if (ISO()>=2405&&ISO()<=2454)
            {
                return new float[]{64.25f,65,64.5f,64.25f};
            }else if (ISO()>=2455&&ISO()<=2503)
            {
                return new float[]{63.5f,64.25f,64.0f,64.75f};
            }
            else if (ISO()>=2504&&ISO()<=2553)
            {
                return new float[]{64,64.25f,64.0f,64};
            }
            else if (ISO()>=2554&&ISO()<=2604)
            {
                return new float[]{63.75f,64.5f,64.25f,63.75f};
            }
            else if (ISO()>=2605&&ISO()<=2654)
            {
                return new float[]{63.75f,64.5f,64.25f,63.75f};
            }
            else if (ISO()>=2655&&ISO()<=2704)
            {
                return new float[]{64,64.75f,64.5f,64};
            }
            else if (ISO()>=2705&&ISO()<=2753)
            {
                return new float[]{63.75f,64.5f,64.0f,64};
            }
            else if (ISO()>=2754&&ISO()<=2803)
            {
                return new float[]{63.75f,64.5f,64.0f,63.75f};
            }
            else if (ISO()>=2804&&ISO()<=2854)
            {
                return new float[]{63.75f,64.75f,64.5f,63.75f};
            }
            else if (ISO()>=2855&&ISO()<=2904)
            {
                return new float[]{63.75f,64.5f,64.0f,64};
            }
            else if (ISO()>=2905&&ISO()<=2954)
            {
                return new float[]{64,64.75f,64.5f,64};
            }
            else if (ISO()>=2955&&ISO()<=3003)
            {
                return new float[]{63.75f,65f,64.75f,63.75f};
            }
            else if (ISO()>=3004&&ISO()<=3053)
            {
                return new float[]{64,65,64.5f,64};
            }
            else if (ISO()>=3054&&ISO()<=3104)
            {
                return new float[]{63.5f,64.5f,64.25f,63.75f};
            }
            else if (ISO()>=3105&&ISO()<=3154)
            {
                return new float[]{63.75f,65,64.75f,64};
            }
            else if (ISO()>=3155&&ISO()<=6309)
            {
                return new float[]{64.5f,64.75f,64.5f,64.5f};
            }else if (ISO()>=6310&&ISO()<=12619)
            {
                return new float[]{64.25f,67f,66.5f,64.5f};
            }
            else if (ISO()>=12620&&ISO()<=25239)
            {
                return new float[]{67.5625f,83.0625f,82.125f,68.4375f};
            }
            else if (ISO()>=25240&&ISO()<=35199)
            {
                return new float[]{87.8125f,127.375f,126.125f,87.3125f};
            }
            else if (ISO()>=35200&&ISO()<=50479)
            {
                return new float[]{98.125f,151.125f,149.9375f,99.9375f};
            }
            else if (ISO()>=50480&&ISO()<=70399)
            {
                return new float[]{136.625f,231.8125f,230.1875f,139f};
            }
            else if (ISO()>=70400&&ISO()<=93499) {
                return new float[]{157.1875f, 281.4375f, 279.75f, 160.625f};
            }

            else if (ISO()>=93500&&ISO()<=113777*2)
            {
                return new float[]{196.8125f,349.625f,347.5f,200.75f};
            }
            else if(passthough[0]==63) {
                return new float[]{63.75f,63.75f,64.0f,67.75f};
            }
            else  {
                return passthough;
            }







    }

    public static void dumpLSCtoFile(LensShadingMap lsc)
    {
        try {
            FileOutputStream fi = new FileOutputStream(new File(Environment.DIRECTORY_DCIM+"/lsc.dat"));
            ObjectOutputStream o = new ObjectOutputStream(fi);

            o.writeObject(lsc);
            o.close();
            fi.close();
        }
        catch (FileNotFoundException ex){}
        catch (IOException ex){}
        catch (ClassCastException ex){}
        catch (Exception ex){

        }
    }

    public static void curveDeezNuts(TotalCaptureResult totalCaptureResult)
    {
        try {


            if (totalCaptureResult != null) {
                TonemapCurve tonemapCurve = (TonemapCurve) totalCaptureResult.get(CaptureResult.TONEMAP_CURVE);

                if (tonemapCurve != null) {
                    float[][] curve = new float[3][];
                    hol_up = new float[3][];
                    for (int i = 0; i <= 2; i++) {
                        curve[i] = new float[2 * tonemapCurve.getPointCount(i)];

                        Log.d("deez Curve", ": "+curve[i]);

                        tonemapCurve.copyColorCurve(i, curve[i], 0);
                    }


                    hol_up = curve;

                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static TonemapCurve staticCurve()
    {
        return new TonemapCurve(hol_up[0],hol_up[1],hol_up[2]);
    }


    public static void setSeeker(View v)
    {
        Seeker1 = v;
    }

    public static void seekerHide(boolean b)
    {
        if (b)
        {
            Seeker1.setVisibility(View.GONE);
        }
        else {
            Seeker1.setVisibility(View.VISIBLE);
        }
    }

}
