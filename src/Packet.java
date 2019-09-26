import java.util.*;

public class Packet {

    //times
    public double serviceTime = 0;
    public double realServiceTime = 0;
    public double turnaroundTime = 0;
    public double startTime = 0;
    public double waitTime = 0;

   // adding the total time
    public static double totalServiceTime = 0;
    public static double totalWaitTime = 0;
    public static double totalturnaroundTime= 0;
    public  static  double totalTime=0;

   //count the number of time
    public static double countWaitTime = 0;
    public static double countturnaroundTime=0;
    public static double countServiceTime=0;

    //store store to find the max time
    public static LinkedList<Double> storeturnaroundTime = new LinkedList<Double>();
    public static LinkedList<Double> storewaitTime = new LinkedList<Double>();
    public static  LinkedList<Double> storeserviceTime = new LinkedList<Double>();


    //const
    public Packet (int time) {
        serviceTime = time;
        startTime();
    }
    // start time
    public void startTime() { startTime = System.currentTimeMillis(); }

    //Turnaroundtime
    public void endTime() {
        countturnaroundTime+=1;
        turnaroundTime = System.currentTimeMillis() - startTime;
        storeturnaroundTime.add(turnaroundTime);
        totalturnaroundTime = totalturnaroundTime+ turnaroundTime;

    }
    // calculate average turnaroundTime
    public static double  avgturnaroundTime() {
        return totalturnaroundTime/countturnaroundTime;

    }

    // calculate the waitime
    public void waitTime() {
        countWaitTime+=1;
        waitTime = turnaroundTime - (realServiceTime);
        storewaitTime.add(waitTime);
        totalWaitTime = totalWaitTime+ waitTime;
    }
    // calculate average waitTime
    public static double avgwaitTime() {
        return totalWaitTime/countWaitTime;

    }

    public void serviceTime() {
        realServiceTime = System.currentTimeMillis();


    }
    // calculate average ServiceTime
    public void calServiceTime() {
        countServiceTime+=1;
        realServiceTime = System.currentTimeMillis() - realServiceTime;
        storeserviceTime.add(realServiceTime);
        totalServiceTime = totalServiceTime + realServiceTime;
    }
    //calculate average ServiceTime
    public static double avgServiceTime() {
        return totalServiceTime/countServiceTime;
    }
    //calculate average total tme
    public static double totalTime() {

        return totalTime = totalturnaroundTime - totalWaitTime;
    }
    // tostring method to print
    @Override
    public String toString() {
        calServiceTime();
        if(turnaroundTime == 0) {
            endTime();
            waitTime();
        }

        return turnaroundTime + " Wait : " + waitTime + " ms ";
    }


    //calculate average  max wait time
    public static double maxwaitTime() {
        double maxValue = storewaitTime.get(0);
        double sizewaittime = storewaitTime.size();

        for (int i = 1; i < sizewaittime; i++) {
            if (storewaitTime.get(i) > maxValue) {
                maxValue = storewaitTime.get(i);

            }

        }
        return maxValue;

    }
    //calculate average  turnrdtime
    public static double maxturnardTime() {

        double maxValue = storeturnaroundTime.get(0);
        double sizeturntime = storeturnaroundTime.size();

        for (int i = 1; i < sizeturntime; i++) {
            if (storeturnaroundTime.get(i) > maxValue) {
                maxValue = storeturnaroundTime.get(i);

            }

        }
        return maxValue;
    }
    //calculate average  service time
    public static double maxserviceTime() {

        double maxValue = storeserviceTime.get(0);
        double sizeservicetime = storeserviceTime.size();

        for (int i = 1; i < sizeservicetime; i++) {
            if (storeserviceTime.get(i) > maxValue)
            {
                maxValue = storeserviceTime.get(i);

            }

        }
        return maxValue;
    }



}