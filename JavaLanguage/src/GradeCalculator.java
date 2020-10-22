import java.util.ArrayList;

public class GradeCalculator {
    private String name;
    private double preSemeterGrade;
    private int creditsTaken;
    // 수강과목 리스트 생성
    ArrayList<Course> courseToBeTaken = new ArrayList<>();
    // 생성자 인수 : 이름, 직전학기 평점, 이수학점
    public GradeCalculator (String name, double preSemeterGrade, int creditsTaken){
        this.name = name;
        this.preSemeterGrade = preSemeterGrade;
        this.creditsTaken = creditsTaken;
    }

    // 수강과목 추가
    public void addCourse (Course course){
        courseToBeTaken.add(course);
    }

    // 이수학점 총합 계산 메소드
    public int getTotalCredit (ArrayList<Course> courses){
        int totalCredit = 0;
        for (Course course: courses) {
            totalCredit += course.getCredit();
        }
        return totalCredit;
    }

    // 이수과목의 평균학점 계산메소드
    public double getAverageGrade (ArrayList<Course> courses){
        double averageGrade = 0;
        for (Course course: courses) {
            averageGrade += course.getCredit() * course.getGradeToNum();
        }
        averageGrade = averageGrade / getTotalCredit(courses);
        return averageGrade;
    }

    // 전체과목의 평균학점 계산 메소드
    public double getTotalAverageGrade (ArrayList<Course> courses){
        double averageGrade = 0;
        for (Course course: courses) {
            averageGrade += course.getCredit() * course.getGradeToNum();
        }
        averageGrade += preSemeterGrade * creditsTaken;
        averageGrade = averageGrade / (getTotalCredit(courses) + creditsTaken);
        return averageGrade;
    }

    // 전체 학점 출력
    public void print(){
        System.out.println("직전 학기 성적: "+this.preSemeterGrade+" (총 "+this.creditsTaken+"학점)");
        System.out.println("이번 학기 성적: "+getAverageGrade(courseToBeTaken)+" (총 "+getTotalCredit(courseToBeTaken)+"학점)");
        System.out.println("전체 예상 학점: "+getTotalAverageGrade(courseToBeTaken)+" (총 "+(getTotalCredit(courseToBeTaken)+creditsTaken)+"학점)");
    }
}
