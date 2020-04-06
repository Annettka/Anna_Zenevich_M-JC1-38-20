package by.academy.HomeWork3.task1;

public interface ICar {

boolean ride();
boolean stop();

    void hasOwner(IHuman human);
    void parckedInGarage(IGarage garage);
    boolean openDoor(IDoor door);
    void tax();

}
