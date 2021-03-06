package coders.azerb.taskUser.dao.model;

import java.util.Arrays;
import java.util.Objects;


public class User {

    private String name;
    private String surname;
    private String username;
    private String password;
    private short age;

    public User(){

    }

    public User(String name,String surname,String username, String password,short age){
            this.name = name;
            this.surname = surname;
            this.username = username;
            this.password = password;
            this.age = age;
    }

    public String getName(){
            return this.name;
    }

    public void setName(String name){
            this.name = name;
    }

    public String getSurname() {
            return surname;
    }

    public void setSurname(String surname) {
            this.surname = surname;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public short getAge() {
            return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name) && surname.equals(user.surname) && username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, username, password, age);
    }

    @Override
    public String toString() {
        return String.format("User{name=%s, surname=%s, username=%s,password=%s,age=%d}",
                name,surname,username,password,age);
    }
}
