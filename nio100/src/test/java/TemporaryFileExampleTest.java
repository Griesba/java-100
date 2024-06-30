import interfaceFonctionnel.ContractParser;
import org.junit.jupiter.api.Test;


public class TemporaryFileExampleTest {

    @Test
    public void test () {
        ContractParser contractParser = new ContractParser();
        Contract contract = contractParser.parse("cillere, foyang", Contract::new);
        System.out.println("-> "+contract);

    }
}
