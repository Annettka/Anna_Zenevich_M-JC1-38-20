package by.academy.HomeWork2.task4;

public class Human implements IHuman{

    private int key;

    @Override
    public void ownCar(ICar car) {

    }

    @Override
    public void ownGarage(IGarage garage) {

    }

    @Override
    public void hasKey(int key) {

    }

    @Override
    public boolean openDoor(IDoor door) {
        return false;
    }

    @Override
    public void tax() {

    }
    public int getPassenger(int numOfPassangers){
        return numOfPassangers;
    }

}
