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
            document.getElementById("surveyContainer").innerHTML += '<input name="'+data[e].id+'" id="'+data[e].id+'.'+data[e].answer[a].answer+'" type="checkbox">' +
            '<label for="'+data[e].id+data[e].answer[a].answer+'"><span class="total">'+data[e].answer[a].total+'</span> / '+data[e].answer[a].answer+'</label>' + '</br>'
        }
        document.getElementById("surveyContainer").innerHTML += '<input id="'+data[e].id+'" type="text"><button onclick="update(\''+data[e].id+'\');">Update</button>'
        document.getElementById("surveyContainer").innerHTML += "</br><hr>"
    }
};

function update(id) {
    if (document.getElementById(id).value === "")
        return;

    var _ID = id;
    var _answers = [];
    var _new = document.getElementById(id).value;
    var _update = {};

    //console.log(_new);
    //console.log(id);
    var check = document.getElementsByName(id);
    //console.log(check);
    for (var c in check) {
        if (check[c].checked) {
            _answers.push(check[c].id.substr(check[c].id.indexOf('.')+1));
        }
    }
    //console.log(_answers);

    _update.question = _ID;
    _update.newAnswer = _new;
    _update.answers = _answers;

    console.log(_update);

    $.ajax({
      type: "POST",
      url: "/survey/update",
      data: JSON.stringify(_update),
      contentType : 'application/json',
      success: successUpdate
    });

    function successUpdate(data) {
        console.log(data);
        location.reload();
    };
}

</script>
</body>

</html>
