import java.time.Instant;

public class Block {

    private int index;
    private Instant timestamp;
    private String previousHash;
    private String hash;
    private String data;
    private int nonce;

    public Block(int index, Instant timestamp, String previousHash, String data) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.data = data;
        this.nonce = 0;
        this.hash = BlockManager.calculateHash(this);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String str() {
        return index + timestamp.toString() + previousHash + data;
    }

    @Override
    public String toString() {
        return "Block{" +
                "index='" + index + '\'' +
                ", timestamp=" + timestamp +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                ", data='" + data + '\'' +
                '}';
    }


}
