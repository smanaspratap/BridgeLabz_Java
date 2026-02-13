package JavaGenerics;
/*5. AI-Driven Resume Screening System
Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards
Problem Statement:
Develop an AI-Driven Resume Screening System that can process resumes for different job roles like Software Engineer, Data Scientist, and Product Manager while ensuring type safety.
Hints:
Create an abstract class JobRole (SoftwareEngineer, DataScientist, ProductManager).
Implement a generic class Resume<T extends JobRole> to process resumes dynamically.
Use a wildcard method (List<? extends JobRole>) to handle multiple job roles in the screening pipeline.

*/
// ResumeScreening.java
import java.util.*;

// Base job role and concrete roles
abstract class JobRole {
    public abstract String roleName();
}

class SoftwareEngineer extends JobRole {
    public String roleName() { return "Software Engineer"; }
}

class DataScientist extends JobRole {
    public String roleName() { return "Data Scientist"; }
}

class ProductManager extends JobRole {
    public String roleName() { return "Product Manager"; }
}

// Generic Resume class parameterized by JobRole
class Resume<T extends JobRole> {
    private final String candidateName;
    private final T role;
    private final Map<String, Object> metadata; // e.g., skills, experience years

    public Resume(String candidateName, T role, Map<String, Object> metadata) {
        this.candidateName = candidateName;
        this.role = role;
        this.metadata = metadata;
    }

    public String getCandidateName() { return candidateName; }
    public T getRole() { return role; }
    public Map<String, Object> getMetadata() { return metadata; }

    @Override
    public String toString() {
        return candidateName + " -> " + role.roleName() + " : " + metadata;
    }
}

// Screening system that can process resumes for any JobRole using wildcards
class ScreeningPipeline {
    // We accept a list of Resume<? extends JobRole> to support mixed roles in a single pipeline
    public static void processResumes(List<Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> r : resumes) {
            // Example simple screening rule - check for 'yearsExperience' >= 2 (just demo)
            Object yrs = r.getMetadata().get("yearsExperience");
            int years = (yrs instanceof Number) ? ((Number) yrs).intValue() : 0;
            boolean passed = years >= 2;

            System.out.printf("%s : %s => %s (years=%d)%n",
                    r.getCandidateName(), r.getRole().roleName(), passed ? "SHORTLIST" : "REJECT", years);
        }
    }
}

// Demo
public class ResumeScreening {
    public static void main(String[] args) {
        Map<String, Object> meta1 = new HashMap<>();
        meta1.put("yearsExperience", 3);
        meta1.put("skills", Arrays.asList("Java", "Spring"));

        Map<String, Object> meta2 = new HashMap<>();
        meta2.put("yearsExperience", 1);
        meta2.put("skills", Arrays.asList("Python", "Pandas"));

        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer(), meta1);
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist(), meta2);

        List<Resume<? extends JobRole>> batch = Arrays.asList(r1, r2);
        ScreeningPipeline.processResumes(batch);
    }
}

