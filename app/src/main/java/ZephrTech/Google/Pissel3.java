package ZephrTech.Google;

import ZephrTech.DeviceStaticMeta;

public class Pissel3 implements DeviceStaticMeta {

    /*else if (ISO()>=12620&&ISO()<=25239)
            {
                return new float[]{270.25f,332.5f,328.5f,273.75f};
            }
            else if (ISO()>=25240&&ISO()<=35199)
            {
                return new float[]{351.25f,509.5f,504.5f,349.25f};
            }
            else if (ISO()>=35200&&ISO()<=50479)
            {
                return new float[]{392.5f,604.5f,599.75f,399.75f};
            }
            else if (ISO()>=50480&&ISO()<=70399)
            {
                return new float[]{546.5f,927.25f,920.75f,556f};
            }
            else if (ISO()>=70400&&ISO()<=93499) {
                return new float[]{628.75f, 1125.75f, 1119f, 642.5f};
            }

            else if (ISO()>=93500&&ISO()<=113777*2)
            {
                return new float[]{787.25f,1398.5f,1390f,803f};
            }*/



    @Override
    public float[] LENS(String property)
    {
       /* switch (property)
        {
            case "poseRotation":
                return new float[]{-0.04992000f,0.00407266f,-0.00739676f,0.00121863f};
            case "poseReference":
                return new float[]{-0.04992000f,0.00407266f,-0.00739676f,0.00121863f};
        }*/
        return new float[]{-0.04992000f,0.00407266f,-0.00739676f,0.00121863f};
    }

    @Override
    public float[] NOISE_MODEL()
    {
        return new float[]{-0.04992000f,0.00407266f,-0.00739676f,0.00121863f};
    }

    @Override
    public float[] OTP_WB(int index,String color)
    {
        return new float[]{-0.04992000f,0.00407266f,-0.00739676f,0.00121863f};

    }


}
