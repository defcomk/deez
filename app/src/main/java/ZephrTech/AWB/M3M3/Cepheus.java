package ZephrTech.AWB.M3M3;

public class Cepheus {

    public static float[] D75_ZF6()
    {
        return new float[]{0.454779f,0.683576f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.493319f,0.642238f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.565422f,0.535638f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.557147f,0.417198f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.590119f,0.414956f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.623091f,0.412713f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.901987f,0.347468f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{1.10216f,0.287979f};
    }





    public static float[] getRG()
    {
        return new float[]{D65_ZF6()[0],D75_ZF6()[0],A_ZF6()[0],TL84_ZF6()[0],CW_ZF6()[0],H_ZF6()[0],D50_ZF6()[0],F_ZF6()[0]};
    }

    public static float[] getBG()
    {
        return new float[]{D65_ZF6()[1],D75_ZF6()[1],A_ZF6()[1],TL84_ZF6()[1],CW_ZF6()[1],H_ZF6()[1],D50_ZF6()[1],F_ZF6()[1]};
    }
}
