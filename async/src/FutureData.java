import java.util.Observable;
import java.util.Observer;

/**
 * Created by sdzn-dsj on 2016/11/29.
 */
public class FutureData implements Data,Observer {

    /**
     * 存放真实数据，并且标志真正的数据是否已经准备完毕
     * 被多线程享受
     * 如果realData2==null，表示数据还准备好
     * */
    private volatile RealData realData = null;
    /**
     * 查看真正的数据是否准备完毕
     * */
    public boolean isFinished() {
        return realData != null;
    }

    /**
     * 如果数据已经准备好，则返回真正的数据；
     * 否则，阻塞调用线程，直到数据准备完毕后，才返回真实数据；
     * */
    public String getContent() {
        synchronized (mutex) {
            while(!isFinished()) {//只要数据没有准备完毕，就阻塞调用线程
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return realData.getContent();
        }
    }

    /**
     *  当 RealData2 准备完数据后，RealData2 应该通知 FutureData2 数据准备完毕。
     *  并在输入参数 realData 传入真实数据，在参数 event 传入事件（比如数据如期准备好了，或出了什么异常）
     *
     *  @param  realData    真实的数据
     *  @param  event       事件类型
     * */
    public void update(Observable realData, Object event) {
        System.out.println("通知...."+event);
        if(!(realData instanceof RealData)) {
            throw new IllegalArgumentException("主题的数据类型必须是RealData2");
        }
        if(!(event instanceof String)) {
            throw new IllegalArgumentException("事件的数据类型必须是String");
        }
        synchronized (mutex) {
            if(isFinished()) {
                mutex.notifyAll();
                return;//如果数据已经准备好了，直接返回.
            }
            if("Finished".equals(event)) {
                this.realData = (RealData)realData;//数据准备好了的时候，便可以通知数据准备好了
                mutex.notifyAll();//唤醒被阻塞的线程
            }
        }
    }

    private Object mutex = new Object();
}

