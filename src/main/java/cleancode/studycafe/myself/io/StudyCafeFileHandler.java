package cleancode.studycafe.myself.io;

import cleancode.studycafe.myself.lockerpass.StudyCafeLockerPass;
import cleancode.studycafe.myself.studycafepass.PassFactory;
import cleancode.studycafe.myself.studycafepass.StudyCafePass;
import cleancode.studycafe.myself.studycafepass.StudyCafePassType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler implements StudyCafeRepository {
    private static final String STUDY_CAFE_PASS_FILE_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";
    private static final String LOCKER_PASS_FILE_PATH = "src/main/resources/cleancode/studycafe/locker.csv";

    public List<StudyCafePass> readStudyCafePasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDY_CAFE_PASS_FILE_PATH));

            List<StudyCafePass> studyCafePasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);

                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                StudyCafePass studyCafePass = PassFactory.create(studyCafePassType, duration, price, discountRate);

                studyCafePasses.add(studyCafePass);
            }

            return studyCafePasses;
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(LOCKER_PASS_FILE_PATH));

            List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);

                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);

                StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(studyCafePassType, duration, price);
                lockerPasses.add(lockerPass);
            }

            return lockerPasses;
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

}
