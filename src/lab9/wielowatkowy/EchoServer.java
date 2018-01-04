package lab9.wielowatkowy;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6669);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
        /*CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,
                20, 5000, TimeUnit.MILLISECONDS, blockingQueue);*/
        ExecutorService executor = Executors.newFixedThreadPool(2);


            try {
                while (true) {
                    clientSocket = serverSocket.accept();
                    //new Thread(new NewThread(clientSocket)).start();
                    executor.submit(new NewThread(clientSocket));
                }
            } catch (IOException e) {
                System.out.println("Accept failed: 6666");
                System.exit(-1);
            }
        executor.shutdown();


    }}