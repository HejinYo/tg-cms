package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.CmsDoc;
import com.turingoal.cms.modules.base.domain.form.CmsDocForm;
import com.turingoal.cms.modules.base.domain.query.CmsDocQuery;

/**
 * DocDao
 */
public interface CmsDocDao {

    /**
     * 查询Doc
     */
    List<CmsDoc> find(final CmsDocQuery query);

    /**
     * 通过id得到一个 Doc
     */
    CmsDoc get(final String id);

    /**
     * 新增 Doc
     */
    void add(final CmsDocForm form);

    /**
     * 修改 Doc
     */
    int update(final CmsDocForm form);

    /**
     * 根据id删除一个 Doc
     */
    int delete(final String id);

    /**
     * 获取所有文件的格式
     */
    List<CmsDoc> findFormat();

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据md5获取
     */
    CmsDocForm getByMd5(String md5str);

    /**
     * 根据ids获取
     */
    List<CmsDoc> findByIds(String[] str);
}