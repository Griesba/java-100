package com.griesba.bookingvtc.acceptance;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingStepDefs {
    @When("je tente de réserver le VTC {string} de {string} à {string}")
    public void je_tente_de_réserver_le_vtc_de_à(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("la réservation est effective")
    public void la_réservation_est_effective() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("la réservation n'est pas effective")
    public void la_réservation_n_est_pas_effective() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
