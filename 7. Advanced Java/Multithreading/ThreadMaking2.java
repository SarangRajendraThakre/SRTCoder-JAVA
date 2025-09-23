public class ThreadMaking2 {

    
    public static void main(String[] args) {
        
        World world = new World();
       Thread thread = new Thread(world);
       thread.start();

        for(;;)
        {
            System.out.println("Sarang");
        }
    }
}

 class  World implements Runnable {
    @Override
    public void run()
    {
        for(;;)
        {
            System.out.println("World");
        }
    }

    
}