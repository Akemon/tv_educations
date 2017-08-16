package application.com.bean;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdminidIsNull() {
            addCriterion("adminID is null");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNotNull() {
            addCriterion("adminID is not null");
            return (Criteria) this;
        }

        public Criteria andAdminidEqualTo(Integer value) {
            addCriterion("adminID =", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotEqualTo(Integer value) {
            addCriterion("adminID <>", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThan(Integer value) {
            addCriterion("adminID >", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminID >=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThan(Integer value) {
            addCriterion("adminID <", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThanOrEqualTo(Integer value) {
            addCriterion("adminID <=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidIn(List<Integer> values) {
            addCriterion("adminID in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotIn(List<Integer> values) {
            addCriterion("adminID not in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidBetween(Integer value1, Integer value2) {
            addCriterion("adminID between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminID not between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNull() {
            addCriterion("adminName is null");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNotNull() {
            addCriterion("adminName is not null");
            return (Criteria) this;
        }

        public Criteria andAdminnameEqualTo(String value) {
            addCriterion("adminName =", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotEqualTo(String value) {
            addCriterion("adminName <>", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThan(String value) {
            addCriterion("adminName >", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThanOrEqualTo(String value) {
            addCriterion("adminName >=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThan(String value) {
            addCriterion("adminName <", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThanOrEqualTo(String value) {
            addCriterion("adminName <=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLike(String value) {
            addCriterion("adminName like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotLike(String value) {
            addCriterion("adminName not like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameIn(List<String> values) {
            addCriterion("adminName in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotIn(List<String> values) {
            addCriterion("adminName not in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameBetween(String value1, String value2) {
            addCriterion("adminName between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotBetween(String value1, String value2) {
            addCriterion("adminName not between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminpassIsNull() {
            addCriterion("adminPass is null");
            return (Criteria) this;
        }

        public Criteria andAdminpassIsNotNull() {
            addCriterion("adminPass is not null");
            return (Criteria) this;
        }

        public Criteria andAdminpassEqualTo(String value) {
            addCriterion("adminPass =", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotEqualTo(String value) {
            addCriterion("adminPass <>", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassGreaterThan(String value) {
            addCriterion("adminPass >", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassGreaterThanOrEqualTo(String value) {
            addCriterion("adminPass >=", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassLessThan(String value) {
            addCriterion("adminPass <", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassLessThanOrEqualTo(String value) {
            addCriterion("adminPass <=", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassLike(String value) {
            addCriterion("adminPass like", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotLike(String value) {
            addCriterion("adminPass not like", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassIn(List<String> values) {
            addCriterion("adminPass in", values, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotIn(List<String> values) {
            addCriterion("adminPass not in", values, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassBetween(String value1, String value2) {
            addCriterion("adminPass between", value1, value2, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotBetween(String value1, String value2) {
            addCriterion("adminPass not between", value1, value2, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminstatusIsNull() {
            addCriterion("adminStatus is null");
            return (Criteria) this;
        }

        public Criteria andAdminstatusIsNotNull() {
            addCriterion("adminStatus is not null");
            return (Criteria) this;
        }

        public Criteria andAdminstatusEqualTo(String value) {
            addCriterion("adminStatus =", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusNotEqualTo(String value) {
            addCriterion("adminStatus <>", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusGreaterThan(String value) {
            addCriterion("adminStatus >", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusGreaterThanOrEqualTo(String value) {
            addCriterion("adminStatus >=", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusLessThan(String value) {
            addCriterion("adminStatus <", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusLessThanOrEqualTo(String value) {
            addCriterion("adminStatus <=", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusLike(String value) {
            addCriterion("adminStatus like", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusNotLike(String value) {
            addCriterion("adminStatus not like", value, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusIn(List<String> values) {
            addCriterion("adminStatus in", values, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusNotIn(List<String> values) {
            addCriterion("adminStatus not in", values, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusBetween(String value1, String value2) {
            addCriterion("adminStatus between", value1, value2, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminstatusNotBetween(String value1, String value2) {
            addCriterion("adminStatus not between", value1, value2, "adminstatus");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityIsNull() {
            addCriterion("adminPriority is null");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityIsNotNull() {
            addCriterion("adminPriority is not null");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityEqualTo(Integer value) {
            addCriterion("adminPriority =", value, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityNotEqualTo(Integer value) {
            addCriterion("adminPriority <>", value, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityGreaterThan(Integer value) {
            addCriterion("adminPriority >", value, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminPriority >=", value, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityLessThan(Integer value) {
            addCriterion("adminPriority <", value, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityLessThanOrEqualTo(Integer value) {
            addCriterion("adminPriority <=", value, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityIn(List<Integer> values) {
            addCriterion("adminPriority in", values, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityNotIn(List<Integer> values) {
            addCriterion("adminPriority not in", values, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityBetween(Integer value1, Integer value2) {
            addCriterion("adminPriority between", value1, value2, "adminpriority");
            return (Criteria) this;
        }

        public Criteria andAdminpriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("adminPriority not between", value1, value2, "adminpriority");
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