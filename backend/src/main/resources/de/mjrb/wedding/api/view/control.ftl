<#-- @ftlvariable name="" type="de.mjrb.wedding.api.view.control" -->

<html>

<head>
<script src="/assets/jquery.min.js"></script>
<link href="/assets/survey.css" type="text/css" rel="stylesheet" />
<script src="/assets/survey.jquery.min.js"></script>
</head>

<body>
<div id="surveyContainer"></div>

<script>
var surveyJSON = {
 pages: [
  {
   name: "page1",
   elements: [
    {
     type: "text",
     isRequired: true,
     name: "question1",
     title: "Nennen Sie einen Disneyfilm."
    },
    {
     type: "text",
     isRequired: true,
     name: "question2",
     title: "Nennen Sie eine beliebte Süßspeise."
    },
    {
     type: "text",
     isRequired: true,
     name: "question3",
     title: "Nennen Sie etwas, das auf [...] endet."
    },
    {
     type: "text",
     isRequired: true,
     name: "question4",
     title: "Nennen Sie ein Tier mit drei Buchstaben."
    },
    {
     type: "text",
     isRequired: true,
     name: "question5",
     title: "Nennen Sie etwas, das man an den PC anschließt."
    },
    {
     type: "text",
     isRequired: true,
     name: "choice1",
     title: "Junge oder Mädchen?"
    },
    {
     type: "text",
     isRequired: true,
     name: "finalquestion1",
     title: "Nennen Sie etwas, das man nur einmal in der Woche wäscht."
    },
    {
     type: "text",
     isRequired: true,
     name: "finalquestion2",
     title: "Nennen Sie einen Jungennamen."
    },
    {
     type: "text",
     isRequired: true,
     name: "finalquestion3",
     title: "Nennen Sie ein Mädchennamen."
    },
    {
     type: "text",
     isRequired: true,
     name: "finalquestion4",
     title: "Nennen Sie ein beliebtes Reiseziel."
    },
    {
     type: "text",
     isRequired: true,
     name: "finalquestion5",
     title: "Nennen Sie etwas, das sich auf sauer reimt."
    }
   ]
  }
 ]
}

function sendDataToServer(survey) {
//    survey.sendResult('540928ab-6fb9-4109-8f6a-fc9524a81eff');
console.log(survey.data);

var surv = survey.data;
var elem = surveyJSON.pages[0].elements;

console.log(surv,elem);

var survArray= [];

for(var s in surv) {
    for(var e in elem) {
        if (s === elem[e].name) {
            var tmp = surv[s];
            surv[s] = {};
            surv[s].id = s;
            surv[s].answer = tmp;
            surv[s].title = elem[e].title;
            survArray.push(surv[s]);
            break;
        }
    }
}

console.log(survArray);

$.ajax({
  type: "POST",
  url: "/survey",
  data: JSON.stringify(survArray),
  contentType : 'application/json',
  success: success
});

function success(data) {
    console.log(data);
    location.reload();
};


}

var survey = new Survey.Model(surveyJSON);
$("#surveyContainer").Survey({
    model: survey,
    onComplete: sendDataToServer
});
</script>
</body>

</html>
