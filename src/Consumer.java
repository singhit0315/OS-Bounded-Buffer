//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */
//package Semaphores.boundedbuffer;


/**
 * This is the consumer thread for the bounded buffer problem.
 */


import java.util.*;

public class Consumer implements Runnable {

    public Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        Packet packet;

        while (true) {
            packet = (Packet) buffer.remove();
            packet.serviceTime();
            System.out.println("Firewall processing the packet");
            SleepUtilities.nap(10);  //(int)packet.serviceTime);
            System.out.println("Total packet time: (millisecond) " + packet.toString() );
            System.out.println();
        }
    }

    private Buffer buffer;
}
