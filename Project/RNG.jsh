import java.util.Random;

public class RandomGenerator {
   private final Random rngArrival;
   private final Random rngService;
   private final Random rngRest;
   private final Random rngRestPeriod;
   private final Random rngTimeoutPeriod;
   private final Random rngCustomerType;
   private final double customerArrivalRate;
   private final double customerServiceRate;
   private final double serverRestingRate;

   RandomGenerator(int var1, double var2, double var4, double var6) {
      this.rngArrival = new Random((long)var1);
      this.rngService = new Random((long)(var1 + 1));
      this.rngRest = new Random((long)(var1 + 2));
      this.rngRestPeriod = new Random((long)(var1 + 3));
      this.rngCustomerType = new Random((long)(var1 + 4));
      this.rngTimeoutPeriod = new Random((long)(var1 + 5));
      this.customerArrivalRate = var2;
      this.customerServiceRate = var4;
      this.serverRestingRate = var6;
   }

   double genInterArrivalTime() {
      return -Math.log(this.rngArrival.nextDouble()) / this.customerArrivalRate;
   }

   double genServiceTime() {
      return -Math.log(this.rngService.nextDouble()) / this.customerServiceRate;
   }

   double genRandomRest() {
      return this.rngRest.nextDouble();
   }

   double genRestPeriod() {
      return -Math.log(this.rngRestPeriod.nextDouble()) / this.serverRestingRate;
   }

   double genCustomerType() {
      return this.rngCustomerType.nextDouble();
   }
}

class RNG {
    private final RandomGenerator rng;

    RNG (int seed, double lambda, double mu, double rho) {
        this.rng = new RandomGenerator(seed, lambda, mu, rho);
    }

    void generateServiceTimes(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + this.rng.genServiceTime());
        }
    }
}
