package deeznutz;

public class AEmod{

    public static long BIASGCAM(long Gcam,long OS)
    {
        long A = (Gcam + OS)/2;

        long B = (Gcam + A)/2;

        return B;
    }

    public static float GcamMatch_OS_TET(long sos,long sgcam)
    {
        return sgcam/sos;


    }

}
