package ZephrTech.AWB.OnePlus.SevenTeeP;

public class IMX586 {
    public static float[] D75_ZF6()
    {
        return new float[]{0.44241f,0.632865f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.479778f,0.603405f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.560285f,0.509319f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.57622f,0.374113f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.615355f,0.383453f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.65449f,0.392793f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.856835f,0.334359f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{1.05123f,0.277816f};
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
