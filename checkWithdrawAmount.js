/**
 * Use in this JS: withdraw.jsp
 */
function CheckWithdraw() 
{
	var amount = document.getElementById("withdrawAmount").value;
	if ((isNaN(amount)) || (amount < 1)) 
	{
		alert("You must enter a number between 1$ and your credit limit");
		return false;
	} 
	else 
	{
		return true;
	}
}