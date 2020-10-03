import org.junit.Test;

public class BlockManagerTest {

    @Test
    public void test1() {

        Block block = new BlockBuilder(1)
                .withPreviousHash("asdfgg")
                .withData("200")
                .build();

        String cyferBlock = BlockManager.calculateHash(block);
        System.out.println("-> "+cyferBlock);
    }
}