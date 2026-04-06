import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
 
    @Bean(name="helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }
    // бин Cat с prototype scope
    @Bean(name="cat")
    @Scope("prototype") // каждый запрос → новый объект
    public Cat getCat() {
        return new Cat();
    }
}

