package com.griesba.bookingvtc.acceptance;


import com.griesba.bookingvtc.adapter.InMemoryCustomerRepository;
import com.griesba.bookingvtc.domain.Customer;
import com.griesba.bookingvtc.domain.repository.CustomerRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class CustomerStepDefs {

    @Mock
    CustomerRepository customerRepository;
    AutoCloseable closeable;
    List<Map<String,String>> dataMaps;

    @BeforeEach
    public void setUp() {
         closeable = MockitoAnnotations.openMocks(this);
    }

    @Given("des clients existent:")
    public void des_clients_existent(io.cucumber.datatable.DataTable dataTable) {
        customerRepository = new InMemoryCustomerRepository();
        dataMaps = dataTable.asMaps(String.class,String.class);
        dataMaps.forEach(dataMap -> {
            Customer customer = new Customer(dataMap.get("id"), dataMap.get("firstName"), dataMap.get("lastName"));
            customerRepository.add(customer);
            assertTrue(customerRepository.all().contains(customer));
        });
    }

    @Then("et une alerte pour identification du client impossible se lève")
    public void et_une_alerte_pour_identification_du_client_impossible_se_lève() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
}
