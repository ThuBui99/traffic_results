import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrafficDAO extends DAO {
    public ArrayList<Traffic> searchTraffic(){
        ArrayList<Traffic> result = new ArrayList<Traffic>();
        String sql = "SELECT * FROM traffic";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Traffic traffic = new Traffic();
                traffic.setMac_client(rs.getString("mac_client"));
                traffic.setFrom_time(rs.getDouble("from_time"));
                traffic.setTo_time(rs.getDouble("to_time"));
                traffic.setVn_traffic(rs.getLong("vn_traffic"));
                traffic.setQt_traffic(rs.getLong("qt_traffic"));
                result.add(traffic);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean addTraffic(Traffic traffic){
        String sql= "INSERT INTO traffic VALUES(?, ?, ?, ?, ?, ?)";
//                + traffic.getMac_client() + "','" + traffic.getFrom_time() + "','" + traffic.getTo_time()
//                + traffic.getVn_traffic() + "','" + traffic.getQt_traffic() + "')";
//        String sql2 = "SELECT id FROM traffic WHERE mac_client = ? ";

        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, null);
            cs.setString(2, traffic.getMac_client());
            cs.setDouble(3, traffic.getFrom_time());
            cs.setDouble(4, traffic.getTo_time());
            cs.setLong(5, traffic.getVn_traffic());
            cs.setLong(6, traffic.getQt_traffic());
            cs.executeUpdate();
//            PreparedStatement ps = con.prepareStatement(sql2);
//            ps.setString(1, traffic.getMac_client());
//            ResultSet rs = ps.executeQuery();
//            int a= 0;
//            while (rs.next()) {
//                a=rs.getInt("id");
//            }
//            if (a>0) {
//                return true;
//            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean addListTraffic(List<Traffic> list){
        String sql= "INSERT INTO traffic VALUES(?, ?, ?, ?, ?, ?)";
//                + traffic.getMac_client() + "','" + traffic.getFrom_time() + "','" + traffic.getTo_time()
//                + traffic.getVn_traffic() + "','" + traffic.getQt_traffic() + "')";
//        String sql2 = "SELECT id FROM traffic WHERE mac_client = ? ";

        try{
            PreparedStatement cs = con.prepareStatement(sql);
            con.setAutoCommit(false);
            for(Traffic traffic : list) {
                cs.setString(1, null);
                cs.setString(2, traffic.getMac_client());
                cs.setDouble(3, traffic.getFrom_time());
                cs.setDouble(4, traffic.getTo_time());
                cs.setLong(5, traffic.getVn_traffic());
                cs.setLong(6, traffic.getQt_traffic());
                cs.execute();
            }
            con.commit();
            con.setAutoCommit(true);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<TrafficResults> getListTrafficResult(){
        String sql= "{CALL get_traffic_results()}";
//                + traffic.getMac_client() + "','" + traffic.getFrom_time() + "','" + traffic.getTo_time()
//                + traffic.getVn_traffic() + "','" + traffic.getQt_traffic() + "')";
//        String sql2 = "SELECT id FROM traffic WHERE mac_client = ? ";
        ArrayList<TrafficResults> listTrafficResult = new ArrayList<TrafficResults>();
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                TrafficResults tr = new TrafficResults();
                tr.setMac_client(rs.getString("mac_client"));
                tr.setQT_GBytes(rs.getDouble("QT_GBytes"));
                tr.setVN_GBytes(rs.getDouble("VN_GBytes"));
                listTrafficResult.add(tr);
            }
            return listTrafficResult;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Traffic15p> getTraffic15p(){
        String sql= "{CALL get_traffic_15p()}";
//                + traffic.getMac_client() + "','" + traffic.getFrom_time() + "','" + traffic.getTo_time()
//                + traffic.getVn_traffic() + "','" + traffic.getQt_traffic() + "')";
//        String sql2 = "SELECT id FROM traffic WHERE mac_client = ? ";
        ArrayList<Traffic15p> listTraffic15p = new ArrayList<Traffic15p>();
        try{
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Traffic15p tr = new Traffic15p();
                tr.setThoigian_15p(rs.getInt("thoigian_15p"));
                tr.setQT_GBytes(rs.getDouble("QT_GBytes"));
                tr.setVN_GBytes(rs.getDouble("VN_GBytes"));
                listTraffic15p.add(tr);
            }
            return listTraffic15p;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

