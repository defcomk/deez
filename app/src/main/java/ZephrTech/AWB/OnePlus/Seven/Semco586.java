package ZephrTech.AWB.OnePlus.Seven;

public class Semco586 {

    public static float[] D75_ZF6()
    {
        return new float[]{0.459125f,0.679093f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.498061f,0.646234f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.590978f,0.543097f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.564458f,0.398993f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.596151f,0.417055f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.627844f,0.435118f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.906136f,0.345966f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{1.12274f,0.285646f};
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
