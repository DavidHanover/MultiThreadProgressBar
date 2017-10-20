public class CompletionMessage extends Message {
  private String TCMssg = "Task Complete!!";
  CompletionMessage(){

  }
  String onComplete(){
    return TCMssg;
  }
}
