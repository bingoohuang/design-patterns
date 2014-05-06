package oom.github.bingoohuang.designpatterns;

public class BadCommand implements Command {
    @Override
    public String execute() {
        return "command unknown";
    }
}
