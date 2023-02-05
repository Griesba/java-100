package leretvil.cleancode.loanpattern.clean;

import leretvil.cleancode.model.Order;
import org.jooq.lambda.Unchecked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*
- easy to test
- use consumer instead of "extends" : another way of doing it was to make FileExport abstract with an abstract
method that UserExport and OrderExport will implement accordingly
- close stream
 */

interface OrderRepo extends JpaRepository<Order, Long> {
    Stream<Order> findByActiveTrue();
}

class  FileExport {
    private final static Logger LOG = LoggerFactory.getLogger(FileExport.class);

    private OrderRepo repo;

    public File exportFile(String fileName, Consumer<Writer> contentWriter) throws IOException {

        File file = new File("export/" + fileName);
        try (Writer writer = new FileWriter(file)){
            contentWriter.accept(writer);
            return file;
        } catch (IOException e) {
            LOG.debug("...");
            throw e;
        }
    }

    public static void main(String[] args) throws IOException {
        FileExport fileExport = new FileExport();
        OrderExportWriter orderExportWriter = new OrderExportWriter();
        UserExporterWriter userExporterWriter = new UserExporterWriter();
        fileExport.exportFile("order.txt", Unchecked.consumer(orderExportWriter::writeContent));
        fileExport.exportFile("user.txt", Unchecked.consumer(userExporterWriter::writeContent));
    }

}


class OrderExportWriter extends FileExport {
    private OrderRepo repo;

    protected void writeContent(Writer writer) throws IOException {
        writer.write("OrderId;Date\n");
        try (Stream<Order> stream = repo.findByActiveTrue()) { // we close the stream
            stream.map(o -> o.getId() + ";" + o.getCreationDate())
                    .forEach(Unchecked.consumer(writer::write));
        }

    }
}

class UserExporterWriter  {

    protected void writeContent(Writer writer) throws IOException {
        // todo
    }
}