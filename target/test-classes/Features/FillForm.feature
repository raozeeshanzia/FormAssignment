Feature: Fill Google form

   @test
   Scenario: Fill Complete Google Form
     Given user is on automation assessment page
     Then user enter username
     Then user enter cnic
     Then user enter useremail
     Then user enter contact number
     Then user click on next button
     And verify successfully move to next page
     Then user choose ans of firebug question
     Then user choose answer of not locator question
     Then user click on next button available on mutliple question
     Then user user select answer of prime number
     Then user user select answer of select number question
     Then user click on next button of checkbox page
     Then user choose capital of punjab
     Then user choose capital pakistan
     Then click on next button of dropdown page
     Then upload images file
     And user upload pdf file
     Then click on next button available on file upload page
     Then enter current time
     Then enter current date
     Then click on submit button
     Then click on view score button
     Then check result of question one and write correct answer in file
     Then check result of checkbox question and write answer in file
     Then check dropdown question and write answer in file
     Then verify total score


