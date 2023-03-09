import java.util.ArrayList;
import java.util.List;

class Brick implements CompositeBlock {
    private final String color;
    private final String material;
    private final List<Block> list;


    Brick(String color, String material, int listSize) {
        this.color = color;
        this.material = material;
        list = new ArrayList<>(listSize);

        for (int i = 0; i < listSize; i++) {
            list.add(new Block() {
                @Override
                public String getColor() {
                    return color;
                }

                @Override
                public String getMaterial() {
                    return material;
                }

                @Override
                public int count() {
                    return 1;
                }
            });
        }


    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
    @Override
    public int count() {
        int count = 0;
        for (Block block : list) {
            count += block.count();
        }
        return count;
    }

    @Override
    public List<Block> getBlocks() {
        List<Block> copy = new ArrayList<>(list);
        return copy;
    }
}
