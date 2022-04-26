import java.util.HashMap;
import java.util.Set;

public class Hashmatique{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("First Song", "Lyrics of the First Song");
        trackList.put("Second Song", "Lyrics of the Second Song");
        trackList.put("Third Song", "Lyrics of the Third Song");
        trackList.put("Fourth Song", "Lyrics of the Fourth Song");

        String thisTrack = trackList.get("Second Song");
        System.out.println(thisTrack);

        Set<String> keys=trackList.keySet();
        for(String key : keys){
            System.out.println("Track: "+key+"  Lyrics: "+trackList.get(key));
        }
    }
}