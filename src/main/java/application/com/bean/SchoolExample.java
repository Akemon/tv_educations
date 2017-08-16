package application.com.bean;

import java.util.ArrayList;
import java.util.List;

public class SchoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchoolExample() {
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

        public Criteria andSchoolnameIsNull() {
            addCriterion("schoolName is null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIsNotNull() {
            addCriterion("schoolName is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameEqualTo(String value) {
            addCriterion("schoolName =", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotEqualTo(String value) {
            addCriterion("schoolName <>", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThan(String value) {
            addCriterion("schoolName >", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThanOrEqualTo(String value) {
            addCriterion("schoolName >=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThan(String value) {
            addCriterion("schoolName <", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThanOrEqualTo(String value) {
            addCriterion("schoolName <=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLike(String value) {
            addCriterion("schoolName like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotLike(String value) {
            addCriterion("schoolName not like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIn(List<String> values) {
            addCriterion("schoolName in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotIn(List<String> values) {
            addCriterion("schoolName not in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameBetween(String value1, String value2) {
            addCriterion("schoolName between", value1, value2, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotBetween(String value1, String value2) {
            addCriterion("schoolName not between", value1, value2, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceIsNull() {
            addCriterion("schoolProvince is null");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceIsNotNull() {
            addCriterion("schoolProvince is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceEqualTo(String value) {
            addCriterion("schoolProvince =", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceNotEqualTo(String value) {
            addCriterion("schoolProvince <>", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceGreaterThan(String value) {
            addCriterion("schoolProvince >", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("schoolProvince >=", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceLessThan(String value) {
            addCriterion("schoolProvince <", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceLessThanOrEqualTo(String value) {
            addCriterion("schoolProvince <=", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceLike(String value) {
            addCriterion("schoolProvince like", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceNotLike(String value) {
            addCriterion("schoolProvince not like", value, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceIn(List<String> values) {
            addCriterion("schoolProvince in", values, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceNotIn(List<String> values) {
            addCriterion("schoolProvince not in", values, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceBetween(String value1, String value2) {
            addCriterion("schoolProvince between", value1, value2, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchoolprovinceNotBetween(String value1, String value2) {
            addCriterion("schoolProvince not between", value1, value2, "schoolprovince");
            return (Criteria) this;
        }

        public Criteria andSchooladdressIsNull() {
            addCriterion("schoolAddress is null");
            return (Criteria) this;
        }

        public Criteria andSchooladdressIsNotNull() {
            addCriterion("schoolAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSchooladdressEqualTo(String value) {
            addCriterion("schoolAddress =", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotEqualTo(String value) {
            addCriterion("schoolAddress <>", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressGreaterThan(String value) {
            addCriterion("schoolAddress >", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressGreaterThanOrEqualTo(String value) {
            addCriterion("schoolAddress >=", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressLessThan(String value) {
            addCriterion("schoolAddress <", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressLessThanOrEqualTo(String value) {
            addCriterion("schoolAddress <=", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressLike(String value) {
            addCriterion("schoolAddress like", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotLike(String value) {
            addCriterion("schoolAddress not like", value, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressIn(List<String> values) {
            addCriterion("schoolAddress in", values, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotIn(List<String> values) {
            addCriterion("schoolAddress not in", values, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressBetween(String value1, String value2) {
            addCriterion("schoolAddress between", value1, value2, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooladdressNotBetween(String value1, String value2) {
            addCriterion("schoolAddress not between", value1, value2, "schooladdress");
            return (Criteria) this;
        }

        public Criteria andSchooltypeIsNull() {
            addCriterion("schoolType is null");
            return (Criteria) this;
        }

        public Criteria andSchooltypeIsNotNull() {
            addCriterion("schoolType is not null");
            return (Criteria) this;
        }

        public Criteria andSchooltypeEqualTo(String value) {
            addCriterion("schoolType =", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotEqualTo(String value) {
            addCriterion("schoolType <>", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeGreaterThan(String value) {
            addCriterion("schoolType >", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeGreaterThanOrEqualTo(String value) {
            addCriterion("schoolType >=", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeLessThan(String value) {
            addCriterion("schoolType <", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeLessThanOrEqualTo(String value) {
            addCriterion("schoolType <=", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeLike(String value) {
            addCriterion("schoolType like", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotLike(String value) {
            addCriterion("schoolType not like", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeIn(List<String> values) {
            addCriterion("schoolType in", values, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotIn(List<String> values) {
            addCriterion("schoolType not in", values, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeBetween(String value1, String value2) {
            addCriterion("schoolType between", value1, value2, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotBetween(String value1, String value2) {
            addCriterion("schoolType not between", value1, value2, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneIsNull() {
            addCriterion("schoolPhone is null");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneIsNotNull() {
            addCriterion("schoolPhone is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneEqualTo(String value) {
            addCriterion("schoolPhone =", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneNotEqualTo(String value) {
            addCriterion("schoolPhone <>", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneGreaterThan(String value) {
            addCriterion("schoolPhone >", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneGreaterThanOrEqualTo(String value) {
            addCriterion("schoolPhone >=", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneLessThan(String value) {
            addCriterion("schoolPhone <", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneLessThanOrEqualTo(String value) {
            addCriterion("schoolPhone <=", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneLike(String value) {
            addCriterion("schoolPhone like", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneNotLike(String value) {
            addCriterion("schoolPhone not like", value, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneIn(List<String> values) {
            addCriterion("schoolPhone in", values, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneNotIn(List<String> values) {
            addCriterion("schoolPhone not in", values, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneBetween(String value1, String value2) {
            addCriterion("schoolPhone between", value1, value2, "schoolphone");
            return (Criteria) this;
        }

        public Criteria andSchoolphoneNotBetween(String value1, String value2) {
            addCriterion("schoolPhone not between", value1, value2, "schoolphone");
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