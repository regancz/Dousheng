package com.charles.dousheng.search.controller;

import com.charles.dousheng.common.api.CommonPage;
import com.charles.dousheng.common.api.CommonResult;
import com.charles.dousheng.search.domain.EsVideo;
import com.charles.dousheng.search.domain.EsVideoRelatedInfo;
import com.charles.dousheng.search.service.EsVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author charles
 * @date 5/4/2023 7:02 PM
 */
@Controller
@Api(tags = "EsVideoController")
@RequestMapping("/esVideo")
public class EsVideoController {
    @Autowired
    private EsVideoService esVideoService;

    @ApiOperation(value = "导入所有数据库中视频信息到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList() {
        int count = esVideoService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除视频")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id) {
        esVideoService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除视频")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esVideoService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建视频")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<EsVideo> create(@PathVariable Long id) {
        EsVideo esVideo = esVideoService.create(id);
        if (esVideo != null) {
            return CommonResult.success(esVideo);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsVideo>> search(@RequestParam(required = false) String keyword,
                                                    @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                    @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsVideo> EsVideoPage = esVideoService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(EsVideoPage));
    }

    @ApiOperation(value = "综合搜索、筛选、排序")
    @ApiImplicitParam(name = "sort", value = "排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低",
            defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsVideo>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false) Long brandId,
                                                      @RequestParam(required = false) Long productCategoryId,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                                      @RequestParam(required = false, defaultValue = "0") Integer sort) {
        Page<EsVideo> EsVideoPage = esVideoService.search(keyword, brandId, productCategoryId, pageNum, pageSize, sort);
        return CommonResult.success(CommonPage.restPage(EsVideoPage));
    }

    @ApiOperation(value = "根据视频id推荐视频")
    @RequestMapping(value = "/recommend/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsVideo>> recommend(@PathVariable Long id,
                                                         @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsVideo> EsVideoPage = esVideoService.recommend(id, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(EsVideoPage));
    }

    @ApiOperation(value = "获取搜索的相关品牌、分类及筛选属性")
    @RequestMapping(value = "/search/relate", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<EsVideoRelatedInfo> searchRelatedInfo(@RequestParam(required = false) String keyword) {
        EsVideoRelatedInfo productRelatedInfo = esVideoService.searchRelatedInfo(keyword);
        return CommonResult.success(productRelatedInfo);
    }
}
