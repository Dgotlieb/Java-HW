import jdk.jshell.spi.ExecutionControl;

public class CarFactory {
    public static exrcesises.class8.Drivable getCar(String carType) throws ExecutionControl.NotImplementedException {
        switch (carType){
            case "BMW":
                return new exrcesises.class8.BMW();
            case "Porsche":
                return new exrcesises.class8.Porsche();
            case "Fiat":
                return new exrcesises.class8.Fiat();
            default:
                throw new ExecutionControl.NotImplementedException
                        ("No such car type: " + carType);
        }
    }
}
