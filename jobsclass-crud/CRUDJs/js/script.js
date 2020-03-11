var listInfo = [
	{
		'id': 1,
		'nombre': 'Yamaha',
		'llantas': [
			{
				'id': 1,
				'tamano': 'Grande'
			},
			{
				'id': 2,
				'tamano': 'Mediano'
			},
			
		]
	},
	{
		'id': 2,
		'nombre': 'Honda',
		'llantas': [
			{
				'id': 1,
				'tamano': 'Grande'
			},
			{
				'id': 2,
				'tamano': 'Mediano'
			},
			
		]
	}
]

var isCreating = false;
var isEditing = false;

$(document).ready(function () {

	$('#btnNuevo').click(function (e) {
		if (!isCreating) {
			$('#btnNuevo').html('Ocultar');
			isCreating = true;
			showCru();
		} else {
			$('#btnNuevo').html('Nuevo');
			isCreating = false;
			hideCru();
		}
	});
	$('#btnAgregar').click(function (e) {
		create();
	});
	$('#btnEditar').click(function (e) {
		edit();
	});
	buildTable();

});

function buildTable() {
	//$('#tableInfo').html(msg);
	var table = '';
	table += '<tr><th>Id</th><th>Nombre</th><th>Número de llantas</th><th>Opciones</th></tr>'

	listInfo.forEach(
		(listItem) => {
			table += '<tr>' + '<td>' + listItem.id + '</td>' + '<td>'
				+ listItem.nombre + '</td>' + '<td>' + listItem.llantas.length + '</td>'
				+ '<td><button class="button button2" onclick="viewItem(' + listItem.id + ')">Ver</button><button class="button button2" onclick="deleteItem(' + listItem.id + ')">Eliminar</button></td>' + '</tr>'
		}
	)

	$('#tableInfo').html(table);

}

function edit() {
	var existingId = $('#carId').val();
	var newName = $('#carName').val();
	var newNumberLl = $('#carNumberLL').val();

	var llTo = [];

	for (var i = 0; i < Number(newNumberLl); i++) {
		llTo.push(
			{
				'id': i,
				'tamano': 'Grande'
			}
		)
	}

	itemToEdit = listInfo.find(
		(itemTo) => {
			return itemTo.id === Number(existingId)
		}
	)

	listInfo[listInfo.indexOf(itemToEdit)] = {
		'id': Number(existingId),
		'nombre': newName,
		'llantas': llTo
	}

	buildTable();

}

function create() {
	var newName = $('#carName').val();
	var newNumberLl = $('#carNumberLL').val();

	var llTo = [];

	for (var i = 0; i < newNumberLl; i++) {
		llTo.push(
			{
				'id': i,
				'tamano': 'Grande'
			}
		)
	}

	listInfo.push(
		{
			'id': listInfo.length + 1,
			'nombre': newName,
			'llantas': llTo
		}
	)

	buildTable();
	showCru();
}

function deleteItem(item) {
	itemToDelete = listInfo.find(
		(itemTo) => {
			return itemTo.id === item
		}
	)

	listInfo.splice(listInfo.indexOf(itemToDelete), 1);

	buildTable();
}

function viewItem(item) {
	itemToView = listInfo.find(
		(itemTo) => {
			return itemTo.id === item
		}
	)

	$('#cruMain').css('display', 'block');
	$('#btnEditar').css('display', 'block');
	$('#carId').css('display', 'block');
	$('#btnAgregar').css('display', 'none');

	$('#carId').val(itemToView.id);
	$('#carName').val(itemToView.nombre);
	$('#carNumberLL').val(itemToView.llantas.length);
}

function showCru() {
	$('#cruMain').css('display', 'block');
	$('#carId').css('display', 'none');
	$('#btnEditar').css('display', 'none');
	$('#btnAgregar').css('display', 'block');
	$('#carId').val('');
	$('#carName').val('');
	$('#carNumberLL').val('');
}

function hideCru() {
	$('#cruMain').css('display', 'none');
	$('#btnEditar').css('display', 'none');
}