var buttonOperations = function(){
  function dialogLead(leadText){
    window.alert(leadText);
  }
  function dialogBass(bassText){
    window.alert(bassText);
  }
  function dialogDrum(drumText){
    window.alert(drumText)
  }
}();

(function() {
  $("processAudioButton").click(function(){
    var leadTextBox = $("#Lead");
    console.log("im alive")
    if(leadTextBox.val() !== ""){
      dialogLead(leadTextBox);
    }
  });
});
