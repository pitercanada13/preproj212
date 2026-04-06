import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        HelloWorld bean =
//                (HelloWorld) applicationContext.getBean("helloworld");
//        System.out.println(bean.getMessage());
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем HelloWorld дважды
        HelloWorld hello1 = (HelloWorld) context.getBean("helloworld");
        HelloWorld hello2 = (HelloWorld) context.getBean("helloworld");
        System.out.println("HelloWorld same instance: " + (hello1 == hello2));
        // true — singleton

        // Получаем Cat дважды
        Cat cat1 = (Cat) context.getBean("cat");
        Cat cat2 = (Cat) context.getBean("cat");
        System.out.println("Cat same instance: " + (cat1 == cat2));
        // false — prototype

    }
}
