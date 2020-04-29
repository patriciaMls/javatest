package castle;

import java.util.HashMap;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/4/15 10:34
 * @version: 1.0
 * @modified By:
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();

    public Room(String description){
        this.description = description;
    }

    public void setExit(String dir, Room room){
        exits.put(dir,room);
    }

    public String toString(){
        return description;
    }

    public String getExitDesc(){
        StringBuffer sb = new StringBuffer();
        for (String dir : exits.keySet()){
            sb.append(dir);
            sb.append(' ');
        }

        return sb.toString();
    }

    public Room getExit(String direction){
        return exits.get(direction);
    }
}
