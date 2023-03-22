import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;

public class OnlineCoursesAnalyzer {

  public List<Course> courses = new ArrayList<>();

  public OnlineCoursesAnalyzer(String datasetPath) {
    BufferedReader br = null;
    String line;
    try {
      br = new BufferedReader(new FileReader(datasetPath));
      br.readLine();
      while ((line = br.readLine()) != null) {
        String[] info = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
        Course course = new Course(info[0], info[1], new Date(info[2]),
            info[3].replaceAll("\"", ""),
            info[4].replaceAll("\"", ""),
            info[5].replaceAll("\"", ""),
            Integer.parseInt(info[6]), Integer.parseInt(info[7]), Integer.parseInt(info[8]),
            Integer.parseInt(info[9]), Integer.parseInt(info[10]), Double.parseDouble(info[11]),
            Double.parseDouble(info[12]), Double.parseDouble(info[13]),
            Double.parseDouble(info[14]),
            Double.parseDouble(info[15]), Double.parseDouble(info[16]),
            Double.parseDouble(info[17]),
            Double.parseDouble(info[18]), Double.parseDouble(info[19]),
            Double.parseDouble(info[20]),
            Double.parseDouble(info[21]), Double.parseDouble(info[22]));
        courses.add(course);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public Map<String, Integer> getPtcpCountByInst() {
    return this.courses.stream().collect(Collectors.groupingBy(Course::getInstitution,
        Collectors.summingInt(Course::getParticipants)));
  }

  public Map<String, Integer> getPtcpCountByInstAndSubject() {
    Map<String, Integer> ans = new LinkedHashMap<String, Integer>();

    ans = this.courses.stream().collect(Collectors.groupingBy(item -> {
      return item.getInstitution() + "-" + item.getCourseBFSubject();
    }, Collectors.summingInt(Course::getParticipants)));

    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
        ans.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });
    Map<String, Integer> result = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> mapping : list) {
      result.put(mapping.getKey(), mapping.getValue());
    }
    return result;
  }

  private static void insertMapOfLists(Map<String, List<List<String>>> m, int index, String key,
      String val) {
    if (m.containsKey(key)) {
      m.get(key).get(index).add(val);
    } else {
      List<String> l1 = new ArrayList<>();
      List<String> l2 = new ArrayList<>();
      if (index == 0) {
        l1.add(val);
      } else {
        l2.add(val);
      }
      List<List<String>> ll = new ArrayList<>(2);
      ll.add(l1);
      ll.add(l2);
      m.put(key, ll);
    }
  }

  public Map<String, List<List<String>>> getCourseListOfInstructor() {
    Map<String, List<List<String>>> instructorCourses = new HashMap<>();
    for (Iterator<Course> it = this.courses.stream().iterator(); it.hasNext(); ) {
      Course c = it.next();
      String[] instructors = c.getInstructors().split(", ");
      if (instructors.length == 1) {
        insertMapOfLists(instructorCourses, 0, instructors[0], c.getCoursebfTitle());
      } else {
        for (String s : instructors) {
          insertMapOfLists(instructorCourses, 1, s, c.getCoursebfTitle());
        }
      }
    }
    for (String name : instructorCourses.keySet()) {
      List<String> l1 = instructorCourses.get(name).get(0).stream().distinct()
          .collect(Collectors.toList());
      List<String> l2 = instructorCourses.get(name).get(1).stream().distinct()
          .collect(Collectors.toList());
      Collections.sort(l1);
      Collections.sort(l2);
      List<List<String>> ll = new ArrayList<>(2);
      ll.add(l1);
      ll.add(l2);
      instructorCourses.put(name, ll);
    }

    return instructorCourses;
  }

  public List<String> getCourses(int topK, String by) {
    List<String> ans;
    if (by.equals("hours")) {
      ans = this.courses.stream()
          .sorted(Comparator.comparing(Course::getTotalCourseBFHours).reversed())
          .map(Course::getCoursebfTitle).distinct().limit(topK).collect(Collectors.toList());
    } else {
      ans = this.courses.stream().sorted(Comparator.comparing(Course::getParticipants).reversed())
          .map(Course::getCoursebfTitle).distinct().limit(topK).collect(Collectors.toList());

    }
    return ans;
  }

  private boolean check(Course course, String name) {
    return course.getCourseBFSubject().toLowerCase().contains(name.toLowerCase());
  }

  public List<String> searchCourses(String courseSubject, double
      percentAudited, double totalCourseHours) {
    List<String> ans;

    ans = this.courses.stream().filter(a -> (a.getAuditedP() >= percentAudited)
            && (a.getTotalCourseBFHours() <= totalCourseHours)
            && check(a, courseSubject)).map(Course::getCoursebfTitle).distinct()
        .collect(Collectors.toList());

    Collections.sort(ans);

    return ans;

  }

  public Map<String, Double> getAge() {
    return courses.stream().collect(Collectors.groupingBy(Course::getCourseNumber,
        Collectors.averagingDouble(Course::getMedianAge)));
  }

  public Map<String, Double> getMale() {
    return courses.stream().collect(Collectors.groupingBy(Course::getCourseNumber,
        Collectors.averagingDouble(Course::getMale)));
  }

  public Map<String, Double> getB() {
    return courses.stream().collect(Collectors.groupingBy(Course::getCourseNumber,
        Collectors.averagingDouble(Course::getBachelorDegree)));
  }

  public Map<String, String> getName(Map<String, List<Course>> name) {
    Map<String, String> nearest = new HashMap<>();

    for (String key : name.keySet()) {
      String n = name.get(key).stream().max(Comparator.comparing(Course::getLaunchDate))
          .map(Course::getCoursebfTitle).get();
      nearest.put(key, n);
    }
    return nearest;
  }

  public List<String> recommendCourses(int age, int gender, int
      isBachelorOrHigher) {

    List<String> ans;

    Map<String, Double> ages = getAge();
    Map<String, Double> male = getMale();
    Map<String, Double> bachelor = getB();

    Map<String, List<Course>> name = this.courses.stream()
        .collect(Collectors.groupingBy(Course::getCourseNumber));
    Map<String, String> nearest = getName(name);

    ans = this.courses.stream()
        .sorted((a, b) -> {
          double v = Math.pow((double) age - ages.get(a.getCourseNumber()), 2)
              + Math.pow(100 * gender - male.get(a.getCourseNumber()), 2)
              + Math.pow(100 * isBachelorOrHigher - bachelor.get(a.getCourseNumber()), 2);
          double u = Math.pow((double) age - ages.get(b.getCourseNumber()), 2)
              + Math.pow(100 * gender - male.get(b.getCourseNumber()), 2)
              + Math.pow(100 * isBachelorOrHigher - bachelor.get(b.getCourseNumber()), 2);
          if (v == u) {
            return nearest.get(a.getCourseNumber()).compareTo(nearest.get(b.getCourseNumber()));
          }
          return Double.compare(v, u);

        })
        .map(a -> nearest.get(a.getCourseNumber())).distinct().limit(10)
        .collect(Collectors.toList());
    return ans;
  }

  public static void main(String[] args) {
    OnlineCoursesAnalyzer a = new OnlineCoursesAnalyzer("local.csv");
    a.recommendCourses(35, 1, 0).forEach(System.out::println);
  }


}
