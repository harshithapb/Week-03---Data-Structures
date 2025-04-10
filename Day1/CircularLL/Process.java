package CircularLL;

import java.util.Scanner;

public class Process {
    int id;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;
    public Process(int id,int burstTime,int priority){
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}
class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue");
            return;
        }
        Process temp = head;
        do {
            System.out.println("PID: " + temp.id + ", Burst: " + temp.burstTime +
                    ", Remaining: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process current = head;
        int time = 0;

        System.out.println("\n--- Round Robin Scheduling ---");
        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                System.out.println("Executing Process PID: " + current.id + " for " + execTime + " units");
                current.remainingTime -= execTime;
                time += execTime;

                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (current.remainingTime == 0) {
                    current.turnaroundTime = time;
                    System.out.println("Process PID: " + current.id + " completed.");
                    removeProcess(current.id);
                }
            }

            current = (head != null) ? current.next : null;
            if (head == null) break;
            displayProcesses();
        }

        System.out.println("\n--- Scheduling Complete ---");
    }

    private void removeProcess(int pid) {
        if (head == null) return;

        Process current = head, prev = tail;

        do {
            if (current.id == pid) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void calculateAndDisplayAverages() {
        if (head == null) return;

        int totalWT = 0, totalTAT = 0, count = 0;
        Process temp = head;
        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Average Waiting Time: " + (double) totalWT / count);
        System.out.println("Average Turnaround Time: " + (double) totalTAT / count);
    }
}
class RoundRobinSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Process " + (i + 1));
            System.out.print("PID: ");
            int pid = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority: ");
            int pr = sc.nextInt();

            scheduler.addProcess(pid, bt, pr);
        }

        System.out.print("Enter Time Quantum: ");
        int timeQuantum = sc.nextInt();

        scheduler.displayProcesses();
        scheduler.simulateRoundRobin(timeQuantum);
        scheduler.calculateAndDisplayAverages();

        sc.close();
    }
}



