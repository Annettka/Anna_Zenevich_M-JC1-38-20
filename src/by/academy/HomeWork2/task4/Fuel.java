package by.academy.HomeWork2.task4;

public class Fuel implements IFuel {
    EFuel fuel;
    @Override
    public EFuel getTypeOfFuel(EFuel fuel) {
        this.fuel = fuel;
        return fuel;
    }

    @Override
    public void comeToEnd() {

    }

    public void getState() {

    }
}
