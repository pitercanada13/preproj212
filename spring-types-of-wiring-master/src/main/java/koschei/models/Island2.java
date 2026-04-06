package koschei.models;

public class Island2 {

    private final Wood3 wood;

    public Island2(Wood3 wood) {
        this.wood = wood;
    }

    public String getDeathPath() {
        return "на том острове дуб стоит, " + wood.getDeathPath();
    }
}
