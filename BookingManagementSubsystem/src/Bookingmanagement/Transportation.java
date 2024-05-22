package Bookingmanagement;

import java.util.Scanner;

public class Transportation {
    private double totalCost;

    public Transportation() {
        this.totalCost = 0.0;
    }

    public void setDetails() {
        // Assuming some logic to determine total cost based on some factors
        this.totalCost = 100.0;  // Example fixed cost for demonstration
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void addCost(double additionalCost) {
        this.totalCost += additionalCost;
    }
}

	
