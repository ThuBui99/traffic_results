import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Traffic {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String mac_client;
    private double from_time;
    private double to_time;
    private long vn_traffic;
    private long qt_traffic;


    public Traffic() {
    }

    public Traffic(int id, String mac_client, double from_time, double to_time, long vn_traffic, long qt_traffic) {
        this.id = id;
        this.mac_client = mac_client;
        this.from_time = from_time;
        this.to_time = to_time;
        this.vn_traffic = vn_traffic;
        this.qt_traffic = qt_traffic;
    }

    public String getMac_client() {
        return mac_client;
    }

    public void setMac_client(String mac_client) {
        this.mac_client = mac_client;
    }

    public double getFrom_time() {
        return from_time;
    }

    public void setFrom_time(double from_time) {
        this.from_time = from_time;
    }

    public double getTo_time() {
        return to_time;
    }

    public void setTo_time(double to_time) {
        this.to_time = to_time;
    }

    public long getVn_traffic() {
        return vn_traffic;
    }

    public void setVn_traffic(long vn_traffic) {
        this.vn_traffic = vn_traffic;
    }

    public long getQt_traffic() {
        return qt_traffic;
    }

    public void setQt_traffic(long qt_traffic) {
        this.qt_traffic = qt_traffic;
    }
}
