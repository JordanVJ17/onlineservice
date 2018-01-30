$(function(){
	//active menu
	
	switch(menu) {
		
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#lisProducts').addClass('active');
		break;
	default:
		$('#lisProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
});