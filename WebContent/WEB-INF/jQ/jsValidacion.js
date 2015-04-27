var x;
x=$(document);
x.ready(inicialiazarEventos);
function inicialiazarEventos()
{
	$("#frmUsers").validate({
		rules:{
			Nombre:{
				required: true,
				minlength: 2,
				maxlength: 45
			},
			Apellido:{
				required: true,
				minlength: 4,
				maxlength: 45
			},
			RFC:{
				required: true,
				minlength: 6,
				maxlength: 6
			},
			email:{
				required: true,
				minlength: 4,
				maxlength: 30
			}
		},
		messages:{
			Nombre:{
				required: "Se requiere su usuario",
				minlength: $.validator.format("Por lo menos {0} caracteres"),
				maxlength: $.validator.format("Maximo {0} caracteres")
			},
			Apellido:{
				required: "Se requiere su usuario",
				minlength: $.validator.format("Por lo menos {0} caracteres"),
				maxlength: $.validator.format("Maximo {0} caracteres")
			},
			RFC:{
				required: "Se requiere su usuario",
				minlength: $.validator.format("Por lo menos {0} caracteres"),
				maxlength: $.validator.format("Maximo {0} caracteres")
			},
			email:{
				required: "Se requiere la contraseña",
				minlength: $.validator.format("Por lo menos {0} caracteres"),
				maxlength: $.validator.format("Maximo {0} caracteres")
			}
		}
	});
}