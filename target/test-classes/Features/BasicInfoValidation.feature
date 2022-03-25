Feature: Validation Test Cases
  Scenario Outline: Verify Name is Required Field
    Given user is on automation assessment page
    Then user enter cnic "<cnicNumber>"
    Then user enter contact number "<phoneNumber>"
    Then user enter useremail "<email>"
    Then user click on next button
    And verify this field is required message is display

    Examples:
    |cnicNumber|phoneNumber|email|
    |  3110138175635        |   02982734563        |raozeeshan@gmail.com     |

  Scenario Outline: Verify Cnic is Required Field
    Given user is on automation assessment page
    Then user enter username "<username>"
    Then user enter contact number "<phoneNumber>"
    Then user enter useremail "<email>"
    Then user click on next button
    And verify this field is required message is display

    Examples:
      |username|phoneNumber|email|
      |testOne  |   02982734563        | raozeeshan@gmail.com  |

  Scenario Outline: Verify Email is Required Field
    Given user is on automation assessment page
    Then user enter username "<username>"
    Then user enter cnic "<cnicNumber>"
    Then user enter contact number "<phoneNumber>"
    Then user click on next button
    And verify this field is required message is display

    Examples:
      |username|cnicNumber|phoneNumber|
      |testOne |  3110138175635        |   02982734563        |

  Scenario Outline: Verify Phone Number is Required Field
    Given user is on automation assessment page
    Then user enter username "<username>"
    Then user enter cnic "<cnicNumber>"
    Then user enter useremail "<email>"
    Then user click on next button
    And verify this field is required message is display

    Examples:
      |username|cnicNumber|email|
      |testOne |  3110138175635   |raozeeshan@gmail.com     |

  Scenario Outline: Verify phone number is not less then 11 digits
    Given user is on automation assessment page
    Then user enter username "<username>"
    Then user enter cnic "<cnicNumber>"
    Then user enter useremail "<email>"
    Then user enter contact number "<phoneNumber>"
    Then user click on next button
    And verify that error message is display

    Examples:
      |username|cnicNumber|email|phoneNumber|
      |testOneee |  3110138175635   |raozeeshan@gmail.com     |0303377199|

  Scenario Outline: Verify cnic number is not less then 13 digits
    Given user is on automation assessment page
    Then user enter username "<username>"
    Then user enter cnic "<cnicNumber>"
    Then user enter useremail "<email>"
    Then user enter contact number "<phoneNumber>"
    Then user click on next button
    And verify that error message is display

    Examples:
      |username|cnicNumber|email|phoneNumber|
      |testOneee |  311013875635   |raozeeshan@gmail.com     |0303377199|

    @run
  Scenario Outline: Verify user successfully move to next page
    Given user is on automation assessment page
    Then user enter username "<username>"
    Then user enter cnic "<cnicNumber>"
    Then user enter useremail "<email>"
    Then user enter contact number "<phoneNumber>"
    Then user click on next button
    And verify successfully move to next page

    Examples:
      |username|cnicNumber|email|phoneNumber|
      |testOneee |  3110138175635   |raozeeshan@gmail.com     |03033377199|



