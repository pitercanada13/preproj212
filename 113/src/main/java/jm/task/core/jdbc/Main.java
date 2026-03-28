package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;



public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        // 1. Создание таблицы
        userService.createUsersTable();

        // 2. Добавление пользователей
        userService.saveUser("Иван", "Иванов", (byte) 25);
        //System.out.println("User с именем – Иван добавлен в базу данных");

        userService.saveUser("Петр", "Петров", (byte) 30);
       // System.out.println("User с именем – Петр добавлен в базу данных");

        userService.saveUser("Анна", "Смирнова", (byte) 22);
        //System.out.println("User с именем – Анна добавлен в базу данных");

        userService.saveUser("Олег", "Сидоров", (byte) 28);
        //System.out.println("User с именем – Олег добавлен в базу данных");

        // 3. Получение всех пользователей
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // 4. Очистка таблицы
        userService.cleanUsersTable();

        // 5. Удаление таблицы
        userService.dropUsersTable();
    }
}









