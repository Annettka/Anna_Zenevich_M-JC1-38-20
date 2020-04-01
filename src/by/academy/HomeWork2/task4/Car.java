package by.academy.HomeWork2.task4;

public class Car implements ICar {

    public Car() {
    }

    @Override
    public boolean ride() {
        Engine engine = new Engine();
        return engine.getState();

    }

    @Override
    public boolean stop() {
        return false;
    }
    public void haveEngine(Engine engine){

    }

}
