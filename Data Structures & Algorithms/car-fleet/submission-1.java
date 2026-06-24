class Solution {

    class Position implements Comparable<Position> {
        int pos;
        int speed;

        Position(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public int compareTo(Position other) {
            return this.pos - other.pos;   
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

        Position[] cars = new Position[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Position(position[i], speed[i]);
        }
         Arrays.sort(cars);
        double prev = (double)(target - cars[cars.length - 1].pos)
              / cars[cars.length - 1].speed;

int count = 1;

for (int i = cars.length - 2; i >= 0; i--) {

    double time = (double)(target - cars[i].pos)
                  / cars[i].speed;

    if (time > prev) {
        count++;
        prev = time;
    }
}
        return count;
    }
}