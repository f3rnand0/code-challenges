package technical.challenges;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PerfilTICCodeChallengeTask3 {

    public static void main(String[] args) {
        PerfilTICCodeChallengeTask3 so = new PerfilTICCodeChallengeTask3();

        System.out.println("price: " + calculate_price("Cama de Perro", "001",
                                                       "100.00", "2.00"));
        System.out.println("price: " + calculate_price("Juguete de Gato", "001",
                                                       "300.00", "8.00"));
        System.out.println("price: " + calculate_price("Piano", "003", "100.00", "2.00"));
        System.out.println("price: " + calculate_price("Guitarra", "003",
                                                       "300.00", "8.00"));
        System.out.println("price: " + calculate_price("Anillo", "000", "100.00", "2.00"));
        System.out.println("price: " + calculate_price("Otro", "000", "300.00", "8.00"));
    }

    public static String calculate_price(String product_name, String category, String cost, String weight) {
        double weightI = Double.valueOf(weight);
        double costD = Double.valueOf(cost);
        double shipping = 0.0;
        double commission = 0.0;
        double tariff = 0.1;
        double costTariff = 0.1;
        double iva = 0.0;
        double price = 0.0;

        if (weightI <= 4) shipping += 10;
        else shipping += 10 + ((weightI - 4) * 2);

        if (category.equals("000")) commission = 0.0;
        else if (category.equals("001")) commission = 0.1;
        else if (category.equals("002")) commission = 0.05;
        else if (category.equals("003")) commission = 0.15;

        commission = commission / (1 - commission);

        costTariff = costD * tariff;
        if (costD > 200.0) iva = 0.19 * (costD + shipping + costTariff);

        // Calculste total price
        price = costD + shipping + costTariff + iva;
        // Include commission
        price += (price * commission);
        // Include profit
        price += (price * 0.1);

        BigDecimal priceB = new BigDecimal(price);
        priceB = priceB.setScale(2, RoundingMode.HALF_UP);
        return product_name + "," + priceB;
    }
}
