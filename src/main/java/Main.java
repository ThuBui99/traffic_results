
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main (String[] args) throws URISyntaxException, IOException {

        System.out.println("Start");
        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\THU BUI\\OneDrive\\Máy tính\\traffic_stats_out");
        //List of all files and directories
        File filesList[] = directoryPath.listFiles();
        long i = 0;
        ArrayList<Traffic> trafficArrayList = new ArrayList<>();
        for(File file : filesList) {
            byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
            String json = new String(bytes);
            ArrayList<Traffic> temp = objectMapper.readValue(json, new TypeReference<ArrayList<Traffic>>() {});

            //// add value without check duplicate
            trafficArrayList.addAll(temp);

            //// add value if duplicate
//            if(i == 0) trafficArrayList = temp;
//            else for(Traffic tf : temp) {
//                Traffic comp = trafficArrayList.stream()
//                        .filter(customer -> tf.getMac_client().equals(customer.getMac_client()))
//                        .findAny()
//                        .orElse(null);
//                if(comp != null) comp.setQt_traffic(comp.getQt_traffic() + tf.getQt_traffic());
//                else trafficArrayList.add(tf);
//            }
//            i++;
        }
        System.out.println("Read file successfully");
        //// add all then update to database
        if( new TrafficDAO().addListTraffic(trafficArrayList)){
            try {
                System.out.println("Write to db successfully");
                ArrayList<TrafficResults> tr = new TrafficDAO().getListTrafficResult();
                FileWriter myWriter = new FileWriter("Qt_traffic_and_vn_traffic_during_the_day_of_clients.csv");
                for(int j =0 ; j<tr.size()-1;j++) {
                    myWriter.write(tr.get(j).getMac_client() +  "," + tr.get(j).getQT_GBytes() +"," + tr.get(j).getVN_GBytes() );
                    myWriter.write("\n");


                    // add and update to database
                //    boolean boo = new TrafficDAO().addTraffic(trafficArrayList.get(j));
                //    System.out.println(boo);
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        if( new TrafficDAO().addListTraffic(trafficArrayList)){
            try {
                System.out.println("Write to db successfully");
                ArrayList<Traffic15p> tr = new TrafficDAO().getTraffic15p();
                FileWriter myWriter = new FileWriter("Qt_traffic_and_vn_traffic_15p.csv");
                for(int j =0 ; j<tr.size()-1;j++) {
                    myWriter.write(tr.get(j).getThoigian_15p() +  "," + tr.get(j).getQT_GBytes() +"," + tr.get(j).getVN_GBytes() );
                    myWriter.write("\n");


                    // add and update to database
                    //    boolean boo = new TrafficDAO().addTraffic(trafficArrayList.get(j));
                    //    System.out.println(boo);
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }


        //// sort array
//        trafficArrayList.sort(Comparator.comparing(Traffic::getQt_traffic).reversed());
//        Traffic tra = trafficArrayList.get(0);
//        System.out.println(tra.getMac_client() + " - " + tra.getQt_traffic());
//        for(int j =0 ; j<trafficArrayList.size()-1;j++) {
//            System.out.println(trafficArrayList.get(j).getMac_client() + " - " + trafficArrayList.get(j).getQt_traffic());
//        }

//        try {
//            //FileWriter myWriter = new FileWriter("Qt_traffic_during_the_day_of_clients.csv");
//            for(int j =0 ; j<trafficArrayList.size()-1;j++) {
////                myWriter.write(trafficArrayList.get(j).getMac_client() +  "," + trafficArrayList.get(j).getFrom_time() +"," + trafficArrayList.get(j).getTo_time() +"," +trafficArrayList.get(j).getVn_traffic() + "," + trafficArrayList.get(j).getQt_traffic());
////                myWriter.write("\n");
//
//
//                    // add and update to database
//                boolean boo = new TrafficDAO().addTraffic(trafficArrayList.get(j));
//                System.out.println(boo);
//            }
////            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (Exception e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

        //// select/insert database
//        Traffic traffic = new Traffic();
////        traffic = new TrafficDAO().searchTraffic().get(0);
////        System.out.println(traffic.getMac_client() +"," + traffic.getFrom_time() +","+ traffic.getTo_time() +"," +  traffic.getVn_traffic() +","+ traffic.getQt_traffic());
//        traffic.setMac_client("a0:65:18:74:fc:23");
//        traffic.setFrom_time(1.649257461645E9);
//        traffic.setTo_time(1.649257521645E9);
//        traffic.setVn_traffic(27062945);
//        traffic.setQt_traffic(646);
//        boolean boo = new TrafficDAO().addTraffic(traffic);
//        System.out.println(boo);
    }

}
