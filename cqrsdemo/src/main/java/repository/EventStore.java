package repository;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import event.Event;

import java.util.List;

public class EventStore {

    private Multimap<String, Event> aggregateEvents = ArrayListMultimap.create();

    public void save(final Event event) {
        aggregateEvents.put(event.getAggregateId(), event);
    }

    public List<Event> history(final String aggregateId) {
        return ImmutableList.copyOf(aggregateEvents.get(aggregateId));
    }

    @VisibleForTesting
    public void clear(){
        aggregateEvents.clear();
    }



}
