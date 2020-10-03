package command;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Command <T> {
    private final UUID uuid;
    private final String aggregateId;
    private final Instant publishedTime;
    private final Class<T> type;
    private final T data;

    private Command(UUID uuid, String aggregateId, Instant publishedTime, Class<T> type, T data) {
        this.uuid = uuid;
        this.aggregateId = aggregateId;
        this.publishedTime = publishedTime;
        this.type = type;
        this.data = data;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public Instant getPublishedTime() {
        return publishedTime;
    }

    public Class<T> getType() {
        return type;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command<?> command = (Command<?>) o;
        return Objects.equals(uuid, command.uuid) &&
                Objects.equals(aggregateId, command.aggregateId) &&
                Objects.equals(publishedTime, command.publishedTime) &&
                Objects.equals(type, command.type) &&
                Objects.equals(data, command.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, aggregateId, publishedTime, type, data);
    }

    public static CommandBuilder builder() {
        return new CommandBuilder();
    }
    public static class CommandBuilder<T> {
        private UUID uuid;
        private String aggregateId;
        private Instant publishedTime;
        private Class<T> type;
        private T data;

        private CommandBuilder() {
        }

        public CommandBuilder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public CommandBuilder setAggregateId(String aggregateId) {
            this.aggregateId = aggregateId;
            return this;
        }

        public CommandBuilder setPublishedTime(Instant publishedTime) {
            this.publishedTime = publishedTime;
            return this;
        }

        public CommandBuilder setType(Class<T> type) {
            this.type = type;
            return this;
        }

        public CommandBuilder setData(T data) {
            this.data = data;
            return this;
        }

        public Command createCommand() {
            return new Command(uuid, aggregateId, publishedTime, type, data);
        }
    }
}
