function signin() {

		var isValid = true;
	
		var email = regForm.email.value;
		var userName = regForm.userName.value;
		var password = regForm.password.value;

		var ptn_email = /^\s*\w+@[a-zA-Z_]{2,}\.[a-zA-Z]{2,3}\s*$/

		var i = 0 ;
		//////////////////Username check//////////////////
		
		if (userName.length < 5) {
			errMsg1.innerHTML = "Username must be at least 5 characters long.";
			i++;
			isValid = false;
		}

		
		/////////////////Password check//////////////////////////
		
		if (password.length < 8) {
			errMsg2.innerHTML = "Password should have minimum 8 characters.";
			i++;
			isValid = false;
		}

		/////////////////Email check//////////////////////////

		if (!ptn_email.test(email)) {
			errMsg3.innerHTML = "Email address has an invalid email address format.";
			i++;
			isValid = false;
		}

		if (i < 1) {
			window.alert("Account has been created successfully!");
		}	

		return isValid;
	}

