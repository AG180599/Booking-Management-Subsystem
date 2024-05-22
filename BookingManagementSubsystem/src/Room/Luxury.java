package Room;

public class Luxury extends Room {
    
    public int rate;  // Specific to Luxury rooms
    private boolean wifi;  // Specific to Luxury rooms

    @Override
    public void setStatus(boolean newStatus) {
        super.setStatus(newStatus);
    }

    @Override
    public void setFare(double fare) {
        super.setFare(fare);
    }

    @Override
    public void statuschange() {
        this.status = !this.status; // Toggles the status
    }
    

    public void set(int r, boolean w, boolean s) {
        this.rate = r;
        this.wifi = w;
        this.status = s;
    }

    public int getRate() {
        return this.rate;
    }

    public boolean getWifi() {
        return this.wifi;
    }

    public boolean getStatus() {
        return this.status;
    }
}
