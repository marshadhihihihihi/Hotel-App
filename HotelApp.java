//scanner class
import java.util.Scanner;

//parent class
class Room {
	
	//attributes
    int roomNumber;
    String guestName;
    int numberOfNightsStayed;
	
	//constructor with parameters
    public Room (int roomNumber,String guestName,int numberOfNightsStayed) {

        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.numberOfNightsStayed = numberOfNightsStayed;
    }
	
	//default constructor without parameters
    public Room() {

        this.roomNumber = 0;
        this.guestName = "unknown";
        this.numberOfNightsStayed = 0;
    }
	
	//method to display room details
    public void displayRoomDetails () {

        System.out.println ("Room number is : "+roomNumber);
        System.out.println ("Guest name is : "+guestName);
        System.out.println ("Nights stayed : "+numberOfNightsStayed);
    }
	
	//method to calculate room cost
    public double calculateRoomCost() {

        return numberOfNightsStayed * 150.0;
    }

    public double calculateRoomCost(double discountPerNight) {

        return calculateRoomCost() - (calculateRoomCost() * discountPerNight / 100);
    }

}

//subclass
class StandardRoom extends Room {
	
	//subclass's attributes
    boolean isIncludeWiFi;

	//constructor with parameters
    public StandardRoom (int roomNumber, String guestName, int numberOfNightsStayed, boolean isIncludeWiFi) {
		
        super(roomNumber,guestName,numberOfNightsStayed); //accessing parent class's attributes
        this.isIncludeWiFi = isIncludeWiFi;
    }
	
	//default constructor without parameters
    public StandardRoom () {

        super(1,"Marshad",1);
        this.isIncludeWiFi = false;
    }

    @Override
    public double calculateRoomCost() {

        return numberOfNightsStayed * 100;
    }

    @Override
    public void displayRoomDetails() {

        super.displayRoomDetails(); // accessing method from parent class
        System.out.println ("This room provides WiFi : "+isIncludeWiFi);
        System.out.println ("Total cost is : "+calculateRoomCost());
    }

}

//subclass
class LuxurySuite extends Room {
	
	//subclass's attributes
    boolean hasBreakFast;
    boolean hasAirPortPickUp;

	//constructor with parameters
    public LuxurySuite(int roomNumber,String guestName,int numberOfNightsStayed,boolean hasBreakFast,boolean hasAirPortPickUp ) {

        super(roomNumber,guestName,numberOfNightsStayed);
        this.hasAirPortPickUp = hasAirPortPickUp;
        this.hasBreakFast = hasBreakFast;

    }
	
	//default constructor without parameters
    public LuxurySuite() {

        super(2,"Ahamed",3);
        this.hasAirPortPickUp = false;
        this.hasBreakFast = false;

    }

    @Override
    public double calculateRoomCost() {

        if (hasAirPortPickUp && hasBreakFast) { // if both are true 75$ added to total cost

            return (numberOfNightsStayed * 200) + 75;
        }

        return numberOfNightsStayed * 200;
    }

    @Override
    public void displayRoomDetails() {

        super.displayRoomDetails();
        System.out.println ("This room provides breakfast : "+hasBreakFast);
        System.out.println ("This room provides Airport pick up : "+hasAirPortPickUp);
        System.out.println ("Total cost is : "+calculateRoomCost());
    }

}

//main class
public class HotelApp { 
    public static  void main (String...args) {
		
		//scanner object
        Scanner sc = new Scanner (System.in);
		
		//object 1 used with default values
        StandardRoom room1 = new StandardRoom();
		
		//user input for object 2
        System.out.print("Enter room number : ");
        int roomNumber = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter guest's name : ");
        String guestName = sc.nextLine();

        System.out.print("Enter how many days has you stayed : ");
        int numberOfNightsStayed = sc.nextInt();

        System.out.print("has breakfast : ");
        boolean hasBreakFast = sc.nextBoolean();

        System.out.print("has Airport pick up : ");
        boolean hasAirPortPickUp = sc.nextBoolean();
		
		//object 2 used with parameters
        LuxurySuite room2 = new LuxurySuite(roomNumber,guestName,numberOfNightsStayed,hasBreakFast,hasAirPortPickUp);
	
		//printing room details(standard and luxury)
        System.out.println("Standard room details : ");
        room1.displayRoomDetails();
        System.out.println();

        System.out.println("Luxury suite details : ");
        room2.displayRoomDetails();

    }

}
