package com.tlswn.C71S3Tlswndemo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommodityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommodityExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCphotoIsNull() {
            addCriterion("cphoto is null");
            return (Criteria) this;
        }

        public Criteria andCphotoIsNotNull() {
            addCriterion("cphoto is not null");
            return (Criteria) this;
        }

        public Criteria andCphotoEqualTo(String value) {
            addCriterion("cphoto =", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoNotEqualTo(String value) {
            addCriterion("cphoto <>", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoGreaterThan(String value) {
            addCriterion("cphoto >", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoGreaterThanOrEqualTo(String value) {
            addCriterion("cphoto >=", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoLessThan(String value) {
            addCriterion("cphoto <", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoLessThanOrEqualTo(String value) {
            addCriterion("cphoto <=", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoLike(String value) {
            addCriterion("cphoto like", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoNotLike(String value) {
            addCriterion("cphoto not like", value, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoIn(List<String> values) {
            addCriterion("cphoto in", values, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoNotIn(List<String> values) {
            addCriterion("cphoto not in", values, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoBetween(String value1, String value2) {
            addCriterion("cphoto between", value1, value2, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCphotoNotBetween(String value1, String value2) {
            addCriterion("cphoto not between", value1, value2, "cphoto");
            return (Criteria) this;
        }

        public Criteria andCpriceIsNull() {
            addCriterion("cprice is null");
            return (Criteria) this;
        }

        public Criteria andCpriceIsNotNull() {
            addCriterion("cprice is not null");
            return (Criteria) this;
        }

        public Criteria andCpriceEqualTo(Double value) {
            addCriterion("cprice =", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceNotEqualTo(Double value) {
            addCriterion("cprice <>", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceGreaterThan(Double value) {
            addCriterion("cprice >", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("cprice >=", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceLessThan(Double value) {
            addCriterion("cprice <", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceLessThanOrEqualTo(Double value) {
            addCriterion("cprice <=", value, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceIn(List<Double> values) {
            addCriterion("cprice in", values, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceNotIn(List<Double> values) {
            addCriterion("cprice not in", values, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceBetween(Double value1, Double value2) {
            addCriterion("cprice between", value1, value2, "cprice");
            return (Criteria) this;
        }

        public Criteria andCpriceNotBetween(Double value1, Double value2) {
            addCriterion("cprice not between", value1, value2, "cprice");
            return (Criteria) this;
        }

        public Criteria andCBtimeIsNull() {
            addCriterion("c_btime is null");
            return (Criteria) this;
        }

        public Criteria andCBtimeIsNotNull() {
            addCriterion("c_btime is not null");
            return (Criteria) this;
        }

        public Criteria andCBtimeEqualTo(Date value) {
            addCriterion("c_btime =", value, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeNotEqualTo(Date value) {
            addCriterion("c_btime <>", value, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeGreaterThan(Date value) {
            addCriterion("c_btime >", value, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_btime >=", value, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeLessThan(Date value) {
            addCriterion("c_btime <", value, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeLessThanOrEqualTo(Date value) {
            addCriterion("c_btime <=", value, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeIn(List<Date> values) {
            addCriterion("c_btime in", values, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeNotIn(List<Date> values) {
            addCriterion("c_btime not in", values, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeBetween(Date value1, Date value2) {
            addCriterion("c_btime between", value1, value2, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCBtimeNotBetween(Date value1, Date value2) {
            addCriterion("c_btime not between", value1, value2, "cBtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeIsNull() {
            addCriterion("c_etime is null");
            return (Criteria) this;
        }

        public Criteria andCEtimeIsNotNull() {
            addCriterion("c_etime is not null");
            return (Criteria) this;
        }

        public Criteria andCEtimeEqualTo(Date value) {
            addCriterion("c_etime =", value, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeNotEqualTo(Date value) {
            addCriterion("c_etime <>", value, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeGreaterThan(Date value) {
            addCriterion("c_etime >", value, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_etime >=", value, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeLessThan(Date value) {
            addCriterion("c_etime <", value, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeLessThanOrEqualTo(Date value) {
            addCriterion("c_etime <=", value, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeIn(List<Date> values) {
            addCriterion("c_etime in", values, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeNotIn(List<Date> values) {
            addCriterion("c_etime not in", values, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeBetween(Date value1, Date value2) {
            addCriterion("c_etime between", value1, value2, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCEtimeNotBetween(Date value1, Date value2) {
            addCriterion("c_etime not between", value1, value2, "cEtime");
            return (Criteria) this;
        }

        public Criteria andCnumIsNull() {
            addCriterion("cnum is null");
            return (Criteria) this;
        }

        public Criteria andCnumIsNotNull() {
            addCriterion("cnum is not null");
            return (Criteria) this;
        }

        public Criteria andCnumEqualTo(Integer value) {
            addCriterion("cnum =", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotEqualTo(Integer value) {
            addCriterion("cnum <>", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumGreaterThan(Integer value) {
            addCriterion("cnum >", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("cnum >=", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumLessThan(Integer value) {
            addCriterion("cnum <", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumLessThanOrEqualTo(Integer value) {
            addCriterion("cnum <=", value, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumIn(List<Integer> values) {
            addCriterion("cnum in", values, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotIn(List<Integer> values) {
            addCriterion("cnum not in", values, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumBetween(Integer value1, Integer value2) {
            addCriterion("cnum between", value1, value2, "cnum");
            return (Criteria) this;
        }

        public Criteria andCnumNotBetween(Integer value1, Integer value2) {
            addCriterion("cnum not between", value1, value2, "cnum");
            return (Criteria) this;
        }

        public Criteria andCdescrideIsNull() {
            addCriterion("cdescride is null");
            return (Criteria) this;
        }

        public Criteria andCdescrideIsNotNull() {
            addCriterion("cdescride is not null");
            return (Criteria) this;
        }

        public Criteria andCdescrideEqualTo(String value) {
            addCriterion("cdescride =", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideNotEqualTo(String value) {
            addCriterion("cdescride <>", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideGreaterThan(String value) {
            addCriterion("cdescride >", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideGreaterThanOrEqualTo(String value) {
            addCriterion("cdescride >=", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideLessThan(String value) {
            addCriterion("cdescride <", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideLessThanOrEqualTo(String value) {
            addCriterion("cdescride <=", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideLike(String value) {
            addCriterion("cdescride like", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideNotLike(String value) {
            addCriterion("cdescride not like", value, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideIn(List<String> values) {
            addCriterion("cdescride in", values, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideNotIn(List<String> values) {
            addCriterion("cdescride not in", values, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideBetween(String value1, String value2) {
            addCriterion("cdescride between", value1, value2, "cdescride");
            return (Criteria) this;
        }

        public Criteria andCdescrideNotBetween(String value1, String value2) {
            addCriterion("cdescride not between", value1, value2, "cdescride");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
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