package org.btn.definitions;

import java.io.IOException;

import org.btn.actions.HitungHargaAction;
import org.btn.util.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HitungHargaDefinitions {
	
	HitungHargaAction hitungHargaAct = new HitungHargaAction();
	
	@Given("User is on hitung harga site")
	public void user_is_on_hitung_harga_site() {
	    HelperClass.openPage("https://www.btnproperti.co.id/tools/hitung-harga-properti");
	}
	
	@When("User input hitung harga form with valid data")
	public void user_input_hitung_harga_form_with_valid_data() throws IOException, InterruptedException {
	    hitungHargaAct.inputValidHitungHargaForm();;
	}
	
	@When("User input hitung harga form with invalid data")
	public void user_input_hitung_harga_form_with_invalid_data() throws IOException, InterruptedException {
	    hitungHargaAct.inputInvalidHitungHargaForm();
	}

	@Then("User has successfully calculated the property price")
	public void user_has_successfully_calculated_the_property_price() {
		;
	}

}
