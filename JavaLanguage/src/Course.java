public class Course {
    public static final int CREDIT_MAJOR = 3;
    public static final int CREDIT_GENERAL = 2;

    // 인스턴스 변수
    private String subject;
    private int credit;
    private String grade;

    // 클래스 생성자 : 과목, 학점, 점수
    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    // 이수학점 getter
    public int getCredit() {
        return this.credit;
    }

    // 문자점수를 숫자로 바꾸는 메소드
    public double getGradeToNum() {
        double gradeInt = 0;
        if (this.grade.equals("A+")){
            gradeInt = 4.5;
        }else if (this.grade.equals("A")){
            gradeInt = 4.0;
        }
        else if (this.grade.equals("B+")){
            gradeInt = 3.5;
        }
        else if (this.grade.equals("B")){
            gradeInt = 3.0;
        }
        else if (this.grade.equals("C+")){
            gradeInt = 2.5;
        }
        else if (this.grade.equals("C")){
            gradeInt = 2.0;
        }
        else if (this.grade.equals("D+")){
            gradeInt = 1.5;
        }
        else if (this.grade.equals("D")){
            gradeInt = 1.0;
        }
        else if (this.grade.equals("F")){
            gradeInt = 0.0;
        }

        return gradeInt;
    }


}
