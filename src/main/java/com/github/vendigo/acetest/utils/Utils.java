package com.github.vendigo.acetest.utils;

import java.util.Collection;
import java.util.Iterator;

public class Utils {
    private Utils() {
    }

    public static <T> T getOnlyElement(Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        T first = iterator.next();
        if (!iterator.hasNext()) {
            return first;
        }

        StringBuilder sb = new StringBuilder().append("expected one element but was: <").append(first);
        for (int i = 0; i < 4 && iterator.hasNext(); i++) {
            sb.append(", ").append(iterator.next());
        }
        if (iterator.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');

        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> T getFirst(Collection<? extends T> collection, T defaultValue) {
        Iterator<? extends T> iterator = collection.iterator();
        return iterator.hasNext() ? iterator.next() : defaultValue;
    }
}
