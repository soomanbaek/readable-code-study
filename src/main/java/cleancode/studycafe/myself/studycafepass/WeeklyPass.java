package cleancode.studycafe.myself.studycafepass;

public class WeeklyPass implements StudyCafePass{
    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private WeeklyPass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static WeeklyPass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new WeeklyPass(passType, duration, price, discountRate);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public boolean canUseLocker() {
        return false;
    }

    public String display() {
        return String.format("%s주권 - %d원", duration, price);
    }
}
