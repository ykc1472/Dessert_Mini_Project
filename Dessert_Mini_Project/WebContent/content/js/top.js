$(document).ready(function(){
	$("#search").autocomplete({
		source : function( request, response ) {
			$.ajax({
				type : "post",
				url : "SearchingFood",
				dataType : "json",
				data : {
					search : $("#search").val().trim()
				},
				success : function(data, status, xhr){
					//서버에서 json 데이터 response 후 목록에 뿌려주기 위함
                    response(
                        $.map(data, function(item) {
                        	console.log(item)
                            return {
                                label: item.FTITLE,
                                value: item.FTITLE
                            }
                        })
                    );
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
			})
			// ajax 끝
		},
		minLength: 2,
        select: function( event, ui ) {
            // 만약 검색리스트에서 선택하였을때 선택한 데이터에 의한 이벤트발생
        	console.log(ui);
            console.log(ui.item);
        },
        focus: function(event, ui) {

            return false;

            //event.preventDefault();
        }
    })
})