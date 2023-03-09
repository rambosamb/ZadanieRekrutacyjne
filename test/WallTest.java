
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
    }

    @Test
    void countListTest() {
        int listCounter = wall.count();
        Assertions.assertEquals(4, listCounter);
    }

    @Test
    void getBlocksTest() {
        List<Block> list = wall.getBlocks();
        Assertions.assertEquals(4, list.size());
        list.clear();
        List<Block> list2 = wall.getBlocks();
        Assertions.assertEquals(4, list2.size());
    }
}