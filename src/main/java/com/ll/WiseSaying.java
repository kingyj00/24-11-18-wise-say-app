package com.ll;

public class WiseSaying {
    public final int id;
    public String content;
    public String author;

    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=%s, author=%s)".formatted(id, content, author);
    }
}
