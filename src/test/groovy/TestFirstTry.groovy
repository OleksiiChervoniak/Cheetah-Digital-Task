println("Greetings! My name is Oleksii and I am from Ukraine\nHere is my first attempt to use Groovy + Geb")

import Pages.ConfirmationPage
import Pages.SignUpPage
import geb.Browser

def option = "a"
def firstName = "Oleksii"
def lastName = "Senior"
def email = "0thisismy@mail.com" // Be sure to change the email after each run

Browser.drive {

    go SignUpPage.url
    at SignUpPage

    fillForm(option, firstName, lastName, email)
    makeRequest()
    handleValidationFail()
    waitFor { at ConfirmationPage }

    go SignUpPage.url
    at SignUpPage
    fillForm(option, firstName, lastName, email)
    makeRequest()
    waitFor { resultModal.displayed }

    println("We are good!")

}.quit()