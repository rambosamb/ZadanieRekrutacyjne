
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
        return _findBlocksByMaterial(blocks, material);
    }


    private List<Block> _findBlocksByMaterial(List<Block> list, String material) {
        List<Block> newBlockList = new ArrayList<>();
        for (Block block : list) {
            if (block instanceof CompositeBlock) {
                newBlockList.addAll(_findBlocksByMaterial(((CompositeBlock) block).getBlocks(), material));
            } else {
                if (block.getMaterial() != null && block.getMaterial().equals(material)) {
                    newBlockList.add(block);
                }
                if (block.getMaterial() == null && material == null) {
                    newBlockList.add(block);
                }
            }

        }
        return newBlockList;
    }

    @Override
    public int count() {
        int count = 0;
        for (Block block : blocks) {
            count += block.count();
        }
        return count;
    }


}


