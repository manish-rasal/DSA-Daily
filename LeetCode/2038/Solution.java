/**
 * Problem: Remove Colored Pieces if Both Neighbors are the Same Color
 * Description: There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. You are given a string colors of length n where colors[i] is the color of the ith piece.
 *
 * Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.
 *
 * Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.
 * Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.
 * Alice and Bob cannot remove pieces from the edge of the line.
 * If a player cannot make a move on their turn, that player loses and the other player wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
 */
class Solution {
    public boolean winnerOfGame(String colours) {
        int i = 0, n = colours.length();
        int aCount = 0, bCount = 0, aTurns = 0, bTurns = 0;
        while(i < n) {
            while(i < n && colours.charAt(i) == 'A') {
                aCount++;
                i++;
            }
            if(aCount >= 3) aTurns += aCount - 2;
            aCount = 0;

            while(i < n && colours.charAt(i) == 'B') {
                bCount++;
                i++;
            }
            if(bCount >= 3) bTurns += bCount - 2;
            bCount = 0;
        }
        if(aTurns == 0) {
            return false;
        } else if(aTurns > bTurns) {
            return true;
        } else {
            return false;
        }
    }
}