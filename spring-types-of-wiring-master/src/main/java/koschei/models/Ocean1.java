package koschei.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ocean1 {

    private final Island2 island;

    @Autowired
    public Ocean1(Island2 island) {
        this.island = island;
    }

    // Новый метод для цепочки
    public String getDeathPath() {
        return island.getDeathPath(); // передаем дальше цепочку
    }
}