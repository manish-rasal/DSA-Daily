/**
 * Problem: Reveal Cards In Increasing Order
 * Description: You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
 *
 * You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
 *
 * You will do the following steps repeatedly until all cards are revealed:
 *
 * Take the top card of the deck, reveal it, and take it out of the deck.
 * If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
 * If there are still unrevealed cards, go back to step 1. Otherwise, stop.
 * Return an ordering of the deck that would reveal the cards in increasing order.
 *
 * Note that the first entry in the answer is considered to be the top of the deck.
 */
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            que.offer(i);
        }

        Arrays.sort(deck);

        for (int i = 0; i < n; i++) {
            int idx = que.poll();
            result[idx] = deck[i];

            if (!que.isEmpty()) {
                que.offer(que.peek());
                que.poll();
            }
        }

        return result;
    }
}