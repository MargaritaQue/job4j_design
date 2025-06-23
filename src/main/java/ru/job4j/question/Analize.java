package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> cur = new HashMap<>();
        int identical = 0;
        for (User user : current) {
            cur.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            if (cur.containsKey(user.getId())) {
                if (!cur.get(user.getId()).equals(user.getName())) {
                    info.setChanged(info.getChanged() + 1);
                } else {
                    identical++;
                }
            } else {
                info.setDeleted(info.getDeleted() + 1);
            }
        }
        info.setAdded(current.size() - info.getChanged() - identical);
        return info;
    }
}