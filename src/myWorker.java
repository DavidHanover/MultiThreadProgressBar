import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class myWorker implements Runnable {

  ConcurrentLinkedQueue<Message> MessageQueue;


  myWorker(ConcurrentLinkedQueue<Message> a) {
    MessageQueue = a;

  }


  public void run() {

    JProgressBar pbar;

    int min = 0;
    int max = 150;

    // initialize Progress Bar
    pbar = new JProgressBar();
    pbar.setMinimum(min);
    pbar.setMaximum(max);
    // add to JPanel
    add(pbar);

    final SimpleLoop it = new SimpleLoop();

    JFrame window = new JFrame("Simple Loop Progress");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //window.setContentPane(it);
    window.pack();
    window.setVisible(true);

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