import java.util.*;

public class CompositeDemo {
    public static void main(String[] args) {
        EmployeeNode dev1 = new Developer("Dev1", "Java");
        EmployeeNode dev2 = new Developer("Dev2", "Spring");
        ManagerNode mgr = new ManagerNode("Manager-A");

        mgr.add(dev1);
        mgr.add(dev2);

        mgr.showDetails();
    }
}

interface EmployeeNode {
    void showDetails();
}

class Developer implements EmployeeNode {
    private final String name;
    private final String skill;

    public Developer(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    public void showDetails() {
        System.out.println("Developer: " + name + " | Skill: " + skill);
    }
}

class ManagerNode implements EmployeeNode {
    private final String name;
    private final List<EmployeeNode> team = new ArrayList<>();

    public ManagerNode(String name) { this.name = name; }

    public void add(EmployeeNode e) { team.add(e); }
    public void remove(EmployeeNode e) { team.remove(e); }

    public void showDetails() {
        System.out.println("Manager: " + name);
        for (EmployeeNode e : team) e.showDetails();
    }
}