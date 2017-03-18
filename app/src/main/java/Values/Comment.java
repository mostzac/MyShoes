package Values;

/**
 * Created by RUNLAI on 2017/3/15.
 */

public class Comment {
    private int id;
    private  ShoesReport shoesReport;
    private String content;

    public ShoesReport getShoesReport(){
        return shoesReport;
    }
    public int getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
}
