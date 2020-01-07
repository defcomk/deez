package ZephrTech.AWB.OnePlus.SevenPro;

public class Ofilm586 {

    public static float[] D75_ZF6()
    {
        return new float[]{0.448772f,0.652606f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.483146f,0.622057f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.568499f,0.524326f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.592502f,0.386876f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.631221f,0.398315f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.669941f,0.409754f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.876533f,0.333155f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{1.07277f,0.272592f};
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
