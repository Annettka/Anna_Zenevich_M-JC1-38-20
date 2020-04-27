package by.academy.HomeWork4.task1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {

    private String nick;
    private String password;
    LocalDate registration;

    public Person(String nick, String password, LocalDate registration) {
        this.nick = nick;
        this.password = password;
        this.registration = registration;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public String toString() {
        return "Person{" +
                "nick=" + nick +
                ", password=" + password +
                ", registration=" + registration.format(formatter) +
                '}' + '\n';
    }
}
