package application.com.bean;

import java.util.ArrayList;
import java.util.List;

public class StatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticExample() {
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

        public Criteria andStatisticidIsNull() {
            addCriterion("statisticID is null");
            return (Criteria) this;
        }

        public Criteria andStatisticidIsNotNull() {
            addCriterion("statisticID is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticidEqualTo(Integer value) {
            addCriterion("statisticID =", value, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidNotEqualTo(Integer value) {
            addCriterion("statisticID <>", value, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidGreaterThan(Integer value) {
            addCriterion("statisticID >", value, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidGreaterThanOrEqualTo(Integer value) {
            addCriterion("statisticID >=", value, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidLessThan(Integer value) {
            addCriterion("statisticID <", value, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidLessThanOrEqualTo(Integer value) {
            addCriterion("statisticID <=", value, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidIn(List<Integer> values) {
            addCriterion("statisticID in", values, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidNotIn(List<Integer> values) {
            addCriterion("statisticID not in", values, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidBetween(Integer value1, Integer value2) {
            addCriterion("statisticID between", value1, value2, "statisticid");
            return (Criteria) this;
        }

        public Criteria andStatisticidNotBetween(Integer value1, Integer value2) {
            addCriterion("statisticID not between", value1, value2, "statisticid");
            return (Criteria) this;
        }

        public Criteria andTotaluserIsNull() {
            addCriterion("totalUser is null");
            return (Criteria) this;
        }

        public Criteria andTotaluserIsNotNull() {
            addCriterion("totalUser is not null");
            return (Criteria) this;
        }

        public Criteria andTotaluserEqualTo(Integer value) {
            addCriterion("totalUser =", value, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserNotEqualTo(Integer value) {
            addCriterion("totalUser <>", value, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserGreaterThan(Integer value) {
            addCriterion("totalUser >", value, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalUser >=", value, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserLessThan(Integer value) {
            addCriterion("totalUser <", value, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserLessThanOrEqualTo(Integer value) {
            addCriterion("totalUser <=", value, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserIn(List<Integer> values) {
            addCriterion("totalUser in", values, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserNotIn(List<Integer> values) {
            addCriterion("totalUser not in", values, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserBetween(Integer value1, Integer value2) {
            addCriterion("totalUser between", value1, value2, "totaluser");
            return (Criteria) this;
        }

        public Criteria andTotaluserNotBetween(Integer value1, Integer value2) {
            addCriterion("totalUser not between", value1, value2, "totaluser");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("Year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("Year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("Year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("Year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("Year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("Year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("Year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("Year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("Year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("Year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("Year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("Year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("Month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("Month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("Month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("Month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("Month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("Month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("Month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("Month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("Month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("Month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("Month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("Month not between", value1, value2, "month");
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