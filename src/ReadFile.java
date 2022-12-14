import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReadFile {

    public final static String ROOM = "room";
    public final static String NAME = "name";
    public final static String DESC = "description";
    public final static String DIRECTION = "direction";
    public final static String START = "start";
    public final static String EXIT = "exit";
    public final static List<String> READERWORDS = Arrays.asList(ROOM, NAME, DESC, DIRECTION);

    public static String startingLoc;
    

    

    public static List<ArrayList<String>> readFile(String fileName) throws Exception {

        List<ArrayList<String>> allLocations = new ArrayList<ArrayList<String>>();

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;

        ArrayList<String> byLocation = new ArrayList<>();
        

        while(null != (line = br.readLine())) {

            
            if(!line.trim().isEmpty()) {

                String[] splitString = line.split(": ");

                if(splitString[0].trim().equals(START)) {
                    startingLoc = splitString[1];
                }

                byLocation.add(splitString[1]);


            } else {
                allLocations.add(byLocation);

                byLocation = new ArrayList<>();
            }
            // System.out.println(allLocations);
            // System.out.println(startingLoc);

        }

        br.close();
        fr.close();

        return allLocations;
    }

    public static HashMap<String, Location> createRooms(List<ArrayList<String>> nested) throws Exception {

        HashMap<String, Location> locationMap = new HashMap<>();

        for(ArrayList<String> i : nested) {

            String tmpRoom = i.get(0);
            String tmpName = i.get(1);
            String tmpDesc = i.get(2).replace("<break>", "\n");
            List<String> tmpDir = new ArrayList<>();
            for(int j = 3; j < i.size(); j++) {
    
                tmpDir.add(i.get(j));
    
            }
    
            Location loc = new Location(tmpRoom, tmpName, tmpDesc, tmpDir);
            locationMap.put(tmpRoom, loc);

        }

        return locationMap;

        
    }
}
