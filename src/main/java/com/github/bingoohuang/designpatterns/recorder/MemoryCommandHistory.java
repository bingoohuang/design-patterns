package com.github.bingoohuang.designpatterns.recorder;

import com.github.bingoohuang.designpatterns.utils.Function;
import com.github.bingoohuang.designpatterns.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MemoryCommandHistory implements CommandHistory {
    List<History> histories = new ArrayList<>();

    @Override
    public void saveHistory(String commandLine, String result) {
        histories.add(new History(commandLine, result));
    }

    @Override
    public String showHistory() {
        return Utils.foldLeft(histories, "", new Function<String, History>() {
            @Override
            public String apply(String fold, History history) {
                return fold + history;
            }
        });
    }
}
