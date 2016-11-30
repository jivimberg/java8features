package presentation;

@SuppressWarnings("Convert2Lambda")
public class IntroToLambda {
    public static void main(String[] args) {
        // TODO 1
        Thread th = new Thread(new Runnable() {
            public void run() {
                System.out.println("In another thread");
            }
        });
        th.start();

        System.out.println("In main");

        //Fixme: function needs to be wrapped in method needs to be wrapped in anonymous class

        //function has 4 things
        //1. name -> anonymous
            //2. parameter list
            //3. body
        //4. return type -> inferred

        // TODO 2
        Thread th2 = new Thread(() -> System.out.println("In another thread"));
        th2.start();

        // Fixme: Lambdas are not just syntatic sugar for inner classes!!
        // Fixme: This would create tons of class$innerclass.class files, bigger jars, more footprint in memory.
    }
}
