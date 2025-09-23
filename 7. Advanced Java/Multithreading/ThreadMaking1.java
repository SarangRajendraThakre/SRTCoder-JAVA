public class ThreadMaking1 {

    
    public static void main(String[] args) {
        
        World world = new World();
        world.start();
        for(;;)
        {
            System.out.println("Sarang");
        }
    }
}

 class  World extends Thread {
    @Override
    public void run()
    {
        for(;;)
        {
            System.out.println("World");
        }
    }

    
}