package org.football_project.services;

import org.football_project.dtos.CompetitionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompetitionServiceRESTAPIClient {

    private final String apiUrl = "http://localhost:8080/api/competitions";

    public CompetitionDto findCompetitionByName(String name) {
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl + "/find/" + name;

        return restTemplate.getForObject(url, CompetitionDto.class);
    }

    public void addCompetition(CompetitionDto competitionDto) {
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl + "/add-competition";

        restTemplate.postForObject(url, competitionDto, CompetitionDto.class);
    }

    public void deleteCompetitionByName(String name) {
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl + "/delete-competition/" + name;

        restTemplate.delete(url, CompetitionDto.class);
    }

}
