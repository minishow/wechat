$(function(){
	$("#div_tabs").tabs({
		fit:true,
		pill:true,
		justified:true,
		onSelect:function(title,index){
			if(index!=0){
				var myTab=$("#div_tabs").tabs("getTab",title);
				var myUrl=myTab.context.id;
				$("#div_tabs").tabs("update",{
					tab:myTab,
					type:"body",
					options:{
						content:"<iframe src='/"+myUrl+"'></iframe>"
					}
				});
			}
		}
	});
	$("#productScale").panel({
		id:"productScale",
		selected:true,
		content:"<iframe src='/productScale'></iframe>"
	});
	$("#brand").panel({
		id:"brand"
	});
	$("#productType").panel({
		id:"productType"
	});
	$("#location").panel({
		id:"location"
	});
	$("#loginLog").panel({
		id:"loginLog"
	});
	$("#productPart").panel({
		id:"productPart"
	});
	$("#productInfo").panel({
		id:"productInfo"
	});
	$("#petKind").panel({
		id:"petKind"
	});
	$("#petType").panel({
		id:"petType"
	});
	$("#supplier").panel({
		id:"supplier"
	});
	$("#stockOutType").panel({
		id:"stockOutType"
	});
});