import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BlockManager {

    public static String calculateHash(Block block) {
        if (block == null) {
            return null;
        }
        MessageDigest messageDigest = null ;

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        String text = block.toString();
        final byte bytes[] = messageDigest.digest(text.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b: bytes) {
            String hexString = Integer.toHexString(0xff & b);
            if (hexString.length() == 1){
                stringBuilder.append("0");
            }
            stringBuilder.append(hexString);
        }
        return stringBuilder.toString();
    }

    public static void mineBlock(Block block, int difficulty) {
        if (!block.getHash().substring(0, difficulty).equals(Utils.zero(difficulty))) {
            block.setNonce(block.getNonce() + 1);
            block.setHash(calculateHash(block));
        }
    }
}
