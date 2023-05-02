package io.github.lantalex;


public interface Int2IntMap {
    int get(final int key);

    int put(final int key, final int value);

    int remove(final int key);

    int size();

    void forEntries(EntryConsumer consumer);

    @FunctionalInterface
    interface EntryConsumer {
        void accept(int key, int value);
    }
}