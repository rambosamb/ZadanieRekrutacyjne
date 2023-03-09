
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<Block> blocks;

    Wall(List<Block> list) {

        this.blocks = list;

    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            String blockColor = block.getColor();
            if (blockColor != null && blockColor.equals(color)) {
                return Optional.of(block);
            }
            if (blockColor == null && color == null) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> newBlockList = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial() != null && block.getMaterial().equals(material)) {
                newBlockList.add(block);
            }
            if (block.getMaterial() == null && material == null) {
                newBlockList.add(block);
            }
        }
        return newBlockList;
    }
    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public List<Block> getBlocks() {
        List<Block> copy = new ArrayList<>(blocks);
        return copy;
    }
}


