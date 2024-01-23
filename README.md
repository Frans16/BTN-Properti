# BTN-Properti
Automation ini digunakan untuk menghitung harga properti maksimal dengan memasukkan penghasilan, cicilan, dan jangka waktu untuk mengetahui harga properti ideal untuk anda.

## Dependency
Dependencies yang digunakan di dalam project ini adalah:
* junit 			: versi 4.13.2
* cucumber-jvm-deps		: versi 1.0.6
* cucumber-junit		: versi 7.15.0
* cucumber-java			: versi 7.15.0
* poi				: versi 5.2.5
* poi-ooxml			: versi 5.2.5
* selenium-java			: versi 4.16.1
* selenium-chrome-driver	: versi 4.16.1

## Packages
      * src\main\java\org\btn\actions    : berisi seluruh function yang akan di jalankan di dalam scenario
      * src\main\java\org\btn\locators   : berisi seluruh element/locator yang digunakan
      * src\main\java\org\btn\util       : berisi pendefenisian webdriver serta browser yang digunakan
      * src\test\java\org\btn\definitions: berisi implementasi dari scenario yang telah di define
      * src\test\java\org\btn\runner     : berisi runner class untuk menjalakan automation
      * src\test\java\driver             : berisi webdriver yang digunakan
      * src\test\java\resource           : berisi scenario yang akan dijalankan
      * src\test\testData                : berisi test data


## Scenario
Terdapat 2 scenario yang disedikan yaitu:
      * positive case
      * negative case
Positive case yaitu menjalankan automation dengan menggunakan data penghasilan lebih besar daripada pengeluaran. Sedangkan untuk negative case menggunakan data pengeluaran lebih besar daripada penghasilan

## Feature File
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

## Test Result
PASS

