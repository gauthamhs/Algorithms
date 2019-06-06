package algorithms.datastructures.design.parkinglot;

//For simplicity, we are not defining getter and setter functions. The reader can
//assume that all class attributes are private and accessed through their respective
//public getter methods and modified only through their public methods function.

public abstract class Account {
private String userName;
private String password;
private AccountStatus status;
private Person person;

public boolean resetPassword();
}

 class Admin extends Account {
public boolean addParkingFloor(ParkingFloor floor);
public boolean addParkingSpot(String floorName, ParkingSpot spot);
public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);

public boolean addEntrancePanel(EntrancePanel entrancePanel);
public boolean addExitPanel(ExitPanel exitPanel);
}

public class ParkingAttendant extends Account {
public boolean processTicket(string TicketNumber);
}
