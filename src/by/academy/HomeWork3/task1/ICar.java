package by.academy.HomeWork3.task1;

public interface ICar {

    boolean ride();

    boolean stop();

    void hasOwner(Human human);

    void parkInGarage(IGarage garage);

    boolean openDoor(IDoor door);

    void fillTank();



}
