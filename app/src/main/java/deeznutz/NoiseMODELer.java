package deeznutz;

import android.util.Log;
import android.util.Pair;

public class NoiseMODELer {

    private static int NUM_COL_CHN = 4;
    private static int isoMUL = 2;
    private static double Noise_Profile_S = 0.0;
    private static double Noise_Profile_0 = 0.0;

    private static int MaxAnalog586ASUS = 1600;
    private static int MaxAnalog362 = 800;
    private static int MaxAnalog363 = 1600;
    private static int MaxAnalog586MEME = 6400;



    public static void setISOMUL(int isomul)
    {
        isoMUL = isomul;
    }

    private static double ISO(int baseMul)
    {
        //return Math.round(frame_a_gain*frame_d_gain);
        return (lol.getISOResult()*2)/getSNR();
    }

    private static double getSNR()
    {
        int Frames = 15;

        return Math.sqrt(Frames-3);
    }

    public static float getScale(int V,float sysScale)
    {
        Log.d("Deez NR SC",":"+V);
        switch (V)
        {

            case 0:
                return sysScale;
            case 1:
                return (float) computeNoiseModelS(ISO(2),"IMX377_GOOGLE");

            case 2:
                return (float) computeNoiseModelS(ISO(2),"IMX378_GOOGLE");

            case 3:
                return (float) computeNoiseModelS(ISO(2),"IMX362_GOOGLE");

            case 4:
                return (float) computeNoiseModelS(ISO(2),"IMX363_GOOGLE");

            case 5:
                return (float) computeNoiseModelS(ISO(2),"IMX355_GOOGLE");

            case 6:
                return (float) computeNoiseModelS(ISO(2),"OV5693_GOOGLE");

            case 7:
                return (float) computeNoiseModelS(ISO(4),"IMX586_MEME");

            case 8:
                return (float) computeNoiseModelS(ISO(4),"IMX586_OP");
            case 9:
                return (float) computeNoiseModelS(ISO(1),"IMX586_CTS");
            case 10:
                return 0.0f;

            default:
                return 0.0f;


        }
    }

    public static float getOffset(int V,float sysScale)
    {
        Log.d("Deez NR OFF",":"+V);
        switch (V)
        {
            case 0:
                return sysScale;
            case 1:
                return (float) computeNoiseModelO(ISO(2),"IMX377_GOOGLE");

            case 2:
                return (float) computeNoiseModelO(ISO(2),"IMX378_GOOGLE");

            case 3:
                return (float) computeNoiseModelO(ISO(2),"IMX362_GOOGLE");

            case 4:
                return (float) computeNoiseModelO(ISO(2),"IMX363_GOOGLE");

            case 5:
                return (float) computeNoiseModelO(ISO(2),"IMX351_GOOGLE");

            case 6:
                return (float) computeNoiseModelO(ISO(2),"OV5693_GOOGLE");

            case 7:
                return (float) computeNoiseModelO(ISO(4),"IMX586_MEME");

            case 8:
                return (float) computeNoiseModelO(ISO(4),"IMX586_OP");
            case 9:
                return (float) computeNoiseModelO(ISO(1),"IMX586_CTS");
            case 10:
                return 0.0f;

            default:
                return 0.0f;


        }
    }

    public static float NR_Scale()
    {
        Log.d("Deez Noise Modeler ISO",""+ISO(2)+ "Scale"+ computeNoiseModelS(ISO(2),"IMX377_GOOGLE"));


        return (float) computeNoiseModelS(ISO(2),"IMX377_GOOGLE");
    }

    public static float NR_Offset()
    {
        Log.d("Deez Noise Modeler ISO",""+ISO(2)+ "Scale"+ computeNoiseModelO(ISO(2),"IMX377_GOOGLE"));
        return (float) computeNoiseModelO(ISO(2),"IMX377_GOOGLE");
    }

    public static float NR_Scale(String device)
    {
        return (float) computeNoiseModelS(ISO(2),device);
    }

    public static float NR_Offset(String device)
    {
        return (float) computeNoiseModelO(ISO(2),device);
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
        Noise_Profile_S = computeNoiseModelS(ISO(2),"Walleye");
        Noise_Profile_0 = computeNoiseModelO(ISO(2),"Walleye");

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


    private static double computeNoiseModelS(double Sensitivity,String Device)
    {
        return  preComputedModels(Device)[0] * Sensitivity + preComputedModels(Device)[1];

    }
    private static double computeNoiseModelO(double Sensitivity,String Device)
    {

        double dGain = Sensitivity/MaxAnalog586ASUS;

        dGain = (dGain<1.0) ? 1.0:dGain;

        return (preComputedModels(Device)[2] * Sensitivity*Sensitivity) + (preComputedModels(Device)[3]*dGain*dGain);

        //return (preComputedModels(Device)[2] * Sensitivity) + preComputedModels(Device)[3];


    }

    private static double computeNoiseModelOCTS(int Sensitivity,String Device)
    {
        return preComputedModels(Device)[2] * Sensitivity * Sensitivity + preComputedModels(Device)[3]*200;


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
            case "IMX586_CTS":
                return new double[]{4.191043e-06,3.987194e-005,1.179649e-010,6.472064e-006};

            default:
                return new double[]{0,0,0,0};
        }

    }
}
