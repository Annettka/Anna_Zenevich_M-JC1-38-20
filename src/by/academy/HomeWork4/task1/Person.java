package by.academy.HomeWork4.task1;

import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat.*;
import java.util.Date;

public class Person {

    SimpleDateFormat dateF = new SimpleDateFormat("dd MM YYYY");
    private String nick;
    private String password;
   // private String registration;
    Date registration;

    public Person(String nick, String password, Date registration) {
        this.nick = nick;
        this.password = password;
        this.registration = registration;
    }

    public Date getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nick=" + nick +
                ", password=" + password +
                ", registration=" + dateF.format(registration) +
                '}' + '\n';
    }
}
