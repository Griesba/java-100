import interfaceFonctionnel.ContractParser;
import org.junit.Test;


public class TemporaryFileExempleTest {

    @Test
    public void test () {
        ContractParser contractParser = new ContractParser();
        Contract contract = contractParser.parse("cillere, foyang", Contract::new);
        System.out.println("-> "+contract);

    }
}
