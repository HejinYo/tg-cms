package com.turingoal.cms.modules.base.web.directive.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.cms.modules.base.domain.query.SpecialQuery;
import com.turingoal.cms.modules.base.service.SpecialService;
import com.turingoal.cms.modules.base.web.directive.SpecialDirective;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.PageGridBean;

/**
 * SpecialDirective
 */
@Component
public class SpecialDirectiveImpl implements SpecialDirective {
    @Autowired
    private SpecialService specialService;

    /**
     * 获取专题列表
     */
    @MethodLog(name = "获取专题列表", description = "根据条件获取专题列表，不分页")
    public List<Special> top(final String typeId, final Integer withImage, final Integer recommend, final Long limit) {
        SpecialQuery query = new SpecialQuery();
        query.setTypeId(typeId);
        query.setWithImage(withImage);
        query.setRecommend(recommend);
        query.setLimit(limit);
        if (limit != null && limit > 0) {
            return specialService.findByPage(query);
        }
        return specialService.findAll(query);
    }

    /**
     * 根据id获取一个专题信息
     */
    @MethodLog(name = "根据id获取一个专题信息", description = "根据id获取一个专题信息")
    public Special getById(final String id) {
        return specialService.get(id);
    }

    /**
     * 分页获取专题列表
     */
    @MethodLog(name = "分页获取专题列表", description = "分页获取专题列表")
    public PageGridBean pageList(final String typeId, final Integer withImage, final Integer recommend, final Long page, final Long pageSize) {
        SpecialQuery query = new SpecialQuery();
        query.setTypeId(typeId);
        query.setWithImage(withImage);
        query.setRecommend(recommend);
        Page<Special> result = (Page<Special>) specialService.findByPage(query);
        return new PageGridBean(result.getTotal(), page, pageSize, result);
    }
}