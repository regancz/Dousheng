package com.charles.dousheng.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "视频标题")
    private String title;

    @ApiModelProperty(value = "发布者id")
    private Long authorId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "视频存放的路径")
    private String playUrl;

    @ApiModelProperty(value = "视频封面图")
    private String coverUrl;

    @ApiModelProperty(value = "喜欢/赞美的数量")
    private Long favoriteCount;

    @ApiModelProperty(value = "评论的数量")
    private Long commentCount;

    @ApiModelProperty(value = "是否喜欢")
    private Boolean isFavorite;

    private Long videoCategoryId;

    private String videoCategoryName;

    private Integer mcnId;

    private String mcnName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Long getVideoCategoryId() {
        return videoCategoryId;
    }

    public void setVideoCategoryId(Long videoCategoryId) {
        this.videoCategoryId = videoCategoryId;
    }

    public String getVideoCategoryName() {
        return videoCategoryName;
    }

    public void setVideoCategoryName(String videoCategoryName) {
        this.videoCategoryName = videoCategoryName;
    }

    public Integer getMcnId() {
        return mcnId;
    }

    public void setMcnId(Integer mcnId) {
        this.mcnId = mcnId;
    }

    public String getMcnName() {
        return mcnName;
    }

    public void setMcnName(String mcnName) {
        this.mcnName = mcnName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", authorId=").append(authorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", playUrl=").append(playUrl);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", favoriteCount=").append(favoriteCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", isFavorite=").append(isFavorite);
        sb.append(", videoCategoryId=").append(videoCategoryId);
        sb.append(", videoCategoryName=").append(videoCategoryName);
        sb.append(", mcnId=").append(mcnId);
        sb.append(", mcnName=").append(mcnName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}