package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

// Интерфейс комманд
interface Command{
    void execute();
}

// Receiver
class Shell{
    public void showDate(){
        System.out.println("Текущая дата: " + LocalDate.now());
    }
    public void showTime(){
        System.out.println("Текущая дата: " + LocalTime.now());
    }
    public void showPWD(){
        System.out.println("Текущая директория: " + System.getProperty("user.dir"));
    }
    public void exit(){
        System.exit(0);
    }
}

// Комманды
class DateCommand implements Command{
    public DateCommand(Shell shell){
        this.shell = shell;
    }
    public void execute(){
        shell.showDate();
    }
    private Shell shell;
}
class TimeCommand implements Command{
    public TimeCommand(Shell shell){
        this.shell = shell;
    }
    public void execute(){
        shell.showTime();
    }
    private Shell shell;
}
class PWDCommand implements Command{
    public PWDCommand(Shell shell){
        this.shell = shell;
    }
    public void execute(){
        shell.showPWD();
    }
    private Shell shell;
}
class ExitCommand implements Command{
    public ExitCommand(Shell shell){
        this.shell = shell;
    }
    public void execute(){
        shell.exit();
    }
    private Shell shell;
}
class HelpCommand implements Command{
    public HelpCommand(ShellInvoker invoker){
        this.invoker = invoker;
    }
    public void execute(){
        System.out.println("Доступные команды:");
        for(Map.Entry<String, CommandInfo> entry: invoker.getCommands().entrySet()){
            System.out.println(" " + entry.getKey() + " - " + entry.getValue().getDescription());
        }
    }
    private ShellInvoker invoker;
}

class CommandInfo{
    private Command command;
    private String description;

    public CommandInfo(Command command, String description){
        this.command = command;
        this.description = description;
    }

    public Command getCommand() {
        return command;
    }
    public String getDescription() {
        return description;
    }
}

// Invoker
class ShellInvoker{
    public Map<String, CommandInfo> getCommands() {
        return commands;
    }
    public void registerCommand(String command_name, Command command, String description){
        commands.put(command_name, new CommandInfo(command, description));
    }
    public void executeCommand(String command_name){
        if (commands.containsKey(command_name)){
            CommandInfo command_info = commands.get(command_name);
            command_info.getCommand().execute();
        }
        else {
            System.out.println("Ошибка: неизвестная команда '" + command_name +"'");
        }
    }

    private Map<String, CommandInfo> commands = new HashMap<>();
}

public class ShellApp {
    public static void main(String[] args) {
        Shell shell = new Shell();
        ShellInvoker invoker = new ShellInvoker();

        // Регистрация команд с описаниями
        invoker.registerCommand("date", new DateCommand(shell), "выводит текущую дату ");
        invoker.registerCommand("time", new TimeCommand(shell), "выводит текущее время");
        invoker.registerCommand("pwd", new PWDCommand(shell), "выводит текущий рабочий каталог");
        invoker.registerCommand("exit", new ExitCommand(shell), "завершает работу приложения ");
        invoker.registerCommand("help", new HelpCommand(invoker), "выводит список доступных команд");

        // Консольный ввод
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                invoker.executeCommand(input);
            }
        }
    }
}