window.onload = function() {
    var totalSEStudents = "[[${totalSEItems}]]";
    var chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        title: {
            // Arjanti type your text here or pass it as variable
            text: "SRecruiter"
        },
        data: [{
            type: "pie",
            startAngle: 240,
            indexLabel: "{label} {y}",
            dataPoints: [
                //qiti variablat e Javes prej query te Y nven te values,
                {y: totalSEStudents, label: "Engineer"},
                {y: 7.31, label: "Architect"},
                {y: 7.06, label: "Musician"},
                {y: 4.91, label: "Yahoo"},
                {y: 1.26, label: "Others"}
            ]
        }]
    });
    var yValue;
    var label;
    
    
    chart.render();
}