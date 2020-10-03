
import java.time.Instant;

public class BlockBuilder {

    private int index;
    private String previousHash;
    private String data;

    public BlockBuilder (int index){
        this.index = index;
    }

    public BlockBuilder withPreviousHash(String previousHash){
        this.previousHash = previousHash;
        return this;
    }

    public BlockBuilder withData(String data) {
        this.data = data;
        return this;
    }

    public Block build() {
        return new Block(index, Instant.now(), previousHash, data);
    }
}
