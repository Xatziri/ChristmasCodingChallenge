  let expression;
            let ans;
            function append(value){
                document.getElementById('res').innerHTML += value;               
            expression = document.getElementById('res').innerHTML;                       
            }
            function clr(){
                document.getElementById('res').innerHTML ='';
            }
            function eval() {
                  if (expression.indexOf("+") != -1){
              
                      var num = expression.split("+"); 
                      var first = parseInt(num[0], 2); 
                      var second = parseInt(num[1], 2); 
                      var sum = first+second; 
                      ans = sum.toString(2);  
            }else if (expression.indexOf("-") != -1){
                      var num = expression.split("-"); 
                      var first = parseInt(num[0], 2); 
                      var second = parseInt(num[1], 2); 
                      var sub = first-second; 
                      ans = sub.toString(2);  
            }else if (expression.indexOf("*") != -1){
                      var num = expression.split("*"); 
                      var first = parseInt(num[0], 2); 
                      var second = parseInt(num[1], 2); 
                      var mul = first*second; 
                      ans = mul.toString(2);  
            }else if (expression.indexOf("/") != -1){
                      var num = expression.split("/"); 
                      var first = parseInt(num[0], 2); 
                      var second = parseInt(num[1], 2); 
                      var div = first/second; 
                      ans = div.toString(2);  
            }
            
            document.getElementById('res').innerHTML =ans;
            }
