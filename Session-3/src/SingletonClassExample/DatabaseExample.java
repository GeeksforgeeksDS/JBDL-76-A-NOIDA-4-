package SingletonClassExample;

public class DatabaseExample {
     private  static DatabaseExample databaseExample  ;

    private DatabaseExample(){
    }

    public static DatabaseExample getDBInstance(){

        synchronized (DatabaseExample.class){
        if(databaseExample==null){
            databaseExample= new DatabaseExample();
        }
            return databaseExample;
        }


        /*Double-Checked Locking Used in case both threads have same priority
        *
        *
        *
         if (databaseExample == null) { // First check (no locking)
            synchronized (DatabaseExample.class) {
                if (databaseExample == null) { // Second check (with locking)
                    databaseExample = new DatabaseExample();
                }
            }
        }
        return instance;
        *
        * */

    }


}
