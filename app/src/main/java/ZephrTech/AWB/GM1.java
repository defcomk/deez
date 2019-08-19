package ZephrTech.AWB;

public class GM1 {
    private static float[] D65()
    {
        return new float[]{0.388668f,0.65830302f};
    }
    private static float[] Shade()
    {
        return new float[]{0.33321401f,0.70507503f};
    }
    private static float[] A()
    {
        return new float[]{0.70763803f,0.32565999f};
    }
    private static float[] TL84()
    {
        return new float[]{0.53801501f,0.40678501f};
    }
    private static float[] CW()
    {
        return new float[]{0.481287f,0.38955501f};
    }
    private static float[] Horizon()
    {
        return new float[]{0.91000003f,0.23f};
    }
    private static float[] D50()
    {
        return new float[]{0.46114501f,0.53010398f};
    }
    private static float[] CustFL()
    {
        return new float[]{0.53801501f,0.40678501f};
    }
    private static float[] NOON()
    {
        return new float[]{0.45053735f,0.56202716f};
    }
    private static float[] CustDay()
    {
        return new float[]{0.388668f,0.65830302f};
    }
    private static float[] CustA()
    {
        return new float[]{0.83999997f,0.25f};
    }
    private static float[] U30()
    {
        return new float[]{0.705769f,0.30853501f};
    }
    private static float[] CustDay1()
    {
        return new float[]{0.39161801f,0.65463102f};
    }
    private static float[] CustDay2()
    {
        return new float[]{0.388668f,0.65830302f};
    }
    private static float[] CustFL1()
    {
        return new float[]{0.53801501f,0.40678501f};
    }
    private static float[] CustFL2()
    {
        return new float[]{0.53801501f,0.40678501f};
    }

    public static float[] getRG()
    {
        return new float[]{D65()[0],Shade()[0],A()[0],TL84()[0],CW()[0],Horizon()[0],D50()[0],CustFL()[0],NOON()[0],CustDay()[0],CustA()[0],U30()[0],CustDay1()[0],CustDay2()[0],CustFL1()[0],CustFL2()[0]};
    }

    public static float[] getBG()
    {
        return new float[]{D65()[1],Shade()[1],A()[1],TL84()[1],CW()[1],Horizon()[1],D50()[1],CustFL()[1],NOON()[1],CustDay()[1],CustA()[1],U30()[0],CustDay1()[1],CustDay2()[1],CustFL1()[1],CustFL2()[1]};
    }

}
