<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function() {

    var availableCity = ["서울","부산","대구","광주","울산"];

    $("#city").autocomplete({

        source: availableCity,

        select: function(event, ui) {
			console.log(ui);
            console.log(ui.item);

        },

        focus: function(event, ui) {

            return false;

            //event.preventDefault();

        }

    });

});


</script>

</head>
<body>
<div class="ui-widget">

  <label for="city">도시: </label>

  <input id="city">

</div>



</body>
</html>