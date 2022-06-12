package coders.azerb.taskUser;

import coders.azerb.taskUser.dao.model.User;
import coders.azerb.taskUser.dao.repository.UserRepository;

import java.util.Scanner;

public class ConsoleApplication {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        String input = "";

        while (true) {
            String menu = "1.Login\n2.Sign up\n3.Exit\n\n" +
                    "Please choose one!";
            System.out.println(menu);
            input = new Scanner(System.in).nextLine();

            if (input.equalsIgnoreCase("login") || input.equals("1")) {
                System.out.print("Username: ");
                String username = sc.next();
                System.out.print("password: ");
                String password = sc.next();

                User[] users = UserRepository.users;

                for (int i=0;i<users.length;i++) {
                    User user=users[i];
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                            System.out.printf("Welcome %s %s\n\n", user.getName(), user.getSurname());
                            userWork(user,i);
                            break;
                    }
                    else{
                        System.out.println("Wrong username and password");
                    }
                }

            } else if (input.equalsIgnoreCase("sign up") || input.equals("2")) {
                System.out.print("name: ");
                String name = sc.next();
                System.out.print("surname: ");
                String surname = sc.next();
                System.out.print("username: ");
                String username = sc.next();
                System.out.print("password: ");
                String password = sc.next();
                System.out.print("age: ");
                short age = sc.nextShort();

                User user = new User(name, surname, username, password, age);
                UserRepository.addUser(user);
            } else if (input.equals("3") || input.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Wrong input!Please try again");
            }

        }

    }
    public static void userWork(User user,int i){
        Scanner sc = new Scanner(System.in);
        String input2 = "";
        String menu2="1.Update Information\n2.Sign out\n3.Show Users";
        System.out.println(menu2);
        input2 = new Scanner(System.in).nextLine();
        if (input2.equalsIgnoreCase("Update Information") || input2.equals("1")){
            System.out.print("name: ");
            String name = sc.next();
            System.out.print("surname: ");
            String surname = sc.next();
            System.out.print("password: ");
            String password = sc.next();

            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);

            UserRepository.updateUser(user,i);
            System.out.println("Updated");

        }
        else if(input2.equalsIgnoreCase("Sign Out") || input2.equals("2")){
                user=null;
                UserRepository.deleteUser(user,i);
            System.out.println("Deleted");
        }
        else if(input2.equalsIgnoreCase("Show Users") || input2.equals("3")){
            UserRepository.showUser(user);
            }
    }

}

