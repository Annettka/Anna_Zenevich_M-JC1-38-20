package by.academy.HomeWork5.task1;

public class EasySearch implements ISearchEngine {

    @Override
    public int search(String[] strings, String s) {
        int counter = 0;
        for (String str : strings) {
            if (str.indexOf(s) >= 0 && str.length() == s.length()) {
                counter++;
            }
        }
        return counter;
    }
}

