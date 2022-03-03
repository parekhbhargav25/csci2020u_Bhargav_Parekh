public class CreateLaunches {
    //use getShape method to get object of type shape
    public SpaceFlight getLaunch(String launchType){
        if(launchType == null){
            return null;
        }
        if(launchType.equalsIgnoreCase("MannedFlight")){
            return new MannedFlight();

        } else if(launchType.equalsIgnoreCase("UnmannedFlight")){
            return new UnmannedFlight();

        } else if(launchType.equalsIgnoreCase("satelliteLaunch")){
            return new satelliteLaunch();
        }

        return null;
    }
}
