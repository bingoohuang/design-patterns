package com.github.bingoohuang.designpatterns;

public class CommandMemento {
    private Command undoCommand;

    public void setUndoCommand(Command undoCommand) {
        this.undoCommand = undoCommand;
    }

    public void undo() {
        if (undoCommand != null) undoCommand.execute();
        undoCommand = null;
    }
}
