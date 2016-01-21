package com.turingoal.cms.modules.base.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.base.domain.CmsFile;
import com.turingoal.cms.modules.base.domain.form.CmsFileForm;
import com.turingoal.cms.modules.base.domain.query.CmsFileQuery;

/**
 * FileDao
 */
public interface CmsFileDao {

    /**
     * 查询 File
     */
    List<CmsFile> find(final CmsFileQuery query);

    /**
     * 通过id得到一个 File
     */
    CmsFile get(final String id);

    /**
     * 新增 File
     */
    void add(final CmsFileForm form);

    /**
     * 修改 File
     */
    int update(final CmsFileForm form);

    /**
     * 根据id删除一个 File
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);

    /**
     * 根据md5查询文件
     * 
     * @param md5str
     * @return 返回文件form
     */
    CmsFileForm getByMd5(String md5);

    /**
     * 获取所有文件的格式
     */
    List<CmsFile> findFormat();

    /**
     * 根据ids获取
     */
    List<CmsFile> findByIds(String[] str);
}