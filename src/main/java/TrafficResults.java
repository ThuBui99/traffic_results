public class TrafficResults {
    private String mac_client;
    private double QT_GBytes;
    private double VN_GBytes;

    public TrafficResults() {
    }

    public TrafficResults(String mac_client, double QT_GBytes, double VN_GBytes) {
        this.mac_client = mac_client;
        this.QT_GBytes = QT_GBytes;
        this.VN_GBytes = VN_GBytes;
    }

    public String getMac_client() {
        return mac_client;
    }

    public void setMac_client(String mac_client) {
        this.mac_client = mac_client;
    }

    public double getQT_GBytes() {
        return QT_GBytes;
    }

    public void setQT_GBytes(double QT_GBytes) {
        this.QT_GBytes = QT_GBytes;
    }

    public double getVN_GBytes() {
        return VN_GBytes;
    }

    public void setVN_GBytes(double VN_GBytes) {
        this.VN_GBytes = VN_GBytes;
    }

}
