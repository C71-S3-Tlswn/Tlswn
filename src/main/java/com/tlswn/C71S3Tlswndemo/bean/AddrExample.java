package com.tlswn.C71S3Tlswndemo.bean;

import java.util.ArrayList;
import java.util.List;

public class AddrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddrExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAnameIsNull() {
            addCriterion("aname is null");
            return (Criteria) this;
        }

        public Criteria andAnameIsNotNull() {
            addCriterion("aname is not null");
            return (Criteria) this;
        }

        public Criteria andAnameEqualTo(String value) {
            addCriterion("aname =", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotEqualTo(String value) {
            addCriterion("aname <>", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThan(String value) {
            addCriterion("aname >", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameGreaterThanOrEqualTo(String value) {
            addCriterion("aname >=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThan(String value) {
            addCriterion("aname <", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLessThanOrEqualTo(String value) {
            addCriterion("aname <=", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameLike(String value) {
            addCriterion("aname like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotLike(String value) {
            addCriterion("aname not like", value, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameIn(List<String> values) {
            addCriterion("aname in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotIn(List<String> values) {
            addCriterion("aname not in", values, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameBetween(String value1, String value2) {
            addCriterion("aname between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andAnameNotBetween(String value1, String value2) {
            addCriterion("aname not between", value1, value2, "aname");
            return (Criteria) this;
        }

        public Criteria andAtelIsNull() {
            addCriterion("atel is null");
            return (Criteria) this;
        }

        public Criteria andAtelIsNotNull() {
            addCriterion("atel is not null");
            return (Criteria) this;
        }

        public Criteria andAtelEqualTo(String value) {
            addCriterion("atel =", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelNotEqualTo(String value) {
            addCriterion("atel <>", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelGreaterThan(String value) {
            addCriterion("atel >", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelGreaterThanOrEqualTo(String value) {
            addCriterion("atel >=", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelLessThan(String value) {
            addCriterion("atel <", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelLessThanOrEqualTo(String value) {
            addCriterion("atel <=", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelLike(String value) {
            addCriterion("atel like", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelNotLike(String value) {
            addCriterion("atel not like", value, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelIn(List<String> values) {
            addCriterion("atel in", values, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelNotIn(List<String> values) {
            addCriterion("atel not in", values, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelBetween(String value1, String value2) {
            addCriterion("atel between", value1, value2, "atel");
            return (Criteria) this;
        }

        public Criteria andAtelNotBetween(String value1, String value2) {
            addCriterion("atel not between", value1, value2, "atel");
            return (Criteria) this;
        }

        public Criteria andAstatusIsNull() {
            addCriterion("astatus is null");
            return (Criteria) this;
        }

        public Criteria andAstatusIsNotNull() {
            addCriterion("astatus is not null");
            return (Criteria) this;
        }

        public Criteria andAstatusEqualTo(Integer value) {
            addCriterion("astatus =", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusNotEqualTo(Integer value) {
            addCriterion("astatus <>", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusGreaterThan(Integer value) {
            addCriterion("astatus >", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("astatus >=", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusLessThan(Integer value) {
            addCriterion("astatus <", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusLessThanOrEqualTo(Integer value) {
            addCriterion("astatus <=", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusIn(List<Integer> values) {
            addCriterion("astatus in", values, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusNotIn(List<Integer> values) {
            addCriterion("astatus not in", values, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusBetween(Integer value1, Integer value2) {
            addCriterion("astatus between", value1, value2, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("astatus not between", value1, value2, "astatus");
            return (Criteria) this;
        }

        public Criteria andAtempIsNull() {
            addCriterion("atemp is null");
            return (Criteria) this;
        }

        public Criteria andAtempIsNotNull() {
            addCriterion("atemp is not null");
            return (Criteria) this;
        }

        public Criteria andAtempEqualTo(String value) {
            addCriterion("atemp =", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempNotEqualTo(String value) {
            addCriterion("atemp <>", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempGreaterThan(String value) {
            addCriterion("atemp >", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempGreaterThanOrEqualTo(String value) {
            addCriterion("atemp >=", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempLessThan(String value) {
            addCriterion("atemp <", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempLessThanOrEqualTo(String value) {
            addCriterion("atemp <=", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempLike(String value) {
            addCriterion("atemp like", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempNotLike(String value) {
            addCriterion("atemp not like", value, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempIn(List<String> values) {
            addCriterion("atemp in", values, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempNotIn(List<String> values) {
            addCriterion("atemp not in", values, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempBetween(String value1, String value2) {
            addCriterion("atemp between", value1, value2, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtempNotBetween(String value1, String value2) {
            addCriterion("atemp not between", value1, value2, "atemp");
            return (Criteria) this;
        }

        public Criteria andAtemp1IsNull() {
            addCriterion("atemp1 is null");
            return (Criteria) this;
        }

        public Criteria andAtemp1IsNotNull() {
            addCriterion("atemp1 is not null");
            return (Criteria) this;
        }

        public Criteria andAtemp1EqualTo(String value) {
            addCriterion("atemp1 =", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1NotEqualTo(String value) {
            addCriterion("atemp1 <>", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1GreaterThan(String value) {
            addCriterion("atemp1 >", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1GreaterThanOrEqualTo(String value) {
            addCriterion("atemp1 >=", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1LessThan(String value) {
            addCriterion("atemp1 <", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1LessThanOrEqualTo(String value) {
            addCriterion("atemp1 <=", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1Like(String value) {
            addCriterion("atemp1 like", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1NotLike(String value) {
            addCriterion("atemp1 not like", value, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1In(List<String> values) {
            addCriterion("atemp1 in", values, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1NotIn(List<String> values) {
            addCriterion("atemp1 not in", values, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1Between(String value1, String value2) {
            addCriterion("atemp1 between", value1, value2, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp1NotBetween(String value1, String value2) {
            addCriterion("atemp1 not between", value1, value2, "atemp1");
            return (Criteria) this;
        }

        public Criteria andAtemp2IsNull() {
            addCriterion("atemp2 is null");
            return (Criteria) this;
        }

        public Criteria andAtemp2IsNotNull() {
            addCriterion("atemp2 is not null");
            return (Criteria) this;
        }

        public Criteria andAtemp2EqualTo(Integer value) {
            addCriterion("atemp2 =", value, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2NotEqualTo(Integer value) {
            addCriterion("atemp2 <>", value, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2GreaterThan(Integer value) {
            addCriterion("atemp2 >", value, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2GreaterThanOrEqualTo(Integer value) {
            addCriterion("atemp2 >=", value, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2LessThan(Integer value) {
            addCriterion("atemp2 <", value, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2LessThanOrEqualTo(Integer value) {
            addCriterion("atemp2 <=", value, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2In(List<Integer> values) {
            addCriterion("atemp2 in", values, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2NotIn(List<Integer> values) {
            addCriterion("atemp2 not in", values, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2Between(Integer value1, Integer value2) {
            addCriterion("atemp2 between", value1, value2, "atemp2");
            return (Criteria) this;
        }

        public Criteria andAtemp2NotBetween(Integer value1, Integer value2) {
            addCriterion("atemp2 not between", value1, value2, "atemp2");
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