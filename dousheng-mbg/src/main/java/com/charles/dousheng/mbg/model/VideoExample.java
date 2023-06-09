package com.charles.dousheng.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Long value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Long value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Long value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Long value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Long> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Long> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Long value1, Long value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPlayUrlIsNull() {
            addCriterion("play_url is null");
            return (Criteria) this;
        }

        public Criteria andPlayUrlIsNotNull() {
            addCriterion("play_url is not null");
            return (Criteria) this;
        }

        public Criteria andPlayUrlEqualTo(String value) {
            addCriterion("play_url =", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotEqualTo(String value) {
            addCriterion("play_url <>", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlGreaterThan(String value) {
            addCriterion("play_url >", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlGreaterThanOrEqualTo(String value) {
            addCriterion("play_url >=", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlLessThan(String value) {
            addCriterion("play_url <", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlLessThanOrEqualTo(String value) {
            addCriterion("play_url <=", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlLike(String value) {
            addCriterion("play_url like", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotLike(String value) {
            addCriterion("play_url not like", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlIn(List<String> values) {
            addCriterion("play_url in", values, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotIn(List<String> values) {
            addCriterion("play_url not in", values, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlBetween(String value1, String value2) {
            addCriterion("play_url between", value1, value2, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotBetween(String value1, String value2) {
            addCriterion("play_url not between", value1, value2, "playUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNull() {
            addCriterion("cover_url is null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNotNull() {
            addCriterion("cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlEqualTo(String value) {
            addCriterion("cover_url =", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotEqualTo(String value) {
            addCriterion("cover_url <>", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThan(String value) {
            addCriterion("cover_url >", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cover_url >=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThan(String value) {
            addCriterion("cover_url <", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("cover_url <=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLike(String value) {
            addCriterion("cover_url like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotLike(String value) {
            addCriterion("cover_url not like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIn(List<String> values) {
            addCriterion("cover_url in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotIn(List<String> values) {
            addCriterion("cover_url not in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlBetween(String value1, String value2) {
            addCriterion("cover_url between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotBetween(String value1, String value2) {
            addCriterion("cover_url not between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountIsNull() {
            addCriterion("favorite_count is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountIsNotNull() {
            addCriterion("favorite_count is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountEqualTo(Long value) {
            addCriterion("favorite_count =", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountNotEqualTo(Long value) {
            addCriterion("favorite_count <>", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountGreaterThan(Long value) {
            addCriterion("favorite_count >", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountGreaterThanOrEqualTo(Long value) {
            addCriterion("favorite_count >=", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountLessThan(Long value) {
            addCriterion("favorite_count <", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountLessThanOrEqualTo(Long value) {
            addCriterion("favorite_count <=", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountIn(List<Long> values) {
            addCriterion("favorite_count in", values, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountNotIn(List<Long> values) {
            addCriterion("favorite_count not in", values, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountBetween(Long value1, Long value2) {
            addCriterion("favorite_count between", value1, value2, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountNotBetween(Long value1, Long value2) {
            addCriterion("favorite_count not between", value1, value2, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Long value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Long value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Long value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Long value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Long value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Long> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Long> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Long value1, Long value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Long value1, Long value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteIsNull() {
            addCriterion("is_favorite is null");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteIsNotNull() {
            addCriterion("is_favorite is not null");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteEqualTo(Boolean value) {
            addCriterion("is_favorite =", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteNotEqualTo(Boolean value) {
            addCriterion("is_favorite <>", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteGreaterThan(Boolean value) {
            addCriterion("is_favorite >", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_favorite >=", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteLessThan(Boolean value) {
            addCriterion("is_favorite <", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_favorite <=", value, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteIn(List<Boolean> values) {
            addCriterion("is_favorite in", values, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteNotIn(List<Boolean> values) {
            addCriterion("is_favorite not in", values, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_favorite between", value1, value2, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andIsFavoriteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_favorite not between", value1, value2, "isFavorite");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdIsNull() {
            addCriterion("video_category_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdIsNotNull() {
            addCriterion("video_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdEqualTo(Long value) {
            addCriterion("video_category_id =", value, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdNotEqualTo(Long value) {
            addCriterion("video_category_id <>", value, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdGreaterThan(Long value) {
            addCriterion("video_category_id >", value, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("video_category_id >=", value, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdLessThan(Long value) {
            addCriterion("video_category_id <", value, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("video_category_id <=", value, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdIn(List<Long> values) {
            addCriterion("video_category_id in", values, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdNotIn(List<Long> values) {
            addCriterion("video_category_id not in", values, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdBetween(Long value1, Long value2) {
            addCriterion("video_category_id between", value1, value2, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("video_category_id not between", value1, value2, "videoCategoryId");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameIsNull() {
            addCriterion("video_category_name is null");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameIsNotNull() {
            addCriterion("video_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameEqualTo(String value) {
            addCriterion("video_category_name =", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameNotEqualTo(String value) {
            addCriterion("video_category_name <>", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameGreaterThan(String value) {
            addCriterion("video_category_name >", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("video_category_name >=", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameLessThan(String value) {
            addCriterion("video_category_name <", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("video_category_name <=", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameLike(String value) {
            addCriterion("video_category_name like", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameNotLike(String value) {
            addCriterion("video_category_name not like", value, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameIn(List<String> values) {
            addCriterion("video_category_name in", values, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameNotIn(List<String> values) {
            addCriterion("video_category_name not in", values, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameBetween(String value1, String value2) {
            addCriterion("video_category_name between", value1, value2, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andVideoCategoryNameNotBetween(String value1, String value2) {
            addCriterion("video_category_name not between", value1, value2, "videoCategoryName");
            return (Criteria) this;
        }

        public Criteria andMcnIdIsNull() {
            addCriterion("MCN_id is null");
            return (Criteria) this;
        }

        public Criteria andMcnIdIsNotNull() {
            addCriterion("MCN_id is not null");
            return (Criteria) this;
        }

        public Criteria andMcnIdEqualTo(Integer value) {
            addCriterion("MCN_id =", value, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdNotEqualTo(Integer value) {
            addCriterion("MCN_id <>", value, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdGreaterThan(Integer value) {
            addCriterion("MCN_id >", value, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MCN_id >=", value, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdLessThan(Integer value) {
            addCriterion("MCN_id <", value, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdLessThanOrEqualTo(Integer value) {
            addCriterion("MCN_id <=", value, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdIn(List<Integer> values) {
            addCriterion("MCN_id in", values, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdNotIn(List<Integer> values) {
            addCriterion("MCN_id not in", values, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdBetween(Integer value1, Integer value2) {
            addCriterion("MCN_id between", value1, value2, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MCN_id not between", value1, value2, "mcnId");
            return (Criteria) this;
        }

        public Criteria andMcnNameIsNull() {
            addCriterion("MCN_name is null");
            return (Criteria) this;
        }

        public Criteria andMcnNameIsNotNull() {
            addCriterion("MCN_name is not null");
            return (Criteria) this;
        }

        public Criteria andMcnNameEqualTo(String value) {
            addCriterion("MCN_name =", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameNotEqualTo(String value) {
            addCriterion("MCN_name <>", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameGreaterThan(String value) {
            addCriterion("MCN_name >", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameGreaterThanOrEqualTo(String value) {
            addCriterion("MCN_name >=", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameLessThan(String value) {
            addCriterion("MCN_name <", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameLessThanOrEqualTo(String value) {
            addCriterion("MCN_name <=", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameLike(String value) {
            addCriterion("MCN_name like", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameNotLike(String value) {
            addCriterion("MCN_name not like", value, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameIn(List<String> values) {
            addCriterion("MCN_name in", values, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameNotIn(List<String> values) {
            addCriterion("MCN_name not in", values, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameBetween(String value1, String value2) {
            addCriterion("MCN_name between", value1, value2, "mcnName");
            return (Criteria) this;
        }

        public Criteria andMcnNameNotBetween(String value1, String value2) {
            addCriterion("MCN_name not between", value1, value2, "mcnName");
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