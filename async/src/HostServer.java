/**
 * Created by sdzn-dsj on 2016/11/29.
 */
public class HostServer {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) 建立FutureData的实体  
        final FutureData futureData = new FutureData();

        // (2) 为了建立RealData的实体，启动新的线程  
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RealData realdata = new RealData();
                realdata.addObserver(futureData);//以便当RealData把数据准备完毕后，通过该回调口子，通知FutureData表示数据已经贮备好了
               // realdata2.createRealData(count, c);
            }
        }.start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) 取回FutureData实体，作为传回值  
        return futureData;
    }

}
