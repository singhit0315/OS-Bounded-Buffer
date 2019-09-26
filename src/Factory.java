//package Semaphores.boundedbuffer;


import java.util.concurrent.TimeUnit;

/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory {

    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();
        Packet packet = new Packet(5);
        //packet.totalWaitTime - packet.totalturnaroundTime

        // now create the producer and consumer threads
        Thread packetProducer = new Thread(new Producer(server,12, 8));
        Thread firewall = new Thread(new Consumer(server));

        packetProducer.start();
        firewall.start();
        //run
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Fail");
        }



            packetProducer.stop();
            firewall.stop();


        System.out.println("*********************Print Result***********************");
        System.out.println("");
        System.out.println("WaitTimes Average:       == " + Packet.avgwaitTime() + " Maximum == " + Packet.maxwaitTime());
        System.out.println("TurnaroundTimes Average  == " + Packet.avgturnaroundTime() + " Maximum == " + Packet.maxturnardTime());
        System.out.println("ServiceTimes Average     == " + Packet.avgServiceTime() + " Maximum == " + Packet.maxserviceTime());
        System.out.println("Packets Total Dropped    == " + BoundedBuffer.countdroppedPackets );
        System.out.println("Packets Total            == " + BoundedBuffer.counttotalPackets);
        System.out.println("Packets Total Dropped Average == " + (BoundedBuffer.countdroppedPackets/(BoundedBuffer.counttotalPackets+BoundedBuffer.countdroppedPackets))*100 + " percent");
        System.out.println("Processor (or CPU) utilization : " + ((Packet.totalServiceTime)/packet.totalTime()) * 100 + " percent");
        System.out.println("Processor throughput (packets/second)  " + (BoundedBuffer.counttotalPackets/packet.totalTime())*100 + " percent");
    }
}