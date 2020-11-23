/** 
 * Coin class contains the coin values 
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Ben Bricker
 */
 public enum Coin
    {
        P10 (10),
        P20 (20),
        P100 (100),
        P200 (200);

        private final int value;

        private Coin(int value)
        {
            this.value = value;
        }
        public int getValue()
        {
            return value;
        }
     }