/**
 *Use in this JS: login.jsp
 */
function CheckClientId()
{
	var clientId = document.getElementById("id").value;
	if(isNaN(clientId))
	{
		alert("Client ID field must contain only numbers");
		return false;
	}
	else
	{
		return true;
	}
}

function CheckAllFields()
{	
	var clientId = document.getElementById("id").value;
	var clientName = document.getElementById("name").value;
	var clientPassword = document.getElementById("password").value;
	if((clientId==null)||(clientId=="")||
			(clientName==null)||(clientName=="")||
			(clientPassword==null)||(clientPassword==""))
	{
		alert("Login Failed, You must fill all fileds");
		return false;
	}
}

