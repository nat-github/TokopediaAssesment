@ORDER
  Feature: Order test automation
    Background: Set the request specification
      Given Request specification is setup
    @orderStatus
    Scenario Outline:Validation of Order status
      Given User sends the request to Order API <orderID>,"<orderDescription>","<orderStatus>"
      Then User verifies the order status
      Examples:
      |orderID|orderDescription|orderStatus|
      |172481 |Tokopedia Order |New        |
    @timeStamp
    Scenario Outline:Validation of timeStamp
      Given User sends the request to Order API <orderID>,"<orderDescription>","<orderStatus>"
      Then User verifies the updatedTimestamp
      Examples:
        |orderID|orderDescription|orderStatus|
        |170670 |Tokopedia Order |Processed  |
    @statusCode
    Scenario Outline:Validation of statusCode
      Given User sends the request to Order API <orderID>,"<orderDescription>","<orderStatus>"
      Then User verifies the statusCode <statusCode>
      Examples:
        |orderID|orderDescription|orderStatus|statusCode|
        |179044 |Tokopedia Order |Old        |200       |
    @NegativeTest
    Scenario Outline:Validation of statusCode
      Given User sends the request to Order API <orderID>,"<orderDescription>","<orderStatus>"
      Then User verifies the response for any errors
      Examples:
        |orderID|orderDescription|orderStatus|
        |172481|Tokopedia Order |Old        |
