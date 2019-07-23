package deeznutz;

import android.util.Pair;

public class NoiseMODELer {

    private static int NUM_COL_CHN = 4;
    private static double Noise_Profile_S = 0.0;
    private static double Noise_Profile_0 = 0.0;

    public static int ISO()
    {
        //return Math.round(frame_a_gain*frame_d_gain);
        return lol.getISO_Out();
    }

    public static double NR_S()
    {
        return computeNoiseModelS(ISO(),"IMX363_GOOGLE");
    }

    public static double NR_O()
    {
        return computeNoiseModelO(ISO(),"IMX363_GOOGLE");
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
                return new double[]{2.0,2.0,2.0,2.0};
            case "IMX355_GOOGLE" :
                return new double[]{2.0,2.0,2.0,2.0};
            case "OV4668_GOOGLE" :
                return new double[]{2.0,2.0,2.0,2.0};
            case "IMX179_GOOGLE" :
                return new double[]{2.0,2.0,2.0,2.0};
            case "OV5647_GOOGLE" :
                return new double[]{2.0,2.0,2.0,2.0};
            case "IMX363_MEME":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX345_SAM":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX363_ASUS":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX586_MEME":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX519_OP":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX586_ASUS":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "IMX586_OP":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            default:
                return new double[]{0,0,0,0};
        }

    }
}
