public class Traffic15p {
    private int thoigian_15p;
    private double QT_GBytes, VN_GBytes ;

    public Traffic15p() {
    }

    public Traffic15p(int thoigian_15p, double QT_GBytes, double VN_GBytes) {
        this.thoigian_15p = thoigian_15p;
        this.QT_GBytes = QT_GBytes;
        this.VN_GBytes = VN_GBytes;
    }

    public int getThoigian_15p() {
        return thoigian_15p;
    }

    public void setThoigian_15p(int thoigian_15p) {
        this.thoigian_15p = thoigian_15p;
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

