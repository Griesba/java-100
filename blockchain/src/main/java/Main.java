public class Main {


    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain(4);
        blockChain.addBlock("www.google.com");
        blockChain.addBlock("www.youtube.com");
        blockChain.addBlock("www.polito.it");
        System.out.printf("Is blockchain valid ? "+ blockChain.isBlockChainValid());
        System.out.println(blockChain);
    }

}
