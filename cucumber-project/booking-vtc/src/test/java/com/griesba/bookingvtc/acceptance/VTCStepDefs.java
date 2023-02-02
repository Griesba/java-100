package com.griesba.bookingvtc.acceptance;

import com.griesba.bookingvtc.adapter.InMemoryVtcRepositoryImpl;
import com.griesba.bookingvtc.domain.Vtc;
import com.griesba.bookingvtc.domain.repository.VtcRepository;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VTCStepDefs {

    List<Map<String,String>> dataMaps;

    VtcRepository vtcRepository;

    @Given("des VTC existent:")
    public void des_vtc_existent(io.cucumber.datatable.DataTable dataTable) {
        vtcRepository = new InMemoryVtcRepositoryImpl();
        dataMaps = dataTable.asMaps(String.class, String.class);
        dataMaps.forEach(dataMap -> {
            Vtc vtc = new Vtc(dataMap.get("id"), dataMap.get("firstName"), dataMap.get("lastName"));
            vtcRepository.add(vtc);
            assertTrue(vtcRepository.all().contains(vtc));
        });
    }
}
