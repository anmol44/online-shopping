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
	default:
		// id is about
		$('#home').addClass('active');
	    $('#a_'+menu).addClass('active');
		break;
	}

});
