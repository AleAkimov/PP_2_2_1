package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.SqlRequest;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        userService.add(new Car("BMW", 4));
        userService.add(new Car("Audi", 5));
        userService.add(new Car("Mercedes", 6));
        userService.add(new Car("Honda", 7));
        List<Car> cars = userService.listCars();
        List<User> users = userService.listUsers();
        for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println(user.toString());
//         System.out.println();
        }
        for (Car car : cars) {
//         System.out.println("Id = "+car.getId());
//         System.out.println("Model = "+car.getModel());
//         System.out.println("Series = "+car.getSeries());
        }
        SqlRequest sqlRequest = context.getBean(SqlRequest.class);
        String model = "BMW";
        int sesies = 4;
        String find = sqlRequest.findUserByCarModelAndSeries(model, sesies);

        System.out.println(find);

        context.close();
    }
}
