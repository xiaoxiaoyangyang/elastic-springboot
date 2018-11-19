package com.example.createdata.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.createdata.entity.HistoryInfo;
import com.example.createdata.entity.ScrollID;
import com.example.createdata.utils.HttpUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.recycler.Recycler;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.avg.AvgAggregationBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class Testelastic {
    private Logger logger=LoggerFactory.getLogger(Testelastic.class);

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private TransportClient client;

    @Value("${delete.url}")
    private String deleteUrl;

    @RequestMapping(value = "aa",method = RequestMethod.GET)
    public ResponseEntity<?> aa(){
        Pageable pageable = new PageRequest(1, 20);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery())
                .withIndices("mallhistory-2018-10-24")
                .withTypes("mallhistory")
                .withPageable(pageable).build();
        List<String> list = elasticsearchTemplate.queryForIds(searchQuery);
        logger.info("*********"+list.size());
        list.forEach(li->{
            logger.info(li);
        });
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @RequestMapping(value = "bb",method = RequestMethod.GET)
    public ResponseEntity<?> bb(){
        String s = new String("{\"term\":{\"id\":\"e5e2487b26a04b608d4741dd0e45f7c7\"}}");
        StringQuery stringQuery = new StringQuery(s);
        stringQuery.addIndices("mallhistory-2018-10-24");
        stringQuery.addTypes("mallhistory");
        List<HistoryInfo> historyInfos = elasticsearchTemplate.queryForList(stringQuery, HistoryInfo.class);
        for(HistoryInfo historyInfo:historyInfos){
            String ss = new String("ss");
            logger.info(historyInfo.toString());
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @RequestMapping(value = "cc",method = RequestMethod.GET)
    public ResponseEntity<?> cc(){
        String s = new String("{\"term\":{\"id\":\"e5e2487b26a04b608d4741dd0e45f7c7\"}}");
        StringQuery stringQuery = new StringQuery(s);
        stringQuery.addIndices("mallhistory-2018-10-24");
        stringQuery.addTypes("mallhistory");
        HistoryInfo historyInfo = elasticsearchTemplate.queryForObject(stringQuery, HistoryInfo.class);
       logger.info(historyInfo.toString());
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

//    @RequestMapping(value = "dd",method = RequestMethod.GET)
//    public ResponseEntity<?> dd(){
//        GetQuery getQuery = new GetQuery();
//        getQuery.setId("e5e2487b26a04b608d4741dd0e45f7c7");
//        HistoryInfo historyInfo = elasticsearchTemplate.queryForObject(getQuery, HistoryInfo.class);
//        return new ResponseEntity<>("ok",HttpStatus.OK);
//    }
    @RequestMapping(value = "ff",method = RequestMethod.GET)
    public ResponseEntity ff(){
        TermsAggregationBuilder peopleName = AggregationBuilders.terms("peopleName").field("targetInfo.id.keyword");
        TermsAggregationBuilder peopleType = AggregationBuilders.terms("peopleType").field("personType.keyword").subAggregation(peopleName);
        Pageable pageable = new PageRequest(1, 100);
        SearchQuery searchQuery= new NativeSearchQueryBuilder().withIndices("mallhistory-2018-10-24")
                .withTypes("mallhistory")
                .withQuery(QueryBuilders.matchAllQuery())
                .withPageable(pageable)
                .addAggregation(peopleType)
                .build();
        AggregatedPage<HistoryInfo> historyInfos = elasticsearchTemplate.queryForPage(searchQuery, HistoryInfo.class);
        Aggregations aggregations = historyInfos.getAggregations();
        aggregations.forEach(aggregation -> {
            String s = aggregation.toString();
            JSONObject jsonObject = JSONObject.parseObject(s);
            JSONObject peopleType1 =(JSONObject) jsonObject.get("peopleType");
            JSONArray buckets =(JSONArray) peopleType1.get("buckets");
            for(int i=0;i<buckets.size();i++){
                JSONObject jsonObject1 = (JSONObject) buckets.get(i);
                String key =(String) jsonObject1.get("key");
                String doc_count = (String)jsonObject.get("doc_count");
                logger.info(key);
                logger.info(doc_count);
            }
            logger.info(aggregation.toString());
        });
        historyInfos.forEach(historyInfo -> {
            String id = historyInfo.getId();
        });
        return new ResponseEntity("ok",HttpStatus.OK);
    }

//    @RequestMapping(value = "hh",method = RequestMethod.GET)
//    public ResponseEntity<?> hh(){
//        TermsAggregationBuilder peopleType = AggregationBuilders.terms("peopleType").field("personType.keyword");
//        Pageable pageable = new PageRequest(1, 100);
//        SearchQuery searchQuery= new NativeSearchQueryBuilder().withIndices("mallhistory-2018-10-24")
//                .withTypes("mallhistory")
//                .withQuery(QueryBuilders.matchAllQuery())
//                .withPageable(pageable)
//                .addAggregation(peopleType)
//                .build();
//        AggregatedPage<HistoryInfo> historyInfos = elasticsearchTemplate.queryForPage(searchQuery, HistoryInfo.class, new SearchResultMapper() {
//            @Override
//            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
//                SearchHits hits = searchResponse.getHits();
//
//                Aggregations aggregations = searchResponse.getAggregations();
//                int pageSize = pageable.getPageSize();
//                int pageNumber = pageable.getPageNumber();
//
//                return null;
//            }
//        });
//        return new ResponseEntity<>("ok",HttpStatus.OK);
//    }

    @RequestMapping(value = "tt",method = RequestMethod.GET)
    public ResponseEntity<?> tt(){
        MoreLikeThisQuery moreLikeThisQuery = new MoreLikeThisQuery();
        moreLikeThisQuery.setIndexName("mallhistory-2018-10-24");
        moreLikeThisQuery.setType("mallhistory");
        moreLikeThisQuery.setId("e5e2487b26a04b608d4741dd0e45f7c7");
        Page<HistoryInfo> historyInfos = elasticsearchTemplate.moreLikeThis(moreLikeThisQuery, HistoryInfo.class);
        Iterator<HistoryInfo> iterator = historyInfos.iterator();
        while (iterator.hasNext()){
            HistoryInfo next = iterator.next();
            String id = next.getId();
            logger.info(id);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @RequestMapping("st")
    public ResponseEntity<?> st(){
        List<AliasMetaData> mallhistory = elasticsearchTemplate.queryForAlias("mallhistory-2018-10-24");
        mallhistory.forEach(am->{
            String alias = am.alias();
            String alias1 = am.getAlias();
        });

    //    SortBuilder order = new ScoreSortBuilder().order(SortOrder.ASC);

        SourceFilter sourceFilter = new SourceFilter() {
            @Override
            public String[] getIncludes() {
                return new String[]{"capturedInfo.trackId"};
            }

            @Override
            public String[] getExcludes() {
                return new String[0];
            }
        };
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<h2>");
//        highlightBuilder.postTags("</h2>");
//        HighlightBuilder.Field field = new HighlightBuilder.Field("capturedInfo.trackId");


        SortBuilder sortBuilder = new FieldSortBuilder("capturedInfo.capturedTime").order(SortOrder.DESC);
    //    SearchType queryThenFetch = SearchType.QUERY_THEN_FETCH;
   //     IndicesOptions indicesOptions = IndicesOptions.fromOptions(true, false, true, false);
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())

    //            .withSort(sortBuilder)
   //             .withSort(order)
                .withSourceFilter(sourceFilter)
  //              .withTrackScores(true)
  //              .withMinScore(1.1f)
  //              .withTrackScores(true)
  //和查询效率有关              .withSearchType(queryThenFetch)
  //              .withIndicesOptions(indicesOptions)
  //              .withHighlightFields(field)
                .withIndices("mallhistory-2018-10-24")
                .withTypes("mallhistory")
                .build();
        List<HistoryInfo> historyInfos = elasticsearchTemplate.queryForList(searchQuery, HistoryInfo.class);
        for (HistoryInfo historyInfo:historyInfos){
            String id = historyInfo.getId();
            logger.info(id);
        }

//        HistoryInfo query = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<HistoryInfo>() {
//            @Override
//            public HistoryInfo extract(SearchResponse searchResponse) {
//                SearchHits hits = searchResponse.getHits();
//                for (SearchHit hit : hits) {
//                    float score = hit.getScore();
//                    String sourceAsString = hit.getSourceAsString();
//                    HistoryInfo historyInfo = JSON.parseObject(sourceAsString, HistoryInfo.class);
//                    logger.info(historyInfo.toString()+"$$$$$$$$$$$$$$$$$$$");
//                }
//                return null;
//            }
//        });
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @RequestMapping(value = "ss",method = RequestMethod.GET)
    public ResponseEntity<?> ss(){
        PageRequest pageRequest = new PageRequest(0, 100);
        NativeSearchQuery build = new NativeSearchQueryBuilder().withPageable(pageRequest)
                .withQuery(QueryBuilders.matchAllQuery())
                .withIndices("mallhistory-2018-10-24")
                .withTypes("mallhistory").build();
        Page<HistoryInfo> historyInfos = elasticsearchTemplate.startScroll(1000l, build, HistoryInfo.class);
        long totalElements = historyInfos.getTotalElements();
        int totalPages = historyInfos.getTotalPages();
        Pageable pageable = historyInfos.nextPageable();
        historyInfos.forEach(historyInfo -> {
            String id = historyInfo.getId();
            logger.info(id);
        });
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @RequestMapping(value = "rr",method = RequestMethod.GET)
    public ResponseEntity<?> rr() throws IOException {
        ScrollID scrollID = new ScrollID();
        SearchResponse searchResponse = client.prepareSearch("tdhistory-2018-11-11")
                .setTypes("tdhistory")
                .setFrom(0).setSize(1000)
                .setQuery(QueryBuilders.matchAllQuery()).setScroll(new TimeValue(10000)).execute().actionGet();
        while(searchResponse.getHits().getHits().length!=0){
            searchResponse = client.prepareSearchScroll(searchResponse.getScrollId()).setScroll(new TimeValue(10000)).execute().actionGet();

        }
        scrollID.setScrollId(searchResponse.getScrollId());
        String s = JSON.toJSONString(scrollID);
        HttpUtil.delete(deleteUrl,s);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
}
