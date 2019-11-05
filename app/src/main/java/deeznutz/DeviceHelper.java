package deeznutz;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class DeviceHelper {

  static int dummy =0;

    public static boolean isAux()
    {


        if(dummy == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean is48MP()
    {


        if(dummy == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static int[] IMX586_12_RANGE()
    {
        if(!isAux())
        {
            return new int[]{25,25600};
        }
        else {
            return new int[]{25,1627};
        }

    }

    public static int IMX586_12()
    {
        if(!isAux()) {
            return 6400;
        }
        else
        {
            return 1600;
        }


    }

    public static void cstarkCreateNewFile()
    {
        String f = "file.tmp";

        String extDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
        File fold = new File(extDir,f);
        try {
            if(fold.createNewFile())
            {
                Log.d("Cstark","TMP Written");
            }

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


}
