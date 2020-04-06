package by.academy.HomeWork3.task1;

public class Car extends ACar implements ICar {

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
