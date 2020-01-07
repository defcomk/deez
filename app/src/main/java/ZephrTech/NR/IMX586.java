package ZephrTech.NR;

import android.os.Build;
import android.util.Log;

import deeznutz.lol;

public class IMX586 {

    static int FACING = 0;


    public static double getIMX586S(int plane)
    {
        if(Build.MODEL.equals("MI 9")||Build.MODEL.equals("Redmi K20 Pro"))
        {
            switch (FACING)
            {
                case 0:
                    return compute_noise_model_entry_S_AVERAGE(plane,lol.getISOResult()*4);
                case 1:
                    return compute_noise_model_entry_S_SUM(plane,lol.getISOResult()*4);
                case 2:
                    return compute_noise_model_entry_S_48(plane,lol.getISOResult()*4);
                case 3:
                    OV13855.compute_noise_model_entry_S(plane,lol.getISOResult());
                case 4:
                    IMX481.compute_noise_model_entry_S(plane,lol.getISOResult());

                default:
                    return 0.0;

            }
        }
        else {
            switch (FACING)
            {
                case 0:
                    return compute_noise_model_entry_S_AVERAGE(plane,lol.getISOResult());
                case 1:
                    return compute_noise_model_entry_S_SUM(plane,lol.getISOResult());
                case 2:
                    return compute_noise_model_entry_S_48(plane,lol.getISOResult());
                case 3:
                    OV13855.compute_noise_model_entry_S(plane,lol.getISOResult());

                default:
                    return 0.0;

            }
        }


    }

    public static float getZenfone6Offset(int plane)
    {
        Log.d("NR Channel",plane+"");
        return (float)compute_noise_model_entry_O_SUM(plane,lol.getISOResult());
    }

    public static float getZenfone6OScale(int plane)
    {
        Log.d("NR Channel",plane+"");
        return (float)compute_noise_model_entry_S_SUM(plane,lol.getISOResult());
    }

    public static double getIMX586O(int plane)
    {
        if(Build.MODEL.equals("MI 9")||Build.MODEL.equals("Redmi K20 Pro"))
        {
            switch (FACING)
            {
                case 0:
                    return compute_noise_model_entry_O_AVERAGE(plane,lol.getISOResult()*4);
                case 1:
                    return compute_noise_model_entry_O_SUM(plane,lol.getISOResult()*4);
                case 2:
                    return compute_noise_model_entry_O_48(plane,lol.getISOResult()*4);
                case 3:
                    OV13855.compute_noise_model_entry_O(plane,lol.getISOResult());
                case 4:
                    IMX481.compute_noise_model_entry_O(plane,lol.getISOResult());
                default:
                    return 0.0;

            }
        }
        else
        {
            switch (FACING)
            {
                case 0:
                    return compute_noise_model_entry_O_AVERAGE(plane,lol.getISOResult());
                case 1:
                    return compute_noise_model_entry_O_SUM(plane,lol.getISOResult());
                case 2:
                    return compute_noise_model_entry_O_48(plane,lol.getISOResult());
                case 3:
                    OV13855.compute_noise_model_entry_O(plane,lol.getISOResult());
                default:
                    return 0.0;

            }

        }


    }


    static double compute_noise_model_entry_S_AVERAGE(int plane, int sens) {
         double noise_model_A[] = { 2.9139025105608897e-06,3.0884708894869443e-06,1.5927762277751013e-06,1.7640045286408792e-06 };
         double noise_model_B[] = { -1.5512341003360423e-05,1.043494450438023e-05,5.876416109953888e-06,1.6807541542686153e-06 };
        double A = noise_model_A[plane];
        double B = noise_model_B[plane];
        double s = A * sens + B;
        return s < 0.0 ? 0.0 : s;
    }

   static   double compute_noise_model_entry_O_AVERAGE(int plane, int sens) {
         double noise_model_C[] = { 7.663206166500089e-12,1.5318274743480304e-11,1.0499577671462283e-12,-2.36924662890651e-13 };
         double noise_model_D[] = { 5.36106135498234e-07,6.011987783375566e-08,3.184102843846181e-07,4.015938148657944e-07 };
        double digital_gain = (sens / getDIGTALGain()) < 1.0 ? 1.0 : (sens / getDIGTALGain());
        double C = noise_model_C[plane];
        double D = noise_model_D[plane];
        double o = C * sens * sens + D * digital_gain * digital_gain;
        return o < 0.0 ? 0.0 : o;
    }

     static double compute_noise_model_entry_S_SUM(int plane, int sens) {
         double noise_model_A[] = { 1.2393332408054649e-05,1.2216674173178746e-05,6.727340512913872e-06,6.897695121573913e-06 };
         double noise_model_B[] = { -7.076279837190812e-05,2.3470542535114918e-05,-1.1487331214779846e-05,1.022217394785556e-05 };
        double A = noise_model_A[plane];
        double B = noise_model_B[plane];
        double aa=   A * sens + B;

         Log.d("NR Scale" ,aa+"");

         return aa;

    }

     static double compute_noise_model_entry_O_SUM(int plane, int sens) {
         double noise_model_C[] = { 9.148571218078536e-11,1.1415504692308749e-10,1.260897840504253e-10,6.235097116754794e-11 };
         double noise_model_D[] = { 1.8436305523840734e-06,3.325025798050419e-07,1.0819215029274746e-06,7.125675245506507e-07 };
        double digital_gain = ((sens / 200) < 1.0 )? 1.0 : (sens / 200);
        double C = noise_model_C[plane];
        double D = noise_model_D[plane];
        double a = C * sens * sens + D * digital_gain * digital_gain;

        Log.d("NR Offset" ,a+"");

        return a;



    }


    static double compute_noise_model_entry_S_48(int plane, int sens) {
        double noise_model_A[] = { 1.2393332408054649e-05,1.2216674173178746e-05,6.727340512913872e-06,6.897695121573913e-06 };
        double noise_model_B[] = { -7.076279837190812e-05,2.3470542535114918e-05,-1.1487331214779846e-05,1.022217394785556e-05 };
        double A = noise_model_A[plane];
        double B = noise_model_B[plane];
        double s = A * sens + B;
        return s < 0.0 ? 0.0 : s;
    }

    static double compute_noise_model_entry_O_48(int plane, int sens) {
        double noise_model_C[] = { 9.148571218078536e-11,1.1415504692308749e-10,1.260897840504253e-10,6.235097116754794e-11 };
        double noise_model_D[] = { 1.8436305523840734e-06,3.325025798050419e-07,1.0819215029274746e-06,7.125675245506507e-07 };
        double digital_gain = (sens / getDIGTALGain()) < 1.0 ? 1.0 : (sens / getDIGTALGain());
        double C = noise_model_C[plane];
        double D = noise_model_D[plane];
        double o = C * sens * sens + D * digital_gain * digital_gain;
        return o < 0.0 ? 0.0 : o;
    }

    public static double getDIGTALGain()
    {
        if(Build.MODEL.equals("MI 9")||Build.MODEL.equals("Redmi K20 Pro"))
        {
            return 6400;
        }
        else {
            return 200;
        }

    }

}
