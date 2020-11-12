package com.dodo.learning.functional.splititerator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class BookSplitIterator implements Spliterator<Book> {

    private String name;
    private String author;
    private String genere;
    private String rating;

    private Spliterator<String> baseSplitIterator;

    public BookSplitIterator(Spliterator<String> baseSplitIterator) {
        this.baseSplitIterator = baseSplitIterator;
    }

    @Override public boolean tryAdvance(Consumer<? super Book> action) {
        if( (this.baseSplitIterator.tryAdvance( (name) -> this.name = name)) &&
                this.baseSplitIterator.tryAdvance( (author) -> this.author = author) &&
                this.baseSplitIterator.tryAdvance((genere) -> this.author = genere) &&
                this.baseSplitIterator.tryAdvance( (rating) -> Double.valueOf(rating)) ) {
            action.accept(new Book(this.name, this.author, this.genere, this.rating));
            return true;
        }
        return false;
    }

    @Override public Spliterator<Book> trySplit() {
        return null;
    }

    @Override public long estimateSize() {
        return baseSplitIterator.estimateSize()/4;
    }

    @Override public int characteristics() {
        return 0;
    }
}
