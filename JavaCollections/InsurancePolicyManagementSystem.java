package JavaCollections;
import java.time.LocalDate;
import java.util.*;

class InsurancePolicyManagement {

    static class Policy {
        String no, name, type;
        LocalDate exp;
        double premium;

        Policy(String no, String name, LocalDate exp, String type, double premium) {
            this.no = no; this.name = name; this.exp = exp; this.type = type; this.premium = premium;
        }
        @Override public boolean equals(Object o) {
            return (o instanceof Policy) && no.equals(((Policy)o).no); // unique by policy no
        }
        @Override public int hashCode() { return no.hashCode(); }
        @Override public String toString() { return no+" | "+name+" | "+type+" | "+exp+" | "+premium; }
    }

    static Comparator<Policy> BY_EXP = (a,b) -> {
        int c = a.exp.compareTo(b.exp);
        if (c != 0) return c;
        return a.no.compareTo(b.no);
    };

    static class Manager {
        Set<Policy> hs = new HashSet<>();
        Set<Policy> lhs = new LinkedHashSet<>();
        Set<Policy> ts = new TreeSet<>(BY_EXP);

        boolean add(Policy p){
            boolean ok = hs.add(p);
            lhs.add(p); ts.add(p);
            return ok;
        }

        List<Policy> expiringIn(int days){
            LocalDate now = LocalDate.now(), limit = now.plusDays(days);
            List<Policy> res = new ArrayList<>();
            for(Policy p: ts)
                if(!p.exp.isBefore(now) && !p.exp.isAfter(limit)) res.add(p);
            return res;
        }

        List<Policy> byType(String type){
            List<Policy> res = new ArrayList<>();
            for(Policy p: hs) if(p.type.equalsIgnoreCase(type)) res.add(p);
            return res;
        }

        static Map<String,Integer> duplicates(List<Policy> raw){
            Map<String,Integer> c = new HashMap<>();
            for(Policy p: raw) c.put(p.no, c.getOrDefault(p.no,0)+1);
            c.entrySet().removeIf(e -> e.getValue() == 1);
            return c;
        }
    }

    static long timeAdd(Set<Policy> s, List<Policy> data){
        long st = System.nanoTime();
        for(Policy p: data) s.add(p);
        return System.nanoTime()-st;
    }
    static long timeSearch(Set<Policy> s, List<Policy> keys){
        long st = System.nanoTime();
        for(Policy k: keys) s.contains(k);
        return System.nanoTime()-st;
    }
    static long timeRemove(Set<Policy> s, List<Policy> data){
        long st = System.nanoTime();
        for(Policy p: data) s.remove(p);
        return System.nanoTime()-st;
    }

    public static void main(String[] args) {
        Manager m = new Manager();

        List<Policy> raw = Arrays.asList(
                new Policy("P1","Amit", LocalDate.now().plusDays(10), "Health", 12000),
                new Policy("P2","Neha", LocalDate.now().plusDays(40), "Auto",   8000),
                new Policy("P3","Ravi", LocalDate.now().plusDays(25), "Home",  15000),
                new Policy("P1","Amit2",LocalDate.now().plusDays(90), "Health", 9999) // duplicate
        );

        System.out.println("Duplicates in raw input: " + Manager.duplicates(raw));

        for(Policy p: raw){
            if(!m.add(p)) System.out.println("Not added duplicate policyNo: " + p.no);
        }

        System.out.println("\nAll unique (HashSet): " + m.hs);
        System.out.println("Insertion order (LinkedHashSet): " + m.lhs);
        System.out.println("Sorted by expiry (TreeSet): " + m.ts);

        System.out.println("\nExpiring in 30 days: " + m.expiringIn(30));
        System.out.println("Coverage type Auto: " + m.byType("Auto"));

        // Performance comparison (small demo; increase n for stronger results)
        int n = 100000;
        List<Policy> big = new ArrayList<>(n);
        LocalDate base = LocalDate.now();
        for(int i=0;i<n;i++){
            big.add(new Policy("POL"+i, "H"+i, base.plusDays(i%365), (i%2==0?"Health":"Auto"), 5000+i));
        }
        List<Policy> keys = new ArrayList<>();
        for(int i=0;i<n/2;i++) keys.add(big.get(i));                    // existing
        for(int i=0;i<n/2;i++) keys.add(new Policy("X"+i,"",base,"",0)); // not existing

        Set<Policy> hs = new HashSet<>();
        Set<Policy> lhs = new LinkedHashSet<>();
        Set<Policy> ts = new TreeSet<>(BY_EXP);

        System.out.println("\n--- Performance (ns) n="+n+" ---");
        System.out.println("Add    HS:"+timeAdd(hs,big)+"  LHS:"+timeAdd(lhs,big)+"  TS:"+timeAdd(ts,big));
        System.out.println("Search HS:"+timeSearch(hs,keys)+" LHS:"+timeSearch(lhs,keys)+" TS:"+timeSearch(ts,keys));
        System.out.println("Remove HS:"+timeRemove(hs,big)+" LHS:"+timeRemove(lhs,big)+" TS:"+timeRemove(ts,big));
    }
}