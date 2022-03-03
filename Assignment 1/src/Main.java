import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        CreateLaunches newLaunch = new CreateLaunches();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select 1 for Manned Flight");
        System.out.println("Select 2 for UnManned Flight");
        System.out.println("Select 3 for Satellite Launch");
        System.out.println("Select: ");
        String userName = myObj.nextLine();

        if (Integer.parseInt(userName) == 1) {
            SpaceFlight newFlight = newLaunch.getLaunch("MannedFlight");
            newFlight.spaceX();
        }
        else if (Integer.parseInt(userName) == 2) {
            SpaceFlight newFlight2 = newLaunch.getLaunch("UnmannedFlight");
            newFlight2.spaceX();
        }
        else if (Integer.parseInt(userName) == 3) {
            SpaceFlight newFlight3 = newLaunch.getLaunch("satelliteLaunch");
            newFlight3.spaceX();
        }
        else {
            System.out.println("Only input 1 or 2 or 3 PLEASE");
        }

    }
}
