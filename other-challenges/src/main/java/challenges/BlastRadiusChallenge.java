package technical.challenges;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class BlastRadiusChallenge {

    class Subscription {
        public Subscription() {
        }

        public Subscription(int id, int customerId, int monthlyPriceInDollars) {
            this.id = id;
            this.customerId = customerId;
            this.monthlyPriceInDollars = monthlyPriceInDollars;
        }

        public int id;
        public int customerId;
        public int monthlyPriceInDollars;
    }

    class User {
        public User() {
        }

        public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
            this.id = id;
            this.name = name;
            this.activatedOn = activatedOn;
            this.deactivatedOn = deactivatedOn;
            this.customerId = customerId;
        }

        public int id;
        public String name;
        public LocalDate activatedOn;
        public LocalDate deactivatedOn;
        public int customerId;
    }

    class Challenge {
        public double billFor(String month, Subscription activeSubscription, User[] users) {
            if (activeSubscription == null) {
                return 0;
            }
            if (users.length == 0)
                return 0;
            // your code here!
            DateTimeFormatter dateFormat = new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM")
                    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                    .toFormatter();
            int year = Integer.valueOf(month.substring(0, month.indexOf("-")));
            int monthInteger = Integer.valueOf(month.substring(month.indexOf("-"), month.length() - 1));
            LocalDate firstDayOfMonth = firstDayOfMonth(LocalDate.of(year, monthInteger, 1));
            LocalDate lastDayOfMonth = lastDayOfMonth(LocalDate.of(year, monthInteger, 1));
            long daysOfMonth = ChronoUnit.DAYS.between(firstDayOfMonth, lastDayOfMonth);
            double dailyRate = activeSubscription.monthlyPriceInDollars / daysOfMonth;
            LocalDate actualDate = firstDayOfMonth;
            int usersNumber;
            Double totalBill = 0d;
            for (int i = 0; i < daysOfMonth; i++) {
                usersNumber = getActiveUsers(actualDate, users);
                totalBill += usersNumber * dailyRate;
                actualDate.plusDays(1);
            }
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(Double.valueOf(df.format(totalBill)));
            return Double.valueOf(df.format(totalBill));
        }

        /*******************
         * Helper functions *
         *******************/

        /**
         * Count the number of active users for a specified date
         */
        private int getActiveUsers(LocalDate date, User[] users) {
            int activeUsers = 0;
            for (int i = 0; i < users.length; i++) {
                int compareDateActivated = date.compareTo(users[i].activatedOn);
                if (compareDateActivated == 0)
                    activeUsers++;
                if (compareDateActivated > 0) {
                    int compareDateDeactivated = date.compareTo(users[i].deactivatedOn);
                    if (compareDateDeactivated > 0)
                        activeUsers--;
                }
            }
            return activeUsers;
        }

        /**
         * Takes a LocalDate object and returns a LocalDate which is the first day
         * of that month. For example:
         * <p>
         * firstDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 1)
         **/
        private LocalDate firstDayOfMonth(LocalDate date) {
            return date.withDayOfMonth(1);
        }

        /**
         * Takes a LocalDate object and returns a LocalDate which is the last day
         * of that month. For example:
         * <p>
         * lastDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 28)
         **/
        private LocalDate lastDayOfMonth(LocalDate date) {
            return date.withDayOfMonth(date.lengthOfMonth());
        }

        /**
         * Takes a LocalDate object and returns a LocalDate which is the next day.
         * For example:
         * <p>
         * nextDay(LocalDate.of(2019, 2, 7))  // => LocalDate.of(2019, 2, 8)
         * nextDay(LocalDate.of(2019, 2, 28)) // => LocalDate.of(2019, 3, 1)
         **/
        private LocalDate nextDay(LocalDate date) {
            return date.plusDays(1);
        }
    }
}
