package cleancode.studycafe.myself;

import cleancode.studycafe.myself.exception.AppException;
import cleancode.studycafe.myself.io.InputHandler;
import cleancode.studycafe.myself.io.OutputHandler;
import cleancode.studycafe.myself.io.StudyCafeFileHandler;
import cleancode.studycafe.myself.io.StudyCafeRepository;
import cleancode.studycafe.myself.lockerpass.StudyCafeLockerPass;
import cleancode.studycafe.myself.lockerpass.StudyCafeLockerPasses;
import cleancode.studycafe.myself.studycafepass.StudyCafePass;
import cleancode.studycafe.myself.studycafepass.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeRepository studyCafeRepository = new StudyCafeFileHandler();

    public void run() {
        try {
            // 안내 메시지 출력
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            // Type 선택
            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            // 스터디 카페 목록 조회
            List<StudyCafePass> fixedPasses = getStudyCafePasses(studyCafePassType);

            // 선택할 수 있는 목록 조회
            outputHandler.showPassListForSelection(fixedPasses);

            // 이용권 선택
            StudyCafePass selectedPass = inputHandler.getSelectPass(fixedPasses);

            // 사물함 조회
            StudyCafeLockerPass lockerPass = getLockerPass(selectedPass);

            // 이용 목록 출력
            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private List<StudyCafePass> getStudyCafePasses(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> studyCafePasses = studyCafeRepository.readStudyCafePasses();
        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePassType.equals(studyCafePass.getPassType()))
            .toList();
    }

    private StudyCafeLockerPass getLockerPass(StudyCafePass selectedPass) {
        StudyCafeLockerPasses lockerPasses = new StudyCafeLockerPasses(studyCafeRepository.readLockerPasses());
        StudyCafeLockerPass lockerPass = lockerPasses.getAvailableLockerPass(selectedPass);

        if(lockerPass == null) return null;

        outputHandler.askLockerPass(lockerPass);
        boolean lockerSelection = inputHandler.getLockerSelection();

        if(!lockerSelection) return null;

        return lockerPass;
    }
}
