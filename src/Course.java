import java.util.Date;

public class Course {
    private String Institution;
    private String Course_Number;
    private Date Launch_Date;
    private String CourseBF_Title;
    private String Instructors;
    private String CourseBF_Subject;
    private int Year;
    private int Honor_Code_Certificates;
    private int Participants;
    private int Audited;
    private int Certified;
    private double Audited_p;
    private double Certified_p;
    private double Certified_50;
    private double Played_Video;
    private double Posted_in_Forum;
    private double Grade_Higher_Than_Zero;
    private double Total_CourseBF_Hours;
    private double Median_Hours_for_Certification;
    private double Median_Age;
    private double Male;
    private double Female;
    private double Bachelor_Degree;


    public Course(String institution, String course_Number, Date launch_Date, String courseBF_Title, String instructors, String courseBF_Subject, int year, int honor_Code_Certificates, int participants, int audited, int certified, double audited_p, double certified_p, double certified_50, double played_Video, double posted_in_Forum, double grade_Higher_Than_Zero, double total_CourseBF_Hours, double median_Hours_for_Certification, double median_Age, double male, double female, double bachelor_Degree) {
        Institution = institution;
        Course_Number = course_Number;
        Launch_Date = launch_Date;
        CourseBF_Title = courseBF_Title;
        Instructors = instructors;
        CourseBF_Subject = courseBF_Subject;
        Year = year;
        Honor_Code_Certificates = honor_Code_Certificates;
        Participants = participants;
        Audited = audited;
        Certified = certified;
        Audited_p = audited_p;
        Certified_p = certified_p;
        Certified_50 = certified_50;
        Played_Video = played_Video;
        Posted_in_Forum = posted_in_Forum;
        Grade_Higher_Than_Zero = grade_Higher_Than_Zero;
        Total_CourseBF_Hours = total_CourseBF_Hours;
        Median_Hours_for_Certification = median_Hours_for_Certification;
        Median_Age = median_Age;
        Male = male;
        Female = female;
        Bachelor_Degree = bachelor_Degree;
    }

    public String getInstitution() {
        return Institution;
    }

    public String getCourse_Number() {
        return Course_Number;
    }

    public Date getLaunch_Date() {
        return Launch_Date;
    }

    public String getCourseBF_Title() {
        return CourseBF_Title;
    }

    public String getInstructors() {
        return Instructors;
    }

    public String getCourseBF_Subject() {
        return CourseBF_Subject;
    }

    public int getYear() {
        return Year;
    }

    public int getHonor_Code_Certificates() {
        return Honor_Code_Certificates;
    }

    public int getParticipants() {
        return Participants;
    }

    public int getAudited() {
        return Audited;
    }

    public int getCertified() {
        return Certified;
    }

    public double getAudited_p() {
        return Audited_p;
    }

    public double getCertified_p() {
        return Certified_p;
    }

    public double getCertified_50() {
        return Certified_50;
    }

    public double getPlayed_Video() {
        return Played_Video;
    }

    public double getPosted_in_Forum() {
        return Posted_in_Forum;
    }

    public double getGrade_Higher_Than_Zero() {
        return Grade_Higher_Than_Zero;
    }

    public double getTotal_CourseBF_Hours() {
        return Total_CourseBF_Hours;
    }

    public double getMedian_Hours_for_Certification() {
        return Median_Hours_for_Certification;
    }

    public double getMedian_Age() {
        return Median_Age;
    }

    public double getMale() {
        return Male;
    }

    public double getFemale() {
        return Female;
    }

    public double getBachelor_Degree() {
        return Bachelor_Degree;
    }
}
