package com.example.createdata.elastic;

import com.example.createdata.entity.EsIndex;
import com.example.createdata.entity.HistoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.AliasBuilder;
import org.springframework.data.elasticsearch.core.query.AliasQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class SaveData {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private EsIndex esIndex;

    public void save(HistoryInfo historyInfo){

        this.create();
        elasticsearchTemplate.index(createIndexQuery(historyInfo));
        elasticsearchTemplate.refresh(HistoryInfo.class);
    }
    public void create(){
        long time = new Date().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String format = simpleDateFormat.format(time);
        String index = String.format("%s-%s", "mallhistory", format);
        esIndex.setIndex(index);

        boolean b = elasticsearchTemplate.indexExists(HistoryInfo.class);
        if(!b){
            elasticsearchTemplate.createIndex(HistoryInfo.class);
            elasticsearchTemplate.putMapping(HistoryInfo.class);
            String indexName = elasticsearchTemplate.getPersistentEntityFor(HistoryInfo.class).getIndexName();
            AliasQuery aliasQuery = new AliasBuilder()
                    .withIndexName(indexName)
                    .withAliasName("mallhistorty").build();
            elasticsearchTemplate.addAlias(aliasQuery);
        }
    }
    public IndexQuery createIndexQuery(HistoryInfo historyInfo){
        IndexQuery build = new IndexQueryBuilder()
                .withId(historyInfo.getId())
                .withObject(historyInfo)
                .build();
        return build;
    }


}
