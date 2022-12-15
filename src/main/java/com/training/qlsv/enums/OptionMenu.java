package com.training.qlsv.enums;

import java.util.HashMap;
import java.util.Map;

public enum OptionMenu {
    OPTION_ONE(1),
    OPTION_TWO(2),
    OPTION_THREE(3),
    OPTION_FOUR(4),
    OPTION_FIVE(5);

    OptionMenu(Integer value) {
        this.value = value;
    }
    private Integer value;

    private static final Map<Integer, OptionMenu> hashMap  = new HashMap<>();

    static {
        for (OptionMenu optionMenu : OptionMenu.values()){
            hashMap.put(optionMenu.value, optionMenu);
        }
    }

    public static OptionMenu of(Integer s){
        return hashMap.get(s);
    }
}
