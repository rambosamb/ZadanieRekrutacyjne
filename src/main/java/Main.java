import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BlockElements element1 = new BlockElements("Green", "Steel");
        BlockElements element2 = new BlockElements("Green", "Wood");
        BlockElements element3 = new BlockElements("Green", "Steel");
        List<Block> list = new ArrayList<>();
        list.add(element1);
        list.add(element2);
        list.add(element3);
        Wall wall = new Wall(list);
        List<Block> list1 = wall.findBlocksByMaterial("Steel");
        List<Block> list2 = wall.findBlocksByMaterial("Wood");

        System.out.println(list1.size());
        System.out.println(list2.size());

        System.out.println(wall.findBlockByColor("Green"));
        System.out.println(wall.findBlockByColor("Green").isPresent());
        System.out.println(wall.findBlockByColor("Green"));
        List<Block> a = wall.findBlocksByMaterial("Steel");
        System.out.println(a.size());
        System.out.println(a.get(0).getColor());
        System.out.println(a.get(1).getColor());
    }
}
