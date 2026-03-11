public class ProxyDemo {
    public static void main(String[] args) {
        FileService admin = new FileAccessProxy("ADMIN");
        admin.readFile("secret.txt");

        FileService guest = new FileAccessProxy("GUEST");
        guest.readFile("secret.txt");
    }
}

interface FileService {
    void readFile(String name);
}

class RealFileService implements FileService {
    public void readFile(String name) {
        System.out.println("Reading file: " + name);
    }
}

class FileAccessProxy implements FileService {
    private final String role;
    private final FileService real = new RealFileService();

    public FileAccessProxy(String role) {
        this.role = role;
    }

    public void readFile(String name) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            System.out.println("Access denied for role: " + role);
            return;
        }
        real.readFile(name);
    }
}