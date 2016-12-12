public class Main {

    public static void main(String[] args) {
        testHostServer();
    }

    static void testHostServer() {
        System.out.println("main BEGIN");
        HostServer hostServer = new HostServer();
        Data data1 = hostServer.request(10, 'A');
        Data data2 = hostServer.request(20, 'B');
        Data data3 = hostServer.request(30, 'C');

        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("main otherJob END");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main END");

    }
}
