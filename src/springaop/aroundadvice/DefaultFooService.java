package springaop.aroundadvice;

public class DefaultFooService implements FooService {

   public Foo getFoo(String name, int age) {
     try {
       Thread.sleep(4000);
     } catch (InterruptedException e) {
       e.printStackTrace();
     }
     return new Foo(name, age);
   }
}
