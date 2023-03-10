package hulio13.notionAlarm.core.entities;

import com.fasterxml.jackson.annotation.*;
import hulio13.notionAlarm.core.entities.plannedTask.PlannedTask;

import java.util.*;

public final class User {
    public final String telegramId;
    private Map<String, String> tokens;
    @JsonManagedReference
    private final List<PlannedTask> plannedTasks;

    public User(String telegramId) {
        this.telegramId = telegramId;
        this.plannedTasks = new LinkedList<>();
    }

    @JsonCreator
    public User(@JsonProperty("telegramId") String telegramId, @JsonProperty("tokens") Map<String, String> tokens, @JsonProperty("plannedTasks") List<PlannedTask> plannedTasks){
        this.telegramId = telegramId;
        this.plannedTasks = plannedTasks;
        this.tokens = tokens;
    }

    public User (String telegramId, Map<String, String> tokens){
        this(telegramId, tokens, new LinkedList<>());
    }
    public String getTokenById(String id) {
        return tokens.get(id);
    }

    public void addToken(String id, String token) {
        tokens.put(id, token);
    }
    public void removeToken(String id) {
        tokens.remove(id);
    }

    public void addPlannedTask(PlannedTask plannedTask){
        plannedTasks.add(plannedTask);
    }
    public void addPlannedTasks(List<PlannedTask> plannedTasks) {this.plannedTasks.addAll(plannedTasks);}

    public List<PlannedTask> getPlannedTasks(){
        return Collections.unmodifiableList(plannedTasks);
    }
}
