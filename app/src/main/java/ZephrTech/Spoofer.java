package ZephrTech;

import android.util.Range;
import android.util.Size;

import java.util.ArrayList;
import java.util.List;

public class Spoofer {

    public static final String MANUFACTURER = "Google";
    public static final String BRAND = "Google";
    public static final String MODEL = "Pixel 2 XL";
    public static final String DEVICE = "taimen";
    public static final String NAME = "taimen";

    public static boolean isBinActive = false;

    public static List<Size> get586inreproc() {

        List<Size> A = new ArrayList<>();

        Size _48MP = new Size(8000,6000);
        Size _12MP = new Size(4000,3000);
        Size _9MP = new Size(4000,2250);
        Size _3MP = new Size(2000,1500);

        A.add(_48MP);
        A.add(_12MP);
        A.add(_9MP);
        A.add(_3MP);


        return A;


    }

    public static Size[] get586sizearr()
    {
        return new Size[]{new Size(4000,3000),new Size(4000,2250),new Size(2000,1500)};
    }

    public static List<Size> get586() {

        List<Size> A = new ArrayList<>();

        Size _48MP = new Size(8000,6000);
        Size _12MP = new Size(4000,3000);
        Size _9MP = new Size(4000,2250);
        Size _3MP = new Size(2000,1500);

        //A.add(_48MP);
        A.add(_12MP);
        A.add(_9MP);
        A.add(_3MP);


        return A;


    }

    public static List<Size> getZF6Video() {

        List<Size> A = new ArrayList<>();

        Size _48MP = new Size(7680,4320);
        Size _9MP = new Size(4000,2250);
        Size _8MP = new Size(3840,2160);
        Size _3MP = new Size(1920,1080);
        Size _720p = new Size(1280,720);

        A.add(_48MP);
        A.add(_9MP);
        A.add(_8MP);
        A.add(_3MP);
        A.add(_720p);


        return A;


    }

    public static List<Size> getPreviewClamped() {

        List<Size> A = new ArrayList<>();

        Size _3MP = new Size(1024,768);


        A.add(_3MP);


        return A;


    }

    public static Long SumOffset(Long inShutter)
    {
        if(inShutter < 110000000 && inShutter > 240000000 )
        {
            isBinActive = true;
          return   inShutter * 2;

        }
        else {
            isBinActive = false;
            return inShutter;
        }
    }

    public static Integer GetISOOFFSET(Integer in)
    {
        if(isBinActive)
        {
            return Math.round(in/2);
        }
        else {
            return in;
        }
    }


    public static Size[] clampPrevi()
    {
        return new Size[]{new Size(1024,768)};
    }

    public static Size[] clampOutput()
    {
        return new Size[]{new Size(4000,3000),new Size(2000,1500)};
    }

    private static void tt()
    {
        List<Size> a = getPreviewClamped();
    }


    public static Range<Integer> getZSL60()
    {


        Range<Integer> range = new Range<>(15,60);

        return range;


    }

}
