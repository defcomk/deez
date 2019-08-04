package ZephrTech.Asus;

import ZephrTech.MoDevice;

public class Zenfone6 implements MoDevice {

    @Override
    public float getScale(){
       return 1.0f;
    }

    @Override
   public float getOffset(){
        return 1.0f;
    }

    @Override
    public float[] getLinearization(){
return new float[]{0f};
    }

    @Override
    public float[] getColorTransform1(){
        return new float[]{0f};
    }

    @Override
    public float[] getColorTransform2(){
        return new float[]{0f};
    }

    @Override
    public int getNumCameras(){
return 2;
    }

    @Override
    public long getLongestShutter(){
return 100000000000l;
    }

    @Override
    public int getMaxISO(){

        return 12;
    }

    @Override
    public float getHyperfocalDistance(){
return 0.41515151f;
    }



}
