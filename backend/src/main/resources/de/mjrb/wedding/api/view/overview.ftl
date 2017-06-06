<#-- @ftlvariable name="" type="de.mjrb.wedding.api.view.update" -->

<html>

<head>
<script src="/assets/jquery.min.js"></script>
<link href="/assets/survey.css" type="text/css" rel="stylesheet" />
<script src="/assets/survey.jquery.min.js"></script>
<style>

span {
    color: white;
    background-color: blue;
    padding-left: 5px;
    padding-right: 5px;
    border-radius: 20px;
}

</style>
</head>

<body>
<div id="surveyContainer"></div>

<script>

$.ajax({
  type: "GET",
  url: "/survey/sum",
  contentType : 'application/json',
  success: success
});

function success(data) {
    console.log(data);
    
    for(var e in data) {
        document.getElementById("surveyContainer").innerHTML += "<p>" +data[e].id +" - "+ data[e].title+ "</p>"
        for(var a in data[e].answer) {
            document.getElementById("surveyContainer").innerHTML += '<label>'+(parseInt(a)+1)+' - <span class="total">'+data[e].answer[a].total+'</span> / '+data[e].answer[a].answer+'</label>' + '</br>'
        }
        document.getElementById("surveyContainer").innerHTML += "</br><hr>"
    }
};


</script>
</body>

</html>
