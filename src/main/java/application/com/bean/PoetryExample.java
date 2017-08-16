package application.com.bean;

import java.util.ArrayList;
import java.util.List;

public class PoetryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoetryExample() {
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

        public Criteria andPoetryidIsNull() {
            addCriterion("poetryID is null");
            return (Criteria) this;
        }

        public Criteria andPoetryidIsNotNull() {
            addCriterion("poetryID is not null");
            return (Criteria) this;
        }

        public Criteria andPoetryidEqualTo(Integer value) {
            addCriterion("poetryID =", value, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidNotEqualTo(Integer value) {
            addCriterion("poetryID <>", value, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidGreaterThan(Integer value) {
            addCriterion("poetryID >", value, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("poetryID >=", value, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidLessThan(Integer value) {
            addCriterion("poetryID <", value, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidLessThanOrEqualTo(Integer value) {
            addCriterion("poetryID <=", value, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidIn(List<Integer> values) {
            addCriterion("poetryID in", values, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidNotIn(List<Integer> values) {
            addCriterion("poetryID not in", values, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidBetween(Integer value1, Integer value2) {
            addCriterion("poetryID between", value1, value2, "poetryid");
            return (Criteria) this;
        }

        public Criteria andPoetryidNotBetween(Integer value1, Integer value2) {
            addCriterion("poetryID not between", value1, value2, "poetryid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPoetIsNull() {
            addCriterion("poet is null");
            return (Criteria) this;
        }

        public Criteria andPoetIsNotNull() {
            addCriterion("poet is not null");
            return (Criteria) this;
        }

        public Criteria andPoetEqualTo(String value) {
            addCriterion("poet =", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetNotEqualTo(String value) {
            addCriterion("poet <>", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetGreaterThan(String value) {
            addCriterion("poet >", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetGreaterThanOrEqualTo(String value) {
            addCriterion("poet >=", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetLessThan(String value) {
            addCriterion("poet <", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetLessThanOrEqualTo(String value) {
            addCriterion("poet <=", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetLike(String value) {
            addCriterion("poet like", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetNotLike(String value) {
            addCriterion("poet not like", value, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetIn(List<String> values) {
            addCriterion("poet in", values, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetNotIn(List<String> values) {
            addCriterion("poet not in", values, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetBetween(String value1, String value2) {
            addCriterion("poet between", value1, value2, "poet");
            return (Criteria) this;
        }

        public Criteria andPoetNotBetween(String value1, String value2) {
            addCriterion("poet not between", value1, value2, "poet");
            return (Criteria) this;
        }

        public Criteria andPoemIsNull() {
            addCriterion("poem is null");
            return (Criteria) this;
        }

        public Criteria andPoemIsNotNull() {
            addCriterion("poem is not null");
            return (Criteria) this;
        }

        public Criteria andPoemEqualTo(String value) {
            addCriterion("poem =", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemNotEqualTo(String value) {
            addCriterion("poem <>", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemGreaterThan(String value) {
            addCriterion("poem >", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemGreaterThanOrEqualTo(String value) {
            addCriterion("poem >=", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemLessThan(String value) {
            addCriterion("poem <", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemLessThanOrEqualTo(String value) {
            addCriterion("poem <=", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemLike(String value) {
            addCriterion("poem like", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemNotLike(String value) {
            addCriterion("poem not like", value, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemIn(List<String> values) {
            addCriterion("poem in", values, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemNotIn(List<String> values) {
            addCriterion("poem not in", values, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemBetween(String value1, String value2) {
            addCriterion("poem between", value1, value2, "poem");
            return (Criteria) this;
        }

        public Criteria andPoemNotBetween(String value1, String value2) {
            addCriterion("poem not between", value1, value2, "poem");
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