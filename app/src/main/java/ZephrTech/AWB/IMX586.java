package ZephrTech.AWB;

public class IMX586 {


    public static float[] D75_ZF6()
    {
        return new float[]{0.467f,0.672f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.5f,0.637f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.569f,0.521f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.546f,0.421f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.5845f,0.439f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.623f,0.457f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.809f,0.356f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{0.983f,0.3f};
    }





    public static float[] getRGZF6()
    {
        return new float[]{D65_ZF6()[0],D75_ZF6()[0],A_ZF6()[0],TL84_ZF6()[0],CW_ZF6()[0],H_ZF6()[0],D50_ZF6()[0],F_ZF6()[0]};
    }

    public static float[] getBGZF6()
    {
        return new float[]{D65_ZF6()[1],D75_ZF6()[1],A_ZF6()[1],TL84_ZF6()[1],CW_ZF6()[1],H_ZF6()[1],D50_ZF6()[1],F_ZF6()[1]};
    }

}
