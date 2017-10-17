$(function(){
	$("#div_tabs").tabs({
		fit:true,
		pill:true,
		justified:true,
		onSelect:function(title,index){
			var myTab=$("#div_tabs").tabs("getTab",title);
			var myUrl=myTab.context.id;
			$("#div_tabs").tabs("update",{
				tab:myTab,
				type:"body",
				options:{
					content:"<iframe src='/"+myUrl+"'></iframe>"
				}
			})
		}
	});
	$("#productScale").panel({
		id:"productScale",
		selected:true,
		content:"<iframe src='/productScale'></iframe>"
	});
	$("#brand").panel({
		id:"brand"
		/*content:"<iframe src='/brand'></iframe>"*/
	});
	$("#productType").panel({
		id:"productType"
		/*content:"<iframe src='/productType'></iframe>"*/
	});
	$("#location").panel({
		id:"location"
		/*content:"<iframe src='/location'></iframe>"*/
	});
	$("#loginLog").panel({
		id:"loginLog"
		/*content:"<iframe src='/loginLog'></iframe>"*/
	});
	$("#productPart").panel({
		id:"productPart"
		/*content:"<iframe src='/productPart'></iframe>"*/
	});
	$("#productInfo").panel({
		id:"productInfo"
		/*content:"<iframe src='/productInfo'></iframe>"*/
	});
	$("#petKind").panel({
		id:"petKind"
		/*content:"<iframe src='/petKind'></iframe>"*/
	});
	$("#petType").panel({
		id:"petType"
		/*content:"<iframe src='/petType'></iframe>"*/
	});
	$("#supplier").panel({
		id:"supplier"
		/*content:"<iframe src='/supplier'></iframe>"*/
	});
	$("#stockOutType").panel({
		id:"stockOutType"
		/*content:"<iframe src='/stockOutType'></iframe>"*/
	});
});