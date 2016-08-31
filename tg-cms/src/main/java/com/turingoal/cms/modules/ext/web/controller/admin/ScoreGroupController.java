package com.turingoal.cms.modules.ext.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.modules.ext.domain.ScoreGroup;
import com.turingoal.cms.modules.ext.domain.ScoreItem;
import com.turingoal.cms.modules.ext.domain.form.ScoreGroupForm;
import com.turingoal.cms.modules.ext.domain.form.ScoreItemForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreGroupQuery;
import com.turingoal.cms.modules.ext.domain.query.ScoreItemQuery;
import com.turingoal.cms.modules.ext.service.ScoreGroupService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * ScoreGroupController
 */
@Controller
@RequestMapping("/m/ext/scoreGroup")
public class ScoreGroupController {

    private static final String LIST_PAGE = "modules/config/scoreRecord/list";
    private static final String ADD_PAGE = "modules/config/scoreRecord/add";
    private static final String ADD_ITEM_PAGE = "modules/config/scoreRecord/addItem";
    private static final String EDIT_PAGE = "modules/config/scoreRecord/edit";
    private static final String EDIT_ITEM_PAGE = "modules/config/scoreRecord/editItem";

    @Autowired
    private ScoreGroupService scoreGroupService;

    /**
     * 返回计分组查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 返回计分组查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final ScoreGroupQuery query) throws BusinessException {
        List<ScoreGroup> result = scoreGroupService.findAll(query);
        return new PageGridBean(result);
    }

    /**
     * 通过id得到一个计分组信息
     */
    @RequestMapping(value = "/get.gsp", method = RequestMethod.POST)
    @ResponseBody
    public ScoreGroup get(final ScoreGroupQuery query) throws BusinessException {
        ScoreGroup scoreGroup = scoreGroupService.get(query.getId());
        return scoreGroup;
    }

    /**
     * 返回计分组选项查询信息
     */
    @RequestMapping(value = "/itemList.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean itemList(final ScoreItemQuery query) throws BusinessException {
        List<ScoreItem> items = scoreGroupService.findItem(query.getGroupId());
        return new PageGridBean(items);
    }

    /**
     * 返回计分组信息新增界面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }

    /**
     * 返回计分组选项信息新增界面
     */
    @RequestMapping(value = "/addItem.gsp", method = RequestMethod.GET)
    public String addItemPage() {
        return ADD_ITEM_PAGE;
    }

    /**
     * 新增计分组信息
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final ScoreGroupForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            scoreGroupService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 新增计分组选项信息
     */
    @RequestMapping(value = "/addItem.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final ScoreItemForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            scoreGroupService.addItem(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 返回计分组信息修改界面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", scoreGroupService.get(id));
        return mav;
    }

    /**
     * 返回计分组选项信息修改界面
     */
    @RequestMapping(value = "/editItem_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editItemPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_ITEM_PAGE);
        mav.addObject("result", scoreGroupService.getItem(id));
        return mav;
    }

    /**
     * 修改计分组信息
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final ScoreGroupForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            scoreGroupService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改计分组选项信息
     */
    @RequestMapping(value = "/editItem.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final ScoreItemForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            scoreGroupService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 计分组信息
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        scoreGroupService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id删除 计分组选项信息
     */
    @RequestMapping(value = "/deleteItem_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteItem(@PathVariable("id") final String id) throws BusinessException {
        scoreGroupService.deleteItem(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantDateFormatTypes.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}