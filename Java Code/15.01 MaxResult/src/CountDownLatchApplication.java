import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

    private static final int NUMBER_OF_OPERATIONS = 10;

    public static void main(String[] args) throws Exception {

        final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
        final ExecutorService executorService = Executors.newCachedThreadPool();
        List<ComplexCalculation> calculations = new ArrayList<>();
        List<Future<Integer>> future = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        
        for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
        	ComplexCalculation calculation= new ComplexCalculation(i,latch);
            calculations.add(calculation);
            final Future<Integer> result = executorService.submit(calculation);
            future.add(result);
        }
        
        System.out.println("Waithing for all complex calculations to finish...");
        latch.await();
        
        for(Future<Integer> futur : future){
        	 final Integer complexCalculationResult = futur.get();
             results.add(complexCalculationResult);
        }

        System.out.println("All complex calculations finished.");
        System.out.println("Largest number is : "+ Collections.max(results));
        executorService.shutdown();
    }
}
