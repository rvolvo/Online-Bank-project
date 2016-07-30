/**
 * Use in this JS: updateClientDetails.jsp
 */
function CheckName()
{
	var clientName = document.getElementById("clientName").value; 
	var alphaExp = /^[a-zA-Z]+ [a-zA-Z]+$/;
	if (!clientName.match(alphaExp))
	{
		alert("Client Name field must contain only letters");
		return false;
	} 
	else if((clientName==null)||(clientName==""))
	{
		alert("Client Name field is mandatory");
		return false;
	}
	else 
	{
		return true;
	}
}

function CheckPassword()
{
	var clientPassword = document.getElementById("clientPassword").value;  
	if ((clientPassword==null)||(clientPassword=="")) 
	{
		alert("Client Password field is mandatory");
		return false;
	} 
	else if((clientPassword.length<4)||(clientPassword.length>10))
	{
		alert("Client Password must contain between 4 to 10 characters");
		return false;
	}
	else 
	{
		return true;
	}
}

function CheckEmail()
{
	var clientEmail = document.getElementById("clientEmail").value;  
	var emailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if ((clientEmail==null)||(clientEmail=="")) 
	{
		alert("Client Email field is mandatory");
		return false;
	} 
	else if(!clientEmail.match(emailFormat))
	{
		alert("You have entered an invalid email address");
		return false;
	}
	else 
	{
		return true;
	}
}

function CheckAddress()
{
	var clientAddress = document.getElementById("clientAddress").value;  
	if ((clientAddress==null)||(clientAddress=="")) 
	{
		alert("Client Address field is mandatory");
		return false;
	} 
	else 
	{
		return true;
	}
}

function CheckPhone()
{
	var clientPhone = document.getElementById("clientPhone").value;  
	if (isNaN(clientPhone)) 
	{
		alert("Client Phone field must contain only numbers");
		return false;
	} 
	else if((clientPhone==null)||(clientPhone==""))
	{
		alert("Client Phone field is mandatory");
		return false;
	}
	else if(clientPhone.length>10)
	{
		alert("Client Phone number must contain maximum 10 characters");
		return false;
	}
	else 
	{
		return true;
	}
}

function CheckComment()
{
	var clientComment = document.getElementById("clientComment").value;  
	if (clientComment.length>100) 
	{
		alert("Client Comment field must contain maximum 100 characters");
		return false;
	} 
	else 
	{
		return true;
	}
}

