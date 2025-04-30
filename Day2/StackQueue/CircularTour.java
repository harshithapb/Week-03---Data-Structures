package StackQueue;


import java.util.LinkedList;
import java.util.Queue;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int canCompleteTour(PetrolPump[] pumps) {
        int n = pumps.length;
        for (int start = 0; start < n; start++) {
            int currentPetrol = 0;
            int count = 0;
            int current = start;
            boolean possible = true;

            while (count < n) {
                currentPetrol += pumps[current].petrol - pumps[current].distance;
                if (currentPetrol < 0) {
                    possible = false;
                    break;
                }
                current = (current + 1) % n;
                count++;
            }

            if (possible) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps1 = {new PetrolPump(4, 6), new PetrolPump(6, 5), new PetrolPump(7, 3)};
        System.out.println(canCompleteTour(pumps1));

        PetrolPump[] pumps2 = {new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3)};
        System.out.println(canCompleteTour(pumps2));

        PetrolPump[] pumps3 = {new PetrolPump(1, 4), new PetrolPump(2, 3), new PetrolPump(3, 2), new PetrolPump(4, 1)};
        System.out.println(canCompleteTour(pumps3));

        PetrolPump[] pumps4 = {new PetrolPump(4, 5), new PetrolPump(5, 4), new PetrolPump(6, 3), new PetrolPump(7, 2)};
        System.out.println(canCompleteTour(pumps4));
    }
}

