package trainTicketsCalculator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Passenger {
    private String name;
    private String icNumber;
    private String gender;
    private int age;
    private String origin;
    private String destination;
    private String packageType;
    private String category;
    private String date;
    private double price;
    private double totalPrice = 0;
    
    public Passenger(String origin, String destination, String packageType, String category) {
        this.origin = origin;
        this.destination = destination;
        this.packageType = packageType;
        this.category = category;
        calculatePrice();
    }

    public Passenger(String name, String icNumber, String gender, int age, String origin, String destination, String packageType, String category, double totalPrice) {
        this.name = name;
        this.icNumber = icNumber;
        this.gender = gender;
        this.age = age;
        this.origin = origin;
        this.destination = destination;
        this.packageType = packageType;
        this.category = category;
        this.totalPrice = totalPrice;
        date();
    }
    
    public Passenger(String name, String icNumber, String gender, int age, String origin, String destination, String packageType, String category, String date, double totalPrice) {
        this.name = name;
        this.icNumber = icNumber;
        this.gender = gender;
        this.age = age;
        this.origin = origin;
        this.destination = destination;
        this.packageType = packageType;
        this.category = category;
        this.date = date;
        this.totalPrice = totalPrice;
    }
    
    public String getName() {
        return name;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return totalPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setPrice(Double price) {
        this.totalPrice = price;
    }
    
    public void date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        
        if (packageType.equals("Weekly Pass")) {
            // Add 6 days for Weekly Pass
            calendar.add(Calendar.DAY_OF_MONTH, 6);
            Date futureDate = calendar.getTime();
            String dateRange = dateFormat.format(currentDate) + " - " + dateFormat.format(futureDate);
            date = dateRange;
        } else if (packageType.equals("Monthly Pass")) {
            // Add 29 days for Monthly Pass
            calendar.add(Calendar.DAY_OF_MONTH, 29);
            Date futureDate = calendar.getTime();
            String dateRange = dateFormat.format(currentDate) + " - " + dateFormat.format(futureDate);
            date = dateRange;
        } else
            date = dateFormat.format(currentDate);
    }
    
    public void calculatePrice() {
        String[] places = {"Padang Besar", "Bukit Ketri", "Arau", "Kodiang", "Anak Bukit", "Alor Setar", "Kobah", "Gurun", "Sungai Petani", "Tasek Gelugor", "Bukit Mertajam", "Bukit Tengah", "Butterworth", "Simpang Ampat", "Nibong Tebal", "Parit Buntar", "Bagan Serai", "Kamunting", "Taiping", "Padang Rengas"};    

        double[][] prices = {
            {0.0, 2.10, 3.20, 3.70, 5.20, 5.70, 6.80, 7.90, 9.30, 10.40, 10.70, 10.90, 11.40, 11.20, 12.10, 12.40, 13.20, 15.60, 15.90, 17.20}, // Padang Besar
            {2.10, 0.0, 1.10, 1.90, 4.10, 4.80, 5.60, 6.80, 8.10, 9.20, 9.50, 9.70, 10.20, 10.00, 10.90, 11.20, 12.00, 14.40, 14.80, 16.00}, // Bukit Ketri
            {3.20, 1.10, 0.0, 1.00, 3.30, 3.90, 5.00, 6.10, 7.40, 8.60, 8.80, 9.10, 9.50, 9.40, 10.20, 10.50, 11.30, 13.70, 14.10, 15.40}, // Arau
            {3.70, 1.90, 1.00, 0.0, 2.50, 3.30, 4.80, 5.60, 6.90, 8.10, 8.30, 8.60, 9.10, 8.90, 9.70, 10.00, 10.90, 13.30, 13.60, 14.90}, // Kodiang
            {5.20, 4.10, 3.30, 2.50, 0.0, 1.00, 2.80, 4.40, 5.50, 6.70, 6.90, 7.10, 7.60, 7.40, 8.30, 8.60, 9.40, 11.80, 12.20, 13.40}, // Anak Bukit
            {5.70, 4.80, 3.90, 3.30, 1.00, 0.0, 1.90, 3.90, 5.00, 6.20, 6.40, 6.70, 7.10, 7.00, 7.80, 8.10, 8.90, 11.30, 11.70, 13.00}, // Alor Setar
            {6.80, 5.60, 5.00, 4.80, 2.80, 1.90, 0.0, 1.90, 4.20, 5.10, 5.30, 5.50, 6.00, 5.80, 6.70, 7.00, 7.80, 10.20, 10.60, 11.80}, // Kobah
            {7.90, 6.80, 6.10, 5.60, 4.40, 3.90, 1.90, 0.0, 2.30, 4.00, 4.30, 4.70, 4.90, 4.70, 5.60, 5.90, 6.70, 9.10, 9.40, 10.70}, // Gurun
            {9.30, 8.10, 7.40, 6.90, 5.50, 5.00, 4.20, 2.30, 0.0, 2.00, 2.40, 2.80, 3.60, 3.30, 4.50, 4.80, 5.40, 7.80, 8.10, 9.40}, // Sungai Petani
            {10.40, 9.20, 8.60, 8.10, 6.70, 6.20, 5.10, 4.00, 2.00, 0.0, 1.00, 1.00, 1.60, 1.30, 2.80, 3.30, 4.40, 6.60, 6.90, 8.20}, // Tasek Gelugor
            {10.70, 9.50, 8.80, 8.30, 6.90, 6.40, 5.30, 4.30, 2.40, 1.00, 0.0, 1.00, 1.20, 1.00, 2.40, 2.90, 4.10, 6.40, 6.70, 8.00}, // Bukit Mertajam
            {10.90, 9.70, 9.10, 8.60, 7.10, 6.70, 5.50, 4.70, 2.00, 1.00, 1.00, 0.0, 1.00, 1.40, 2.90, 3.20, 4.50, 6.60, 7.00, 8.30}, // Bukit Tengah
            {11.40, 10.20, 9.50, 9.10, 7.60, 7.10, 6.00, 4.90, 3.60, 1.60, 1.20, 1.00, 0.0, 2.20, 3.70, 3.90, 5.00, 7.10, 7.50, 8.70}, // Butterworth
            {11.20, 10.00, 9.40, 8.90, 7.40, 7.00, 5.80, 4.70, 3.30, 1.30, 1.00, 1.40, 2.20, 0.0, 1.40, 2.00, 3.40, 5.80, 6.20, 7.40}, // Simpang Ampat
            {12.10, 10.90, 10.20, 9.70, 8.30, 7.80, 6.70, 5.60, 4.50, 2.80, 2.40, 2.90, 3.70, 1.40, 0.0, 1.00, 1.90, 5.00, 5.30, 6.60}, // Nibong Tebal
            {12.40, 11.20, 10.50, 10.00, 8.60, 8.10, 7.00, 5.90, 4.80, 3.30, 2.90, 3.20, 3.90, 2.00, 1.00, 0.0, 1.40, 5.00, 5.00, 6.30}, // Parit Buntar
            {13.20, 12.00, 11.30, 10.90, 9.40, 8.90, 7.80, 6.70, 5.40, 4.40, 4.10, 4.50, 5.00, 3.40, 1.90, 1.40, 0.0, 3.80, 4.40, 5.50}, // Bagan Serai
            {15.60, 14.40, 13.70, 13.30, 11.80, 11.30, 10.20, 9.10, 7.80, 6.60, 6.40, 6.60, 7.10, 5.80, 5.00, 5.00, 3.80, 0.0, 1.00, 2.80}, // Kamunting
            {15.90, 14.80, 14.10, 13.60, 12.20, 11.70, 10.60, 9.40, 8.10, 6.90, 6.70, 7.00, 7.50, 6.20, 5.30, 5.00, 4.40, 1.00, 0.0, 2.20}, // Taiping
            {17.20, 16.00, 15.40, 14.90, 13.40, 13.00, 11.80, 10.70, 9.40, 8.20, 8.00, 8.30, 8.70, 7.40, 6.60, 6.30, 5.50, 2.80, 2.20, 0.0}  // Padang Rengas
        };

        for (int i = 0; i < places.length; i++) {
            if (origin.equals(places[i])) {
                for (int j = 0; j < places.length; j++) {
                    if (destination.equals(places[j])) {
                        price = prices[i][j];
                        break;
                    }
                }
                break;
            }
        }
        
        if(packageType.equals("Return Journey"))
            totalPrice =  price * 2;
        else if(packageType.equals("Weekly Pass"))
            totalPrice = price * 10;
        else if(packageType.equals("Monthly Pass"))
            totalPrice = (price * 10) * 4;
        else
            totalPrice = price;
        
        if(category.equals("Student"))
            totalPrice *= 0.9;
        else if(category.equals("Person with Disabilities"))
            totalPrice *= 0.85;
        else if(category.equals("Senior Citizen"))
            totalPrice *= 0.80;
        else
            totalPrice *= 1.0;
    }
    
    public String toString() {
        return  "Name: " + name + "\n" +
                "IC Number: " + icNumber + "\n" +
                "Gender: " + gender + "\n" +
                "Age: " + age + "\n" +
                "Origin: " + origin + "\n" +
                "Destination: " + destination + "\n" +
                "Date: " + date + "\n" +
                "Package Type: " + packageType + "\n" +
                "Category: " + category + "\n" +
                "Total Price: RM " + String.format("%.2f", totalPrice);
    }
}