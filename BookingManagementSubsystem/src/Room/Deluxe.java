package Room;

public class Deluxe extends Room {

    private int rate;  // Rate specific to Deluxe rooms
    private boolean wifi;  // Wifi availability for Deluxe rooms

    public Deluxe() {
        super();  // Ensures that any initialization in the superclass is handled
    }

    // Method to set properties for a Deluxe room
    public void set(int r, boolean w, boolean s) {
        this.rate = r;
        this.wifi = w;
        this.setStatus(s);  // Use the setter to handle status setting
    }

    // Getter for rate
    public int getRate() {
        return this.rate;
    }

    // Getter for status using superclass method
    public boolean getStatus() {
        return super.getStatus();  // Ensure to use the superclass method if specific behavior is implemented there
    }

    // Getter for wifi
    public boolean isWifiAvailable() {
        return this.wifi;
    }

    // Method to toggle the status of the room
    @Override
    public void statuschange() {  // Changed method name to camelCase
        this.status = !this.status;
    }

    // Method to directly set the room's status with a new value
    @Override
    public void setStatus(boolean newStatus) {
        super.setStatus(newStatus);  // Calling the superclass method to ensure any additional behavior there is executed
    }

    // Method to set the fare for the room
    @Override
    public void setFare(double fare) {
        super.setFare(fare);  // Use superclass method to set fare
    }
}
