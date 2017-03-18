package Values;

import android.graphics.Bitmap;


/**
 * Created by RUNLAI on 2017/3/15.
 */

public class Shoes {
    private int id;
    private String shoesName;
    private String type;
    private Bitmap shoesImage;

    public String getShoesName(){
        return shoesName;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public Bitmap getShoesImage(){
        return shoesImage;
    }

}
