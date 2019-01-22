class Ticket implements Runnable{
      private int num=100;
public Ticket(){}
public void run(){
    while(true){
      if(num>1){
             System.out.println(Thread.currentThread().getName()+"...."+num--);
}
        
}
}

}
public class Demo{
   public static void main(String[] args){
        Ticket a=new Ticket();
        Thread t1=new Thread(a);
        Thread t2=new Thread(a);
        Thread t3=new Thread(a);
        Thread t4=new Thread(a);
        t1.start(); 
t2.start(); 
t3.start(); 
t4.start(); 
        



}





}