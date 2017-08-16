package application.com.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentID is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("studentID =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("studentID <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("studentID >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentID >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("studentID <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("studentID <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("studentID in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("studentID not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("studentID between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("studentID not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentnunberIsNull() {
            addCriterion("studentNunber is null");
            return (Criteria) this;
        }

        public Criteria andStudentnunberIsNotNull() {
            addCriterion("studentNunber is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnunberEqualTo(String value) {
            addCriterion("studentNunber =", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberNotEqualTo(String value) {
            addCriterion("studentNunber <>", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberGreaterThan(String value) {
            addCriterion("studentNunber >", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberGreaterThanOrEqualTo(String value) {
            addCriterion("studentNunber >=", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberLessThan(String value) {
            addCriterion("studentNunber <", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberLessThanOrEqualTo(String value) {
            addCriterion("studentNunber <=", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberLike(String value) {
            addCriterion("studentNunber like", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberNotLike(String value) {
            addCriterion("studentNunber not like", value, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberIn(List<String> values) {
            addCriterion("studentNunber in", values, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberNotIn(List<String> values) {
            addCriterion("studentNunber not in", values, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberBetween(String value1, String value2) {
            addCriterion("studentNunber between", value1, value2, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnunberNotBetween(String value1, String value2) {
            addCriterion("studentNunber not between", value1, value2, "studentnunber");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("studentName is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("studentName is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("studentName =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("studentName <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("studentName >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("studentName >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("studentName <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("studentName <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("studentName like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("studentName not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("studentName in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("studentName not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("studentName between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("studentName not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentgradeIsNull() {
            addCriterion("studentGrade is null");
            return (Criteria) this;
        }

        public Criteria andStudentgradeIsNotNull() {
            addCriterion("studentGrade is not null");
            return (Criteria) this;
        }

        public Criteria andStudentgradeEqualTo(String value) {
            addCriterion("studentGrade =", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeNotEqualTo(String value) {
            addCriterion("studentGrade <>", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeGreaterThan(String value) {
            addCriterion("studentGrade >", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeGreaterThanOrEqualTo(String value) {
            addCriterion("studentGrade >=", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeLessThan(String value) {
            addCriterion("studentGrade <", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeLessThanOrEqualTo(String value) {
            addCriterion("studentGrade <=", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeLike(String value) {
            addCriterion("studentGrade like", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeNotLike(String value) {
            addCriterion("studentGrade not like", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeIn(List<String> values) {
            addCriterion("studentGrade in", values, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeNotIn(List<String> values) {
            addCriterion("studentGrade not in", values, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeBetween(String value1, String value2) {
            addCriterion("studentGrade between", value1, value2, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeNotBetween(String value1, String value2) {
            addCriterion("studentGrade not between", value1, value2, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNull() {
            addCriterion("schoolID is null");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNotNull() {
            addCriterion("schoolID is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolidEqualTo(Integer value) {
            addCriterion("schoolID =", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotEqualTo(Integer value) {
            addCriterion("schoolID <>", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThan(Integer value) {
            addCriterion("schoolID >", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThanOrEqualTo(Integer value) {
            addCriterion("schoolID >=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThan(Integer value) {
            addCriterion("schoolID <", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThanOrEqualTo(Integer value) {
            addCriterion("schoolID <=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidIn(List<Integer> values) {
            addCriterion("schoolID in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotIn(List<Integer> values) {
            addCriterion("schoolID not in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidBetween(Integer value1, Integer value2) {
            addCriterion("schoolID between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotBetween(Integer value1, Integer value2) {
            addCriterion("schoolID not between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andStudentphoneIsNull() {
            addCriterion("studentPhone is null");
            return (Criteria) this;
        }

        public Criteria andStudentphoneIsNotNull() {
            addCriterion("studentPhone is not null");
            return (Criteria) this;
        }

        public Criteria andStudentphoneEqualTo(String value) {
            addCriterion("studentPhone =", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneNotEqualTo(String value) {
            addCriterion("studentPhone <>", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneGreaterThan(String value) {
            addCriterion("studentPhone >", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneGreaterThanOrEqualTo(String value) {
            addCriterion("studentPhone >=", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneLessThan(String value) {
            addCriterion("studentPhone <", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneLessThanOrEqualTo(String value) {
            addCriterion("studentPhone <=", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneLike(String value) {
            addCriterion("studentPhone like", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneNotLike(String value) {
            addCriterion("studentPhone not like", value, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneIn(List<String> values) {
            addCriterion("studentPhone in", values, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneNotIn(List<String> values) {
            addCriterion("studentPhone not in", values, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneBetween(String value1, String value2) {
            addCriterion("studentPhone between", value1, value2, "studentphone");
            return (Criteria) this;
        }

        public Criteria andStudentphoneNotBetween(String value1, String value2) {
            addCriterion("studentPhone not between", value1, value2, "studentphone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}