package Pages

import geb.Page

class SignUpPage extends Page {

    static url = "https://ngx.me/4tjjUGV"
    static at = {
        title == "Micro Sign Up"
        $("h1").text() == "JOIN OUR NEWSLETTER"
        $("label", 0, id: "What_are_you_interested_in").text() == "What are you interested in?"
        $("div[role='radiogroup']")
        $("#xSubmitContainer div[class=xTextContainer]").text() == "SIGN UP"
    }

    static content = {
        firstNameInput { $("input[id=name_Firstname]") }
        lastNameInput { $("input[id=name_Lastname]") }
        emailInput { $("input[id=email]") }
        signUpBtn { $("#xSubmitContainer a") }
        resultModal(wait: true) { $(".xOverlayContent", text: "Only one entry per user is allowed.") }
    }

    void fillForm(option, firstName, lastName, email) {
        js.exec("window.scrollBy(0,document.body.scrollHeight)")
        $("#option_" + option).click()
        firstNameInput.click().value(firstName)
        lastNameInput.click().value(lastName)
        emailInput.click().value(email)
    }

    void makeRequest() {
        $("input[id=terms_and_conditions_check]").parent().click()
        $("input[id=brand_opt_in_check]").parent().click()
        signUpBtn.click()
    }

    void handleValidationFail() {
        if ($(".xOverlayContent").text() == "Entry could not be validated. Check your entry.") {
            $(".xCTA.xButton.xAction.xActionCloseOverlay").click()
            waitFor { signUpBtn.hasClass("xActivityInactive") }
            signUpBtn.click()
        }
    }

}
