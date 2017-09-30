import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] arags){
        multiThread();
    }
    public static void singleThread(){
        List<Integer> list=new ArrayList<>();
        list.add(2);
        //list.add(3);

        Iterator<Integer> iterator=list.iterator();

        while (iterator.hasNext()){
            Integer i=iterator.next();
            if(i==2){
                //iterator.remove();
                list.remove(2);
            }
        }
        System.out.println(list.size());
    }

    public static void multiThread(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);

        list.add(2);

        list.add(3);

        list.add(4);

        list.add(5);

        Thread thread1 = new Thread(){

            public void run() {

                Iterator<Integer> iterator = list.iterator();

                while(iterator.hasNext()){

                    Integer integer = iterator.next();

                    System.out.println(integer);

                    try {

                        Thread.sleep(100);

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            };

        };

        Thread thread2 = new Thread(){

            public void run() {

                Iterator<Integer> iterator = list.iterator();

                while(iterator.hasNext()){

                    Integer integer = iterator.next();

                    if(integer==2)

                        iterator.remove();

                }

            };

        };

        thread1.start();

        thread2.start();


    }
}
