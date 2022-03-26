package Pages

import geb.Page

class ConfirmationPage extends Page {
    static url = "https://x.wayin.com/display/container/dc/e0563347-4446-45a3-b780-c0cff6e6306f/confirmation"
    static at = {
        title == "Micro Sign Up"
        $("h1[class='xTitle xHeading']").text() == "Thank you for signing up!"
        $("a[class='xCTA xButton '] div[class='xTextContainer']")
    }
}
