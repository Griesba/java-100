package event;

import java.time.Instant;
import java.util.UUID;

public class Event <T>{

    private final UUID uuid;
    private final Class<T> type;
    private final String aggregateId;
    private final T data;
    private final Instant triggeredTime;
    private final UUID commandId;

    private Event(UUID uuid, Class<T> type, String aggregateId, T data, Instant triggeredTime, UUID commandId) {
        this.uuid = uuid;
        this.type = type;
        this.aggregateId = aggregateId;
        this.data = data;
        this.triggeredTime = triggeredTime;
        this.commandId = commandId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Class<T> getType() {
        return type;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public T getData() {
        return data;
    }

    public Instant getTriggeredTime() {
        return triggeredTime;
    }

    public UUID getCommandId() {
        return commandId;
    }

    public static EventBuilder builder() {
        return new EventBuilder<>();
    }
    public static class EventBuilder<T> {
        private UUID uuid;
        private Class<T> type;
        private String aggregateId;
        private T data;
        private Instant triggeredTime;
        private UUID commandId;

        public EventBuilder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public EventBuilder setType(Class<T> type) {
            this.type = type;
            return this;
        }

        public EventBuilder setAggregateId(String aggregateId) {
            this.aggregateId = aggregateId;
            return this;
        }

        public EventBuilder setData(T data) {
            this.data = data;
            return this;
        }

        public EventBuilder setTriggeredTime(Instant triggeredTime) {
            this.triggeredTime = triggeredTime;
            return this;
        }

        public EventBuilder setCommandId(UUID commandId) {
            this.commandId = commandId;
            return this;
        }

        public Event createEvent() {
            return new Event(uuid, type, aggregateId, data, triggeredTime, commandId);
        }
    }
}
