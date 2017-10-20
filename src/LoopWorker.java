import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This is the worker class that gets used in threadB over in the main method of SimpleLoop.  It
 * basically runs the 'doStuff' loop and creates messages to add to the ConcurrentLinkedQueue.
 */

public class LoopWorker implements Runnable {

  ConcurrentLinkedQueue<Message> MessageQueue;

  LoopWorker(ConcurrentLinkedQueue<Message> a) {
    MessageQueue = a;
  }

  /**
   * This is the Overridden 'run' method. It contains the 'doStuff' loop, which runs every 100
   * milliseconds and just passes its iterator to a ProgressMessage, to be interpreted as completion
   * percentage. The ProgressMessage is then added the the concurrentlinkedqueue and when the loop
   * is finished, a final message is added, this time a single 'CompletionMessage'.
   */
  public void run() {
    // run a loop to demonstrate raising
    int min = 0;
    int max = 100;

    for (int i = min; i <= max; i++) {
      try {
        java.lang.Thread.sleep(100);
      } catch (InterruptedException e) {
      }
      if (i < max) {
        ProgressMessage x = new ProgressMessage(i);
        MessageQueue.add(x);
      }
      if (i == max) {
        CompletionMessage x = new CompletionMessage();
        MessageQueue.add(x);
      }
    }
  }
}
