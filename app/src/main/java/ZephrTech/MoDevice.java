package ZephrTech;

public interface MoDevice {

    float getScale();

    float getOffset();

    float[] getLinearization();

    float[] getColorTransform1();

    float[] getColorTransform2();

    int getNumCameras();

    long getLongestShutter();

    int getMaxISO();

    float getHyperfocalDistance();




}
