public class CommandDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command on = new LightOnCommand(light);
        Command off = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(on);
        remote.press();

        remote.setCommand(off);
        remote.press();
    }
}

interface Command { void execute(); }

class Light {
    void on() { System.out.println("Light ON"); }
    void off() { System.out.println("Light OFF"); }
}

class LightOnCommand implements Command {
    private final Light light;
    LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.on(); }
}

class LightOffCommand implements Command {
    private final Light light;
    LightOffCommand(Light light) { this.light = light; }
    public void execute() { light.off(); }
}

class RemoteControl {
    private Command command;
    void setCommand(Command command) { this.command = command; }
    void press() {
        if (command == null) throw new IllegalStateException("No command set");
        command.execute();
    }
}