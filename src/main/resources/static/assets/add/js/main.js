$(document).ready(function() {
  $(document).on("click", "#submit", function() {
    var radios = document.getElementsByName("imob");
    console.log(radios.length);
    for (var i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
            console.log("Escolheu: " + radios[i].value);
        }
    }
  });
  
});