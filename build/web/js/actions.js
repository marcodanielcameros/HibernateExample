function muestraAlert(element){
	console.log("Aqui va todo");
	console.log(element);
	window.alert("Click en el elemento con el id"+element.id);

}

function muestraIngreso(){
	var
	text_1=document.getElementById("nombre").value;
	text_2=document.getElementById("apellido").value;
	text_3=document.getElementById("correo").value;
	text_4=document.getElementById("telefono").value;



	//window.alert(text_1+"Esto ingresaste");
	console.log("Nombre: "+text_1+"\n"+"Apellido: "+text_2+"\n"+"Correo: "+text_3+"\n"+"Telefono: "+text_4)
	if(!text_1||!text_2||!text_3||!text_4)
	{
		window.alert("Llena todos los campos");
		//document.getElementById('123').disabled=true;
	}
	/*console.log("Nombre: "+text_1);
	console.log("Apellido: "+text_2);
	console.log("Correo: "+text_3);
	console.log("Telefono: "+text_4);*/
}