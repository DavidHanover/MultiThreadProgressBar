/**
 * The ProgressMessage class contains an integer value that gets passed to it upon creation.  The
 * value is meant to mean progress percentage, to be used later when updating the widget in the
 * SimpleLoop main method.
 */
public class ProgressMessage extends Message {

  private int prcntCmplt = 0;

  ProgressMessage(int a) {
    prcntCmplt = a;
  }

  /**
   * This method, onProgress, simply returns the Integer that the class contains.
   *
   * @return prcntCmplt
   */
  int onProgress() {
    return prcntCmplt;
  }

}
