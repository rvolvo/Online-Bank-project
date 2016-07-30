/**
 * Use in this JS: preOpenDeposit.jsp
 */
function CheckDepositId()
{
	var depositId = document.getElementById("depositIdToPreOpen").value;
	if(isNaN(depositId))
	{
		alert("Deposit Id must be a number");
		return false;
	}
	else if((depositId==null)||(depositId==""))
	{
		alert("You have to fill Deposit Id field");
		return false;
	}
	else
	{
		return true;
	}
}