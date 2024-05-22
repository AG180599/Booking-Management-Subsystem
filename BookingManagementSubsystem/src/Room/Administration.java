package Room;

public class Administration {

	    // Method to add a new room
	public void addRoom(Room room, Room[] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {  // Find the first null spot in the array
                rooms[i] = room;
                System.out.println("New room added at position " + i);
                return;
            }
        }
        System.out.println("No available space to add a new room.");
    }

	// Method to remove a room from the system
    public void removeRoom(int roomId, Room[] rooms) {
        if (roomId >= 0 && roomId < rooms.length && rooms[roomId] != null) {
            rooms[roomId] = null;  // Setting the room at the specified index to null
            System.out.println("Room " + roomId + " has been removed.");
        } else {
            System.out.println("Invalid room ID or room already empty.");
        }
    }
 // Method to update room fare
    public void updateRoomFare(int roomId, double newFare, Room[] rooms) {
        if (roomId >= 0 && roomId < rooms.length && rooms[roomId] != null) {
            rooms[roomId].setFare(newFare);
            System.out.println("Fare of room " + roomId + " has been updated to $" + newFare);
        } else {
            System.out.println("Invalid room ID or room not found.");
        }
    }

 // Method to generate a report
    public String generateReport(Room[] rooms) {
        StringBuilder report = new StringBuilder();
        int activeRooms = 0;
        double totalRevenue = 0.0;

        report.append("Room Report:\n");
        for (Room room : rooms) {
            if (room != null) {
                activeRooms++;
                totalRevenue += room.getFare();
                report.append("Room: $" + room.getFare() + " - " +
                              (room.getStatus() ? "Occupied" : "Available") + "\n");
            }
        }

        report.append("\nTotal Active Rooms: " + activeRooms);
        report.append("\nTotal Potential Revenue: $" + totalRevenue);
        return report.toString();
    }


	    public void enableRoom(Luxury[] ly, int roomId) {
	        if (roomId >= 0 && roomId < ly.length) {  // Corrected from Room.length to ly.length
	            ly[roomId].setStatus(true);
	            System.out.println("Room " + roomId + " has been enabled.");
	        } else {
	            System.out.println("Invalid room ID.");
	        }
	    }

	    public void disableRoom(Luxury[] rooms, int roomId) {
	        if (roomId >= 0 && roomId < rooms.length) {
	            rooms[roomId].setStatus(false);
	            System.out.println("Room " + roomId + " has been disabled.");
	        } else {
	            System.out.println("Invalid room ID.");
	        }

			
		}

	    public void updateRoomFare(Luxury[] rooms, int roomId, double newFare) {
	        if (roomId >= 0 && roomId < rooms.length) {
	            rooms[roomId].setFare(newFare);
	            System.out.println("Fare of room " + roomId + " has been updated to " + newFare);
	        } else {
	            System.out.println("Invalid room ID.");
	        }
	    }
}