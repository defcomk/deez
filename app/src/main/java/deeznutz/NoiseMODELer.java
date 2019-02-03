package deeznutz;

public class NoiseMODELer {

    private static int NUM_COL_CHN = 4;
    private static double Noise_Profile_S = 0.0;
    private static double Noise_Profile_0 = 0.0;

    private static double[] noise_profile = new double[2*NUM_COL_CHN];

    public static void GenerateModel(int Sen,String Dev)

    {
        Noise_Profile_S = computeNoiseModelS(Sen,Dev);
        Noise_Profile_0 = computeNoiseModelO(Sen,Dev);

        for(int i=0; i < 2*NUM_COL_CHN ; i +=2)
        {
            noise_profile[i] = Noise_Profile_S;
            noise_profile[i+1] = Noise_Profile_S;
        }
    }

    private static double computeNoiseModelS(int Sensitivity,String Device)
    {
        double s = preComputedModels(Device)[0] * Sensitivity + preComputedModels(Device)[1];

        return s;
    }

    private static double computeNoiseModelO(int Sensitivity,String Device)
    {
        double o = preComputedModels(Device)[1] * Sensitivity + preComputedModels(Device)[2];

        return o;
    }
    private static double[] preComputedModels(String Device)
    {
        switch (Device)
        {
            case "BULLHEAD":
                return new double[]{2.0,2.0,2.0,2.0};
            case "MARLIN" :
                return new double[]{2.0,2.0,2.0,2.0};
            case "Walleye":
                return new double[]{3.514601e-006,1.049551e-005,4.786872e-011,2.237714e-006};
            case "Crosshatch":
                return new double[]{2.0,2.0,2.0,2.0};
            default:
                return new double[]{2.0,2.0,2.0,2.0};
        }

    }
}
