package interfaceFonctionnel;

import interfaceFonctionnel.Creator;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ContractParser {

    public <T> T parse(String contract, Creator creator) {
        String[] contractDetail = contract.split(",");
        return (T) creator.create(contractDetail[0], contractDetail[1]);
    }

    public <T> void doSomething(String contract, Operation operation) {
        try {
            T t = (T)operation.function(contract);
            operation.onSuccess(t);
        }catch (Exception e){
            operation.onError(e);
        }
    }

    public <T>void doSomething(String contract, Function<String, T> consumer1, Consumer<T> consumer2, Consumer<Exception> consumer3) {
        try {
            T t = consumer1.apply(contract);
            consumer2.accept(t);
        } catch (Exception e ){
            consumer3.accept(e);
        }
    }
}
