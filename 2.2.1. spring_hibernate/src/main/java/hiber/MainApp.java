package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      CarService carService = context.getBean(CarService.class);
      Car car1 = new Car("Model1", 1);
      Car car2 = new Car("Model2", 2);
      Car car3 = new Car("Model3", 3);
      Car car4 = new Car("Model4", 4);
      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);
      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }
      System.out.println(userService.getUserByCar(car1).toString());
      System.out.println(userService.getUserByCar(car2).toString());
      System.out.println(userService.getUserByCar(car3).toString());
      System.out.println(userService.getUserByCar(car4).toString());

      context.close();
   }
}
