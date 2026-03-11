public class BuilderDemo {
    public static void main(String[] args) {
        User u = new User.Builder()
                .firstName("Devraj")
                .lastName("Patel")
                .email("devraj@example.com")
                .age(21)
                .build();

        System.out.println(u);
    }
}

class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;

    private User(Builder b) {
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.email = b.email;
        this.age = b.age;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private int age;

        public Builder firstName(String v) { this.firstName = v; return this; }
        public Builder lastName(String v) { this.lastName = v; return this; }
        public Builder email(String v) { this.email = v; return this; }
        public Builder age(int v) { this.age = v; return this; }

        public User build() { return new User(this); }
    }

    @Override
    public String toString() {
        return "User{firstName='%s', lastName='%s', email='%s', age=%d}"
                .formatted(firstName, lastName, email, age);
    }
}