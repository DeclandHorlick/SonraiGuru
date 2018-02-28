 $(document).ready(function()
 {

    console.log("Get function is about to be called to our API");
    get_transaction();
    var getDayArray;
      function get_transaction()
      {

        $.ajax(
        {
            url: "http://localhost:8080/sonrai-guru/rest/transaction/date?fromDate=2018-02-20&toDate=2018-02-27",
            method: "GET",
            success:function(result)
            {
                console.log(result);
                var time = [];
                var balance = [];

                for(var i in result)
                {
                    time.push("Date "+ result[i].dateStamp);
                    balance.push(result[i].transactionAmount);

                }
                var chart = 
                {
                    labels:time,
                    datasets : 
                    [
                        {
                            label: 'Time',
                            data: time
                        }
                    ]
                };
                var ctx = document.getElementById('myChart1').getContext('2d');
                var lineChart = new Chart(ctx, 
                {
                    type: 'line',
                    data: chart

                });
            }
        });
    }   
        
});


//function dateGraphWeekly() 
		//{
			//var ctx = document.getElementById('myChart').getContext('2d');
			//var chart = new Chart(ctx, {
			// The type of chart we want to create
			//type: 'line',

    		// The data for our dataset
    		//data: {
    			//labels: ["1", "2", "3", "4", "5", "6", "7"],
    			//datasets: [{
    				//label: "Customer Balance Last Seven Days",
            		//backgroundColor: 'rgb(223, 105, 26)',
            		//borderColor: 'white',
            		//data: [0, 101, 52, 231, 201, 304, 245],
        		//}]
    		//},

    		// Configuration options go here
    		//options : {
    			//scales: {
    				//yAxes: [{

                        //ticks: {
                            //fontColor: "white"
                        //},
    					//scaleLabel: {
                            //fontColor: 'white',
    						//display: true,
    						//labelString: 'Balance'
    					//}
    				//}],
    				//xAxes: [{
                        //ticks: {
                            //fontColor: "white"
                        //},
    					//scaleLabel: {
                            //fontColor: 'white',
    						//display: true,
    						//labelString: 'Days'
    					//}
    				//}]
    			//},
    			//elements: {
    				//line: {
    					//tension: 0, // disables bezier curves
    				//}
    			//}
    		//}
			//});
   		//}


//$.get({url: "http://localhost:8080/sonrai-guru/rest/transaction/date?fromDate=2018-02-20&toDate=2018-02-27",success:function(result){
//getDayArray = result[0].transactionAmount;
//console.log("Get function has returned our transactions between a date");
//console.log(result);
//console.log("Get function has returned a single amount from these transactions");
//console.log(getDayArray);