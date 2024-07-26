package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarServiceImpl;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarServiceImpl carServiceImp = context.getBean(CarServiceImpl.class);
        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        carServiceImp.add(new Car("BMW", 4));
        carServiceImp.add(new Car("Audi", 5));
        carServiceImp.add(new Car("Mercedes", 6));
        carServiceImp.add(new Car("Honda", 7));
        List<Car> cars = carServiceImp.listCars();
        List<User> users = userService.listUsers();
        for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println(user.toString());
            System.out.println();
        }
        for (Car car : cars) {
//         System.out.println("Id = "+car.getId());
//         System.out.println("Model = "+car.getModel());
//         System.out.println("Series = "+car.getSeries());
        }
        System.out.println(userService.findUserByCarModelAndSeries("BMW", 4));

        context.close();
    }
}
