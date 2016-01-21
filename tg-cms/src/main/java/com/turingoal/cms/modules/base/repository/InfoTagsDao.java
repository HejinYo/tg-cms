package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.InfoTags;
import com.turingoal.cms.modules.base.domain.form.InfoTagsForm;
import com.turingoal.cms.modules.base.domain.query.InfoTagsQuery;

/**
 * InfoTagsDao 
 */
public interface InfoTagsDao {
    
    /**
     * 查询 InfoTags
     */
    List<InfoTags> find(final InfoTagsQuery query);
    
    /**
     * 通过id得到一个 InfoTags
     */
    InfoTags get(final String id);
    
    /**
     * 新增 InfoTags
     */
    void add(final InfoTagsForm form);

    /**
     * 修改 InfoTags
     */
    int update(final InfoTagsForm form);
    
    /**
     * 根据id删除一个 InfoTags
     */
    int delete(final String id);
    
    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}