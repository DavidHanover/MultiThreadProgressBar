import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

/**
 * This is the main class.  I somehow hacked the widget together despite never having seen this
 * stuff or used it. I have used PyQt before, and I guess swing might be similar? I basically copied
 * an Oracle example and hacked it to pieces in order to create this.  It does the thing I'm pretty
 * sure.
 */


public class SimpleLoop extends JPanel {


  public static void main(String args[]) {

    JProgressBar pbar = new JProgressBar();
    pbar.setMinimum(0);
    pbar.setMaximum(100);

    JFrame window = new JFrame("Simple Loop Progress");
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setContentPane(pbar);
    window.pack();
    window.setVisible(true);
    ConcurrentLinkedQueue<Message> MessageQueue = new ConcurrentLinkedQueue<Message>();
    LoopWorker WorkerA = new LoopWorker(MessageQueue);
    Thread threadB = new Thread(WorkerA);
    threadB.start();
    boolean r = true;
    while (r == true) {

      try {
        java.lang.Thread.sleep(100);
      } catch (InterruptedException e) {
      }

      if (MessageQueue.peek() instanceof ProgressMessage) {
        ProgressMessage pm = (ProgressMessage) MessageQueue.poll();
        pbar.setValue(pm.onProgress());
      }
      if (MessageQueue.peek() instanceof CompletionMessage) {
        CompletionMessage cm = (CompletionMessage) MessageQueue.poll();
        System.out.println(cm.onComplete());
        r = false;
      }

    }


  }
}