package koschei.models;

import org.springframework.stereotype.Component;

@Component
public class Egg6 {

    private final Needle7 needle;

    public Egg6(Needle7 needle) {
        this.needle = needle;
    }

    public String getDeathPath() {
        return "в утке — яйцо, " + needle.getDeathPath();
    }
}
