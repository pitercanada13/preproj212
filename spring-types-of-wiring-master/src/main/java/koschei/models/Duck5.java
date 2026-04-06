package koschei.models;

import org.springframework.stereotype.Component;

@Component
public class Duck5 {

    private final Egg6 egg;

    public Duck5(Egg6 egg) {
        this.egg = egg;
    }

    public String getDeathPath() {
        return "в зайце — утка, " + egg.getDeathPath();
    }
}
