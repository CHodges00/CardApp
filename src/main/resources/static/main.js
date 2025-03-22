function validateAddCardForm() {
    var teamName = document.getElementById('team');
    var cardNumber = document.getElementById('cardNumber');
    var playerName = document.getElementById('playerName');
    var qty = document.getElementById('qty');
    var brand = document.getElementById('brand');
    var value = document.getElementById('value');
    var year = document.getElementById('year');
    var submitButton = document.getElementById('submitButton');

    // Enable the submit button if all fields are filled
    if (teamName.value && cardNumber.value && playerName.value && qty.value && brand.value && year.value && value.value) {
        submitButton.disabled = false;
    } else {
        submitButton.disabled = true;
    }
}

function confirmAddCard(event) {
    event.preventDefault();

    var teamName = document.getElementById('team');
    var cardNumber = document.getElementById('cardNumber');
    var playerName = document.getElementById('playerName');
    var qty = document.getElementById('qty');
    var brand = document.getElementById('brand');
    var brand = document.getElementById('year');
    var value = document.getElementById('value');

    if (teamName && cardNumber && playerName && qty && brand && year && value) {
        // Get the selected brand text
        var brandName = brand.options[brand.selectedIndex].text;

        var confirmationMessage = "Team Name: " + teamName.value + "\nCard #: " + cardNumber.value + "\nPlayer Name: " + playerName.value + "\nQty: " + qty.value + "\nBrand: " + brandName + "\nYear: " + year.value  +"\nValue: " + value.value + "\n\nIs this information correct?";

        var result = confirm(confirmationMessage);
        if (result) {
            document.getElementById('addCardForm').submit();
        }
    } else {
        console.error('Card likely already exists');
    }
}

function validateAddBrandForm() {
    var name = document.getElementById('name');

    // Enable the submit button if all fields are filled
    if (name.value) {
        submitButton.disabled = false;
    } else {
        submitButton.disabled = true;
    }
}

function confirmAddBrand(event) {
    event.preventDefault();

    var name = document.getElementById('name');

    if (name) {
        var confirmationMessage = "Brand Name: " + name.value + "\n\nIs this information correct?";

        var result = confirm(confirmationMessage);
        if (result) {
            document.getElementById('addBrandForm').submit();
        }
    } else {
        console.error('Brand likely already exists');
    }
}

function validateAddYearForm() {
    var year = document.getElementById('year');

    // Enable the submit button if all fields are filled
    if (year.value) {
        submitButton.disabled = false;
    } else {
        submitButton.disabled = true;
    }
}

function confirmAddYear(event) {
    event.preventDefault();

    var year = document.getElementById('year');

    if (year) {
        var confirmationMessage = "Year: " + year.value + "\n\nIs this information correct?";

        var result = confirm(confirmationMessage);
        if (result) {
            document.getElementById('addYearForm').submit();
        }
    } else {
        console.error('Year likely already exists');
    }
}