package deeznutz;

import android.util.Log;
import android.util.Pair;

public class NoiseMODELer {

    private static int NUM_COL_CHN = 4;
    private static int isoMUL = 2;
    private static double Noise_Profile_S = 0.0;
    private static double Noise_Profile_0 = 0.0;

    public static void setISOMUL(int isomul)
    {
        isoMUL = isomul;
    }

    public static int ISO()
    {
        //return Math.round(frame_a_gain*frame_d_gain);
        return lol.getISOResult()*isoMUL;
    }

    public static float getScale(int V)
    {
        switch (V)
        {
            case 1:
                return (float) computeNoiseModelS(ISO(),"IMX377_GOOGLE");

            case 2:
                return (float) computeNoiseModelS(ISO(),"IMX378_GOOGLE");

            case 3:
                return (float) computeNoiseModelS(ISO(),"IMX362_GOOGLE");

            case 4:
                return (float) computeNoiseModelS(ISO(),"IMX363_GOOGLE");

            case 5:
                return (float) computeNoiseModelS(ISO(),"IMX355_GOOGLE");

            case 6:
                return (float) computeNoiseModelS(ISO(),"OV5693_GOOGLE");

            case 7:
                return (float) computeNoiseModelS(ISO(),"IMX586_MEME");

            case 8:
                return (float) computeNoiseModelS(ISO(),"IMX586_OP");

            default:
                return (float) computeNoiseModelS(ISO(),"IMX377_GOOGLE");


        }
    }

    public static float getOffset(int V)
    {
        switch (V)
        {
            case 1:
                return (float) computeNoiseModelO(ISO(),"IMX377_GOOGLE");

            case 2:
                return (float) computeNoiseModelO(ISO(),"IMX378_GOOGLE");

            case 3:
                return (float) computeNoiseModelO(ISO(),"IMX362_GOOGLE");

            case 4:
                return (float) computeNoiseModelO(ISO(),"IMX363_GOOGLE");

            case 5:
                return (float) computeNoiseModelO(ISO(),"IMX351_GOOGLE");

            case 6:
                return (float) computeNoiseModelO(ISO(),"OV5693_GOOGLE");

            case 7:
                return (float) computeNoiseModelO(ISO(),"IMX586_MEME");

            case 8:
                return (float) computeNoiseModelO(ISO(),"IMX586_OP");

            default:
                return (float) computeNoiseModelO(ISO(),"IMX377_GOOGLE");


        }
    }

    public static float NR_Scale()
    {
        Log.d("Deez Noise Modeler ISO",""+ISO()+ "Scale"+ computeNoiseModelS(ISO(),"IMX377_GOOGLE"));


        return (float) computeNoiseModelS(ISO(),"IMX377_GOOGLE");
    }

    public static float NR_Offset()
    {
        Log.d("Deez Noise Modeler ISO",""+ISO()+ "Scale"+ computeNoiseModelO(ISO(),"IMX377_GOOGLE"));
        return (float) computeNoiseModelO(ISO(),"IMX377_GOOGLE");
    }

    public static float NR_Scale(String device)
    {
        return (float) computeNoiseModelS(ISO(),device);
    }

    public static float NR_Offset(String device)
    {
        return (float) computeNoiseModelO(ISO(),device);
    }

    public static float NR_Scale(String device,int iso)
    {
        return (float) computeNoiseModelS(iso,device);
    }

    public static float NR_Offset(String device,int iso)
    {
        return (float) computeNoiseModelO(iso,device);
    }



    private static double[] noise_profile = new double[2*NUM_COL_CHN];

    public static void GenerateModel()

    {
        Noise_Profile_S = computeNoiseModelS(ISO(),"Walleye");
        Noise_Profile_0 = computeNoiseModelO(ISO(),"Walleye");

        for(int i=0; i < 2*NUM_COL_CHN ; i +=2)
        {
            noise_profile[i] = Noise_Profile_S;
            noise_profile[i+1] = Noise_Profile_S;
        }
    }

   /* public static Pair[] nrm()
    {
        return new Pair[]{noise_profile,noise_profile};
    }*/


    private static double computeNoiseModelS(int Sensitivity,String Device)
    {
        return  (preComputedModels(Device)[0] * Sensitivity) + preComputedModels(Device)[1];

    }

    private static double computeNoiseModelO(int Sensitivity,String Device)
    {
        return (preComputedModels(Device)[2] * Sensitivity) + preComputedModels(Device)[3];


    }
    private static double[] preComputedModels(String Device)
    {
        switch (Device)
        {
            case "IMX362_GOOGLE":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX363_GOOGLE":
                return new double[]{0.0000025720647,0.000028855721,0.000000000039798506,0.000000046578279};

            case "IMX378_GOOGLE":
                return new double[]{2.193985e-006,2.2338231e+021,1.630839e-011,1.961165e-006};
            case "IMX377_GOOGLE" :
                return new double[]{1.902395e-006,1.649218e-005,2.362977e-011,1.584547e-006};
            case "OV4668_GOOGLE" :
                return new double[]{2.0,2.0,2.0,2.0};
            case "IMX355_GOOGLE" :
                return new double[]{4.7371119e-006,1.4144828e-005,3.6762353e-011,1.7669711e-007};
            case "OV5693_GOOGLE" :
                return new double[]{3.73802e-006,3.651935e-004,4.499952e-007,-2.968624e-004};
            case "IMX363_MEME":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX345_SAM":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX363_ASUS":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX586_MEME":
                return new double[]{5.015589e-007,4.117037e-006,1.441289e-102,1.894463e-007};
            case "IMX519_OP":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX586_ASUS":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX586_OP":
                return new double[]{5.694684e-007,9.380359e-006,1.187943e-012,1.150711e-007};
            default:
                return new double[]{0,0,0,0};
        }

    }
}
