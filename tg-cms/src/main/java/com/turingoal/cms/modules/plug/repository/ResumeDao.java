package com.turingoal.cms.modules.plug.repository;

import java.util.List;
import java.util.Map;
import com.turingoal.cms.modules.plug.domain.Resume;
import com.turingoal.cms.modules.plug.domain.form.ResumeForm;
import com.turingoal.cms.modules.plug.domain.query.ResumeQuery;

/**
 * ResumeDao
 */
public interface ResumeDao {

    /**
     * 查询 Resume
     */
    List<Resume> find(final ResumeQuery query);

    /**
     * 通过id得到一个 Resume
     */
    Resume get(final String id);

    /**
     * 新增 Resume
     */
    void add(final ResumeForm form);

    /**
     * 修改 Resume
     */
    int update(final ResumeForm form);

    /**
     * 根据id删除一个 Resume
     */
    int delete(final String id);

    /**
     * 修改状态
     */
    int changeState(final Map<String, Object> map);
}