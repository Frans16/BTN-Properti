Feature: BTN Hitung Harga Properti Maksimal

  @positiveCase
  Scenario: Hitung Harga Positive
    Given User is on hitung harga site
    When User input hitung harga form with valid data
    Then User has successfully calculated the property price
    
  @negativeCase
  Scenario: Hitung Harga Negative
    Given User is on hitung harga site
    When User input hitung harga form with invalid data
    Then User has successfully calculated the property price
