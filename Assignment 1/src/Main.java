public class Main {

    public static void main(String[] args) {
        CreateLaunches newLaunch = new CreateLaunches();

        //get an object of Circle and call its draw method.
        SpaceFlight newFlight = newLaunch.getLaunch("MannedFlight");

        //call draw method of Circle
        newFlight.spaceX();

        //get an object of Rectangle and call its draw method.
        SpaceFlight newFlight2 = newLaunch.getLaunch("UnmannedFlight");

        //call draw method of Rectangle
        newFlight2.spaceX();

        //get an object of Square and call its draw method.
        SpaceFlight newFlight3 = newLaunch.getLaunch("satelliteLaunch");

        //call draw method of square
        newFlight3.spaceX();
    }
}
