class Solution {
    /*
    who so ever reaches 1 first lose the game 
    
    if n is odd alice(first player) will always lose
    because she can never force bob to operate on odd no.
    she will only be able to choose odd x because odd % even is never 0
    choosing an odd x she will let bob operate on even x because odd - odd is always even
    
    now bob has upper hand because he can always force alice to operate on odd n by choosing 1
    
    so who so ever gets to operate on even no. first wins
    */
    
    public boolean divisorGame(int n) {
        return (n%2==0);
    }
}