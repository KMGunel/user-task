package coders.azerb.taskUser.dao.repository;

import coders.azerb.taskUser.dao.model.User;

import java.util.Arrays;

public class UserRepository {

       public static User[] users = {};

    public static void addUser(User user){
        User[] newUsers = Arrays.copyOf(users,users.length+1);
        newUsers[users.length]=user;
        users=newUsers;
    }

    public static void updateUser(User user,int index){
        if (index<0 || index >=users.length) {
            System.out.println("User not found.");
        }
        else{
            users[index]=user;
            }

    }
    public static void deleteUser(User user,int index){
        if(index>=0 && index< users.length){
            User[] newUsers = new User[users.length-1];
            for (int i = 0,j=0; i < users.length; i++) {
                if(user != null)  newUsers[j++] = users[i];
            }
            users=newUsers;
        }
    }
    public static void showUser(User user){
        for (User value : users) {
            System.out.println(value.getUsername());
        }
    }

}
