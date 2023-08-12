package com.example.geektrust.service.impl;

import com.example.geektrust.entity.Journey;
import com.example.geektrust.entity.enums.PassengerType;
import com.example.geektrust.entity.enums.Station;
import com.example.geektrust.service.JourneyService;
import com.example.geektrust.service.SummaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SummaryServiceImpl implements SummaryService {
    private final JourneyService journeyService;

    public SummaryServiceImpl(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    public void printSummary() {
        List<Journey> allJourneys = journeyService.fetchAllCommutedJourney();
        for (Station station : Station.values()) {
            List<Journey> journeysForGivenStation = allJourneys.stream().filter(journey -> journey.getSource().equals(station)).collect(Collectors.toList());
            printTotalSummary(journeysForGivenStation, station);
            printPassengerSummary(journeysForGivenStation);
        }
    }

    private void printTotalSummary(List<Journey> journeysForGivenStation, Station station) {
        Double totalFare = journeysForGivenStation.stream().mapToDouble(Journey::getFare).sum();
        Double serviceFee = journeysForGivenStation.stream().mapToDouble(Journey::getServiceFee).sum();
        Double discountFee = journeysForGivenStation.stream().mapToDouble(Journey::getDiscountFee).sum();

        Double totalFareWithServiceFee = totalFare + serviceFee;
        System.out.printf("TOTAL_COLLECTION %s %d %d%n", station, totalFareWithServiceFee.intValue(), discountFee.intValue());
    }

    private void printPassengerSummary(List<Journey> journeys) {
        Map<PassengerType, Integer> passengerTypeToCount = journeys.stream().collect(Collectors.groupingBy(Journey::getPassengerType, Collectors.summingInt(journey -> 1)));
        System.out.println("PASSENGER_TYPE_SUMMARY");
        List<Map.Entry<PassengerType, Integer>> sortedList = new ArrayList<>(passengerTypeToCount.entrySet());
        sortedList.sort(Map.Entry.<PassengerType, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey(Comparator.comparing(Enum::name))));

        sortedList.forEach((entry) -> {
            PassengerType passengerType = entry.getKey();
            Integer count = entry.getValue();
            System.out.printf("%s %d%n", passengerType.name(), count);
        });
    }
}
