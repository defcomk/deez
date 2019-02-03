package deeznutz;

public class BlackLeveler {

    public static float[] BlackShift(int paramInt1, int paramInt2)
    {
        if (paramInt2 == 0) {
            return new float[] { 64.0F, 64.0F, 64.0F, 64.0F };
        }
        if ((paramInt1 > 99) && (paramInt1 < 200)) {
            return new float[] { 63.875F, 64.0F, 64.8125F, 64.25F };
        }
        if ((paramInt1 > 200) && (paramInt1 < 400)) {
            return new float[] { 63.75F, 65.0F, 63.75F, 63.9375F };
        }
        if ((paramInt1 > 400) && (paramInt1 < 800)) {
            return new float[] { 63.75F, 63.75F, 64.75F, 63.6875F };
        }
        if ((paramInt1 > 800) && (paramInt1 < 1600)) {
            return new float[] { 63.5625F, 63.5F, 64.4375F, 63.5F };
        }
        if ((paramInt1 > 1600) && (paramInt1 < 3200)) {
            return new float[] { 64.125F, 64.625F, 63.9375F, 63.9375F };
        }
        if ((paramInt1 > 3200) && (paramInt1 < 6400)) {
            return new float[] { 63.3125F, 64.3125F, 67.92969F, 63.6875F };
        }
        if ((paramInt1 > 6400) && (paramInt1 < 12800)) {
            return new float[] { 61.6875F, 62.6875F, 62.9375F, 63.4375F };
        }
        if ((paramInt1 > 12800) && (paramInt1 < 19200)) {
            return new float[] { 59.75F, 63.4375F, 61.9375F, 63.0F };
        }
        if (paramInt1 < 19200) {
            return new float[] { 72.0F, 72.0F, 71.0F, 72.0F };
        }
        return new float[] { 62.25F, 64.6875F, 64.5625F, 64.875F };
    }

    public static float[] BlackShiftOBJ(Integer paramInteger1, Integer paramInteger2)
    {
        if (paramInteger2.intValue() == 1) {
            return new float[] { 16.0F, 16.0F, 16.0F, 16.0F };
        }
        if ((paramInteger1.intValue() > 3200) && (paramInteger1.intValue() < 6400)) {
            return new float[] { 65.0F, 65.0F, 64.0F, 65.0F };
        }
        if ((paramInteger1.intValue() > 6400) && (paramInteger1.intValue() < 8800)) {
            return new float[] { 65.0F, 65.0F, 65.0F, 64.0F };
        }
        if ((paramInteger1.intValue() > 8800) && (paramInteger1.intValue() < 12800)) {
            return new float[] { 66.0F, 66.0F, 66.0F, 67.0F };
        }
        return new float[] { 64.0F, 64.0F, 64.0F, 64.0F };
    }

    public static float[] IMX363(boolean passthru,float[] inBL,int Sensitivity)
    {
        Sensitivity = Sensitivity/(int)lol.getISO_to_Gain_Quant();
        if(passthru)
        {
            return inBL;
        }
        else if ((Sensitivity >= 100) && (Sensitivity <= 199)) {
            return new float[] { 63.875F, 64.0F, 64.8125F, 64.25F };
        }
        else if ((Sensitivity >= 200) && (Sensitivity <= 399)) {
            return new float[] { 63.75F, 65.0F, 63.75F, 63.9375F };
        }
        else if ((Sensitivity >= 400) && (Sensitivity <= 799)) {
            return new float[] { 63.75F, 63.75F, 64.75F, 63.6875F };
        }
        else if ((Sensitivity >= 800) && (Sensitivity <= 1599)) {
            return new float[] { 63.5625F, 63.5F, 64.4375F, 63.5F };
        }
        else if ((Sensitivity >= 1600) && (Sensitivity <= 3199)) {
            return new float[] { 64.125F, 64.625F, 63.9375F, 63.9375F };
        }
        else if ((Sensitivity >= 3200) && (Sensitivity <= 6399)) {
            return new float[] { 63.3125F, 64.3125F, 67.92969F, 63.6875F };
        }
        else if ((Sensitivity >= 6400) && (Sensitivity <= 12799)) {
            return new float[] { 61.6875F, 62.6875F, 62.9375F, 63.4375F };
        }
        else if ((Sensitivity >= 12800) && (Sensitivity <= 15999)) {
            return new float[] { 59.75F, 63.4375F, 61.9375F, 63.0F };
        }
        else if ((Sensitivity >= 16000) && (Sensitivity <= 25599)) {
            return new float[] { 72.0F, 72.0F, 71.0F, 72.0F };
        }
        else if ((Sensitivity >= 25600) && (Sensitivity <= 29999)) {
            return new float[] { 72.0F, 72.0F, 71.0F, 72.0F };
        }
        else if ((Sensitivity >= 30000) && (Sensitivity <= 51199)) {
            return new float[] { 72.0F, 72.0F, 71.0F, 72.0F };
        }
        else if ((Sensitivity >= 51200) && (Sensitivity <= 102400)) {
            return new float[] { 72.0F, 72.0F, 71.0F, 72.0F };
        }
        else
        {
            return inBL;
        }
    }
}
