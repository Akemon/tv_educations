package application.com.bean;

import java.util.Date;

public class Record {
    private Integer recordid;

    private Integer studentid;

    private Integer poetryid;

    private String score;

    private Date scoretime;

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getPoetryid() {
        return poetryid;
    }

    public void setPoetryid(Integer poetryid) {
        this.poetryid = poetryid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public Date getScoretime() {
        return scoretime;
    }

    public void setScoretime(Date scoretime) {
        this.scoretime = scoretime;
    }
}