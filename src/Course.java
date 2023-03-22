import java.util.Date;

public class Course {

  private String institution;
  private String courseNumber;
  private Date launchDate;
  private String coursebfTitle;
  private String instructors;
  private String courseBFSubject;
  private int year;
  private int honorCodeCertificates;
  private int participants;
  private int audited;
  private int certified;
  private double auditedP;
  private double certifiedP;
  private double certified50;
  private double playedVideo;
  private double postedInForum;
  private double gradeHigherThanZero;
  private double totalCourseBFHours;
  private double medianHoursForCertification;
  private double medianAge;
  private double male;
  private double female;
  private double bachelorDegree;


  public Course(String institution, String courseNumber, Date date, String courseBFTitle,
      String instructors, String courseBFSubject, int year, int honorCodeCertificates,
      int participants, int audited, int certified, double auditedP, double certifiedP,
      double certified50, double playedVideo, double postedInForum,
      double gradeHigherThanZero, double totalCourseBFHours,
      double medianHoursForCertification, double medianAge, double male, double female,
      double bachelorDegree) {
    this.institution = institution;
    this.courseNumber = courseNumber;
    launchDate = date;
    coursebfTitle = courseBFTitle;
    this.instructors = instructors;
    this.courseBFSubject = courseBFSubject;
    this.year = year;
    this.honorCodeCertificates = honorCodeCertificates;
    this.participants = participants;
    this.audited = audited;
    this.certified = certified;
    this.auditedP = auditedP;
    this.certifiedP = certifiedP;
    this.certified50 = certified50;
    this.playedVideo = playedVideo;
    this.postedInForum = postedInForum;
    this.gradeHigherThanZero = gradeHigherThanZero;
    this.totalCourseBFHours = totalCourseBFHours;
    this.medianHoursForCertification = medianHoursForCertification;
    this.medianAge = medianAge;
    this.male = male;
    this.female = female;
    this.bachelorDegree = bachelorDegree;
  }

  public String getInstitution() {
    return institution;
  }

  public String getCourseNumber() {
    return courseNumber;
  }

  public Date getLaunchDate() {
    return launchDate;
  }

  public String getCoursebfTitle() {
    return coursebfTitle;
  }

  public String getInstructors() {
    return instructors;
  }

  public String getCourseBFSubject() {
    return courseBFSubject;
  }

  public int getYear() {
    return year;
  }

  public int getHonorCodeCertificates() {
    return honorCodeCertificates;
  }

  public int getParticipants() {
    return participants;
  }

  public int getAudited() {
    return audited;
  }

  public int getCertified() {
    return certified;
  }

  public double getAuditedP() {
    return auditedP;
  }

  public double getCertifiedP() {
    return certifiedP;
  }

  public double getCertified50() {
    return certified50;
  }

  public double getPlayedVideo() {
    return playedVideo;
  }

  public double getPostedInForum() {
    return postedInForum;
  }

  public double getGradeHigherThanZero() {
    return gradeHigherThanZero;
  }

  public double getTotalCourseBFHours() {
    return totalCourseBFHours;
  }

  public double getMedianHoursForCertification() {
    return medianHoursForCertification;
  }

  public double getMedianAge() {
    return medianAge;
  }

  public double getMale() {
    return male;
  }

  public double getFemale() {
    return female;
  }

  public double getBachelorDegree() {
    return bachelorDegree;
  }
}
