
// Wait for the DOM to be fully loaded
document.addEventListener('DOMContentLoaded', function () {
    
    let valueDisplays = document.querySelectorAll('.num');
    let interval = 5000;

    valueDisplays.forEach((valueDisplay) =>{
        let startValue = 0;
        let endValue = parseInt(valueDisplay.
            getAttribute("data-value"));
        console.log(endValue);
        let duration = Math.floor(interval/endValue);
        let counter = setInterval(function(){
            startValue += 1;
            valueDisplay.textContent = startValue;
            if(startValue == endValue){
                clearInterval(counter);
            }
        }, duration);
    })
    
  });
  



