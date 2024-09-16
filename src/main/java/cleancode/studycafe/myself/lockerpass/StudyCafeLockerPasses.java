package cleancode.studycafe.myself.lockerpass;

import cleancode.studycafe.myself.lockerpass.StudyCafeLockerPass;
import cleancode.studycafe.myself.studycafepass.StudyCafePass;

import java.util.List;

public class StudyCafeLockerPasses {
    private final List<StudyCafeLockerPass> lockerPasses;

    public StudyCafeLockerPasses(List<StudyCafeLockerPass> lockerPasses){
        this.lockerPasses = lockerPasses;
    }

    public StudyCafeLockerPass getAvailableLockerPass(StudyCafePass selectedPass){
        return lockerPasses.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
            )
            .findFirst()
            .orElse(null);
    }
}
