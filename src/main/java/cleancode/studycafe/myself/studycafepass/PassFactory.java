package cleancode.studycafe.myself.studycafepass;

public class PassFactory {
    public static StudyCafePass create(StudyCafePassType type, int duration, int price, double discountRate){
        if(StudyCafePassType.HOURLY.equals(type)){
            return HourlyPass.of(type, duration, price, discountRate);
        }
        if(StudyCafePassType.WEEKLY.equals(type)){
            return WeeklyPass.of(type, duration, price, discountRate);
        }
        if(StudyCafePassType.FIXED.equals(type)){
            return FixedPass.of(type, duration, price, discountRate);
        }
        throw new RuntimeException("조회되지 않는 타입입니다.");
    }
}
