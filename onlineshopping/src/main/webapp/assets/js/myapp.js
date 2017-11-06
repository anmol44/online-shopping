$(function() {
	// solving the active menu problem
	switch (menu) {
	// about us is title from pAGE CONTROLLER
	case 'about us':
		// id is about
		$('#about').addClass('active');
		break;
	case 'contact us':
		// id is about
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'home':
		$('#home').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	var $table = $('#productListTable');

	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		console.log('inside the table');

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'All' ] ],
					pageLength : 3,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src = "' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg " class = "dataTableIMG"/>'
								}

							},
							{
								data : 'name'
							},

							{
								data : 'brand'
							},

							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377;' + data;
								}
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style = "color:red">out of stock</span>';
									}
									else {return data;}
								}
							},

							{

								data : 'views'
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href = "'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class = "btn btn-primary"><span class = "glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (row.quantity < 1) {
										str += '<a href = "javascript:version(0)" class = "btn btn-success disabled"><span class = "glyphicon glyphicon-shopping-cart"></span></a>';
									}

									else {
										str += '<a href = "'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product"class = "btn btn-success"><span class = "glyphicon glyphicon-shopping-cart"></span></a>';
									}

									return str;

								}
							} ]

				});
	}

});
