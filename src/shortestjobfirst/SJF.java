package shortestjobfirst;
import java.util.ArrayList;
public class SJF
{
    public ArrayList<Process> processes;
    private ArrayList<Process> queue;
    private int BiggestCycle;
    
    public SJF()
    {
        queue = new ArrayList<>();
    }
    public SJF(ArrayList<Process> ps)
    {
        processes = ps;
        queue = new ArrayList<>();
    }
    public int getBiggestCycle()
    {
        return BiggestCycle;
    }
    public void start()
    {
        int lastID = -1;
        int i = 0;
        for(Process s : processes)
        {
            if(s.arrivalTime == 0)
            {
                queue.add(s);
                break;
            }
        }
        while(true)
        {
            for(int j = 0; j < processes.size(); j++)
            {
                if(i == processes.get(j).arrivalTime && i != 0)
                {
                    if(processes.get(j).burstTime >= queue.get(0).burstTime)
                        queue.add(processes.get(j));
                    else
                        queue.add(0, processes.get(j));
                }
            }
            if(queue.isEmpty())
            {
                BiggestCycle = i;
                break;
            }
            int min = queue.size()-1;
            for(int f = 0; f < queue.size(); f++)
            {
                if(queue.get(f).burstTime < queue.get(min).remainingTime && f != min)
                    min = f;
            }
            queue.add(0, queue.get(min));
            queue.remove(min + 1);
            if(i == 0)
                processes.get(queue.get(0).processID -1).pushStartTime(i);
            queue.get(0).remainingTime--;
            i++;
            if(lastID != -1 && lastID != queue.get(0).processID)
            {
                processes.get(queue.get(0).processID-1).pushStartTime(i-1);
                processes.get(lastID-1).pushEndTime(i-1);
            }
            lastID = queue.get(0).processID;
            if(queue.get(0).remainingTime == 0)
            {
                if(queue.get(0).remainingTime == 0)
                {
                    processes.get(queue.get(0).processID -1).pushEndTime(i);
                    queue.remove(0);
                }
            }
        }
    }
    public double calculateWaitingTime()
    {
        double res = 0.0;
        for(var p : processes)
        {
            if(p.startTimes.size() == 1)
            {
                res += p.startTimes.get(0) - p.arrivalTime;
                p.waitingTime = p.startTimes.get(0) - p.arrivalTime;
            }
            else
            {
                int currentProcess = p.startTimes.get(0) - p.arrivalTime;
                for(int i = 1; i < p.startTimes.size(); i++)
                {
                    currentProcess += p.startTimes.get(i) - p.endTimes.get(i-1);
                }
                p.waitingTime = currentProcess;
                res += currentProcess;
            }
        }
        return res / processes.size();
    }
}
