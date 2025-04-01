package technical.challenges;

import java.util.Optional;

public class UserStats {
    Optional<Long> visitCount;

    UserStats(Optional<Long> visits) {
        this.visitCount = visits;
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }
}
