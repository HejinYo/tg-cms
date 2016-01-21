package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.InfoAttrs;
import com.turingoal.cms.modules.base.domain.form.InfoAttrsForm;
import com.turingoal.cms.modules.base.domain.query.InfoAttrsQuery;

/**
 * InfoAttrsDao
 */
public interface InfoAttrsDao {

    /**
     * 查询 InfoAttrs
     */
    List<InfoAttrs> find(final InfoAttrsQuery query);

    /**
     * 通过id得到一个 InfoAttrs
     */
    InfoAttrs get(final String id);

    /**
     * 新增 InfoAttrs
     */
    void add(final InfoAttrsForm form);

    /**
     * 修改 InfoAttrs
     */
    int update(final InfoAttrsForm form);

    /**
     * 根据id删除一个 InfoAttrs
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据文章id删除attr
     * 
     * @param infoId
     * @return
     */
    int deleteByInfoId(final String infoId);
}