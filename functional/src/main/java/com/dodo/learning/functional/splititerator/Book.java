package com.dodo.learning.functional.splititerator;

public class Book {

    private String name;
    private String author;
    private String genere;
    private String rating;

    public Book(String name, String author, String genere, String rating) {
        this.name = name;
        this.author = author;
        this.genere = genere;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override public String toString() {
        return "Book{" + "name='" + name + '\'' + ", author='" + author + '\'' + ", genere='" + genere + '\'' + ", rating='" + rating + '\'' + '}';
    }
}
