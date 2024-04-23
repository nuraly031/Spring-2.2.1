package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User a = new User("User1", "Lastname1", "user1@mail.ru");
      User b = new User("User2", "Lastname2", "user2@mail.ru");
      User c = new User("User3", "Lastname3", "user3@mail.ru");
      User f = new User("User4", "Lastname4", "user4@mail.ru");

      userService.add(a);
      userService.add(b);
      userService.add(c);
      userService.add(f);

      CarService carService = context.getBean(CarService.class);
      Car car1 = new Car(a, "Mers",111);
      Car car2 = new Car(b, "BMW",222);
      Car car3 = new Car(c, "Audi",333);
      Car car4 = new Car(f, "WW",444);

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = "+ user.getCar().getModel());
         System.out.println("Car number = "+ user.getCar().getSeriosNumber());
         System.out.println();
      }

      context.close();
   }
}