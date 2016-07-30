/**
 * Use in this JS: newDeposit.jsp , depositToAccount.jsp
 */
function CheckDepositAmount() 
{
	var amount = document.getElementById("depositAmount").value;
	if (isNaN(amount)) 
	{
		alert("You must enter a number");
		return false;
	}
	else if (amount < 1) 
	{
		alert("Minimum deposit of 1$");
		return false;
	}
	else
	{
		return true;
	}
}
