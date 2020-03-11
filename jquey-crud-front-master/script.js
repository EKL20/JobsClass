var listPersonas = [{ "id": 1, "nombre": "Juan E", "apellido": "Henao" },
{ "id": 2, "nombre": "Jesus", "apellido": "Nazaret" },
{ "id": 3, "nombre": "David", "apellido": "Henao" },
{ "id": 4, "nombre": "Elkin", "apellido": "Londoño" },
{ "id": 5, "nombre": "Miguel", "apellido": "Vergoya" },
{ "id": 6, "nombre": "Keyla", "apellido": "Zapata" }];

function cargarTable() {
	$('#table').html('');

	$("#table").append('<tr><td>Id</td>' +
		'<td>Nombre</td>' +
		'<td>Apellido</td>' +
		'<td></td>');

	listPersonas.forEach(
		(listItem) => {
			$("#table").append('<tr id="fill' + listItem.id + '">' +
				'<td>' + listItem.id + '</td>' +
				'<td>' + listItem.nombre + '</td>' +
				'<td>' + listItem.apellido + '</td>' +
				'<td><button id="eli" onclick="deleteObject(' + listItem.id + ')">Eli</button></td>');
		}
	)
}

function insertObject() {
	var nombre = $('#name').val();
	var apellido = $('#lastname').val();
	var id = listPersonas.length + 1;
	//console.log(nombre + apellido)

	listPersonas.push(
		{
			'id': id,
			'nombre': nombre,
			'apellido': apellido
		}
	)

	listPersonas.forEach(
		(listObject, i) => {
			if (i === listPersonas.length - 1) {
				$("#table").append('<tr id="fill' + listObject.id + '">' +
					'<td>' + listObject.id + '</td>' +
					'<td>' + listObject.nombre + '</td>' +
					'<td>' + listObject.apellido + '</td>' +
					'<td><button id="eli" onclick="deleteObject(' + listObject.id + ')">Eli</button></td>');
			}
		}
	)
}

function test(arr, neddle){
	var min = 0;
	max = arr.length - 1;
	while( min <= max ) {
		var guess = Math.floor((min + max) / 2);
		if (arr[guess] === neddle) return guess;
		(arr[guess] === neddle) ? min = guess + 1 : max = guess - 1
	}
	return -1;
}

function consumerService(){
	$.ajax({
		url: "http://localhost:8083/api2/sum",
		data: "",
		contentType: "application/json; charset=utf-8",
		type: "GET",
		success: function(data){
			console.log(data);
			$('#p').append(data);
		},
		error: function (x) {
			console.log(x);
		}
	});
}

function consArr(){
	var x = $('#x').val();
	var y = $('#y').val();

	var arrMat;
	var cont = 0;

	if(x == "" || y == ""){
		alert("Ingresa valores válido");
	} else {
		$.ajax({
			url: 'http://localhost:8083/api2/try?x=' + x + '&y=' + y,
			data: "",
			contentType: "application/json; charset=utf-8",
			type: "GET",
			success: function(data){
				console.log(data);

				arrMat = data.split(',');

				arrMat.forEach(arrOnj => {
					if(arrOnj != ""){
						if(cont <= x){
							$('#mat').append('<td>' + arrOnj + '</td>');
							cont++;
						} else {
							$('#mat').append('<td>' + arrOnj + '</td>');
						}
					}
				});

				/*for(var i = 0; i < arrMat.length; i++){
					if(arrMat[i] != ""){
						if(i < x - 1){
							
						} else {
							$('#mat').append('<td>' + arrMat[i] + '</td>');
						}
					}
				}*/
			},
			error: function (e) {
				console.log(e);
			}
		});
	}
}

function updateObject() {
	var idE = $('#id').val();
	var nombre = $('#name').val();
	var apellido = $('#lastname').val();

	itemToEdit = listPersonas.find(
		(listObject) => {
			return listObject.id === Number(idE);
		}
	)

	listPersonas[listPersonas.indexOf(itemToEdit)] = {
		'id': Number(idE),
		'nombre': nombre,
		'apellido': apellido,
	}
	cargarTable();
}

function deleteObject(id) {
	/*listPersonas.forEach(
		(listItem, i) => {
			if(listItem.id == id){
				delete listItem.id;
				delete listItem.nombre;
				delete listItem.apellido;
			}
		}
	)*/
	$("#fill" + id).remove();
}

var default_content = "";

$(document).ready(function () {
	console.log(test([1,2,3,4,4,5,6,7,7,7,8,9,0,1,2], 4));

	cargarTable();

	checkURL();
	$('ul li a').click(function (e) {

		checkURL(this.hash);

	});

	//filling in the default content

	consumerService();

	default_content = $('#pageContent').html();

	

	setInterval("checkURL()", 250);

});

var lasturl = "";

function checkURL(hash) {
	if (!hash) hash = window.location.hash;

	if (hash != lasturl) {
		lasturl = hash;

		// FIX - if we've used the history buttons to return to the homepage,
		// fill the pageContent with the default_content

		if (hash == "")
			$('#pageContent').html(default_content);

		else
			loadPage(hash);
	}
}


function loadPage(url) {
	url = url.replace('#page', '');

	$('#loading').css('visibility', 'visible');

	$.ajax({
		type: "POST",
		url: "load_page.php",
		data: 'page=' + url,
		dataType: "html",
		success: function (msg) {

			if (parseInt(msg) != 0) {
				$('#pageContent').html(msg);
				$('#loading').css('visibility', 'hidden');
			}
		}

	});

}

var labe = [[0, 0, 0, 1, 2],
	[0, 0, 1, 1, 1],
	[0, 0, 1, 0, 1],
	[0, 0, 1, 0, 0],
	[0, 0, 3, 0, 0]];

function lab() {
	

	var res = false;

	labe.forEach(
		(row, i) => {
			row.forEach(
				(colum, j) => {
					if(!res){
						if(colum[j,i] === 1 || row[i,j] === 1){
							labe[j, i] = 4;
							labe[i, j] = 4;
							console.log(colum);
						}
					}
				}
			)
		}
	)

	console.log(labe)
}

function labRes(indexOfArray, actualRow){
	var acd = 'l';
	var res = false;
	var pos = [0, 4];

	while(!res){
		
	}
}