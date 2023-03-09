
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class WallTest {
    private Wall wall;

    @BeforeEach
    void beforeEach() {
        List<Block> list = new ArrayList<>();
        list.add(new BlockElements("Green", "Steel"));
        list.add(new BlockElements("Brown", "Wood"));
        list.add(new BlockElements("Yellow", null));
        list.add(new BlockElements(null, "Wood"));
        list.add(new Brick("Black", "Plastic", 12));
        list.add(new Brick("Black", "Plastic", 5));
        list.add(new Brick("Black", "Aluminum", 4));
        list.add(new BlockElements("Yellow", "Aluminum"));
        list.add(new BlockElements("Yellow", "Aluminum"));

        wall = new Wall(list);
    }

    @Test
    void findBlockByColorTest() {
        Optional<Block> result = wall.findBlockByColor("Green");
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Green", result.get().getColor());

        Optional<Block> result2 = wall.findBlockByColor(null);
        Assertions.assertTrue(result2.isPresent());
        Assertions.assertNull(result2.get().getColor());

        Optional<Block> result3 = wall.findBlockByColor("Red");
        Assertions.assertTrue(result3.isEmpty());

        Optional<Block> result4 = wall.findBlockByColor("Black");
        Assertions.assertTrue(result4.isPresent());
        Assertions.assertEquals("Black", result4.get().getColor());

    }

    @Test
    void findBlocksByMaterialTest() {
        List<Block> list = wall.findBlocksByMaterial("Wood");
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Wood", list.get(0).getMaterial());
        Assertions.assertEquals("Wood", list.get(1).getMaterial());

        List<Block> list2 = wall.findBlocksByMaterial(null);
        Assertions.assertEquals(1, list2.size());
        Assertions.assertNull(list2.get(0).getMaterial());

        List<Block> list3 = wall.findBlocksByMaterial("Dirt");
        Assertions.assertTrue(list3.isEmpty());

        List<Block> list4 = wall.findBlocksByMaterial("Plastic");
        Assertions.assertEquals(17, list4.size());

        List<Block> list5 = wall.findBlocksByMaterial("Aluminum");
        Assertions.assertEquals(6, list5.size());
    }

    @Test
    void countListTest() {
        int listCounter = wall.count();
        Assertions.assertEquals(27, listCounter);
    }

}