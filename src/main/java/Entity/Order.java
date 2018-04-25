package Entity;

import javax.persistence.Entity;

@Entity
public class Order {
    private String item;
    private int time;


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Order(String order, int date)
    {
        this.item = order;
        this.time = date;
    }

}
