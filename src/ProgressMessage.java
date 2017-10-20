public class ProgressMessage extends Message {
  private int prcntCmplt = 0;
  ProgressMessage(int a){
    prcntCmplt = a;
  }
  int onProgress(){
    return prcntCmplt;
  }

}
