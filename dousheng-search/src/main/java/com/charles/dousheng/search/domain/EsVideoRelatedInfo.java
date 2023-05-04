package com.charles.dousheng.search.domain;

import java.util.List;

/**
 * 搜索视频的MCN机构名称，分类名称及属性
 *
 * @author charles
 * @date 5/4/2023 7:02 PM
 */
public class EsVideoRelatedInfo {
    private List<String> MCNNames;

    private List<String> videoCategoryNames;

    private List<VideoAttr> videoAttrs;

    public List<String> getMCNNames() {
        return MCNNames;
    }

    public void setMCNNames(List<String> MCNNames) {
        this.MCNNames = MCNNames;
    }

    public List<String> getVideoCategoryNames() {
        return videoCategoryNames;
    }

    public void setVideoCategoryNames(List<String> videoCategoryNames) {
        this.videoCategoryNames = videoCategoryNames;
    }

    public List<VideoAttr> getVideoAttrs() {
        return videoAttrs;
    }

    public void setVideoAttrs(List<VideoAttr> videoAttrs) {
        this.videoAttrs = videoAttrs;
    }

    public static class VideoAttr {
        private Long attrId;
        private String attrName;
        private List<String> attrValues;

        public Long getAttrId() {
            return attrId;
        }

        public void setAttrId(Long attrId) {
            this.attrId = attrId;
        }

        public List<String> getAttrValues() {
            return attrValues;
        }

        public void setAttrValues(List<String> attrValues) {
            this.attrValues = attrValues;
        }

        public String getAttrName() {
            return attrName;
        }

        public void setAttrName(String attrName) {
            this.attrName = attrName;
        }
    }
}
