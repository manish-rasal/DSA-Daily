/**
 * Problem: Smallest Number in Infinite Set
 * Description: You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 *
 * Implement the SmallestInfiniteSet class:
 *
 * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
 * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 * void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 */
class SmallestInfiniteSet {

    boolean[] isPopped;
    int smallest;

    public SmallestInfiniteSet() {
        isPopped = new boolean[1001];
        smallest = 1;
    }

    public int popSmallest() {
        int result = smallest;
        isPopped[smallest] = true;
        for(int i = smallest + 1; i <= 1000; i++) {
            if(isPopped[i] == false) {
                smallest = i;
                break;
            }
        }
        return result;

    }

    public void addBack(int num) {
        isPopped[num] = false;
        if(num < smallest) {
            smallest = num;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */