package ZephrTech.AWB;

public class OV13855 {
    public static float[] HIGH_ZF6()
    {
        return new float[]{0.363f,0.917f};
    }

    public static float[] D75_ZF6()
    {
        return new float[]{0.407f,0.787f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.439f,0.75f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.495f,0.624f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.558f,0.527f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.583f,0.5495f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.608f,0.572f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.74f,0.448f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{0.913f,0.393f};
    }

    public static float[] LOW_ZF6()
    {
        return new float[]{1.391f,0.34f};
    }



    public static float[] getRGZF6()
    {
        return new float[]{D65_ZF6()[0],D75_ZF6()[0],A_ZF6()[0],TL84_ZF6()[0],CW_ZF6()[0],H_ZF6()[0],D50_ZF6()[0],F_ZF6()[0]};
    }

    public static float[] getBGZF6()
    {
        return new float[]{D65_ZF6()[1],D75_ZF6()[1],A_ZF6()[1],TL84_ZF6()[1],CW_ZF6()[1],H_ZF6()[1],D50_ZF6()[1],F_ZF6()[1]};
    }

    public static float[] getRG12k21k()
    {
        return new float[]{HIGH_ZF6()[0],D65_ZF6()[0],D75_ZF6()[0],A_ZF6()[0],TL84_ZF6()[0],CW_ZF6()[0],H_ZF6()[0],D50_ZF6()[0],F_ZF6()[0],LOW_ZF6()[0]};
    }

    public static float[] getBG12k21k()
    {
        return new float[]{HIGH_ZF6()[1],D65_ZF6()[1],D75_ZF6()[1],A_ZF6()[1],TL84_ZF6()[1],CW_ZF6()[1],H_ZF6()[1],D50_ZF6()[1],F_ZF6()[1],LOW_ZF6()[1]};
    }
}
