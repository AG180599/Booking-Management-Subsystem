package Room;

public class Room {
    private String roomNumber;
    private String roomType;
    private boolean isAvailable;

    public Room(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
               "roomNumber='" + roomNumber + '\'' +
               ", roomType='" + roomType + '\'' +
               ", isAvailable=" + isAvailable +
               '}';
    }
}

