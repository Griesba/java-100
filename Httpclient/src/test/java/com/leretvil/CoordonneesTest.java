package com.leretvil;

import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;


public class CoordonneesTest {

    HttpClient client;

    @Before
    public void beforeTest() {
        client = new HttpClient();
    }
    @Test
    public void test() {
        Coordonnees coordonnees = new Coordonnees("00", "11");
        String jsonCoordonnees = new GsonBuilder().setPrettyPrinting().create().toJson(coordonnees, Coordonnees.class);
        assertThat(coordonnees.toString(), is(jsonCoordonnees));
    }

    @Test
    public void should_send_basket_to_hypemedia_api() {
        Basket basket = new Basket("test");
        int code = client.sendRequest(basket.toString());
        assertThat(code, not(-1));
    }
}
