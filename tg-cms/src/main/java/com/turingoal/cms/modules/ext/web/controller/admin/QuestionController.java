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
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Question;
import com.turingoal.cms.modules.ext.domain.QuestionItem;
import com.turingoal.cms.modules.ext.domain.QuestionOption;
import com.turingoal.cms.modules.ext.domain.form.QuestionForm;
import com.turingoal.cms.modules.ext.domain.form.QuestionItemForm;
import com.turingoal.cms.modules.ext.domain.form.QuestionOptionForm;
import com.turingoal.cms.modules.ext.domain.query.QuestionQuery;
import com.turingoal.cms.modules.ext.service.QuestionService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * QuestionController
 */
@Controller
@RequestMapping("/m/ext/question")
public class QuestionController {

    private static final String LIST_PAGE = "modules/content/question/list";
    private static final String ADD_PAGE = "modules/content/question/add";
    private static final String ADD_ITEM_PAGE = "modules/content/question/addItem";
    private static final String ADD_OPTION_PAGE = "modules/content/question/addOption";
    private static final String EDIT_PAGE = "modules/content/question/edit";
    private static final String EDIT_ITEM_PAGE = "modules/content/question/editItem";
    private static final String EDIT_OPTION_PAGE = "modules/content/question/editOption";

    @Autowired
    private QuestionService questionService;

    /**
     * 返回调查问卷查询界面
     */
    @RequestMapping(value = "/list_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView listPage(@PathVariable final String id) throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        mav.addObject("question", questionService.get(id));
        return mav;
    }

    /**
     * 返回问卷调查查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final QuestionQuery query) throws BusinessException {
        Page<Question> result = questionService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 返回问卷调查项查询信息
     */
    @RequestMapping(value = "/questionList.gsp", method = RequestMethod.POST)
    @ResponseBody
    public Question questionList(final QuestionQuery query) throws BusinessException {
        Question question = questionService.get(query.getId());
        return question;
    }

    /**
     * 返回问卷调查项查询信息
     */
    @RequestMapping(value = "/itemList.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean itemList(final QuestionItem query) throws BusinessException {
        List<QuestionItem> items = questionService.findItem(query.getQuestionId());
        for (QuestionItem item : items) {
            List<QuestionOption> option = questionService.findOption(item.getId());
            item.setQuestionOptions(option);
        }
        return new PageGridBean(items);
    }

    /**
     * 返回问卷信息新增界面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }

    /**
     * 返回问卷选项信息新增界面
     */
    @RequestMapping(value = "/addItem.gsp", method = RequestMethod.GET)
    public String addItemPage() {
        return ADD_ITEM_PAGE;
    }

    /**
     * 返回选项内容新增界面
     */
    @RequestMapping(value = "/addOption_{itemId}.gsp", method = RequestMethod.GET)
    public ModelAndView addOptionPage(@PathVariable("itemId") final String itemId) {
        ModelAndView mav = new ModelAndView(ADD_OPTION_PAGE);
        mav.addObject("itemId", itemId);
        return mav;
    }

    /**
     * 新增 问卷信息
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final QuestionForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            questionService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 新增 选项信息
     */
    @RequestMapping(value = "/addItem.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final QuestionItemForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            questionService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 新增 选项内容信息
     */
    @RequestMapping(value = "/addOption.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final QuestionOptionForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            questionService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 返回问卷信息修改界面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", questionService.get(id));
        return mav;
    }

    /**
     * 返回选项信息修改界面
     */
    @RequestMapping(value = "/editItem_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editItemPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_ITEM_PAGE);
        mav.addObject("result", questionService.getItem(id));
        return mav;
    }

    /**
     * 返回选项内容信息修改界面
     */
    @RequestMapping(value = "/editOption_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editOptionPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_OPTION_PAGE);
        mav.addObject("result", questionService.getOption(id));
        return mav;
    }

    /**
     * 修改 问卷信息
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final QuestionForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            questionService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改 选项信息
     */
    @RequestMapping(value = "/editItem.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final QuestionItemForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            questionService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改 选项内容信息
     */
    @RequestMapping(value = "/editOption.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final QuestionOptionForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            questionService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 问卷信息
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        questionService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id删除 问卷选项信息
     */
    @RequestMapping(value = "/deleteItem_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteItem(@PathVariable("id") final String id) throws BusinessException {
        questionService.deleteItem(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id删除 选项内容信息
     */
    @RequestMapping(value = "/deleteOption_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteOption(@PathVariable("id") final String id) throws BusinessException {
        questionService.deleteOption(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 Question
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        questionService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 Question
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        questionService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantPattern4Date.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}