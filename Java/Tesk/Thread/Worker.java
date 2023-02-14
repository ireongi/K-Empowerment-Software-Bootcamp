package Java_Network.Tesk.Thread;

public class Worker extends Thread{
    public void run(){
        for(int i =0; i<=4; i++){
            try{
                System.out.println("작업 스레드 : " + i);
                Thread.sleep(1000);
            } catch(InterruptedException e){

            }
        }
    }

    public static void main(String[] args) {
        int alphabet = 'a';
        Thread w = new Worker();
        w.start();
        for (int i = 0; i < 30; i++) {
            try{
                System.out.println("메인 스레드 : " + (char)(alphabet + i));
                Thread.sleep(500);
            }catch (InterruptedException e){

            }
        }


    }
}
