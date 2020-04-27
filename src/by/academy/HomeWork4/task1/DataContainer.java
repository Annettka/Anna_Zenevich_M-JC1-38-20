package by.academy.HomeWork4.task1;

import java.util.*;

public class DataContainer<E> {
    private E[] data;

    public E[] getData() {
        return data;
    }

    public DataContainer(E[] data) {
        this.data = data;
    }

    public void add(E item) {
        for (int i = 0; i <= this.data.length; i++) {
            if (i == this.data.length) {
                this.data = Arrays.copyOf(this.data, this.data.length + 1);
            }
            if (this.data[i] == null) {
                this.data[i] = item;
                break;
            }
        }
    }

    public static <E> void sort(DataContainer<E> data, Comparator<E> compar) {
        boolean unsorted = true;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < data.getData().length - 1; i++) {
                if (compar.compare(data.getData()[i], data.getData()[i + 1]) == 1) {
                    E temp = data.getData()[i];
                    data.getData()[i] = data.getData()[i + 1];
                    data.getData()[i + 1] = temp;
                    unsorted = true;
                }
            }
        }
    }

    void delete(int index) {
        if (index >= 0 || index < data.length - 1) {
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            data = Arrays.copyOf(data, data.length - 1);
        } else {
            System.err.println("Index not found");
        }
    }

    void delete(E item) {
        int ind = -1;
        for (int i = 0; i < data.length - 1; i++) {
            if (item.equals(data[i])) {
                ind = i;
            }
        }
        if ((ind > -1)) {
            delete(ind);
        } else {
            System.err.println("Element not found");
        }
    }


}
