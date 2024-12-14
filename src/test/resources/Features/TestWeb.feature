@SmokeTests @WebTests
Feature: Search Flight Options

  Background:
    Given User opens Google Search
@TC1
  Scenario: Verify flight options search from Cairo to Marsa Alam

    When enters the query "Flights from Cairo to Marsa Alam" in the search bar
    And click on search button
    Then the search results should display is "Cairo" or "Marsa Alam" or "flights"
    And Assert the header of the page is "Flights to Marsa Alam"

  @TC2
  Scenario: Verify weather search for Marsa Alam
    When enters the query "Marsa Alam weather" in the search bar
    And click on search button
    Then the search results should display is "Marsa" or "Weather" or "forecast"

  @TC3
  Scenario: Verify restaurant search near Marsa Alam
    When enters the query "restaurant near Marsa Alam" in the search bar
    And click on search button
    Then the search results should display is "Restaurant" or "Marsa" or "Alam"
    When navigate to more page then filter by top Rate "4.0"
    And Assert that all result items more than or equal 4.0