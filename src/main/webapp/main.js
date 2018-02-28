 $(document).ready(function(){

 console.log("Get function is about to be called to our API");
   
get_transaction();
var getDayArray;
      function get_transaction(){

$.get({url: "http://localhost:8080/sonrai-guru/rest/transaction/date?fromDate=2018-02-20&toDate=2018-02-27",success:function(result){
getDayArray = result[0].transactionAmount;
console.log("Get function has returned our transactions between a date");
console.log(result);
console.log("Get function has returned a single amount from these transactions");
console.log(getDayArray);
	


}});
}
 }); 