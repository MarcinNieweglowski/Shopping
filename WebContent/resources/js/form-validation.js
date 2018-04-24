/************************************************************************
 * Performing real-time validation of input fields for product-form.jsp *
 ************************************************************************/
 
function CustomValidation() {
    this.errorChecks = [];	// in order to make the validityChecks re-usable, this array is to be defined here (to not multiply .add / .remove)
};

CustomValidation.prototype = {
    
    checkValidity: function(input) {
    	for (var i=0; i<this.errorChecks.length; i++) {
    		var isInvalid = this.errorChecks[i].isInvalid(input);
    		if (isInvalid) {
    			this.errorChecks[i].element.classList.add("invalid");
    			this.errorChecks[i].element.classList.remove("valid");
    		} else {
    			this.errorChecks[i].element.classList.add("valid");
    			this.errorChecks[i].element.classList.remove("invalid");
    		}
    	}
    }
};

/**
 Checks the input on fields, searches for a specific invalidity 
 **/
var productNameValidityChecks = [
	{
		isInvalid: function(input) {	// true -> error in the field / false - is ok
			input = input.value;		// without type conversion javascript functions like trimLeft() do not work
			input = input.trim();
			return ( input.length < 2 ) ? true : false;
		},
		element: document.querySelector("label[for='productName'] li:nth-child(1)")
	},
	{
		isInvalid: function(input) {
			var illegalChars = input.value.match(/[^a-zA-Z0-9 ]/g);	// space is also allowed
			return ( illegalChars || input.value == "" ) ? true : false;
		},
		element: document.querySelector("label[for='productName'] li:nth-child(2)")
	}
];

var quantityNeededValidityChecks = [
	{
		isInvalid: function(input) {
			var quantityNeededValue = Number(input.value);
			return (input.value < 1 || input.value == "" || input.value == " " || isNaN(Number(quantityNeededValue)) )? true : false;
		},
		element: document.querySelector("label[for='quantityNeeded'] li:nth-child(1)")
	}
];

var statusValidityChecks = [
	{
		isInvalid: function(input) {
			var statusValue = Number(input.value);
			return ( input.value < 0 || input.value == "" || input.value == " " || isNaN(Number(statusValue)) )? true : false;
		},
		element: document.querySelector("label[for='status'] li:nth-child(1)")
	},
	{
		isInvalid: function(input) {
			var statusVal = Number(input.value);
			var quantityNeededVal = Number(quantityNeededInput.value);
			return ( statusVal > quantityNeededVal || isNaN(quantityNeededVal) ) ? true : false;
		},
		element: document.querySelector("label[for='status'] li:nth-child(2)")
	}
];

var productNameInput = document.getElementById("productName");
var quantityNeededInput = document.getElementById("quantityNeeded");
var statusInput = document.getElementById("status");

productNameInput.CustomValidation = new CustomValidation();
productNameInput.CustomValidation.errorChecks = productNameValidityChecks;	// add productNameValidityChecks to validityChecks array

quantityNeededInput.CustomValidation = new CustomValidation();
quantityNeededInput.CustomValidation.errorChecks = quantityNeededValidityChecks;	// add quantityNeededValidityChecks to validityChecks array

statusInput.CustomValidation = new CustomValidation();
statusInput.CustomValidation.errorChecks = statusValidityChecks;	// add statusValidityChecks to validityChecks array

productNameInput.addEventListener("keyup", function() {
	productNameInput.CustomValidation.checkValidity(this);
}); 
quantityNeededInput.addEventListener("keyup", function() {
	quantityNeededInput.CustomValidation.checkValidity(this);
	statusInput.CustomValidation.checkValidity(statusInput);// need to check the value of status, should the user later change the quantity needed
});
statusInput.addEventListener("keyup", function() {
	statusInput.CustomValidation.checkValidity(this);
});




