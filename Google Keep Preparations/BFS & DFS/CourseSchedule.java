import java.util.ArrayList;

class Course {
    private boolean visiting;
    private boolean done;
    private ArrayList<Course> pre = new ArrayList<>();

    void addPre(Course preCourse) {
        this.pre.add(preCourse);
    }

    boolean isCyclic() {
        if (done) {
            return false;
        }

        if (visiting) {
            return true;
        }

        visiting = true;

        for (Course preCourse: pre) {
            if (preCourse.isCyclic()) {
                return true;
            }
        }

        visiting = false;
        done = true;
        return false;
    }
}

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course courseList[] = new Course[numCourses];

        for (int i=0; i<numCourses; i++) {
            courseList[i] = new Course();
        }

        for (int[] couple: prerequisites) {
            Course c1 = courseList[couple[0]];
            Course c2 = courseList[couple[1]];
            c1.addPre(c2);
        }

        for (int i=0; i<numCourses; i++) {
            if (courseList[i].isCyclic()) {
                return false;
            }
        }

        return true;
    }    
}