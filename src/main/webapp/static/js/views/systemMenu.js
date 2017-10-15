$(function(){
	$("#div_tabs").tabs({
		fit:true,
		pill:true,
		justified:true
	});
	$("#productScale").panel({
		content:"<iframe src='/productScale'></iframe>"
	});
	$("#brand").panel({
		content:"<iframe src='/brand'></iframe>"
	});
	$("#productType").panel({
		content:"<iframe src='/productType'></iframe>"
	});
	$("#location").panel({
		content:"<iframe src='/location'></iframe>"
	});
	$("#loginLog").panel({
		content:"<iframe src='/loginLog'></iframe>"
	});
	$("#productPart").panel({
		content:"<iframe src='/productPart'></iframe>"
	});
	$("#productInfo").panel({
		content:"<iframe src='/productInfo'></iframe>"
	});
	$("#petKind").panel({
		content:"<iframe src='/petKind'></iframe>"
	});
	$("#supplier").panel({
		content:"<iframe src='/supplier'></iframe>"
	});
	$("#stockOutType").panel({
		content:"<iframe src='/stockOutType'></iframe>"
	});
});