package chapter12;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {
    public FormattedGradeLecture(int pass, String title, List<Integer> scores, List<Grade> grades) {
        super(pass, title, scores, grades);
    }

    public String formatAverage() {
        // GradeLecture에는 존재 X
        // Lecture 존재
        return String.format("Avg: %1.1f", super.average());
    }
}
