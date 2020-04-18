package by.academy.HomeWork5.task1;

public class ReadTextMain {
    public static void main(String[] args) {
        String filePath = "E:\\Курсы It-academy\\Java_базовый\\Война и мир.txt";

        String text = ReadAllBytes.readAllBytesJava7(filePath);
        String[] words = (text.toLowerCase().replaceAll("[-.?!)(,:;\"\n]", " ")).split(" ");

        EasySearch wordSearch = new EasySearch();
        /*for (String word : words) {
            System.out.println(word);
        }*/
        System.out.println(wordSearch.search(words,"война"));
        System.out.println(wordSearch.search(words,"мир"));
        System.out.println(wordSearch.search(words,"и"));
    }
}
