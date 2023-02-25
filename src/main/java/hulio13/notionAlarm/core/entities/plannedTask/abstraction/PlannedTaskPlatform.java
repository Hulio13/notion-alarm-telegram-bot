package hulio13.notionAlarm.core.entities.plannedTask.abstraction;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hulio13.notionAlarm.database.jsonDb.deserializers.PlannedTaskPlatformDeserializer;
import hulio13.notionAlarm.database.jsonDb.serializers.PlannedTaskPlatformSerializer;

@JsonSerialize(using = PlannedTaskPlatformSerializer.class, as=String.class)
@JsonDeserialize(using = PlannedTaskPlatformDeserializer.class)
public interface PlannedTaskPlatform {
    String getId();
}