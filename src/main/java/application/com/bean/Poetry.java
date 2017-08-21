package application.com.bean;

public class Poetry {
    private Integer poetryid;

    private String title;

    private String poet;
    private String[] poem2;

    public String[] getPoem2() {
        return poem2;
    }

    public void setPoem2(String[] poem2) {
        this.poem2 = poem2;
    }

    public Poetry(Integer poetryid, String title, String poet, String poem) {
        this.poetryid = poetryid;
        this.title = title;
        this.poet = poet;
        this.poem = poem;
    }

    public Poetry(Integer poetryid, String title, String poet, String[] poem) {
        this.poetryid = poetryid;
        this.title = title;
        this.poet =poet;
        this.poem2 = poem;
    }


    public Poetry() {
    }

    private String poem;

    public Integer getPoetryid() {
        return poetryid;
    }

    public void setPoetryid(Integer poetryid) {
        this.poetryid = poetryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPoet() {
        return poet;
    }

    public void setPoet(String poet) {
        this.poet = poet == null ? null : poet.trim();
    }

    public String getPoem() {
        return poem;
    }

    public void setPoem(String poem) {
        this.poem = poem == null ? null : poem.trim();
    }
}