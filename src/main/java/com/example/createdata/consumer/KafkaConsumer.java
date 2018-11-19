package com.example.createdata.consumer;

import com.example.createdata.entity.HistoryInfo;
import org.json.JSONObject;
import com.example.createdata.task.TaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

//    @KafkaListener(topics = "${consumer.topic}")
    public void receive(String playload){
        taskExecutor.executeMessage(playload);
    }
}
