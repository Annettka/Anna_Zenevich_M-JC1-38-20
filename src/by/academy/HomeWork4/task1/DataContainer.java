package by.academy.HomeWork4.task1;

import java.util.*;

public class DataContainer<E>{
    private E[] data;

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
        /*List <DataContainer<E>> coll = Arrays.asList(data);
        Collections.sort(coll, new Comparator<E> compar);

        coll.sort(compar.compare(o1, o2));
        data.sort(compar.compare(E o1, E o2));

*/

    }

    public void delete(int index) {
        remove(this.data[index]);
    }

    private void remove(E datum) {
    }

    public <E> void delete(E item) {

    }

    public E[] getData() {
        return data;
    }


}
