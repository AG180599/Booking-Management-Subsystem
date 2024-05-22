package Room;

public abstract class Room {
    protected boolean status;
    protected double fare;
    public int rate;  // Assuming rate is common to all rooms
    protected boolean wifi;  // Assuming wifi availability is a common feature

    // Sets the status of the room
    public void setStatus(boolean status) {
        this.status = status;
    }

    // Returns the current status of the room
    public boolean getStatus() {
        return this.status;
    }

    // Sets the fare for the room
    public void setFare(double fare) {
        this.fare = fare;
    }

    // Returns the fare of the room
    public double getFare() {
        return this.fare;
    }

    // Abstract method to change the status, must be implemented in all subclasses
    public abstract void statuschange();

    // Returns the rate for the room
    public int getRate() {
        return rate;
    }

    // Sets the rate for the room
    public void setRate(int rate) {
        this.rate = rate;
    }

    // Checks if wifi is available in the room
    public boolean isWifiAvailable() {
        return wifi;
    }

    // Sets the wifi availability for the room
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

	public void statusChange() {
		// TODO Auto-generated method stub
		
	}
}
