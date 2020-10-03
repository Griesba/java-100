import java.time.Instant;
import java.util.LinkedList;

public class BlockChain {
    private int difficulty;
    private LinkedList<Block> blocks;

    public BlockChain(int difficulty) {
        this.difficulty = difficulty;
        blocks = new LinkedList<>();
        Block firstBlock = new Block(0, Instant.now(), null, "First block");
        BlockManager.mineBlock(firstBlock, difficulty);
        blocks.add(firstBlock);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Block newBlock(String data) {
        Block latestBlock = latestBlock();
        return new Block(latestBlock.getIndex() + 1, Instant.now(), latestBlock.getHash(), data);
    }

    public void addBlock(Block block) {
        if (block != null) {
            BlockManager.mineBlock(block, difficulty);
            blocks.add(block);
        }
    }

    public void addBlock(String data) {
        addBlock(newBlock(data));
    }

    public Block latestBlock() {
        return blocks.get(blocks.size() - 1);
    }

    private boolean isFirstBlockValid() {
        Block block = blocks.get(0);
        if (block.getIndex() != 0) {
            return false;
        }

        if (block.getPreviousHash() != null) {
            return false;
        }

        if (block.getHash() == null || !BlockManager.calculateHash(block).equals(block.getHash())) {
            return false;
        }

        return true;
    }

    public boolean isNewBlockValid(Block newBlock, Block previousBlock) {
        if (newBlock == null || previousBlock == null) {
            return false;
        }

        if (newBlock.getIndex() != (1 + previousBlock.getIndex())) {
            return false;
        }

        if (newBlock.getHash() == null || !(BlockManager.calculateHash(newBlock).equals(newBlock.getHash()))) {
            return false;
        }

        if (newBlock.getPreviousHash() == null || !(BlockManager.calculateHash(previousBlock).equals(newBlock.getPreviousHash()))) {
            return false;
        }
        return true;
    }

    public boolean isBlockChainValid() {
        if (!isFirstBlockValid()) {
            return false;
        }

        for (int i = 1; i < blocks.size(); i++) {
            if (!isNewBlockValid(blocks.get(i), blocks.get(i - 1))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Block block : blocks) {
            stringBuilder.append(block.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
