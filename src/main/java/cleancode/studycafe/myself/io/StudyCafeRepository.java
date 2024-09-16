package cleancode.studycafe.myself.io;

import cleancode.studycafe.myself.lockerpass.StudyCafeLockerPass;
import cleancode.studycafe.myself.studycafepass.StudyCafePass;

import java.util.List;

public interface StudyCafeRepository {
    List<StudyCafePass> readStudyCafePasses();
    List<StudyCafeLockerPass> readLockerPasses();
}
