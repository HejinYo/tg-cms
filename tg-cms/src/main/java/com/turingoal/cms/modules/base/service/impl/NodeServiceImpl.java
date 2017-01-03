package com.turingoal.cms.modules.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.primitives.Doubles;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.commons.SystemLogHelper;
import com.turingoal.cms.core.domain.CustomFieldValue;
import com.turingoal.cms.core.domain.form.CustomFieldValueForm;
import com.turingoal.cms.core.domain.query.CustomFieldValueQuery;
import com.turingoal.cms.core.repository.CustomFieldValueDao;
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.Node;
import com.turingoal.cms.modules.base.domain.form.NodeForm;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;
import com.turingoal.cms.modules.base.domain.query.NodeQuery;
import com.turingoal.cms.modules.base.repository.InfoDao;
import com.turingoal.cms.modules.base.repository.NodeDao;
import com.turingoal.cms.modules.base.service.NodeService;
import com.turingoal.common.annotation.MethodLog;
import com.turingoal.common.bean.BaseTreeNodeBean;
import com.turingoal.common.bean.TreeBean;
import com.turingoal.common.constants.ConstantEnabledValue;
import com.turingoal.common.util.lang.StringUtil;

/**
 * 栏目Service
 */
@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeDao nodeDao;
    @Autowired
    private InfoDao infoDao;
    @Autowired
    private CustomFieldValueDao customFieldValueDao;

    /**
     * 根据父栏目编码查询栏目
     */
    @MethodLog(name = "根据父栏目编码查询栏目", description = "根据父栏目编码查询栏目")
    public List<Node> findByParentCodeNum(final String parentCodeNum, final Long limit) {
        List<Node> result = nodeDao.findByParentCodeNum(parentCodeNum, limit);
        return result;
    }

    /**
     * 查询全部栏目
     */
    @MethodLog(name = "查询全部栏目", description = "根据条件查询全部的栏目")
    public List<Node> findAll(final NodeQuery query) {
        List<Node> result = nodeDao.find(query);
        return result;
    }

    /**
     * 设置自定义字段
     */
    private void putCustomDatas(final Node node) {
        if (node == null) {
            return;
        }
        CustomFieldValueQuery query = new CustomFieldValueQuery();
        query.setOwnerType("nodeModel");
        query.setOwnerId(node.getId());
        List<CustomFieldValue> list = customFieldValueDao.findByOwner(query);
        for (CustomFieldValue fieldValue : list) {
            String keyStr = fieldValue.getKeyStr();
            String prefix = keyStr.substring(0, keyStr.lastIndexOf("_") + 1);
            String key = keyStr.replace(prefix, "");
            switch (prefix) {
            case "cus_str_":
                node.getCustoms().put(key, fieldValue.getValueStr());
                break;
            case "cus_blob_":
                node.getCustoms().put(key, fieldValue.getValueForLongText());
                break;
            case "cus_date_":
                node.getCustoms().put(key, fieldValue.getValueForDate());
                break;
            case "cus_num_":
                node.getCustoms().put(key, fieldValue.getValueForDouble());
                break;
            default:
                break;
            }
        }
    }

    /**
     * 通过id得到一个 栏目
     */
    @MethodLog(name = "通过id得到栏目", description = "通过id得到一个栏目")
    public Node get(final String id) {
        Node node = nodeDao.get(id);
        putCustomDatas(node);
        return node;
    }

    /**
     * 通过栏目名称获取
     */
    @MethodLog(name = "通过栏目名称获取", description = "通过栏目名称获取")
    public Node getByNoddName(final String noddName) {
        return nodeDao.getByNoddName(noddName);
    }

    /**
     * 通过codeNum得到一个 栏目
     */
    @MethodLog(name = "通过codeNum得到一个 栏目", description = "通过codeNum得到一个 栏目")
    public Node getByCode(final String codeNum) {
        NodeQuery query = new NodeQuery();
        query.setCodeNum(codeNum);
        Node node = nodeDao.getByCode(query);
        putCustomDatas(node);
        return node;
    }

    /**
     * 更新自定义字段
     */
    private void updateCusFieldValue(final NodeForm form, final Map<String, String> cusMap) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ownerType", "nodeModel");
        params.put("ownerId", form.getId());
        customFieldValueDao.deleteByModel(params);

        for (String keyStr : cusMap.keySet()) {
            CustomFieldValueForm cusForm = new CustomFieldValueForm();
            String prefix = keyStr.substring(0, keyStr.lastIndexOf("_") + 1);
            cusForm.setKeyStr(keyStr);
            if (StringUtil.isNullOrBlank(cusMap.get(keyStr))) {
                continue;
            }
            switch (prefix) {
            case "cus_str_":
                cusForm.setValueStr(cusMap.get(keyStr));
                break;
            case "cus_blob_":
                cusForm.setValueForLongText(cusMap.get(keyStr));
                break;
            case "cus_date_":
                cusForm.setValueForDate(DateTime.parse(cusMap.get(keyStr).toString()).toDate());
                break;
            case "cus_num_":
                cusForm.setValueForDouble(Doubles.tryParse(cusMap.get(keyStr).toString()));
                break;
            default:
                break;
            }
            cusForm.setOwnerId(form.getId());
            cusForm.setOwnerType("nodeModel");
            customFieldValueDao.add(cusForm);
        }
    }

    /**
     * 新增 栏目
     */
    @MethodLog(name = "新增栏目", description = "新增一个栏目，返回id")
    public void add(final NodeForm form, final Map<String, String> cusMap) {
        form.setRefersCount(0);
        form.setViewsCount(0);
        form.setRealNode(1);
        form.setHidden(2);
        form.setHtmlState(2);
        if (form.getParentId() == null) {
            form.setParentId("0");
        }
        form.setCreateDataUsername(SystemHelper.getCurrentUsername());
        nodeDao.add(form);
        updateCusFieldValue(form, cusMap);
        // 记录操作日志
        SystemLogHelper.log("新增栏目,id={},noddName={}", form.getId(), form.getNoddName());
    }

    /**
     * 修改 栏目
     */
    @MethodLog(name = "修改栏目", description = "修改一个栏目")
    public int update(final NodeForm form, final Map<String, String> cusMap) {
        form.setUpdateDataUsername(SystemHelper.getCurrentUsername());
        int result = nodeDao.update(form);
        updateCusFieldValue(form, cusMap);
        // 记录操作日志
        SystemLogHelper.log("修改栏目,id={},noddName={}", form.getId(), form.getNoddName());
        return result;
    }

    /**
     * 根据id删除一个 Node
     */
    @MethodLog(name = "删除栏目", description = "根据id删除一个栏目")
    public String delete(final String id) {
        NodeQuery query = new NodeQuery();
        query.setParentId(id);
        List<Node> nodes = nodeDao.find(query);
        if (nodes.size() > 0) {
            return "请优先删除子栏目！";
        }
        InfoQuery infoQuery = new InfoQuery();
        infoQuery.setNodeId(id);
        List<Info> infos = infoDao.find(infoQuery);
        if (infos.size() > 0) {
            return "该栏目已有文章使用，请优先删除该栏目下的文章！";
        }
        nodeDao.delete(id);
        // 记录操作日志
        SystemLogHelper.log("删除栏目,id={}", id);
        return null;
    }

    /**
     * 启用
     */
    @MethodLog(name = "启用栏目", description = "根据id启用一个栏目")
    public int enable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", ConstantEnabledValue.ENABLED_INT);
        return nodeDao.changeState(params);
    }

    /**
     * 停用
     */
    @MethodLog(name = "停用栏目", description = "根据id停用一个栏目")
    public int disable(final String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("enabled", ConstantEnabledValue.DISABLED_INT);
        return nodeDao.changeState(params);
    }

    /**
     * 查询全部栏目树
     */
    public BaseTreeNodeBean getNodeTreeGird(final NodeQuery query) {
        List<Node> allNodes = nodeDao.find(query);
        List<? extends BaseTreeNodeBean> nodeList = allNodes;
        Node root = new Node();
        root.setId("0");
        root.setLeaf(false);
        root.setNoddName("根栏目");
        return TreeBean.createTree(root, nodeList, "nodes");
    }
}