package com.papounidis.space_data_hub.util;

import com.papounidis.space_data_hub.infrastructure.MissionRepository;
import com.papounidis.space_data_hub.model.ImageType;
import com.papounidis.space_data_hub.model.Mission;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
class LoadMissions {


    /*
    Loading the memory with initial mission names for the use with the REST API
     */
    @Bean
    CommandLineRunner initDatabase(MissionRepository repository) {
        return args -> {
            repository.save(new Mission("Space Explorer",
                            ImageType.Panchromatic,
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2012-04-14T17:32:25+0000"),
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2019-06-17T17:32:25+0000")));
            repository.save(new Mission("Marine Quest",
                            ImageType.Multispectral,
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2010-03-17T17:48:35+0000"),
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2023-06-30T02:26:50+0000")));
            repository.save(new Mission("Infinity Gauntlet",
                            ImageType.Panchromatic,
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2018-07-10T01:29:09+0000"),
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2023-05-14T03:31:14+0000")));
            repository.save(new Mission("6884 Caeli VI",
                            ImageType.Hyperspectral,
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2014-09-12T21:01:16+0000"),
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2024-09-07T01:23:10+0000")));
            repository.save(new Mission("7493 Persei",
                            ImageType.Hyperspectral,
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2011-02-21T13:58:01+0000"),
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2015-07-15T15:47:41+0000")));
            repository.save(new Mission("New Zion",
                            ImageType.Multispectral,
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2017-07-08T23:00:33+0000"),
                            new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ssZ").parse("2019-02-09T12:00:25+0000")));
        };
    }
}