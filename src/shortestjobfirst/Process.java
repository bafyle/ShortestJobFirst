package shortestjobfirst;
import java.util.ArrayList;

public class Process
{
    public int processID;
    public int arrivalTime;
    public int burstTime;
    public int remainingTime;
    public int waitingTime;
    public ArrayList<Integer> startTimes;
    public ArrayList<Integer> endTimes;
    public Process()
    {
        startTimes = new ArrayList<>();
        endTimes = new ArrayList<>();
    }
    void pushEndTime(int endTime)
    {
        endTimes.add(endTime);
    }
    void pushStartTime(int startTime)
    {
        startTimes.add(startTime);
    }
}
