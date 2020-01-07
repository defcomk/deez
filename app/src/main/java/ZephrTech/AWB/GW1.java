package ZephrTech.AWB;

public class GW1 {

    private static float[] HIGH_ZF6()
    {
        return new float[]{0.214104f,0.945349f};
    }

    private static float[] D75_ZF6()
    {
        return new float[]{0.473056f,0.75333f};
    }

    private static float[] D65_ZF6()
    {
        return new float[]{0.503625f,0.68302f};
    }

    private static float[] D50_ZF6()
    {
        return new float[]{0.589943f,0.619013f};
    }

    private static float[] CW_ZF6()
    {
        return new float[]{0.607903f,0.443968f};
    }

    private static float[] F_ZF6()
    {
        return new float[]{0.641816f,0.449073f};
    }
    private static float[] TL84_ZF6()
    {
        return new float[]{0.675729f,0.454178f};
    }

    private static float[] A_ZF6()
    {
        return new float[]{0.900343f,0.388876f};
    }

    private static float[] H_ZF6()
    {
        return new float[]{1.11547f,0.330927f};
    }

    private static float[] LOW_ZF6()
    {
        return new float[]{1.42839f,0.246637f};
    }



    public static float[] getRG()
    {
        return new float[]{D65_ZF6()[0],D75_ZF6()[0],A_ZF6()[0],TL84_ZF6()[0],CW_ZF6()[0],H_ZF6()[0],D50_ZF6()[0],F_ZF6()[0]};
    }

    public static float[] getBG()
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
