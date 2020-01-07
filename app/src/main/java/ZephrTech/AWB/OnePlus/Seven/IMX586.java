package ZephrTech.AWB.OnePlus.Seven;

public class IMX586 {

    public static float[] D75_ZF6()
    {
        return new float[]{0.4575f,0.68627f};
    }

    public static float[] D65_ZF6()
    {
        return new float[]{0.5029f,0.640718f};
    }

    public static float[] D50_ZF6()
    {
        return new float[]{0.5864f,0.53703f};
    }

    public static float[] CW_ZF6()
    {
        return new float[]{0.5529f,0.3941f};
    }

    public static float[] F_ZF6()
    {
        return new float[]{0.59762f,0.416252f};
    }
    public static float[] TL84_ZF6()
    {
        return new float[]{0.62341f,0.4135f};
    }

    public static float[] A_ZF6()
    {
        return new float[]{0.90344f,0.3379f};
    }

    public static float[] H_ZF6()
    {
        return new float[]{1.05f,0.2857f};
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
