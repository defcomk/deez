package ZephrTech;

import android.util.Size;

import java.util.ArrayList;
import java.util.List;

public class Spoofer {

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

}
