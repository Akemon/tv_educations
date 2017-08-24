package application.com.bean;

import java.util.Date;

public class Record {
    private Integer recordid;

    private Integer studentid;

    private int alreadyReadNum;

    public int getAlreadyReadNum() {
        return alreadyReadNum;
    }

    public void setAlreadyReadNum(int alreadyReadNum) {
        this.alreadyReadNum = alreadyReadNum;
    }

    public Record() {
    }

    public Record(Integer studentid, Integer poetryid, String score, String scoretime) {
        this.studentid = studentid;
        this.poetryid = poetryid;
        this.score = score;
        this.scoretime = scoretime;
    }

    private Integer poetryid;

    private String score;

    private String scoretime;

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

    public String getScoretime() {
        return scoretime;
    }

    public void setScoretime(String scoretime) {
        this.scoretime = scoretime;
    }
}