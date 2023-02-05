package leretvil.cleancode.loanpattern.dirty;

import leretvil.cleancode.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.stream.Stream;

interface OrderRepo extends JpaRepository<Order, Long> {
    Stream<Order> findByActiveTrue();
}

class OrderExport {
    private final static Logger LOG = LoggerFactory.getLogger(OrderExport.class);

    private OrderRepo repo;

    public File exportFile(String fileName) throws IOException {

        File file = new File("export/" + fileName);
        try (Writer writer = new FileWriter(file)){
            writer.write("OrderId;Date\n");
            repo.findByActiveTrue().map(o -> o.getId() + ";" + o.getCreationDate())
                    .forEach(str -> { // the method forEach accept a consumer as parameter and a consumer doesn't throw exception
                        try {
                            writer.write(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            return file;
        } catch (Exception e) {
            LOG.debug("Coucou !", e); // TERREUR
            throw e;
        }
    }
}