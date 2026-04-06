package koschei;

import koschei.models.Ocean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KoscheiTheDeathless {

    private final Ocean1 ocean;

    @Autowired
    public KoscheiTheDeathless(Ocean1 ocean) {
        this.ocean = ocean;
    }

    public String getRulesByDeth() {
        // Здесь вызываем getDeathPath(), чтобы получить всю цепочку
        return "На море на океане есть остров, " + ocean.getDeathPath();
    }
}