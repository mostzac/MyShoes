package Values;

/**
 * Created by RUNLAI on 2017/3/15.
 */

public class ShoesReport {
    private int id;
    private String title;
    private Shoes shoes;
    private User user;

    public User getUser(){
        return user;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public Shoes getShoes(){
        return shoes;
    }
}
