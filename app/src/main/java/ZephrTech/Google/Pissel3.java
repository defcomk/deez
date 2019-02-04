package ZephrTech.Google;

import ZephrTech.DeviceStaticMeta;

public class Pissel3 implements DeviceStaticMeta {




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
