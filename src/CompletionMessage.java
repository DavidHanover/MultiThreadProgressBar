/**
 * This Message class is only used once, when the loop is done doing stuff. It contains the String
 * "TCMssg", which is hard coded to be "Task Complete!!".
 */
public class CompletionMessage extends Message {

  private String TCMssg = "Task Complete!!";

  CompletionMessage() {

  }

  /**
   * This method simply prints the TCMssg, which, again, is hard-coded to be "Task Complete!!".
   *
   * @return TCMssg - "Task Complete!!"
   */
  String onComplete() {
    return TCMssg;
  }
}
