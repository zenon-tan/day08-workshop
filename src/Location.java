import java.util.List;

public class Location {

    private String room;
    private String name;
    private String description;
    private List<String> direction; // Use it for navigate and next location

    // Constructors

    public Location() {
 
    }
    public Location(String room, String name, String desc, List<String> direction) {
        this.room = room;
        this.name = name;
        this.description = desc;
        this.direction = direction;
    }

    public String getRoom() {
        return room;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDirection() {
        return direction;
    }
    

    public void setRoom(String room) {
        this.room = room;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDirection(List<String> direction) {
        this.direction = direction;
    }
    @Override
    public String toString() {
        String formatDir = "";
        for(String i : this.direction) {
            String[] splitStr = i.split(" ");
            formatDir = formatDir + "'%s' to %s\n".formatted(splitStr[0], splitStr[1]);
        }

        String formattedText = "\nRoom: %s\nName: %s\n%s\n\nYou can go:\n%s".formatted(this.room, this.name, this.description, formatDir);
        return formattedText;
    }

    

    



    

    
    
}
