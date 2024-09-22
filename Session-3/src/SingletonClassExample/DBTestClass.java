package SingletonClassExample;

public class DBTestClass {
    public static void main(String[] args) {

     //   DatabaseExample db1= new DatabaseExample();
//        DatabaseExample db1= DatabaseExample.getDBInstance();
//        DatabaseExample db2= DatabaseExample.getDBInstance();
//        DatabaseExample db3= DatabaseExample.getDBInstance();
//
//       /* DatabaseExample db2= new DatabaseExample();
//        DatabaseExample db3= new DatabaseExample();*/
//
//
//        System.out.println(db1.hashCode());
//        System.out.println(db2.hashCode());
//        System.out.println(db3.hashCode());


        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseExample db1= DatabaseExample.getDBInstance();
                System.out.println(db1.hashCode());
            }
        });

        Thread thread2= new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseExample db2= DatabaseExample.getDBInstance();
                System.out.println(db2.hashCode());
            }
        });

        thread1.start();
        thread2.start();


    }
}
