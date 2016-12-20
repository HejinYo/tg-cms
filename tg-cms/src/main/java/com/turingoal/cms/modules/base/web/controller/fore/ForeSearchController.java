package com.turingoal.cms.modules.base.web.controller.fore;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Controller-栏目
 */
@Controller
public class ForeSearchController {
    /*@Autowired
    private NodeService nodeService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private LuceneHelper luceneHelper;
    @Autowired
    private SmartChineseAnalyzer luceneAnalyzer;
    @Autowired
    private TemplateEngineHelper templateEngineHelper;*/

    /**
     * 栏目
     */
/*    @RequestMapping("/search_{page:[0-9]*}.htm")
    public void index(final String q, @PathVariable final Integer page, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ParseException {
        IndexSearcher searcher = luceneHelper.getIndexSearcher();
        List<String> ids = new ArrayList<String>();
        Integer totalRecords = 0;
        int curPage = page == null ? 1 : page;
        int limit = 6;
        int start = (curPage - 1) * limit;
        int hm = start + limit;
        if (!StringUtil.isNullOrEmpty(q)) {
            String queryString = QueryParser.escape(q);
            BooleanQuery booleanQuery = new BooleanQuery();
            Query qy = MultiFieldQueryParser.parse(queryString, new String[] { "title", "metaKeywords", "metaDescription", "infoText" }, new Occur[] { SHOULD, SHOULD, SHOULD, SHOULD }, luceneAnalyzer);
            booleanQuery.add(qy, Occur.MUST);
            TopFieldCollector c = TopFieldCollector.create(Sort.INDEXORDER, hm, false, false, false);
            // searcher.search(booleanQuery, null, c);
            TopDocs td = c.topDocs(start, limit);
            totalRecords = c.getTotalHits();
            for (ScoreDoc d : td.scoreDocs) {
                Document doc = searcher.doc(d.doc);
                ids.add(doc.get("id"));
            }
        }
        List<Info> infos = infoService.findByIds(ids);
        request.setAttribute("result", new PageGridBean(totalRecords, curPage, limit, infos));
        request.setAttribute("page", curPage);
        request.setAttribute("q", q);
        templateEngineHelper.process("search", request, response);
        return;
    }*/

    /**
     * 将form表单里面的字符串去掉空白
     */
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}