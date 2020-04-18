package by.academy.HomeWork3.task1;

public class Fuel implements IFuel {
    EFuel fuel;
    @Override
    public EFuel getTypeOfFuel(EFuel fuel) {
        this.fuel = fuel;
        return fuel;
    }

    @Override
    public String outputMessage() {
        return null;
    }

    public void getState() {

    }
}
