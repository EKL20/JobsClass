$(document).ready(function () {
  startTriqui();
})

var dutty = false; //False is x, true is o
var hasFinish = false;

function verifyTriqui(xPosition, yPosition) {
  if (!hasFinish) {
      $.ajax({
          url: 'http://localhost:8083/api2/verify_triqui?xPosition='
              + xPosition + '&yPosition=' + yPosition + '&type=' + dutty,
          data: "",
          contentType: "charset=utf-8",
          type: "GET",
          success: function (verifyAnswer) {
              console.log(verifyAnswer);
              if (verifyAnswer === 'X-TK') {
                  console.log("Gano X");
                  $('#win').append("Gano X");
                  hasFinish = !hasFinish;
                  getLastMatrix();
              } else if (verifyAnswer === 'O-TK') {
                  console.log("Gano O");
                  $('#win').append("Gano O");
                  hasFinish = !hasFinish;
                  getLastMatrix();
              } else {
                  drawTriqui(verifyAnswer);
              }
          },
          error: function (verifyError) {
              console.error(verifyError);
          }
      });
      dutty = !dutty;
      
  } else {
      console.log('Ya perdió deje de llorar');
  }
}

function getLastMatrix() {
  $.ajax({
      url: 'http://localhost:8083/api2/get_last_matrix',
      data: "",
      contentType: "charset=utf-8",
      type: "GET",
      success: function (startAnswer) {
          drawTriqui(startAnswer);
      },
      error: function (startAnswerError) {
          console.error(startAnswerError);
      }
  });
}

function startTriqui() {
  $.ajax({
      url: 'http://localhost:8083/api2/start_triqui',
      data: "",
      contentType: "charset=utf-8",
      type: "GET",
      success: function (startAnswer) {
          drawTriqui(startAnswer);
      },
      error: function (startAnswerError) {
          console.error(startAnswerError);
      }
  });
}

function drawTriqui(triquiToDraw) {
  var triquiSplited = triquiToDraw.split(',');
  var table = '<tr>';
  var actuallyRow = '';
  var row = 0;
  var col = 0;

  // var maquina = $('#maq').val();

  hasFinish = !hasFinish;
  for (var i = 0; i < triquiSplited.length; i++) {
      if(triquiSplited[i] === '-'){
          hasFinish = false;
      }
    if ((i + 1) % 3 === 0) {
        actuallyRow += '<td text-align: center;"><a onclick="verifyTriqui(' + row + ',' + col + ')">' + triquiSplited[i] + '</a></td>';
        table += actuallyRow + '</tr><tr>';
        actuallyRow = '';
        row++;
        col = 0;
    } else {
        actuallyRow += '<td text-align: center;"><a onclick="verifyTriqui(' + row + ',' + col + ')">' + triquiSplited[i] + '</a></td>';
        col++;
    }
  }

  $('#tableMain').html(table);
}

function numAleatorio(min, max){
    return Math.random(Math.random() * (max - min) + min);
}