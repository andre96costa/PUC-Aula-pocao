public class Pocao {

    private int maxRestore = 10;

    public int restoreHp(int[] dados) {
        var lifeToRestore = 0;
        
        if (!isEmpty()) {
            for (int d : dados) {
                // if (d == 6) {
                //     lifeToRestore++;
                // }
                lifeToRestore += d;
            }
            if (lifeToRestore > 10) {
                lifeToRestore = 10;
            }
            maxRestore -= lifeToRestore;
            return lifeToRestore;
        }
        return 0;
    }

    private boolean isEmpty(){
        if (this.maxRestore <= 0) {
            return true;
        }
        return false;
    }
    
}
