package ZephrTech.AWB.M3M3;

public class Beryllium {
    public static float[] D75_ZF6()
    {
        return new float[]{0.415866f,0.784988f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.448004f,0.733977f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.510997f,0.604971f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.539858f,0.440643f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.584042f,0.443877f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.628226f,0.44711f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.76684f,0.364499f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{0.936039f,0.29531f};
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
