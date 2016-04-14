package wsienski.iview.mycustomapp.data.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by WSienski on 06/04/2016.
 */
public class TimeLineModel implements Serializable {
    private ArrayList<String> events;
    private int year;

    public ArrayList<String> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
