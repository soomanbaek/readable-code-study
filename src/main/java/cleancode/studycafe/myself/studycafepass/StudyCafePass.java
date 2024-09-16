package cleancode.studycafe.myself.studycafepass;

public interface StudyCafePass {

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

    double getDiscountRate();
    boolean canUseLocker();

    String display();
}
