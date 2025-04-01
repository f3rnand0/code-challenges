package technical.challenges;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WAESChallenge1 {

  class Product {
    String status;

    public String getStatus() {
      return status;
    }
  }

  interface ProductVerifier {
    void verify(Product product) throws Exception;
  }

  class ProductLineTestReport {
    long correctCounter;      // number of correct products
    long checkedExcCounter;
    // number of products which threw a checked exception during verification
    long uncheckedExcCounter;
    // number of products which threw an unchecked exception during verification
    long otherExcCounter;     // number of products which threw an error during verification

    ProductLineTestReport(long correctCounter, long checkedExcCounter, long uncheckedExcCounter,
                          long otherExcCounter) {
      this.correctCounter = correctCounter;
      this.checkedExcCounter = checkedExcCounter;
      this.uncheckedExcCounter = uncheckedExcCounter;
      this.otherExcCounter = otherExcCounter;
    }
  }

  class ProductionLineTester {

    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
      this.verifier = verifier;
    }

    ProductLineTestReport test(Stream<Product> products) {
      ProductLineTestReport emptyReport = new ProductLineTestReport(0, 0, 0, 0);
      if (products == null) {
        return emptyReport;
      }

      List<Product> processedProducts =
          products.filter(Objects::nonNull).filter(p -> !"invalid".equalsIgnoreCase(p.getStatus()))
              .skip(10).limit(20).collect(Collectors.toList());

      if (processedProducts.isEmpty()) {
        return emptyReport;
      }

      int checkedExceptions = 0;
      int uncheckedExceptions = 0;
      int errors = 0;
      int correctProducts = 0;

      for (Product product : processedProducts) {
        try {
          verifier.verify(product);
          correctProducts++;
        } catch (RuntimeException e) {
          uncheckedExceptions++;
        } catch (Exception e) {
          checkedExceptions++;
        } catch (Error e) {
          errors++;
        }
      }

      return new ProductLineTestReport(correctProducts, checkedExceptions, uncheckedExceptions,
                                       errors);
    }
  }

  public static void main(String[] args) {
    WAESChallenge1 waesChallenge1 = new WAESChallenge1();
  }

}
