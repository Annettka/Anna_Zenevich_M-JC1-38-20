package by.academy.HomeWork3.task1;

public class Car extends ACar implements ICar {

    public Car() {
    }

    @Override
    public boolean ride() {
        Engine engine = new Engine();
 //       engine.getStateOfFuel(Tank); ????????
        return true;

    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public void hasOwner(Human human) {

    }

    @Override
    public void parkInGarage(IGarage garage) {

    }

    @Override
    public boolean openDoor(IDoor door) {
        return false;
    }

    @Override
    public void fillTank() {

    }

    /*public void haveEngine(Engine engine){

    }*/

    void tax() {

    }

    public int getPassenger(int numOfPassangers){
        return numOfPassangers;
    }

}
