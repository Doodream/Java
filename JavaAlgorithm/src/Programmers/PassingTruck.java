package Programmers;

import java.util.*;

// 트럭이라는 클래스를 만든다.
class Truck {
    // 다리를 처음 들어갔을때 시간을 저장한다.
    private int passingTime = 0;
    // 트럭의 무게를 저장한다.
    private int weight = 0;

    public int getPassingTime() {
        return passingTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setPassingTime(int passingTime) {
        this.passingTime = passingTime;
    }

    // 트럭을 생성할 때 트럭의 무게를 집어넣어준다.
    public Truck(int weight) {
        this.weight = weight;
    }
}

class PassingTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리는 Queue 형태이므로 queue로 구현한다.
        // ArrayList로 비슷하게 할 수 있으나 index값으로 삭제하고 불러오는데 매우 에러가 많다.
        Queue<Truck> waitingTrucks = new LinkedList<>();
        Queue<Truck> passedBridge = new LinkedList<>();
        Queue<Truck> inBridge = new LinkedList<>();

        // 트럭들을 waitingTruck에 옮겨 닮는다.
        for (int truckWeight : truck_weights) {
            waitingTrucks.add(new Truck(truckWeight));
        }
        // 시간은 0부터 시작한다.
        int time = 0;
        // 트럭들이 모두 다리를 지나가면 멈춘다.
        while (!(passedBridge.size() == truck_weights.length)) {
            // 트럭이 다리를 지나간 것을 먼저 체크해야 다리 위에 있는 것들이 clear된다.
            // 다리에 있던 마지막 트럭이 다리를 건넌다
            // 다리에 트럭이 있다면 실행
            if (!inBridge.isEmpty()) {
                // 다리에 있는 마지막 트럭이 다리에 있던시간(현재 시간 - 들어올 때 시간)이 다리길이와 같거나 크다면 다리를 지나감
                if (time - inBridge.peek().getPassingTime() >= bridge_length) {
                    passedBridge.add(inBridge.peek());
                    inBridge.poll();
                }
            }

            // 다리에 있는 모든 트럭의 무게를 더한다.
            int sum = 0;
            if (!inBridge.isEmpty()) {
                for (Truck truck : inBridge) {
                    sum += truck.getWeight();
                }
            }

            // 현재 다리위의 무게와 들어올 차량의 무게를 더한것이 다리한계보다 낮다면 다리에 올린다.
            // 기다리는 트럭들이 없을시 실행
            if (!waitingTrucks.isEmpty()) {
                if (sum + waitingTrucks.peek().getWeight() <= weight) {
                    waitingTrucks.peek().setPassingTime(time);
                    // 다리위에 올린다.
                    inBridge.add(waitingTrucks.peek());
                    waitingTrucks.poll();
                }
            }
            // 다음시간.
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        PassingTruck passingTruck = new PassingTruck();
        int bridge_length = 2;
        int weight = 10;
        int[] truckWeight = {7, 4, 5, 6};
        System.out.println(passingTruck.solution(bridge_length, weight, truckWeight));
    }
}
