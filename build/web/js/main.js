
$().ready(function() {
	$("#card").flip({
	  trigger: 'manual'
	});
});

function sendData2Back(){
    var nombre=document.getElementById("nombre").value;
    var paterno=document.getElementById("paterno").value;
    var materno=document.getElementById("materno").value;    
    var telefono=document.getElementById("telefono").value;  
    
    
    var tipoPersona = document.getElementById("tipoPersona");
    var pro = tipoPersona.options[tipoPersona.selectedIndex].value;


    $.post("Test",
    {
        nombre:nombre,
        paterno:paterno,
        materno:materno,
        telefono:telefono,
        tipoPersona:pro
    }
    ,
    function(data){
        console.log("Hey tu data");
        console.log(data);
        document.getElementById("idSuperGenial").innerHTML="";
        document.getElementById("idSuperGenial").innerHTML=data;
    }
    );
    
}
$(".signup_link").click(function() {

	$(".signin_form").css('opacity', '0');
	$(".signup_form").css('opacity', '100');
	
	
	$("#card").flip(true);
	
	return false;
});

$("#unflip-btn").click(function(){
  
	$(".signin_form").css('opacity', '100');
	$(".signup_form").css('opacity', '0');
	
  	$("#card").flip(false);
	
	return false;
	
});